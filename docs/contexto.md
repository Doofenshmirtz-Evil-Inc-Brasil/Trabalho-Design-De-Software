# Contexto do NexusLog

## Problema

Empresas que realizam entregas precisam lidar com diferentes modalidades de frete,
transportadoras, rastreamento e comunicação com clientes.

O NexusLog será usado como laboratório para mostrar como decisões de design evoluem
quando o problema se torna mais complexo.

## Stakeholders

| Stakeholder | Interesse |
|---|---|
| Cliente/remetente | Cotação, envio e rastreamento |
| Destinatário | Saber o status da entrega |
| Operador logístico | Operar e acompanhar entregas |
| Transportadora | Receber solicitações de envio |
| Administrador | Configurar e acompanhar o sistema |

## Sistemas externos
- API de transportadora;
- serviço de e-mail/SMS/WhatsApp;
- futuramente serviços adicionais.

## Restrições
- APIs externas podem ter formatos incompatíveis;
- serviços externos podem falhar;
- novas modalidades de frete poderão ser adicionadas;
- decisões precisam ser rastreáveis.

## Necessidades iniciais
- registrar uma solicitação de entrega;
- calcular frete;
- encaminhar a entrega para uma transportadora;
- acompanhar status;
- notificar interessados.
