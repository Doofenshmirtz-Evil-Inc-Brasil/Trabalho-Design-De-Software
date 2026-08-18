/*
 * NEXUSLOG - COMENTÁRIOS DIDÁTICOS
 * Arquivo: App.java
 *
 * Finalidade:
 * CLASSE DE DEMONSTRAÇÃO: ponto de entrada usado para tornar o comportamento do projeto observável em sala.
 *
 * Leitura recomendada em aula:
 * 1) identifique a responsabilidade desta classe;
 * 2) identifique de quais abstrações ela depende;
 * 3) observe o que mudaria se surgisse uma nova regra/integração;
 * 4) relacione a decisão a coesão, acoplamento, SOLID e/ou decisão arquitetural.
 */
package br.edu.nexuslog;

import br.edu.nexuslog.legacy.LegacyShippingService;

// Classe concreta: implementa uma responsabilidade específica dentro do desenho.

public class App {
    public static void main(String[] args) {
        LegacyShippingService service = new LegacyShippingService();
        double price = service.process("Cliente Exemplo", "EXPRESSO", 8.5, "CORREIOS");
        System.out.println("Preço calculado: R$ " + price);
    }
}
