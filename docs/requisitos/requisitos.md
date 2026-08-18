# Requisitos do NexusLog

## Funcionais
- RF01: cadastrar uma solicitação de entrega.
- RF02: calcular frete conforme modalidade.
- RF03: selecionar/acionar uma transportadora.
- RF04: acompanhar mudança de status.
- RF05: notificar interessados.
- RF06: gerar identificação/etiqueta de envio.

## Não funcionais
- RNF01 Segurança: dados sensíveis não devem aparecer em logs.
- RNF02 Desempenho: cálculo de frete local deve responder rapidamente.
- RNF03 Disponibilidade: falha de uma transportadora não deve impedir consulta local.
- RNF04 Manutenibilidade: inclusão de nova modalidade deve minimizar alterações.
- RNF05 Rastreabilidade: decisões relevantes devem apontar para requisitos/ADRs.
