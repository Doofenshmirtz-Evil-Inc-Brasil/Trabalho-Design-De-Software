/*
 * NEXUSLOG - COMENTÁRIOS DIDÁTICOS
 * Arquivo: QualityCheck.java
 *
 * Finalidade:
 * CLASSE DE DEMONSTRAÇÃO: ponto de entrada usado para tornar o comportamento do projeto observável em sala.
 *
 * Leitura recomendada em aula:
 * 1) identifique a responsabilidade desta classe;
 * 2) confirme que a fórmula de cálculo de frete está correta;
 * 3) relacione essa verificação simples ao papel de testes na evolução do sistema.
 */
package br.edu.nexuslog;

import br.edu.nexuslog.domain.Shipment;
import br.edu.nexuslog.service.SimpleFreightService;

public class QualityCheck {
    public static void main(String[] args) {
        Shipment s = new Shipment("T1", "Teste", 10.0);
        SimpleFreightService freightService = new SimpleFreightService();
        double economic = freightService.calculate(s, "ECONOMICO");
        if (Math.abs(economic - 25.0) > 0.0001) {
            throw new AssertionError("Cálculo econômico incorreto");
        }
        System.out.println("QualityCheck OK");
    }
}
