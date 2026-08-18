/*
 * NEXUSLOG - COMENTÁRIOS DIDÁTICOS
 * Arquivo: NotificationService.java
 *
 * Finalidade:
 * SERVIÇO DIDÁTICO: etapa intermediária de separação de responsabilidades usada antes da introdução formal dos padrões.
 *
 * Leitura recomendada em aula:
 * 1) identifique a responsabilidade desta classe;
 * 2) identifique de quais abstrações ela depende;
 * 3) observe o que mudaria se surgisse uma nova regra/integração;
 * 4) relacione a decisão a coesão, acoplamento, SOLID e/ou decisão arquitetural.
 */
package br.edu.nexuslog.service;

// Classe concreta: implementa uma responsabilidade específica dentro do desenho.

public class NotificationService {
    public void sendStatus(String customerName, String message) {
        System.out.println("[NOTIFICAÇÃO] " + customerName + ": " + message);
    }
}
