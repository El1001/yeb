package com.yeb.server.config.component;
// 当访问接口没有权限时，自定义返回结果类

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yeb.server.pojo.RespBean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        PrintWriter out = httpServletResponse.getWriter();
        RespBean respBean = RespBean.error("权限不足，请联系管理员！");
        respBean.setCode(403);
        out.write(new ObjectMapper().writeValueAsString(respBean));
        out.flush();
        out.close();
    }
}
