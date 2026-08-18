# NexusLog — Projeto Completo Comentado
## Projeto de referência da Unidade Curricular Design de Software — 80h

> Este repositório reúne a **versão consolidada do NexusLog**, utilizada como projeto de referência do professor ao longo das 20 aulas.
> O código está comentado com finalidade didática: os comentários explicam **o que o código faz, por que a decisão existe e a qual conceito de Design de Software ela se relaciona**.
>
> **Nota de revisão:** este projeto foi readequado para acompanhar o Plano de Ensino vigente, focado em arquitetura de software (estilos arquiteturais, Spring Boot, Angular, REST, arquitetura orientada a eventos, cache distribuído e API Gateway). Padrões de projeto (GoF) não fazem mais parte do escopo desta Unidade Curricular — eles são tratados em profundidade em uma UC específica no semestre seguinte.

---

# 1. Finalidade do projeto

O NexusLog é uma plataforma didática de logística e entregas.

O domínio foi escolhido porque permite trabalhar, dentro de um mesmo projeto:

- requisitos funcionais e não funcionais;
- contexto e stakeholders;
- problemas de design;
- evolução de software e sistemas legados;
- reúso de software e engenharia baseada em componentes;
- estilos arquiteturais e sua escolha justificada;
- implementação com Spring Boot, Angular e REST;
- arquitetura orientada a eventos (mensageria, filas, roteamento);
- cache distribuído e desempenho;
- API Gateway;
- contratos de integração;
- ADRs;
- avaliação e auditoria;
- consolidação e apresentação técnica.

O objetivo **não é produzir um sistema comercial de logística completo**.
O objetivo é transformar o projeto em um laboratório no qual cada conceito da Unidade Curricular modifica ou explica uma parte real da solução.

---

# 2. Metodologia pedagógica adotada

A metodologia segue uma evolução incremental:

**professor demonstra → aluno observa o problema → grupo aplica no próprio projeto → grupo registra a decisão → grupo comunica/valida → professor orienta a próxima evolução**

A aplicação deve ser conduzida com quatro regras:

1. **começar pelo problema, não pela tecnologia**;
2. **justificar cada decisão**;
3. **manter rastreabilidade entre requisito, decisão e artefato**;
4. **evoluir o mesmo projeto, evitando exercícios desconectados**.

O NexusLog é o exemplo do professor.
Os grupos não precisam copiar o domínio de logística: devem transportar o princípio demonstrado para o projeto escolhido pelo grupo (ou para o Projeto Integrador, a partir da Aula 18).

---

# 3. Como usar o projeto em sala

Em cada encontro:

## Parte A — retomada
O professor abre a versão/estado anterior e revisa rapidamente: o problema existente, o artefato produzido, o que ainda ficou pendente.

## Parte B — conceito
O conteúdo teórico é apresentado com exemplos simples e, depois, relacionado ao NexusLog.

## Parte C — demonstração supervisionada
O professor altera ou apresenta os arquivos correspondentes ao novo conteúdo.

## Parte D — prática dos grupos
Cada grupo aplica o **mesmo princípio** no seu projeto.

## Parte E — registro
O grupo registra: problema, decisão, justificativa, diagrama/código/documento, consequência, commit.

## Parte F — comunicação/validação
Flash Demo, revisão cruzada, Issue, checklist ou devolutiva, conforme a aula.

---

# 4. Organização sugerida de um encontro de 4h

- **18h30–18h50** — retomada e objetivos;
- **18h50–19h35** — conceito e exemplos;
- **19h35–20h10** — demonstração do professor no NexusLog;
- **20h10–20h30** — início da prática orientada;
- **20h30–20h45** — intervalo;
- **20h45–21h45** — desenvolvimento supervisionado dos grupos;
- **21h45–22h15** — validação, peer review ou Flash Demo;
- **22h15–22h35** — documentação, commit e entrega;
- **22h35–22h45** — fechamento e preparação da aula seguinte.

A divisão pode ser ajustada conforme avaliação, dificuldade da turma e atividades institucionais.

---

# 5. Evolução completa — Aulas 01 a 20

## Aula 01 — Fundamentos
**Objetivo:** distinguir Design de Software, Web Design e Arquitetura de Software; apresentar os 7 princípios de Hooker; organizar equipe e repositório.
**NexusLog:** o projeto nasce pequeno. Não há arquitetura sofisticada.
**Artefatos:** `docs/conceitos-iniciais.md` · `docs/equipe.md` · `README.md`
**Aprendizado central:** antes de escrever código, é preciso saber qual problema será resolvido.

## Aula 02 — Contexto
**Objetivo:** contexto de software, stakeholders, restrições, ciclo compreender → propor → validar.
**NexusLog:** identificados cliente, operador, destinatário, transportadoras e serviços externos.
**Artefatos:** `docs/contexto.md` · `docs/diagramas/contexto.md`
**Aprendizado central:** nenhuma decisão técnica existe fora de um contexto de negócio.

## Aula 03 — Diagnóstico
**Objetivo:** identificar acoplamento excessivo, baixa coesão, duplicação, condicionais crescentes.
**NexusLog:** `LegacyShippingService` mantido propositalmente como exemplo de código problemático.
**Artefatos:** `legacy/LegacyShippingService.java` · `docs/achados-tecnicos.md`
**Aprendizado central:** primeiro localizar evidências; depois propor solução.

## Aula 04 — Arquitetura de Software: Introdução, Evolução e Projeto Arquitetural
**Objetivo:** reconhecer a natureza e a necessidade da arquitetura de software; introduzir projeto arquitetural.
**NexusLog:** responsabilidades começam a ser separadas do legado — domínio (`Shipment`), cálculo (`SimpleFreightService`), notificação (`NotificationService`).
**Artefatos:** `Shipment` · `SimpleFreightService` · `NotificationService` · `ADR-001`
**Aprendizado central:** um sistema pode passar em todos os testes hoje e ainda ser inviável de manter em dois anos.

## Aula 05 — Requisitos Arquiteturais e Evolução de Software
**Objetivo:** classificar requisitos funcionais e não funcionais; entender como sistemas legados chegam ao estado diagnosticado na Aula 03.
**Artefatos:** `docs/requisitos/requisitos.md` · `docs/requisitos/rastreabilidade.md`
**Aprendizado central:** são os requisitos não funcionais que mais pesam nas decisões estruturais.

## Aula 06 — Reúso de Software e Engenharia Baseada em Componentes
**Objetivo:** identificar componentes reutilizáveis no sistema legado.
**NexusLog:** candidatos identificados — cálculo de frete, validação de dados de envio, integração com transportadoras.
**Artefatos:** `docs/planejamento/backlog.md` · `docs/planejamento/checklist.md`
**Aprendizado central:** um componente reutilizável nasce de isolar uma responsabilidade atrás de uma interface clara.

## Aula 07 — Estilos Arquiteturais: Visão Comparativa e Decisão
**Objetivo:** comparar monolítica, em camadas, distribuída, microsserviços, SOA, cliente-servidor e peer-to-peer.
**Decisão do NexusLog:** monólito modular/em camadas, com eventos usados pontualmente a partir da Aula 11.
**Artefatos:** `docs/arquitetura/tradeoffs.md` · `docs/diagramas/c4-contexto.md`
**Aprendizado central:** não existe estilo "melhor" — a pergunta certa é qual resolve os problemas reais do NexusLog.

## Aula 08 — Spring Boot + Angular + Arquitetura REST
**Objetivo:** estruturar backend (Spring Boot) e frontend (Angular), comunicando-se via REST.
**NexusLog:** entra a API REST, expondo o `CreateShipmentUseCase` já existente.
**Artefatos:** `NexusLogApplication.java` · `api/ShipmentController.java`
**Aprendizado central:** a lógica de negócio não muda ao ganhar uma porta HTTP.

## Aula 09 — Revisão Geral e Apresentação dos Estilos Arquiteturais
**Objetivo:** consolidar Aulas 04-08; grupos apresentam os estilos aprofundados desde a Aula 07.
**Artefato:** `docs/revisao/sintese-n1.md`
**Pergunta de controle:** se o código fosse removido, a documentação explicaria por que a solução tomou essa forma?

## Aula 10 — Avaliação N1
**Objetivo:** avaliação individual (Forms/Classroom + exercício prático), cobrindo Aulas 01-09.
**Artefato:** `docs/revisao/checkpoint-n1.md`
**Observação:** congelamento controlado do projeto — não inserir funcionalidade artificial só porque há uma aula.

## Aula 11 — Arquitetura Orientada a Eventos: Mensageria e Filas
**Objetivo:** mensageria e filas como desacoplamento temporal.
**NexusLog:** publicação do evento `shipment.criado`.
**Artefatos:** `events/RabbitConfig.java` · `events/ShipmentEventPublisher.java`
**Aprendizado central:** quem publica um evento segue em frente, sem esperar quem vai processá-lo.

## Aula 12 — Arquitetura Orientada a Eventos: Produtores e Consumidores
**Objetivo:** consumidores independentes reagindo ao mesmo evento.
**NexusLog:** `NotificacaoConsumer` reage a `shipment.criado`, acionando o `NotificationService` existente.
**Artefato:** `events/NotificacaoConsumer.java`
**Aprendizado central:** o mesmo evento pode ter vários consumidores independentes.

## Aula 13 — Arquitetura Orientada a Eventos: Roteamento de Eventos e CDN
**Objetivo:** rotear eventos por routing key; entender quando CDN se aplica.
**Artefatos:** `docs/diagramas/sequencia-envio.md` · `docs/integracao/shipment-contract.json`
**Aprendizado central:** routing key permite que cada consumidor escute só o que importa para ele.

## Aula 14 — Cache Distribuído (Redis/Memcached)
**Objetivo:** aplicar cache a uma operação cara e repetitiva; medir o ganho de desempenho.
**NexusLog:** `SimpleFreightService.calculate()` agora anotado com `@Cacheable`.
**Artefato:** `service/SimpleFreightService.java` (atualizado)
**Aprendizado central:** o desafio real do cache é saber quando o dado deixa de ser válido.

## Aula 15 — API Gateway
**Objetivo:** avaliar se um Gateway se justifica; configurar roteamento, autenticação, rate limiting.
**Artefato:** `docs/arquitetura/api-gateway.md`
**Aprendizado central:** centralizar regras transversais evita reimplementá-las em cada serviço.

## Aula 16 — Revisão Geral e Preparação para a Avaliação N2
**Objetivo:** consolidar mensageria, cache e API Gateway.
**Aprendizado central:** os mecanismos das Aulas 11-15 são respostas a demandas específicas, não peças soltas.

## Aula 17 — Avaliação N2 (avaliação final da UC)
**Objetivo:** avaliação individual (Forms/Classroom + exercício prático), cobrindo Aulas 11-16.
**Artefato:** `docs/revisao/checkpoint-n2.md`

## Aulas 18-20 — Apoio ao Projeto Integrador (PI)
**Objetivo:** aplicar os conteúdos da UC ao PI. Sem conteúdo novo.
**Artefatos:** `docs/final/roteiro-apresentacao.md` · `docs/final/checklist-entrega.md`
**Linha narrativa da apresentação:** problema → contexto → requisitos → arquitetura → implementação → eventos → desempenho → resultado.

---

# 6. Estrutura do código

```text
src/main/java/br/edu/nexuslog/
├── App.java                    # demonstração do legado (Aula 03)
├── NexusLogApplication.java    # ponto de entrada Spring Boot (Aula 08+)
├── QualityCheck.java           # verificação didática simples
├── api/                        # controllers REST (Aula 08)
├── application/                # casos de uso
├── domain/                     # conceitos centrais do negócio
├── events/                     # mensageria: config, publisher, consumer (Aulas 11-13)
├── integration/
│   └── external/                # isola interfaces com sistemas externos
├── legacy/                     # versão problemática mantida para comparação
└── service/                    # serviços de domínio (frete, notificação)
```

**`legacy`** mantém a versão problemática para comparação. **`domain`** contém conceitos centrais do negócio. **`application`** representa casos de uso. **`integration`** isola interfaces com sistemas externos. **`api`** expõe casos de uso como endpoints REST. **`events`** cuida da mensageria. **`service`** contém os serviços de domínio, evoluídos ao longo do projeto — inclusive com cache distribuído a partir da Aula 14.

---

# 7. Execução

**Pré-requisitos:** JDK 17+, Maven 3.8+, RabbitMQ e Redis rodando localmente a partir da Aula 11 (ver `src/main/resources/application.yml`).

```bash
mvn compile
```

- **Projeto legado (Aula 03):** execute `br.edu.nexuslog.App`
- **API REST (Aula 08+):** execute `br.edu.nexuslog.NexusLogApplication` (requer RabbitMQ/Redis a partir da Aula 11)
- **Verificação didática:** execute `br.edu.nexuslog.QualityCheck`

---

# 8. Como o professor deve usar o código comentado

Os comentários internos foram escritos em três níveis: **O QUE** (comportamento), **POR QUÊ** (a decisão), **DESIGN** (relação com o conteúdo da disciplina). Em aula, o ideal é não ler todos os comentários — use-os como roteiro de apoio e peça que os alunos identifiquem a justificativa antes de revelá-la.

---

# 9. O que os grupos devem entregar ao longo do semestre

README, contexto, requisitos, diagramas, ADRs, código (backend Spring Boot + frontend Angular), contratos de integração, checklists, Issues/peer review, commits, evidências de desempenho (com e sem cache), apresentação final.

A avaliação deve observar: coerência, justificativa técnica das escolhas arquiteturais, rastreabilidade, aplicação correta dos conceitos, capacidade de explicar trade-offs.

---

# 10. Regra final do projeto

> **Um bom Design de Software não é o que utiliza a arquitetura mais sofisticada. É o que resolve o problema com responsabilidades claras, decisões justificadas e complexidade proporcional à necessidade.**
