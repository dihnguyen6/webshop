package com.mrKhoai.webshop.offcial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


    @Configuration
    @Order(1)
    public static class UserSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserService userService;

        @Autowired
        private WebshopAuthenticationSuccessHandler successHandler;

        public UserSecurityConfig() {
            super();
        }

        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            /*http.sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .maximumSessions(1)
                    .expiredUrl("/home")
                    .maxSessionsPreventsLogin(true)
                    .and().invalidSessionUrl("/home")
                    .sessionFixation().migrateSession()
                    .enableSessionUrlRewriting(false)
                    .sessionAuthenticationErrorUrl("/home");*/

            http.authorizeRequests().antMatchers("/", "/basis/**", "/special/**")
                    .permitAll().anyRequest().authenticated();

            http.antMatcher("/user**")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("USER")

                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/user_login")
                    .failureUrl("/login?error=loginError")
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
                    .rememberMe()
                    .key("uniqueAndSecret")
                    .alwaysRemember(true)

                    .and()
                    .csrf().disable();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
        }
    }

    @Configuration
    public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserService userService;

        @Autowired
        private WebshopAuthenticationSuccessHandler successHandler;

        public AdminSecurityConfig() {
            super();
        }

        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
           /* http.sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                    .maximumSessions(1)
                    .expiredUrl("/home")
                    .maxSessionsPreventsLogin(true)
                    .and().invalidSessionUrl("/home")
                    .sessionFixation().migrateSession()
                    .enableSessionUrlRewriting(false)
                    .sessionAuthenticationErrorUrl("/home");*/

            http.authorizeRequests().antMatchers("/", "/basis/**", "/special/**")
                    .permitAll().anyRequest().authenticated();

            http.antMatcher("/admin/**")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("ADMIN")

                    .and()
                    .formLogin()
                    .loginPage("/admin")
                    .loginProcessingUrl("/admin")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/admin/management")
                    .failureForwardUrl("/admin?error=loginError")
                    .permitAll()

                    .and()
                    .logout()
                    .logoutUrl("/admin_logout")
                    .logoutSuccessUrl("/home")
                    .deleteCookies("JSESSIONID")

                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("/error-403")

                    .and()
                    .rememberMe()
                    .key("uniqueAndSecret")
                    .alwaysRemember(false)

                    .and()
                    .csrf().disable();

            /*http
                    .logout()
                        .logoutUrl("/loginAdmin?logout")
                    .and()
                    .formLogin()
                        .loginPage("/admin")
                        .loginProcessingUrl("/perform_login")
                        .defaultSuccessUrl("/admin/management")
                        .failureForwardUrl("/admin?error=loginError");*/
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
            /*auth.inMemoryAuthentication()
                    .withUser("admin")
                    .password("admin")
                    .roles("ADMIN")
                    *//*.and()
                    .withUser("admin")
                    .password("admin")
                    .credentialsExpired(true)
                    .accountExpired(true)
                    .accountLocked(true)
                    .authorities("WRITE_PRIVILEGES", "READ_PRIVILEGES")
                    .roles("ADMIN")*//*;*/
        }
    }
}