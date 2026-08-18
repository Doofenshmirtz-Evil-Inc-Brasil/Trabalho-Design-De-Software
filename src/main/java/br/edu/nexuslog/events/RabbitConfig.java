/*
 * NEXUSLOG - COMENTÁRIOS DIDÁTICOS
 * Arquivo: RabbitConfig.java
 *
 * Finalidade:
 * MENSAGERIA (Aula 11): declara a exchange e as filas usadas para desacoplar a criação
 * de uma remessa das ações que precisam acontecer em seguida (notificação, atualização
 * de status), sem que o ShipmentController precise saber quem consome cada evento.
 */
package br.edu.nexuslog.events;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String EXCHANGE = "shipments.exchange";
    public static final String QUEUE_NOTIFICACAO = "notificacao.queue";
    public static final String ROUTING_KEY_CRIADO = "shipment.criado";

    @Bean
    public TopicExchange shipmentsExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Queue notificacaoQueue() {
        return new Queue(QUEUE_NOTIFICACAO);
    }

    @Bean
    public Binding bindingNotificacao(Queue notificacaoQueue, TopicExchange shipmentsExchange) {
        return BindingBuilder.bind(notificacaoQueue)
            .to(shipmentsExchange)
            .with(ROUTING_KEY_CRIADO);
    }
}
