/*
 * NEXUSLOG - COMENTÁRIOS DIDÁTICOS
 * Arquivo: Delivery.java
 *
 * Finalidade:
 * DOMÍNIO: contém conceitos centrais do negócio. O objetivo é manter regras essenciais separadas de detalhes de infraestrutura.
 *
 * Leitura recomendada em aula:
 * 1) identifique a responsabilidade desta classe;
 * 2) identifique de quais abstrações ela depende;
 * 3) observe o que mudaria se surgisse uma nova regra/integração;
 * 4) relacione a decisão a coesão, acoplamento, SOLID e/ou decisão arquitetural.
 */
package br.edu.nexuslog.domain;

// Classe concreta: implementa uma responsabilidade específica dentro do desenho.

public class Delivery {
    // Dependência/estado obrigatório mantido como `final`: favorece objeto estável após a construção.
    private final Shipment shipment;
    private DeliveryStatus status;

    public Delivery(Shipment shipment) {
        this.shipment = shipment;
        this.status = DeliveryStatus.RECEBIDO;
    }

    public Shipment shipment() { return shipment; }
    public DeliveryStatus status() { return status; }
    public void changeStatus(DeliveryStatus newStatus) { this.status = newStatus; }
}
