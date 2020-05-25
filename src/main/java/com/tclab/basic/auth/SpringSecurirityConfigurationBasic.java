package com.tclab.basic.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurirityConfigurationBasic extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable() // We disabled csrf
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // enable preflight requests for all endpoints
        .anyRequest().authenticated()
        .and()
        .httpBasic(); // use http basic authentication
  }
}
