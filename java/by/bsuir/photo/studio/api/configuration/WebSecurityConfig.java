package by.bsuir.photo.studio.api.configuration;

import by.bsuir.photo.studio.api.service.UserService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableConfigurationProperties
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    public WebSecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().antMatchers(HttpMethod.POST, "/contacts", "/halls", "/halls/gallery").hasRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.GET, "/contacts", "/halls", "/halls/gallery").permitAll()
                .and()
                .authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.PUT, "/contacts", "/halls", "/halls/gallery").hasRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.DELETE, "/contacts", "/halls", "/halls/gallery").hasRole("ADMIN")
                .and().httpBasic()
                .and().sessionManagement().disable()
                .formLogin()
                .defaultSuccessUrl("/admin", true)
                .and()
                .logout()
                .deleteCookies("JSESSIONID");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
