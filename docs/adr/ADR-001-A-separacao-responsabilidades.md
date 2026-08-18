# ADR-001 — Separar responsabilidades básicas

**Contexto:** a classe legada concentra cálculo, integração e notificação.

**Decisão:** iniciar separação entre domínio (`Shipment`) e serviços específicos.

**Vantagens:** aumenta coesão, legibilidade e testabilidade.

**Desvantagens:** aumenta a quantidade de classes e exige disciplina de organização.
