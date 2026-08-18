/*
 * NEXUSLOG - COMENTÁRIOS DIDÁTICOS
 * Arquivo: ShipmentEventPublisher.java
 *
 * Finalidade:
 * MENSAGERIA (Aula 11): publica o evento "shipment.criado" e segue em frente, sem
 * esperar (nem saber) quem vai processar esse evento. É o mesmo Shipment que já existe
 * desde o domínio original — nenhuma classe de domínio precisou mudar para isso funcionar.
 */
package br.edu.nexuslog.events;

import br.edu.nexuslog.domain.Shipment;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShipmentEventPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publicarShipmentCriado(Shipment shipment) {
        rabbitTemplate.convertAndSend(
            RabbitConfig.EXCHANGE,
            RabbitConfig.ROUTING_KEY_CRIADO,
            shipment
        );
    }
}
