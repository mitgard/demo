package ru.rustam.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.rustam.demo.config.AppSecurityConfig;

@Configuration
@EnableWebMvc
@Import({AppSecurityConfig.class})
@ComponentScan({"ru.rustam.demo.controllers", "ru.rustam.demo.config"})
public class WebConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

}
