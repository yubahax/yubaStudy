package com.example.demo;

import com.example.demo.service.UserAuthService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@Configuration
public class Config extends WebSecurityConfigurerAdapter {
    @Resource
    UserAuthService service;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/index").hasRole("user")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/dologin")
                .successForwardUrl("/index")
                .and()
                .csrf().disable();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(service)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

}
