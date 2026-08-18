/*
 * NEXUSLOG - COMENTÁRIOS DIDÁTICOS
 * Arquivo: SimpleFreightService.java
 *
 * Finalidade:
 * SERVIÇO DE DOMÍNIO: contém a fórmula de cálculo de frete usada em todo o projeto,
 * desde a Aula 03 (comparação com o legado) até a Aula 14 (cache distribuído).
 *
 * Leitura recomendada em aula:
 * 1) esta é a mesma fórmula do LegacyShippingService, agora isolada em sua própria classe;
 * 2) a partir da Aula 14, o resultado passa a ser armazenado em cache (Redis) — a fórmula
 *    em si não muda, só passa a não ser recalculada toda vez para os mesmos parâmetros.
 */
package br.edu.nexuslog.service;

import br.edu.nexuslog.domain.Shipment;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SimpleFreightService {

    @Cacheable(value = "frete", key = "#shipment.id() + #freightType")
    public double calculate(Shipment shipment, String freightType) {
        // Etapa intermediária: ainda há seleção por tipo — ponto de crescimento natural
        // caso surjam novas modalidades de frete no futuro.
        return switch (freightType) {
            case "ECONOMICO" -> 10.0 + shipment.weightKg() * 1.5;
            case "EXPRESSO" -> 25.0 + shipment.weightKg() * 3.0;
            case "PRIORITARIO" -> 40.0 + shipment.weightKg() * 4.5;
            default -> throw new IllegalArgumentException("Modalidade inválida");
        };
    }
}
