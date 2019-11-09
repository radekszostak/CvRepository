package site.radekszostak.cvrepository.config;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import site.radekszostak.cvrepository.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
	@Autowired
	private UserService userService;

	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/register/*").permitAll()
			.antMatchers("/img/user/*").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/showCv").permitAll()
			.antMatchers("/css/*").permitAll()
			.antMatchers("/script/*").permitAll()
			.antMatchers("/**").hasRole("USER")
			.and()
			.formLogin().loginPage("/login").loginProcessingUrl("/authenticateTheUser")
				.successHandler(customAuthenticationSuccessHandler).failureUrl("/login?loginerror").permitAll().
			and()
				.logout().logoutSuccessUrl("/?loggedout").permitAll()
			.and().exceptionHandling()
				.accessDeniedPage("/?accessdenied").authenticationEntryPoint(unauthenticatedRequestHandler());

	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());//set BCrypt encryption
		return auth;
	}

	
	@Bean
	UnauthenticatedRequestHandler unauthenticatedRequestHandler() {
		return new UnauthenticatedRequestHandler();
	}

	static class UnauthenticatedRequestHandler implements AuthenticationEntryPoint {

		@Override
		public void commence(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException authException) throws IOException {
			
				response.sendRedirect("/login?accessdenied");
			
		}

	}

}
