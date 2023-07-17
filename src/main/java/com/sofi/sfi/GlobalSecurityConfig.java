package com.sofi.sfi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class GlobalSecurityConfig  {

    @Bean // Esto reemplaza a extends WebSecurityConifgurerAdapter
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests((authz)->
                        authz   /*Estos eran los antmatchers*/
                                .requestMatchers("/api/v1/public/**").permitAll()
                                .requestMatchers("/api/v1/admin/**").hasRole("admin")
                                .requestMatchers("/api/v1/user/**").hasRole("user")
                         ).httpBasic(Customizer.withDefaults());
        return http.build();
    }


    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails admin= User
                .withUsername("sofia")
                .password("{noop}sofi")
                .roles("admin")
                .build();
        UserDetails user= User
                .withUsername("vale")
                .password("{noop}vale")
                .roles("user")
                .build();

        return new InMemoryUserDetailsManager(admin,user);
    }

}
