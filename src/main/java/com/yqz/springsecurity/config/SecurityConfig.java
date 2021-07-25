package com.yqz.springsecurity.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


//    权限控制、链式  授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        请求授权的规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user");


        //没有权限跳到登录页面
//        开启登录页面
        http.formLogin();
    }



//    认证
//    密码编码加密需要加密

//  spring security中新增了很多加密方式
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("chenhc").password(new BCryptPasswordEncoder().encode("chc123")).roles("admin")
                .and().withUser("sucx").password(new BCryptPasswordEncoder().encode("scx123")).roles("user");
    }
}
