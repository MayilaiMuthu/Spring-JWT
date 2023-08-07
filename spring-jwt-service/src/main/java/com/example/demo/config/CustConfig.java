package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author MayilaiMuthu
 * @since 08-Aug-2023
 *
 */

@Configuration
@EnableWebSecurity
public class CustConfig {

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
 	WebSecurityCustomizer webSecurityCustomizer() {
 		return (web) -> web.ignoring()
 		// Spring Security should completely ignore URLs starting with /resources/
 				.antMatchers(ApplicationConstants.REGISTER_URL, ApplicationConstants.TEST_URL);
 	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(ApplicationConstants.REGISTER_URL, ApplicationConstants.TEST_URL)
				.permitAll().anyRequest().hasRole("USER").and()
				// Possibly more configuration ...
				.formLogin() // enable form based log in
				// set permitAll for all URLs associated with Form Login
				.permitAll();
		return http.build();
	}
	
	@Bean
 	UserDetailsService userDetailsService() {
 		UserDetails user = User.builder()
 			.username("user")
 			.password(bCryptPasswordEncoder().encode("password"))
 			.roles("USER")
 			.build();
 		UserDetails admin = User.builder()
 			.username("admin")
 			.password(bCryptPasswordEncoder().encode("password"))
 			.roles("ADMIN", "USER")
 			.build();
 		return new InMemoryUserDetailsManager(user, admin);
 	}


}
