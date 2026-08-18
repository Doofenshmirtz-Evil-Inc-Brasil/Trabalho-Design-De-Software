/*
 * NEXUSLOG - COMENTÁRIOS DIDÁTICOS
 * Arquivo: CorreiosAdapter.java
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
import br.edu.nexuslog.integration.external.CorreiosLegacyClient;

// Classe concreta: implementa uma responsabilidade específica dentro do desenho.

public class CorreiosAdapter implements CarrierGateway {
    // Dependência/estado obrigatório mantido como `final`: favorece objeto estável após a construção.
    private final CorreiosLegacyClient client;

    public CorreiosAdapter(CorreiosLegacyClient client) {
        this.client = client;
    }

    // Implementação do contrato da abstração; aqui aparece o comportamento específico.

    @Override
    public String createShipment(Shipment shipment) {
        return client.postar(shipment.id(), shipment.weightKg());
    }

    // Implementação do contrato da abstração; aqui aparece o comportamento específico.

    @Override
    public String track(String trackingCode) {
        return client.consultarObjeto(trackingCode);
    }
}
