package com.bitc.gotrip.configuration;

import com.bitc.gotrip.service.MemberSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final MemberSecurityService memberSecurityService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
            .authorizeRequests().antMatchers("/**").permitAll()
            .and()
            .formLogin()
            .loginPage("/member/login")
            .defaultSuccessUrl("/")
            .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(memberSecurityService).passwordEncoder(passwordEncoder());

  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

//  private final MemberSecurityService memberSecurityService;
//
//  @Bean
//  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////    모든 인정되지 않은 요청을 허락한다는 의미
//    http.authorizeRequests().antMatchers("/**").permitAll()
//        .and()
//        .formLogin()
//        .loginPage("/member/login")
//        .defaultSuccessUrl("/")
//        .and()
//        .logout()
//        .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
//        .logoutSuccessUrl("/")
//        .invalidateHttpSession(true);
//    return http.build();
//  }
//
//  @Bean
//  public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//  }
//
//@Bean
//  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//    return authenticationConfiguration.getAuthenticationManager();
//}
}
