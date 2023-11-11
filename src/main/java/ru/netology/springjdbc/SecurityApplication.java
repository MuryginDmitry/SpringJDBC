package ru.netology.springjdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityApplication extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService () {
        UserDetails user = User.withUsername("Dima")
                .password("{noop}123456!")
                .roles("User")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .and()
                .authorizeRequests()
                .antMatchers("/hi").permitAll()
                .anyRequest().authenticated();
    }
}


