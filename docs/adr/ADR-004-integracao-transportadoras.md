# ADR-004 Separar responsabilidades básicas

*Contexto:* O metodo LegacyShippingService estava apresentando uma baixa coesão, onde a classe em especifico estava executando 3 funções ao mesmo tempo.

*Decisão:* O grupo em conjunto, optou pela separaçao da classe 'LegacyShippingService', em 3 classes distintas: Shipment(Classe Validadora), SimpleFreightService(Classe de calculo), NotificationService(Classe de Notificação).

*Vantagens:* aumenta coesão, legibilidade e testabilidade.

*Desvantagens:* aumenta a quantidade de classes e exige disciplina de organização, oque aumenta de forma consideravel os numeros de processos.