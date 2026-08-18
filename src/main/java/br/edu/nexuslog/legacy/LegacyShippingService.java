/*
 * NEXUSLOG - COMENTÁRIOS DIDÁTICOS
 * Arquivo: LegacyShippingService.java
 *
 * Finalidade:
 * LEGADO DIDÁTICO: este código é propositalmente problemático e existe para diagnóstico e comparação. NÃO representa a solução recomendada.
 *
 * Leitura recomendada em aula:
 * 1) identifique a responsabilidade desta classe;
 * 2) identifique de quais abstrações ela depende;
 * 3) observe o que mudaria se surgisse uma nova regra/integração;
 * 4) relacione a decisão a coesão, acoplamento, SOLID e/ou decisão arquitetural.
 */
package br.edu.nexuslog.legacy;

// Classe concreta: implementa uma responsabilidade específica dentro do desenho.

public class LegacyShippingService {
    public double process(String customerName, String freightType, double weightKg, String carrier) {
        // Código propositalmente ruim para diagnóstico em sala.
        double price = 0.0;

        // PROBLEMA DIDÁTICO: cada nova modalidade força alteração desta classe (sinal de baixa extensibilidade).

        if ("ECONOMICO".equals(freightType)) {
            price = 10.0 + weightKg * 1.5;
        } else if ("EXPRESSO".equals(freightType)) {
            price = 25.0 + weightKg * 3.0;
        } else if ("PRIORITARIO".equals(freightType)) {
            price = 40.0 + weightKg * 4.5;
        }

        // PROBLEMA DIDÁTICO: o núcleo conhece fornecedores concretos; isso gera acoplamento com integrações externas.

        if ("CORREIOS".equals(carrier)) {
            System.out.println("Chamando API Correios...");
        } else if ("RAPIDEX".equals(carrier)) {
            System.out.println("Chamando API Rapidex...");
        }

        System.out.println("Enviando e-mail para " + customerName);
        System.out.println("Registrando log de envio para " + customerName);
        return price;
    }
}
