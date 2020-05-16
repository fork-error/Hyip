package com.techbek.hyip.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .formLogin().loginPage("/login")
                .and()
                .authorizeRequests()
                .antMatchers("/dashboard").permitAll();

        ;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/", "/webjars/**", "/error**", "/css/**", "/js/**", "/fonts/**",
                "/img/**", "/webfonts/**", "/images/**","/about","/investment","/faq","/blog","/contact","/login","/error","/dashboard/**","/account/**");
    }
}
