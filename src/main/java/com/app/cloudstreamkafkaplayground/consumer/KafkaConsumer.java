package com.app.cloudstreamkafkaplayground.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;
import java.util.logging.Logger;

@Configuration
public class KafkaConsumer {
    public static final Logger logger = Logger.getLogger(KafkaConsumer.class.getName());

    @Bean
    public Consumer<Flux<String>> consumer() {
        return flux -> flux.doOnNext(record -> {
            logger.info("Received: " + record);
        }).subscribe();
    }
}
