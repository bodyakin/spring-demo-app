package com.bodyiakin.demoaop.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate myRestTemplate() {
        return new RestTemplateBuilder(rt ->
                rt.getInterceptors().add((request, body, execution) -> {
                            request.getHeaders().add("X-MY-HEADER", "Wow it's cool innit!");
                            return execution.execute(request, body);
                        })
        ).build();
    }
}
