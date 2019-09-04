package com.phihung.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
@Component
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/*
	 * @Autowired PersistentTokenRepository tokenRepository;
	 */

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("Web is protected with Spring Security");

		http.authorizeRequests()
		.antMatchers("/login")
			.permitAll()
				/*
				 * .and() .formLogin() .loginPage("/login") .defaultSuccessUrl("/")
				 * .failureUrl("/login?error=true") .permitAll()
				 */
		.and()
			.logout()
				.logoutUrl("/logout")
				.deleteCookies("JSESSIONID")
		.and()
			.exceptionHandling()
				.accessDeniedPage("/access-denied");
		 
	}
	

	/*/Access_Denied
	 * @Bean public PersistentTokenBasedRememberMeServices
	 * getPersistentTokenBasedRememberMeServices() {
	 * PersistentTokenBasedRememberMeServices tokenBasedservice = new
	 * PersistentTokenBasedRememberMeServices( "remember-me", userDetailsService,
	 * tokenRepository); return tokenBasedservice; }
	 */

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	/*
	 * @Bean public PersistentTokenBasedRememberMeServices
	 * getPersistentTokenBasedRememberMeServices() {
	 * PersistentTokenBasedRememberMeServices tokenBasedservice = new
	 * PersistentTokenBasedRememberMeServices( "remember-me", userDetailsService,
	 * tokenRepository); return tokenBasedservice; }
	 */

	@Bean
	public AuthenticationTrustResolver getAuthenticationTrustResolver() {
		return new AuthenticationTrustResolverImpl();
	}
}
