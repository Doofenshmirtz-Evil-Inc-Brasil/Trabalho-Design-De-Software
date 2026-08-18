# ADR-002 — Adapter para transportadoras

**Problema:** APIs externas possuem nomes, formatos e ciclos diferentes.

**Decisão:** expor internamente `CarrierGateway` e adaptar cada API externa.

**Vantagens:** reduz acoplamento com fornecedores; facilita troca e teste.

**Desvantagens:** cria classes adicionais; mudanças profundas na API externa ainda exigem manutenção do adapter.
