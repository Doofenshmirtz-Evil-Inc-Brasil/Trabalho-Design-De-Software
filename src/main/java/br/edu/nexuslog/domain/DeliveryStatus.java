/*
 * NEXUSLOG - COMENTÁRIOS DIDÁTICOS
 * Arquivo: DeliveryStatus.java
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

// Enum: restringe o conjunto de estados válidos e evita strings soltas para representar o ciclo de vida.

public enum DeliveryStatus {
    RECEBIDO, COLETADO, EM_TRANSITO, SAIU_PARA_ENTREGA, ENTREGUE
}
