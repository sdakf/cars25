package pl.sda.cars25.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder1;

    @Override //konfiguracja dostępów w aplikacji - urle
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .httpBasic();
    }

    @Override //konfiguracja odpytania o użytkownika
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder1.encode("password"))
                .roles("USER");
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT u.email, u.password, 1 FROM user u WHERE u.email=?")
                .authoritiesByUsernameQuery("select u.EMAIL, urr.ROLE_NAME, 1\n" +
                        "from USER u\n" +
                        "left join USER_ROLES UR on u.ID = UR.USER_ID\n" +
                        "left join USER_Role URR on UR.ROLES_ID = URR.ID\n" +
                        "where u.EMAIL =?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder1);
    }

//    @Bean //inny sposob tworzenia tego beana
//    public CarService carService(CarRepository carRepository) {
//        return new CarService(carRepository);
//    }

}
