package org.rangiffler.config;

import org.rangiffler.cors.CorsCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
@Profile("local")
public class SecurityConfig {

  private final CorsCustomizer corsCustomizer;

  @Autowired
  public SecurityConfig(CorsCustomizer corsCustomizer) {
    this.corsCustomizer = corsCustomizer;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    corsCustomizer.corsCustomizer(http);

    http.authorizeHttpRequests(
            authorize ->
                    authorize.anyRequest().permitAll()
    ).csrf().disable();
    return http.build();
  }

/*  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    corsCustomizer.corsCustomizer(http);

    http.authorizeHttpRequests()
            .requestMatchers("/actuator/health").permitAll()
            .anyRequest()
            .authenticated().and()
            .oauth2ResourceServer()
            .jwt();
    return http.build();
  }*/

}
