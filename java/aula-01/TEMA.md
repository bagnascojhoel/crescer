# Exercícios Aula 01

### Exercício 1

- No `projeto1`, criar uma estrutura de classes que permita criar um Veículo que deve possuir as seguintes informações:
  - Placa
  - Marca
  - Modelo
  - Ano
  - Cor
  - Foto (url da foto)
  - Categoria
  - Quantidade de lugares
  - Proprietario, ou seja, um motorista

Onde `marca` e `cor` possuem as seguintes opções:
- Marca
  - AUDI
  - BMW
  - CHERY
  - CHEVROLET
  - CHRYSLER
  - CITROEN
  - DODGE
  - EFFA
  - FIAT
  - FORD
  - GEELY
  - HONDA
  - HYUNDAI
  - JAC
  - JEEP
  - KIA
  - LAND_ROVER
  - LEXUS
  - LIFAN
  - MERCEDES_BENZ
  - MITSUBISHI
  - NISSAN
  - PEUGEOT
  - RENAULT
  - SEAT
  - SMART
  - SSANGYONG
  - SUBARU
  - SUZUKI
  - TOYOTA
  - VOLKSWAGEN
  - VOLVO
- Cor
  - Branco
  - Prata
  - Preto


### Exercício 2

- No `projeto1`, criar uma regra de validação para verificar se um Motorista possui ao menos 18 anos;


### Exercício 3
No `projeto1`:
- Não deve ser permitido instanciar um veículo sem um motorista. Nesta caso lançar uma Exception do tipo `ProprietarioObrigatorioException`.
- Não deve ser permitido instanciar um veículo com um motorista cuja CNH seja de categoria diferente da categoria do veículo. Neste caso deve ser lançada uma Exception do tipo `MotoristaNaoHabilitadoException`.
- Não deve ser permitido instanciar um veículo com um motorista cuja CNH esteja vencida. Neste caso deve ser lançada uma Exception do tipo `MotoristaComCNHVencidaException`.


### Exercício 4

- Criar um **novo** projeto maven chamado "Me Leva Aí", usando Spring Boot através do [Spring Initializr](https://start.spring.io/).
   - Incluir a dependência `Spring Web`
   - Definir o nome do groupId `br.com.cwi.crescer` e o artifactId `melevaai`
- Criar uma classe no pacote `br.com.cwi.crescer.melevaai.controller` chamada `HelloController.java` com um método chamado `sayHello()` que retorne uma String com o valor `Olá Crescer 2020/2`
   - Utilize as anotações `@RestController` (na classe) e `@GetMapping` (no método)
- Executar a aplicação e abrir a URL da aplicação no browser através da URL `http://localhost:8080` para visualizar o texto `Olá Crescer 2020/2`
- Converter o arquivo de configurações para o formato `yml`
- Modificar a porta padrão da aplicação para `8100`
- Modificar a url do contexto da aplicação para `me-leva-ai`
- Executar a aplicação e abrir a URL da aplicação no browser através da URL `http://localhost:8100/me-leva-ai` para visualizar o texto `Olá Crescer 2020/2`

### Exercício 5

- No projeto "Me Leva Aí", criar uma classe chamada `MotoristaController` com um método `mostrarMotorista()` que retorne os dados de um motorista (deve ser instanciado um novo Motorista com dados fixo)
   - URL => `GET http://localhost:8100/me-leva-ai/motorista`
