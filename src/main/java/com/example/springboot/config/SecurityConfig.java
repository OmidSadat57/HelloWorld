package com.example.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String home = "test";
        String home1 = "/";
        http.authorizeRequests()
                //
        .antMatchers(
                HttpMethod.GET,
                home,
                home1
        ).permitAll()
                //static resources
        .antMatchers(
                "/css/**",
                "/img/**",
                "/js/**"
        ).permitAll()
                //
        .anyRequest().authenticated()
                //send the user to the root page when they logout
        .and()
        .logout().logoutSuccessUrl("/")
                //
        .and()
        .oauth2Client()
        .and()
        .oauth2Login();
    }
}
