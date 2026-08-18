/*
 * NEXUSLOG - COMENTÁRIOS DIDÁTICOS
 * Arquivo: CorreiosLegacyClient.java
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
package br.edu.nexuslog.integration.external;

// Classe concreta: implementa uma responsabilidade específica dentro do desenho.

public class CorreiosLegacyClient {
    public String postar(String codigoPedido, double peso) {
        return "BR-" + codigoPedido + "-" + ((int)(peso * 10));
    }
    public String consultarObjeto(String codigo) {
        return "EM_TRANSITO:" + codigo;
    }
}
