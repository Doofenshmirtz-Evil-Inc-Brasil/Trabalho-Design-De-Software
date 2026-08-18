/*
 * NEXUSLOG - COMENTÁRIOS DIDÁTICOS
 * Arquivo: NexusLogApplication.java
 *
 * Finalidade:
 * PONTO DE ENTRADA SPRING BOOT: usado a partir da Aula 08, quando o sistema passa a
 * expor uma API REST (Spring Boot) consumida pelo frontend (Angular).
 *
 * Este arquivo convive com App.java (demonstração do legado, Aula 03) e QualityCheck.java
 * (verificação simples da fórmula de frete) — cada um com um propósito didático diferente.
 */
package br.edu.nexuslog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class NexusLogApplication {
    public static void main(String[] args) {
        SpringApplication.run(NexusLogApplication.class, args);
    }
}
