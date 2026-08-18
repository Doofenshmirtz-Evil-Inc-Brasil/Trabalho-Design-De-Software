/*
 * NEXUSLOG - COMENTÁRIOS DIDÁTICOS
 * Arquivo: CreateShipmentUseCase.java
 *
 * Finalidade:
 * APLICAÇÃO: coordena um caso de uso sem assumir detalhes de infraestrutura.
 *
 * Leitura recomendada em aula:
 * 1) identifique a responsabilidade desta classe;
 * 2) identifique de quais abstrações ela depende;
 * 3) observe o que mudaria se surgisse uma nova regra/integração;
 * 4) relacione a decisão a coesão, acoplamento, SOLID e/ou decisão arquitetural.
 */
package br.edu.nexuslog.application;

import br.edu.nexuslog.domain.Shipment;

// Classe concreta: implementa uma responsabilidade específica dentro do desenho.

public class CreateShipmentUseCase {
    public Shipment execute(String id, String customerName, double weightKg) {
        return new Shipment(id, customerName, weightKg);
    }
}
