package com.reshma.blogapp.blogApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class WebSecurityConfig  {

	  @Bean
	    public static PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	@Bean
	public  SecurityFilterChain filterchain(HttpSecurity http) throws Exception{
		
		
		http
			
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/posts/*").permitAll()
			.antMatchers("/register").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
            .loginProcessingUrl("/login")
            .usernameParameter("email").passwordParameter("password")
            .defaultSuccessUrl("/", true).failureUrl("/login?error")
            .permitAll()
            .and()
            .logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout")
            .and()
            .httpBasic();
		
        http.csrf().disable();
        http.headers().frameOptions().disable();
        
        return http.build();
	}
}
