# Sessão CRC — Classe, Responsabilidade, Colaboração

| Classe | Responsabilidade | Colabora com |
|---|---|---|
| Shipment | representar solicitação de envio | Delivery |
| Delivery | manter ciclo de vida/status | notificação/eventos |
| FreightPolicy | calcular preço | Shipment |
| CarrierGateway | enviar/rastrear | transportadora externa |
| NotificationSubscriber | reagir a eventos | Delivery |
