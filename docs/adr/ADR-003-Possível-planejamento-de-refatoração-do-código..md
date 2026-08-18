# ADR-0003: Possível Planejamento de Refatoração do Código.

## Status
Aceito


## Contexto
Foi dado em código apresentando uma estrutura passivel de erro. Nesse contexto foram encontradas as seguintes faljas no código, sendo elas: 1) Baixa coesão 
      2) Acoplamento excessivo
      3) Condicionais crescentes

## Decisão 

Em consenso, a equipe chegou as seguintes conclusões para solucionar os erros acima.
      1) Para a baixa coesão, a solução é separar essas responsabilidades em classes diferentes: uma só pra calcular
      2) Para o Acoplamento excessivo, a ideia é criar uma interface, algo como CarrierGateway, e cada transportadora ter sua própria implementação
      3) Para as Condicionais crescentes, a gente propõe representar os tipos de frete como um enum, com a regra de cálculo já associada a cada valor.


## Consequências

Com essa refatoração o código se tornou mais responsivo, limpo e menos suscetível a falhas devido a baixa coesão. Por consequência se tornou mais funcional.
---
*Autor(es): Gabriel Nazaré, Riudy Eduardo, Diogo Costa, Luiz Felipe, Vinicius Barbosa, Erick Marques*
*Data: 15/08/2026*