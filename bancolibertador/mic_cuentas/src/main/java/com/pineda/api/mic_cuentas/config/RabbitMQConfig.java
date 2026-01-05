package com.pineda.api.mic_cuentas.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Marco
 * @date 1/2/2026
 */

@Configuration
public class RabbitMQConfig
{
    @Bean
    public Queue queue() {
        return new Queue("cuentaQueue", false);
    }
}
