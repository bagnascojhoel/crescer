## Trabalho em Duplas

![fire](resources/fire.gif)

---

### Objetivo do trabalho

Deve ser entregue uma aplicação completa **(com FRONTEND em React!)**, que seja possível:
1. Cadastrar e listar passageiros
1. Cadastrar, listar e excluir motoristas
1. Cadastrar e listar veículos
1. Passageiro chamar uma corrida
1. Motorista iniciar uma corrida
1. Motorista finalizar uma corrida
1. Passageiro adicionar saldo à própria conta
1. Motorista sacar valor da própria conta
1. Passageiro avaliar o motorista de uma corrida
1. Motorista avaliar o passageiro de uma corrida

> Todos os dados e regras de validação estão descritos no arquivo [ME-LEVA-AI.md](ME-LEVA-AI.md)

### Entrega
- :warning: O código completo precisa estar comitado até as **11:59:59** de Segunda.
- Todos os exercícios serão **avaliados**.

### Sugestões

- Definir um modelo de trabalho: trabalhar em pair e/ou em paralelo.
- Começar pelo planejamento: definir tarefas, estruturar telas.
- Se for necessário para algum fluxo de tela, está liberado criar outros endpoints.
- Começar pela API
- A partir de segunda, vamos continuar evoluindo a mesma aplicação individualmente.
    - Copiar o repositório para que os 2 membros do time possam continuar a implementação depois

### Duplas

| Integrante         | Integrante       | Repositório                                                                    |
| ------------------ | ---------------- | ------------------------------------------------------------------------------ |
| angela.almeida     | yuri.anjos       | [angos](https://git.cwi.com.br/crescer/2020-02/java-me-leva-ai/angos)          |
| arthur.juchem      | thiago.rocha     | [artocha](https://git.cwi.com.br/crescer/2020-02/java-me-leva-ai/artocha)      |
| daniel.brochier    | taiane.schutz    | [danutz](https://git.cwi.com.br/crescer/2020-02/java-me-leva-ai/danutz)        |
| derik.amaral       | rodrigo.mello    | [deello](https://git.cwi.com.br/crescer/2020-02/java-me-leva-ai/deello)        |
| francisco.muller   | rafaela.kreusch  | [franusch](https://git.cwi.com.br/crescer/2020-02/java-me-leva-ai/franusch)    |
| gabriel.enriconi   | rafael.germann   | [gabann](https://git.cwi.com.br/crescer/2020-02/java-me-leva-ai/gabann)        |
| gabriel.gamboa     | pedro.jacobus    | [gabobus](https://git.cwi.com.br/crescer/2020-02/java-me-leva-ai/gabobus)      |
| giuliano.pezzi     | pedro.becker     | [giucker](https://git.cwi.com.br/crescer/2020-02/java-me-leva-ai/giucker)      |
| guilherme.carmo    | paulo.machado    | [guichado](https://git.cwi.com.br/crescer/2020-02/java-me-leva-ai/guichado)    |
| guilherme.silva    | patrick.trindade | [guidade](https://git.cwi.com.br/crescer/2020-02/java-me-leva-ai/guidade)      |
| jennifer.diehl     | patricia.lopes   | [jenopes](https://git.cwi.com.br/crescer/2020-02/java-me-leva-ai/jenopes)      |
| jhoel.bagnasco     | mateus.vieira    | [jhoeira](https://git.cwi.com.br/crescer/2020-02/java-me-leva-ai/jhoeira)      |
| joao.rocha         | marlon.saldanha  | [joanha](https://git.cwi.com.br/crescer/2020-02/java-me-leva-ai/joanha)        |
| joao.schmitz       | marcelo.lopes    | [joapes](https://git.cwi.com.br/crescer/2020-02/java-me-leva-ai/joapes)        |
| jose.rodrigues     | marcelo.apollo   | [josollo](https://git.cwi.com.br/crescer/2020-02/java-me-leva-ai/josollo)      |
| leonardo.kruger    | maike.bressan    | [leossan](https://git.cwi.com.br/crescer/2020-02/java-me-leva-ai/leossan)      |
| leonardo.schilling | lucca.souza      | [leouza](https://git.cwi.com.br/crescer/2020-02/java-me-leva-ai/leouza)        |


---

### :warning: Observação importante! :warning:
Para que o frontend consiga realizar requisições para o backend, ambos rodando em ambiente local, será necessário configurar o Spring para aceitar chamadas de qualquer origem. Normalmente os servidores possuem uma restrição (chamada CORS) que evita que uma chamada seja realizada a partir de uma origem com URL diferente. Ou seja, se meu site roda em http://localhost:3000 e a api roda em http://localhost:8100 a origem `http://localhost:3000` é diferente de `http://localhost:8100` e o servidor vai negar a requisição.

Para resolver isso vamos configurar o Spring Boot para aceitar tudo. Precisamos criar uma classe que configura o Spring Boot.

1. Crie um pacote `br.com.cwi.crescer.melevaai.config`
1. Crie uma classe chamada `CorsConfig`
1. Copie o conteúdo abaixo:

```java
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
    }

}
```

---

### Exercício 1

1. Adaptar os endpoints criados na [aula anterior](../aula-02/TEMA.md) para considerar as regras de negócio especificadas.
   - Cadastro de Motorista
   - Exclusão de Motorista
   - Cadastro de Passageiro
   - Cadastro de Veículo
   - Listagem de Motorista, Passageiro e Veículo

### Exercício 2 - Endpoints de Corrida

1. Criar um endpoint para que o passageiro possa chamar uma corrida
   - Mapping: `POST /corridas/passageiros/{cpf-do-passageiro}`
   - Request:
      - CPF do Passageiro (via path)
      - Ponto inicial (coordenadas x e y do ponto)
      - Ponto final (coordenadas x e y do ponto)
   - Response:
      - Sucesso
         - HTTP 201 - CREATED com um *objeto novo* contendo somente:
            - Código da Corrida
            - Dados específicos do Veículo:
               - Placa
               - Marca
               - Modelo
               - Cor
               - Foto
               - Nome do motorista
            - Tempo estimado para chegada do motorista
      - Erro
         - HTTP 400 - BAD REQUEST               

1. Criar um endpoint para que o motorista inicie a corrida
   - Mapping: `POST /corridas/{cod-corrida}`
   - Request:
      - Código da Corrida (via path)
   - Response:
      - Sucesso
         - HTTP 201 - CREATED com um objeto contedo:
            - Tempo estimado para chegada no destino
            - Valor estimado da corrida
      - Erro
         - HTTP 400 - BAD REQUEST

1. Criar endpoint para finalizar uma corrida
   - Mapping: `PUT /corridas/{cod-corrida}`
   - Request:
      - Id da Corrida (via path)
      - Obs: ainda não é necessáro fazer a transferência de valores do passageiro para o motorista
   - Response:
      - Sucesso
         - HTTP 200 - OK
      - Erro
         - HTTP 400 - BAD REQUEST

1. Criar um endpoint para listar todas as corridas realizadas por um passageiro
   - Mapping: `GET /corridas/passageiros/{cpf-do-passageiro}`
   - Request:
      - CPF do Passageiro (via path)
   - Response:
      - Sucesso
         - HTTP 200 - OK com a Lista de Corridas
      - Erro
         - HTTP 400 - BAD REQUEST

### Exercício 3 - Endpoints de Transações com a Conta Virtual

1. Criar um endpoint que permita ao passageiro incluir crédito em sua conta virtual
   - Mapping: `PUT /passageiros/{cpf-do-passageiro}/conta-virtual/`
   - Request:
      - CPF do Passageiro (via path)
      - Valor depositado (Dica: Utilize uma variável anotada com `@RequestParam`)
   - Response:
      - Sucesso
         - HTTP 200 - OK
      - Erro
         - HTTP 400 - BAD REQUEST

1. Criar um endpoint que permita ao motorista fazer um saque de sua conta virtual
   - Mapping: `PUT /motoristas/{cpf-do-motorista}/conta-virtual/`
   - Request:
      - CPF do Motorista (via path)
      - Valor de saque (Dica: Utilize uma variável anotada com `@RequestParam`)
   - Response:
      - Sucesso
         - HTTP 200 - OK
      - Erro
         - HTTP 400 - BAD REQUEST

1. Alterar o endpoint criado no exercício 2.3 `PUT /corridas/{cod-corrida}` (que finaliza uma corrida) para que seja feita a transferência do valor da corrida da conta do Passageiro para a conta do Motorista. *Não esqueça das regras de negócio*.

### Exercício 4 - Endpoints de Avaliação

1. Criar um endpoint para permitir a avaliação de um passageiro, realizada pelo motorista
   - Mapping `POST /corridas/{cod-corrida}/passageiros/avaliacao`
   - Request:
      - Código da Corrida (via path)
      - Nota (de 1 à 5)
   - Response:
      - Sucesso
         - HTTP 200 - OK
      - Erro
         - HTTP 400 - BAD REQUEST

1. Criar um endpoint para permitir a avaliação de um motorista, realizada por um passageiro
   - Mapping `POST /corridas/{cod-corrida}/motoristas/avaliacao`
   - Request:
      - Código da Corrida (via path)
      - Nota (de 1 à 5)
   - Response:
      - Sucesso
         - HTTP 200 - OK
      - Erro
         - HTTP 400 - BAD REQUEST

---

### Ordem de prioridade

- Exercício 1: API e Frontend
- Exercício 2: API e Frontend
- Exercício 3: API
- Exercício 4: API
- Exercício 3: Frontend
- Exercício 4: Frontend
