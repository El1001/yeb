package com.yeb.server.config.security.component;

import com.yeb.server.pojo.Menu;
import com.yeb.server.pojo.Role;
import com.yeb.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {
    @Autowired
    IMenuService menuService;
    //AntPathMatcher 用作匹配
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // FilterInvocation  这个类的作用本身很简单，就是把doFilter传进来的request,response和FilterChain对象保存起来，供FilterSecurityInterceptor的处理代码调用。
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        //拉去菜单
        List<Menu> menus = menuService.getAllMenusWithRole();
        for (Menu menu : menus) {
            // 判断url 和菜单角色是否匹配
            if (antPathMatcher.match(menu.getUrl(), requestUrl)) {
                String[] str = menu.getRoles().stream().map(Role::getName).toArray(String[]::new);
                return SecurityConfig.createList(str);
            }
        }
        //没匹配的url默认为登录即可访问
        return SecurityConfig.createList("ROLE_LOGIN");

    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
