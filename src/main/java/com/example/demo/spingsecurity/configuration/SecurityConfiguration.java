package com.example.demo.spingsecurity.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER");
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		http.authorizeRequests()
//	@formatter:off
	.antMatchers("/elementiView").hasRole("USER")
	.antMatchers("/").permitAll()
	// equivalent to <http auto-config="true">
	.and().formLogin()
	.and().httpBasic()
	.and().logout()
	// CSRF is enabled by default (will discuss later)
	.and().csrf().disable();
	}
//	@formatter:on

//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(
////				@formatter:off
//				(requests) -> requests
//			.antMatchers("/", "/home").permitAll()
//			.anyRequest().authenticated()
//		)
//		.formLogin((form) -> form
//			.loginPage("/login")
//			.permitAll()
//		)
//		.logout((logout) -> logout.permitAll());
//
//	return http.build();
//		@formatter:on
//	}

}
