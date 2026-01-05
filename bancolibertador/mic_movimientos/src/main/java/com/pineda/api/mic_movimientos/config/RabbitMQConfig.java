package com.pineda.api.mic_movimientos.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * @author Marco
 * @date 1/3/2026
 */

@Configuration
@EnableRabbit
public class RabbitMQConfig
{
    @RabbitListener(queues = "cuentaQueue")
    public void listen(String message) {
        System.out.println(message);
    }
}
