# Exercícios - Aula 2

Todos os exercícios serão *avaliados* 

O "contrato" dos serviços deve ser seguido à risca.

Deve ser criado uma controller para cada recurso.

## Exercício 1 - Cadastrar e Excluir motoristas

Criar os endpoints responsáveis pelas operações relacionadas ao `Motorista`.

1. Criar um endpoint que permita cadastrar um novo Motorista
   - Mapping `POST /motoristas`
   - Request:
      - Motorista:
         - Nome completo
         - E-Mail
         - Data de Nascimento
         - CPF
         - Carteira de Habilitação
            - Número
            - Categoria
            - Data Vencimento
   - Response:
      - Sucesso
         - HTTP 201 - CREATED com o objeto Motorista criado

1. Criar um endpoint para permitir que um motorista deixe de ser motorista do aplicativo
   - Mapping: `DELETE /motoristas/{cpf}`
   - Request:
      - CPF do Motorista
   - Response:
      - Sucesso
         - HTTP 200 - OK
      - Caso o id informado não exista
         - HTTP 404 - NOT FOUND

## Exercício 2 - Cadastrar Veículos e Passageiros

1. Criar um endpoint que permita cadastrar um novo Veículo
   - Mapping `POST /veiculos`
   - Request:
      - Veículo:
         - Placa
         - Marca
         - Modelo
         - Ano
         - Cor
         - Foto (url da foto)
         - Quantidade de Lugares
         - Categoria
         - Proprietário (Motorista)
   - Response:
      - Sucesso
         - HTTP 201 - CREATED com os dados do Veículo criado

1. Criar um endpoint que permita cadastrar um novo Passageiro
   - Mapping `POST /passageiros`
   - Request:
      - Passageiro:
         - Nome completo 
         - E-Mail 
         - Data de Nascimento 
         - CPF
   - Response:
      - Sucesso
         - HTTP 201 - CREATED com o objeto Passageiro criado

## Exercício 3 - Listar Motoristas, Veículos e Passageiros

1. Criar endpoints para permitir a listagem dos recursos: `Motorista`, `Veiculo` e `Passageiro`
   - Mapping `GET /motoristas`
   - Mapping `GET /veiculos`
   - Mapping `GET /passageiros`
   - Response:
      - Sucesso
         - HTTP 200 - OK
