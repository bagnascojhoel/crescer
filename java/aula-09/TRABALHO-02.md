# Trabalho 02 - Aula 9

### Continuação...
  - Na aula 3 foram passadas as regras de negócio da aplicação e de lá para cá, a cada dia, foram solicitadas novas funcionalidades. Este trabalho tem como objetivo dar continuidade no que foi implementado observando os padrões de arquitetura de dados, mais a cobertura de testes unitários e também a persistência de dados ocorrendo no banco Oracle.


### Persistência

1. Reescrever todos os repository "em memória" utilizando a interface `Repository` do JPA
   - Basicamente será necessário apagar a implementação em memória e crias as interfaces utilizando a sintaxe que o Spring Data entende
   - ~~Definir qual interface do Spring Data deve ser usada (Repository, CrudRepository, PagingAndSortingRepository ou JpaRepository)~~
   - Se for necessário fazer uma consulta que não exista nas interfaces do Spring, implementar a consulta por assinaturas.


### Testes
- Todas as `Services`, `Validators` e `Mappers` devem ter testes.


### Entrega
- :warning: O código completo precisa estar comitado até as **13:29:59** de Segunda (16/11/2020).
- Criar uma nova pasta no repositório do aluno com nome de "trabalho02" com:
Código do backend, scripts para criação do banco, README.md com instruções para rodar o projeto e export da collection do postman. 
- Todos os exercícios serão **avaliados**.

---

## Bônus (Opcional)

### Exercício 1 - Integrar projeto de backend com fronted

### Exercício 2 - Paginação e Ordenação

1. Alterar o endpoint que lista `Motorista`, `Passageiro` e `Veiculo` para que ele seja paginável.
1. Por padrão, ordenar a listagem de `Motorista` por nome completo
1. Por padrão, ordenar a listagem de `Passageiro` por data de nascimento
1. Por padrão, ordenar a listagem de `Veiculo` por ano

### Exercício 3 - ProjeçãoNative Query

1. Alterar o método que busca o veículo disponível para que a consulta seja realizada direto no Banco de Dados.

### Exercício 4 - Projeção

1. Criar um endpoint para retornar um objeto que **represente** um relatório baseado no modelo abaixo:

| Data da Corrida | Nome Motorista | Placa do Veículo | Nome Passageiro | Custo Final | Avaliação Motorista | Avaliação Passageiro |
| --- | --- | --- | --- | :---: | :---: | :---: |
| 13/01/2018 | Nazgûl | IJC1309 | Gollum | 100,00 | 4 | 3 |
| 19/10/2017 | Carl "CJ" Johnson | AKJ2297 | John Marston | 300,00 | 3 | 3 |
| 21/01/2016 | Iron Man | CPO9862 | Spiderman | 3,45 | 5 | 5 | 
| 17/12/2018 | Bruce Wayne | KJM1201 | Jack Sparrow | 12,00 | 1 | 3 |

**Observações**
  - A consulta realizada no banco já deve retornar a projeção desejada
  - Por se tratar de um relatório, não deve ser uma consulta paginável

### Exercício 5 - Agregação e Filtro

 1. Criar um endpoint que retorne o total de gastos realizados por um passageiro em um determinado período.
   - Retorno Esperado
      - Nome do Passageiro
      - Valor total gasto
