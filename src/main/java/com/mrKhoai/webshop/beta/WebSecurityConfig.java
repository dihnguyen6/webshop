package com.mrKhoai.webshop.beta;

import com.mrKhoai.webshop.controller.WebshopConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Configuration
    @Order(1)
    public static class AdminConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserService userService;

        @Autowired
        private WebshopAuthenticationSuccessHandler successHandler;

        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder() {
            return new BCryptPasswordEncoder();
        }

        public AdminConfigurationAdapter() {
            super();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.NEVER)
                    .maximumSessions(1)
                    .expiredUrl("/home")
                    .maxSessionsPreventsLogin(true)
                    .and().invalidSessionUrl("/home")
                    .sessionFixation().migrateSession()
                    .enableSessionUrlRewriting(false)
                    .sessionAuthenticationErrorUrl("/home");

            http.authorizeRequests()
                    .antMatchers("/", "/css/**", "/js/**", "/images/**",
                            "/fonts/**", "/includes/**", "/sass/**", "/vendor/**")
                    .permitAll()
                    .antMatchers(HttpMethod.POST, "/register").permitAll()
                    .antMatchers(HttpMethod.POST, "/login").permitAll()
                    .antMatchers(HttpMethod.GET, "/login").permitAll()
                    .antMatchers("/anonymous/**").permitAll()
                    .antMatchers("/admin/**").hasRole(WebshopConst.ADMINISTRATOR)
                    .antMatchers("/web-dev/**").hasRole(WebshopConst.WEB_DEV)
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .successForwardUrl("/home")
                    .successHandler(successHandler)
                    .permitAll()
                    .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/home")
                    .permitAll().and()
                    .rememberMe()
                    .alwaysRemember(true)
                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("/error-403")
                    .and()
                    .csrf().disable();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
        }
    }

    @Configuration
    @Order(2)
    public static class UserConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserService userService;

        @Autowired
        private WebshopAuthenticationSuccessHandler successHandler;

        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder() {
            return new BCryptPasswordEncoder();
        }

        public UserConfigurationAdapter() {
            super();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .maximumSessions(1)
                    .expiredUrl("/home")
                    .maxSessionsPreventsLogin(true)
                    .and().invalidSessionUrl("/home")
                    .sessionFixation().migrateSession()
                    .enableSessionUrlRewriting(false)
                    .sessionAuthenticationErrorUrl("/home");

            http.authorizeRequests()
                    .antMatchers("/", "/css/**", "/js/**", "/images/**",
                            "/fonts/**", "/includes/**", "/sass/**", "/vendor/**")
                    .permitAll()
                    .antMatchers(HttpMethod.POST, "/register").permitAll()
                    .antMatchers(HttpMethod.POST, "/login").permitAll()
                    .antMatchers(HttpMethod.GET, "/login").permitAll()
                    .antMatchers("/anonymous/**").permitAll()
                    .antMatchers("/admin/**").hasRole(WebshopConst.ADMINISTRATOR)
                    .antMatchers("/web-dev/**").hasRole(WebshopConst.WEB_DEV)
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .successForwardUrl("/home")
                    .successHandler(successHandler)
                    .permitAll()
                    .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/home")
                    .permitAll()
                    .and()
                    .csrf().disable();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
        }
    }
}