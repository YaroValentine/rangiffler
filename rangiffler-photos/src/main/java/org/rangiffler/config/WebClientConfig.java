package org.rangiffler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient() {
        return WebClient
                .builder()
                .exchangeStrategies(ExchangeStrategies.builder().codecs(
                        configurer -> configurer.defaultCodecs().maxInMemorySize(Integer.MAX_VALUE)).build())
                .build();
    }
}
