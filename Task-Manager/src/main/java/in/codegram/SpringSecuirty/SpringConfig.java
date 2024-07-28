package in.codegram.SpringSecuirty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringConfig{

SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception{

    http.csrf((csrf)->csrf.disable())
    .authorizeHttpRequests((authorize)->{authorize.anyRequest().authenticated();})
    .httpBasic(Customizer.withDefaults());
    return http.build();
}


// in memory authentication( I can say method chaining password)
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails manvi= User.builder()
                .username("furkan")
                .password(passwordEncoder().encode("furkan123"))
                .roles("admin")
                .build();

        UserDetails adil=User.builder()
                .username("adil")
                .password(passwordEncoder().encode("adil123"))
                .roles("USER")
                .build();


return new InMemoryUserDetailsManager(manvi,adil);
    }


    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}