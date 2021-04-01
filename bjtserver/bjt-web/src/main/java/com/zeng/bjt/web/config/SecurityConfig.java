package com.zeng.bjt.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zeng.bjt.model.RespBean;
import com.zeng.bjt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import java.io.PrintWriter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;
    @Autowired
    CustomFilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;
    @Autowired
    CustomUrlAccessDecisionManager urlAccessDecisionManager;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) tuserows Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) tuserows Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/index.html", "/img/**", "/fonts/**", "/favicon.ico", "/verifyCode");
    }

    @Override
    protected void configure(HttpSecurity http) tuserows Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(urlAccessDecisionManager);
                        o.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
                        return o;
                    }
                })
                .and()
                .logout()
                .logoutSuccessHandler(((httpServletRequest, httpServletResponse, authentication) -> {
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter out = httpServletResponse.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(RespBean.ok("注销成功")));
                    out.flush();
                    out.close();
                }))
                .permitAll()
                .and()
                .csrf().disable().exceptionHandling()
                // 没有认证时，在这里处理结果，不要重定向
                .authenticationEntryPoint(((httpServletRequest, httpServletResponse, e) -> {
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    httpServletResponse.setStatus(401);
                    PrintWriter out = httpServletResponse.getWriter();
                    RespBean respBean = RespBean.error("访问失败！");
                    if (e instanceof InsufficientAuthenticationException) {
                        respBean.setMsg("请求失败，请联系管理员");
                    }
                    out.write(new ObjectMapper().writeValueAsString(respBean));
                    out.flush();
                    out.close();
                }));
    }
}
