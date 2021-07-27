package com.yeb.server.config.component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    //   配置密匙及过期时间 和 application.yml 的一致
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    //根据负载生成 jwt token
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder() //这里其实就是new一个JwtBuilder，设置jwt的body
                .setClaims(claims)  //如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setExpiration(generateExpirationDate()) // 设置过期时间
                .signWith(SignatureAlgorithm.HS512, secret) //设置签名使用的签名算法和签名使用的秘钥
                .compact();

        // 还有 .setId(id)  设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
        // .setIssuedAt(now)  iat: jwt的签发时间 等
    }

    //  从token中获取jwt负载
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

    // 计算过期时间
    private Date generateExpirationDate() {
        // 该方法的作用是返回当前的计算机时间，时间的表达格式为当前计算机时间和GMT毫秒数 + 过期的时间 *1000 ms
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    // 从token 获得过期时间
    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    //判断token是否失效
    private  boolean isTokenExpired(String token) {
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    // 从toekn 获取登录名
    public  String getUserNameFormToken(String token) {
        String userName;
        try {
            Claims claims = getClaimsFromToken(token);
            userName = claims.getSubject();
        }catch (Exception e) {
            userName = null;
        }
        return userName;
    }

    // 判断token是否有效
    // Spring Security 中获得
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFormToken(token);
        return username.equals(userDetails.getUsername()) &&
                !isTokenExpired(token);
    }
    //根据用户信息生成token
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    // 判断token是否可以呗刷新
    public boolean canRefresh(String token) {
        return !isTokenExpired(token);
    }
    
    //刷新 token
    public String refreshToken(String token) {
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }
}
