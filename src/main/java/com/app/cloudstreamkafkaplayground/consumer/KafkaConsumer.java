package com.app.cloudstreamkafkaplayground.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Logger;

@Configuration
public class KafkaConsumer {
    public static final Logger logger = Logger.getLogger(KafkaConsumer.class.getName());

    @Bean
    public Consumer<Flux<String>> consumer() {
        return flux -> flux.doOnNext(record -> {
            logger.info("Consumer Received: " + record);
        }).subscribe();
    }

    @Bean
    public Function<Flux<String>, Mono<Void>> consumer2() {
        return flux -> flux.doOnNext(record -> {
            logger.info("Function Received: " + record);
        }).then();
    }
}
