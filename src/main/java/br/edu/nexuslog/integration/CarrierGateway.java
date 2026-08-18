/*
 * NEXUSLOG - COMENTÁRIOS DIDÁTICOS
 * Arquivo: CarrierGateway.java
 *
 * Finalidade:
 * INTEGRAÇÃO: isola dependências externas atrás de contratos internos. Isso reduz acoplamento com fornecedores.
 *
 * Leitura recomendada em aula:
 * 1) identifique a responsabilidade desta classe;
 * 2) identifique de quais abstrações ela depende;
 * 3) observe o que mudaria se surgisse uma nova regra/integração;
 * 4) relacione a decisão a coesão, acoplamento, SOLID e/ou decisão arquitetural.
 */
package br.edu.nexuslog.integration;

import br.edu.nexuslog.domain.Shipment;

// Contrato: define o que os clientes podem usar sem conhecer a implementação concreta.

public interface CarrierGateway {
    String createShipment(Shipment shipment);
    String track(String trackingCode);
}
