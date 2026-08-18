/*
 * NEXUSLOG - COMENTÁRIOS DIDÁTICOS
 * Arquivo: NotificacaoConsumer.java
 *
 * Finalidade:
 * MENSAGERIA (Aula 12): consome o evento "shipment.criado" e aciona o NotificationService
 * já existente no projeto (antes chamado diretamente; agora reagindo a um evento assíncrono).
 * Esse consumidor não sabe nada sobre quem publicou o evento — só reage a ele.
 */
package br.edu.nexuslog.events;

import br.edu.nexuslog.domain.Shipment;
import br.edu.nexuslog.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoConsumer {

    private final NotificationService notificationService = new NotificationService();

    @RabbitListener(queues = RabbitConfig.QUEUE_NOTIFICACAO)
    public void processar(Shipment shipment) {
        notificationService.sendStatus(
            shipment.customerName(),
            "Recebemos sua remessa " + shipment.id() + "!"
        );
    }
}
