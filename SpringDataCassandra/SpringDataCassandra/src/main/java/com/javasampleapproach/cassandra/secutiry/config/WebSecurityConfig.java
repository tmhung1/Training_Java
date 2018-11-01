package com.javasampleapproach.cassandra.secutiry.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.javasampleapproach.cassandra.secutiry.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//in order to enable support concurrent session-control
	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	 @Autowired
	  private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 // Cấu hình concurrent session
		//sessionManagement(): quản lí session
		//invalidSessionUrl():dùng để chỉ định url sẽ chuyển hướng tới nếu request chứa session đã hết hạn
	    //maximumSessions: xác định số lượng session lớn nhất có thể hoạt động đồng thời, 
		//ở đây mình để là 1 tức là 1 tài khoản chỉ cho phép hoạt động tại một nơi duy nhất.
		//maxSessionsPreventsLogin: true: k thể login o noi khác khi đạt max session, 
		//false: có thể login ở 1 nơi khác nhưng nơi login trước đó sẽ bị hết hạn.
		//expiredUrl(): chỉ định đường dẫn sẽ chuyển hướng trong trường hợp login thất bại do tình huống bị timeout do login ở nơi khác.
		http.sessionManagement().sessionFixation().newSession()
	    .invalidSessionUrl("/login?message=timeout")
	    .maximumSessions(1).expiredUrl("/login?message=max_session").maxSessionsPreventsLogin(true);
	    
		http.authorizeRequests().antMatchers("/", "/login", "/logout", "/register").permitAll()
				.antMatchers("/userInfo", "/time/*", "/sales/*").access("hasAnyRole('MEMBER', 'ADMIN')")
				.antMatchers("/admin").hasRole("ADMIN").and().formLogin().loginPage("/login").usernameParameter("email")
				.passwordParameter("password").defaultSuccessUrl("/userInfo")
				.failureHandler(customAuthenticationFailureHandler)
				.failureUrl("/login?error").and()
				.logout()
				.logoutUrl("/logout")
				/* .logoutSuccessUrl("/logoutsuccessful") */
				.and().exceptionHandling().accessDeniedPage("/403");
	}
}