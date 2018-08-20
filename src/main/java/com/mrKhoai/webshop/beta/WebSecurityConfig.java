package com.mrKhoai.webshop.beta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Configuration
    public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserService userService;

        @Autowired
        private WebshopAuthenticationSuccessHandler successHandler;

        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder() {
            return new BCryptPasswordEncoder();
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

            http.antMatcher("/admin*")
                    .authorizeRequests()
                    .antMatchers("/", "/basis/**", "/special/**")
                    .permitAll()
                    .and()
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("ADMIN")

                    .and()
                    .formLogin()
                    .loginPage("/loginAdmin")
                    .loginProcessingUrl("/admin_login")
                    .failureUrl("/loginAdmin?error=loginError")
                    .defaultSuccessUrl("/adminPage")
                    .successHandler(successHandler)

                    .and()
                    .logout()
                    .logoutUrl("/admin_logout")
                    .logoutSuccessUrl("/protectedLinks")
                    .deleteCookies("JSESSIONID")

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
    public static class SpringSecurityConfig2 extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserService userService;

        @Autowired
        private WebshopAuthenticationSuccessHandler successHandler;

        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder() {
            return new BCryptPasswordEncoder();
        }

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

            http.antMatcher("/user*")
                    .authorizeRequests()
                    .antMatchers("/", "/basis/**", "/special/**")
                    .permitAll()
                    .and()
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("USER")

                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/user_login")
                    .failureUrl("/loginUser?error=loginError")
                    .defaultSuccessUrl("/home")
                    .successHandler(successHandler)

                    .and()
                    .logout()
                    .logoutUrl("/user_logout")
                    .logoutSuccessUrl("/protectedLinks")

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
}