# NexusLog

Projeto de referência completo da Unidade Curricular **Design de Software — 80h**.

## Comece aqui

Leia primeiro: **`READ.md`**

Esse arquivo contém:
- metodologia adotada;
- sequência das 20 aulas;
- como o projeto evoluiu;
- relação entre artefatos e conteúdos;
- roteiro de execução;
- orientação para professor e alunos.

## Projeto

O NexusLog simula uma plataforma de logística e entregas e foi construído para ensinar
Design de Software de forma incremental, com foco em arquitetura de software (estilos
arquiteturais, Spring Boot, Angular, REST, arquitetura orientada a eventos, cache
distribuído e API Gateway).

## Comandos

```bash
mvn compile
```

Classes principais:
- `App` — demonstra o legado (Aula 03);
- `NexusLogApplication` — API REST Spring Boot (Aula 08 em diante);
- `QualityCheck` — verificação didática.

## Observação didática

O pacote `legacy` contém código propositalmente inadequado.
Ele é mantido para que a turma consiga comparar o problema inicial com a solução evoluída.
