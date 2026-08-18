# Guia do código-fonte comentado

- `src/main/java/br/edu/nexuslog/App.java` — CLASSE DE DEMONSTRAÇÃO: ponto de entrada usado para tornar o comportamento do projeto observável em sala.
- `src/main/java/br/edu/nexuslog/QualityCheck.java` — CLASSE DE DEMONSTRAÇÃO: ponto de entrada usado para tornar o comportamento do projeto observável em sala.
- `src/main/java/br/edu/nexuslog/application/CreateShipmentUseCase.java` — APLICAÇÃO: coordena um caso de uso sem assumir detalhes de infraestrutura.
- `src/main/java/br/edu/nexuslog/domain/Delivery.java` — DOMÍNIO: contém conceitos centrais do negócio. O objetivo é manter regras essenciais separadas de detalhes de infraestrutura.
- `src/main/java/br/edu/nexuslog/domain/DeliveryStatus.java` — DOMÍNIO: contém conceitos centrais do negócio. O objetivo é manter regras essenciais separadas de detalhes de infraestrutura.
- `src/main/java/br/edu/nexuslog/domain/Shipment.java` — DOMÍNIO: contém conceitos centrais do negócio. O objetivo é manter regras essenciais separadas de detalhes de infraestrutura.
- `src/main/java/br/edu/nexuslog/integration/CarrierGateway.java` — INTEGRAÇÃO: isola dependências externas atrás de contratos internos. Isso reduz acoplamento com fornecedores.
- `src/main/java/br/edu/nexuslog/integration/CorreiosAdapter.java` — INTEGRAÇÃO: isola dependências externas atrás de contratos internos. Isso reduz acoplamento com fornecedores.
- `src/main/java/br/edu/nexuslog/integration/external/CorreiosLegacyClient.java` — INTEGRAÇÃO: isola dependências externas atrás de contratos internos. Isso reduz acoplamento com fornecedores.
- `src/main/java/br/edu/nexuslog/legacy/LegacyShippingService.java` — LEGADO DIDÁTICO: este código é propositalmente problemático e existe para diagnóstico e comparação. NÃO representa a solução recomendada.
- `src/main/java/br/edu/nexuslog/service/NotificationService.java` — SERVIÇO DE DOMÍNIO: usado diretamente até a Aula 11, e depois acionado pelo NotificacaoConsumer em resposta a eventos assíncronos.
- `src/main/java/br/edu/nexuslog/service/SimpleFreightService.java` — SERVIÇO DE DOMÍNIO: contém a fórmula de cálculo de frete usada em todo o projeto; a partir da Aula 14, seu resultado passa a ser armazenado em cache (Redis).
- `src/main/java/br/edu/nexuslog/NexusLogApplication.java` — PONTO DE ENTRADA SPRING BOOT: usado a partir da Aula 08, quando o sistema passa a expor uma API REST.
- `src/main/java/br/edu/nexuslog/api/ShipmentController.java` — API REST (Aula 08): expõe o CreateShipmentUseCase como endpoint HTTP, consumido pelo Angular.
- `src/main/java/br/edu/nexuslog/events/RabbitConfig.java` — MENSAGERIA (Aula 11): declara exchange e filas para desacoplar a criação de uma remessa das ações subsequentes.
- `src/main/java/br/edu/nexuslog/events/ShipmentEventPublisher.java` — MENSAGERIA (Aula 11): publica o evento "shipment.criado" sem esperar por quem vai consumi-lo.
- `src/main/java/br/edu/nexuslog/events/NotificacaoConsumer.java` — MENSAGERIA (Aula 12): consome o evento e aciona o NotificationService já existente no projeto.
