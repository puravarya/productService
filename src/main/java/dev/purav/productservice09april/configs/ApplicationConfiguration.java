package dev.purav.productservice09april.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {
    //first obejct that you want to injectible is resttemplate
    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}
