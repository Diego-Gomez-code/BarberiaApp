package com.proyectoweb.barberia.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/users/all").permitAll()
                .antMatchers(HttpMethod.GET, "/products/").permitAll()
                .antMatchers(HttpMethod.POST, "/users/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/users/edit").permitAll()
                .antMatchers(HttpMethod.GET, "/users/find/{id}").permitAll()
                .anyRequest().authenticated();
    }
}
