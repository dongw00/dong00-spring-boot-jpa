package com.dongwoo.api.security.config;

import com.dongwoo.api.security.aop.SecurityFilter;
import com.dongwoo.api.security.domain.SecurityProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class SecurityConfig extends
    SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final SecurityProvider provider;

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        SecurityFilter securityFilter = new SecurityFilter(provider);
        builder.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
