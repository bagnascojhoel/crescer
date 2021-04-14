# Aula 8

# Persistência de dados

Capacidade de armazenar informações de forma que seja possível recuperá-la posteriormente.

## Tipos de persistência

### Memória

Exemplo que usamos até agora. Criamos uma lista, adicionamos as informações nela e podemos recuperar. O problema é que ela existe somente enquanto a aplicação está em execução.

### Arquivo

Podemos salvar os dados em um arquivo texto por exemplo. Onde cada linha do arquivo pode representar o nosso objeto. Para isso precisamos *serializar* o objeto de alguma forma. O que usamos até agora foi json. O problema é que a operação de leitura e escrita em disco, mesmo que hoje existam soluções de armazenamento melhores como o SSD, ainda é lenta se comparado com outras abordagens.

### Banco de Dados

Melhor solução para conseguirmos atingir o objetivo (guardar a informação) com uma boa performance e fazer uso de consultas.

## JDBC

Significa `Java Database Connectivity`. E é um conjunto de classes nativas do Java que fazem o envio de instruções SQL para um banco de dados relacional.

Provê uma maneira uniforme de lidar com banco de dados, independente do *SGBD*. Para isso, cada *SGBD* possui um *driver* JDBC que sabe converter o que foi pedido para a sua estrutura própria.

# JPA - Java Persistence API

> JPA é um framework leve, baseado em POJOS (Plain and Old Java Objects) para persistir objetos Java.

Principais características:

- POJOS Persistentes (entidades)
- Consultas em **Objetos** (JPQL)
- Permite continuar o mindset de Orientação a Objetos

# Mapeamento Objeto Relacional

Técnica para mapear as tabelas do banco de dados com os Objetos da aplicação.

Precisamos mapear as nossas classes de domínio (entidades) com as tabelas e colunas do banco de dados.

- `@Entity`
   - Utilizada para informar que uma classe é uma entidade. **Obrigatório**
- `@Table`
   - Utilizada para referenciar a entidade com a tabela. Necessário somente quando o nome da tabela for diferente do nome da Classe. **Opcional**
- `@Column`
    - Utilizada para especificar o nome da coluna no banco de dados. Quando não for informado, será usada uma convenção.
- `@Id`
   - Utilizada para informar ao JPA qual atributo da entidade será usado como chave primária da tabela no banco de dados. **Obrigatório.**
- `@GeneratedValue`
   - Utilizada para informar que a geração do valor do identificador único da entidade (primary key) será gerenciada pelo provedor de persistência (Hibernate).
   - Ex: `@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOME_DO_GERADOR")`
- `@SequenceGenerator`
   - Utilizada para definir que a geração do valor referenciado será realizada através de uma Sequence do Banco de Dados. Referencia, por nome, o `@GeneratedValue`
   - Ex: `@SequenceGenerator(name = "NOME_DO_GERADOR", sequenceName = "NOME_DA_SEQUENCE")`
- `@MappedSuperclass`
   - Utilizada para definir uma classe cujas informação de mapeamento são aplicadas às entidades que herdam dela. Não será mapeada uma tabela para esta classe.
- `@Inheritance`
    - Utilizada para definir a estratégia de mapeamento das tabelas para os casos em que há uso de herança entre classes de domínio.
        - `SINGLE_TABLE` - Uma tabela para tudo
        - `TABLE_PER_CLASS` - Uma tabela por classe concreta
        - `JOINED` - Uma tabela por classe mas somente com os atributos específicos da classe.
- `@Embeddable`
    - Indica que a classe pode ser incorporada à um atributo de outra classe
- `@Embedded`
    - Indica que o atributo será embutido a partir de uma classe incorporável.
- `@AttributeOverride`
    - Permite sobrescrever o mapeamento de um atributo para as colunas de uma tabela. É usado em conjunto com o `@Embedded`.
- `@Enumerated`
   - Utilizada para mapear Enums. Pode ser configurada como `STRING` (o texto de cada chave do enum) ou `ORDINAL` (o índice da chave do enum).
- `@Transient`
    - Utilizada para representar um atributo na classe de domínio, que não deve ser considerado no mapeamento do JPA.
- `@ManyToOne`
   - Significa muitos-para-1. Many = classe atual, One = classe do atributo
- `@OneToMany`
   - Significa 1-para-muitos. One = classe atual, Many = classe do atributo
- `@OneToOne`
   - Significa 1-para-1.
- `@JoinColumn`
   - Utilizada para definir qual a coluna que faz a união entre 2 entidades

**Convenção**
- Replace dots with underscores
- Change camel case to snake case
- Lower-case table names

## Exemplos de @ManyToOne e @OneToMany

### Mapeamento Unidirecional (deve ser utilizado somente 1 das abordagens abaixo)

- `@ManyToOne` - Definindo a classe `Veiculo` como "proprietária" da informação
    ```java
    @Entity
    public class Veiculo {
        
        @ManyToOne
        @JoinColumn(name = "id_proprietario")
        private Motorista proprietario;

    }
    ```
ou
- `@OneToMany` - Definindo a classe `Motorista` como "proprietária" da informação
    ```java
    @Entity
    public class Motorista {
        
        @OneToMany
        @JoinColumn(name = "id_proprietario") // Esta coluna está na tabela "VEICULO".
        private List<Veiculo> veiculos;

    }
    ```

### Mapeamento Bidirecional (ambas abordagens deve ser usadas ao mesmo tempo)

- `@ManyToOne` - Mapeando o `Motorista` do `Veiculo`
    ```java
    @Entity
    public class Veiculo {
        
        @ManyToOne
        @JoinColumn(name = "id_proprietario")
        private Motorista proprietario;

    }
    ```

- `@OneToMany` - Mapeando os `Veiculo`s na `Motorista`
    ```java
    @Entity
    public class Motorista {

        @OneToMany(mappedBy = "proprietario")
        private List<Veiculo> veiculos;

    }
    ```

# Configuração da aplicação

## Dependências:

```xml
<!-- Starter para utilizar JPA -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<!-- Driver da Oracle -->
<dependency>
    <groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc6</artifactId>
    <version>11.2.0.4</version>
</dependency>
```

## Configuração da conexão com o Banco de Dados Oracle usando JPA

```yml
logging:
  level:
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
spring:
  jpa:
    hibernate:
      ddl-auto: validate
  datasource:
    username: crescer
    password: crescer
    url: jdbc:oracle:thin:@localhost:1521:xe
    driver-class-name: oracle.jdbc.OracleDriver
```

---

**Referências**

- https://www.baeldung.com/jpa-embedded-embeddable
- https://thoughts-on-java.org/complete-guide-inheritance-strategies-jpa-hibernate/
- https://www.casadocodigo.com.br/products/livro-jpa-eficaz
- https://pt.stackoverflow.com/questions/234755/diferen%c3%a7as-onetomany-manytomany-manytoone-onetoone/234768#234768
- https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories