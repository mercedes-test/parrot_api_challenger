package com.mx.api.parrot.challenger.oauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService usuarioService;


	@Autowired
	private AuthenticationEventPublisher eventPublisher;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.usuarioService).passwordEncoder(passwordEncoder()).and()

				.authenticationEventPublisher(eventPublisher);
	}

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web) {
		web.ignoring().antMatchers(
				"/v3/api-docs/**", 
				"/swagger-ui/**", 
				"/v2/api-docs", 
				"/configuration/ui",
				"/swagger-resources/**", 
				"/configuration/**", 
				"/swagger-ui.html",
				"/webjars/**");
	}
}
