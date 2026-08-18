# ADR-002 — Isolamento da integração com transportadoras externas

**Status:** Aceito

**Contexto:** APIs externas (Correios, Rapidex) possuem nomes, formatos e ciclos de
mudança diferentes entre si — e diferentes da forma como a NexusLog organiza seus
próprios dados internamente.

**Decisão:** expor internamente uma interface própria (`CarrierGateway`) e implementar,
para cada transportadora, uma classe que traduz entre a API externa e essa interface
interna (ex.: `CorreiosAdapter` conversa com `CorreiosLegacyClient` e devolve o formato
que o resto do sistema espera).

**Consequências:**
- O restante do sistema depende só de `CarrierGateway`, nunca diretamente de uma API
  externa específica — trocar de transportadora, ou adicionar uma nova, não exige
  alterar código que já funciona.
- Cria uma classe adicional por transportadora integrada — um custo aceito em troca do
  desacoplamento.
- Mudanças profundas numa API externa ainda exigem atualizar o adapter correspondente,
  mas o impacto fica contido ali, sem se espalhar pelo resto do sistema.
