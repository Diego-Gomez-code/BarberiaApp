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
                //Usuario endpoints
                .antMatchers(HttpMethod.GET, "/users/all").permitAll()
                .antMatchers(HttpMethod.POST, "/users/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/users/edit").permitAll()
                .antMatchers(HttpMethod.GET, "/users/find/{id}").permitAll()
                //productos endpoints
                .antMatchers(HttpMethod.GET, "/products/find/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/products/create").permitAll()
                .antMatchers(HttpMethod.POST, "/products/update").permitAll()
                .antMatchers(HttpMethod.GET, "/products/all").permitAll()
                //CarritoCompra endpoints
                .antMatchers(HttpMethod.POST, "/carritocompra/create").permitAll()
                .antMatchers(HttpMethod.GET, "/carritocompra/find/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/carritocompra/addproduct").permitAll()
                .antMatchers(HttpMethod.POST, "/carritocompra/removeproduct").permitAll()
                .antMatchers(HttpMethod.POST, "/carritocompra/delete/{id}").permitAll()
                //Servicios endpoints
                .antMatchers(HttpMethod.POST, "/service/create").permitAll()
                .antMatchers(HttpMethod.GET, "/service/find/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/service/findAll").permitAll()
                .antMatchers(HttpMethod.POST, "/service/delete/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/service/update/{id}").permitAll()
                //CarritoCliente endpoints
                .antMatchers(HttpMethod.POST, "/carritocliente/create").permitAll()
                //Schedule endpoint
                .antMatchers(HttpMethod.POST, "/schedule/create").permitAll()
                .antMatchers(HttpMethod.GET, "/schedule/findAll").permitAll()
                .antMatchers(HttpMethod.POST, "/schedule/delete/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/schedule/update/{id}").permitAll()
                //CarritoServices endpoints
                .antMatchers(HttpMethod.GET, "/carritoservice/findAll").permitAll()
                .anyRequest().authenticated();
    }
}
