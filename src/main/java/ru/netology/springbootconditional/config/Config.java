package ru.netology.springbootconditional.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.springbootconditional.profile.DevProfile;
import ru.netology.springbootconditional.profile.ProductionProfile;
import ru.netology.springbootconditional.profile.SystemProfile;

@Configuration
public class Config {
    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "false")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "true")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
