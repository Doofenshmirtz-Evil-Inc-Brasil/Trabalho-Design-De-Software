/*
 * NEXUSLOG - COMENTÁRIOS DIDÁTICOS
 * Arquivo: Shipment.java
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

// Record: objeto de dados imutável, adequado para representar um valor/conceito simples do domínio.

public record Shipment(String id, String customerName, double weightKg) {
    public Shipment {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id obrigatório");
        if (customerName == null || customerName.isBlank()) throw new IllegalArgumentException("cliente obrigatório");
        if (weightKg <= 0) throw new IllegalArgumentException("peso deve ser positivo");
    }
}
