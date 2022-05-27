package MyProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().withUser("user1").password("{noop}user1").roles("USER");
            auth.inMemoryAuthentication().withUser("user2").password("{noop}user2").roles("USER");
            auth.inMemoryAuthentication().withUser("user3").password("{noop}user3").roles("USER");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/articles/save/**").access("hasRole('ROLE_USER')")
                    .antMatchers("/articles/put/**").access("hasRole('ROLE_USER')")
                    .antMatchers("/articles/delete/**").access("hasRole('ROLE_USER')")
                    .antMatchers("/balance/save/**").access("hasRole('ROLE_USER')")
                    .antMatchers("/balance/put/**").access("hasRole('ROLE_USER')")
                    .antMatchers("/balance/delete/**").access("hasRole('ROLE_USER')")
                    .antMatchers("/operations/save/**").access("hasRole('ROLE_USER')")
                    .antMatchers("/operations/put/**").access("hasRole('ROLE_USER')")
                    .antMatchers("/operations/delete/**").access("hasRole('ROLE_USER')")
                    .and().formLogin().defaultSuccessUrl("/", false);
        }
}
