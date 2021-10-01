package com.mactivites.mactivites.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/**").permitAll();


        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/ms1/**").hasAuthority("USER");
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/api/ms1/employes","/api/ms1/projets").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/api/ms1/employes/{id}","/api/ms1/projets/{id}").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/api/ms1/employes/**","/api/ms1/projets/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilterAfter(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
