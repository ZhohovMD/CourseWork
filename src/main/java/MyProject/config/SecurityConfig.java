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
            auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER");
            auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/articles/save/**").access("hasRole('ROLE_ADMIN')")
                    .antMatchers("/articles/put/**").access("hasRole('ROLE_ADMIN')")
                    .antMatchers("/articles/delete/**").access("hasRole('ROLE_ADMIN')")
                    .antMatchers("/balance/save/**").access("hasRole('ROLE_ADMIN')")
                    .antMatchers("/balance/put/**").access("hasRole('ROLE_ADMIN')")
                    .antMatchers("/balance/delete/**").access("hasRole('ROLE_ADMIN')")
                    .antMatchers("/operations/save/**").access("hasRole('ROLE_ADMIN')")
                    .antMatchers("/operations/put/**").access("hasRole('ROLE_ADMIN')")
                    .antMatchers("/operations/delete/**").access("hasRole('ROLE_ADMIN')")
                    .and().formLogin().defaultSuccessUrl("/", false);
        }
}
