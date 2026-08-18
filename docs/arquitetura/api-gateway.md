# API Gateway — Referência para a Aula 15

## Por que um Gateway para a NexusLog

Se a equipe decidiu (Aula 07) por uma arquitetura com mais de um serviço independente,
expor cada serviço diretamente ao Angular cria complexidade desnecessária: o frontend
precisaria conhecer o endereço de cada serviço, e regras transversais (autenticação,
limite de requisições) precisariam ser reimplementadas em cada um.

Se a equipe decidiu por um monólito modular bem estruturado, um Gateway completo pode
ser um exagero para o tamanho do projeto — documentem essa decisão também, se for o caso.

## Exemplo de configuração (Spring Cloud Gateway)

Para equipes que optarem por implementar um Gateway de verdade, um novo módulo Maven
separado (`nexuslog-gateway`) com a dependência `spring-cloud-starter-gateway` e uma
configuração como esta já resolve o roteamento básico:

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: shipments-service
          uri: http://localhost:8080
          predicates:
            - Path=/api/shipments/**
        - id: tracking-service
          uri: http://localhost:8081
          predicates:
            - Path=/api/tracking/**
```

## O que documentar na atividade da Aula 15

- Qual(is) serviço(s) da NexusLog o Gateway routeia.
- Se autenticação está centralizada no Gateway ou em cada serviço.
- Se algum limite de requisições (rate limiting) foi configurado, e por quê.
- Caso a equipe tenha decidido que um Gateway não se justifica: a justificativa técnica
  para essa escolha vale tanto quanto a implementação em si.
