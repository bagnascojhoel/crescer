# Aula 9

- Estratégia de criação de Banco
   - JPA Auto DDL
   - Manual
   - Liquibase

# Spring Data

> A missão da Spring Data é fornecer um modelo de programação familiar e consistente para o acesso a dados, mantendo as características especiais do armazenamento de dados subjacente.

- [Spring Data LDAP](https://spring.io/projects/spring-data-ldap)
- [Spring Data Solr](https://spring.io/projects/spring-data-solr)
- [Spring Data Elasticsearch](https://spring.io/projects/spring-data-elasticsearch)
- [Spring Data MongoDB](https://spring.io/projects/spring-data-mongodb)
- [Spring Data REST](https://spring.io/projects/spring-data-rest)
- [Spring Data Redis](https://spring.io/projects/spring-data-redis)
- [Spring Data for Apache Cassandra](https://spring.io/projects/spring-data-cassandra)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)

## [Spring Data JPA](https://spring.io/projects/spring-data-jpa)

> O Spring Data JPA permite a implementação fácil de repositórios baseados em JPA. Trata do suporte aprimorado para camadas de acesso a dados baseadas em JPA.

## Spring Data Repository - Básico

- :neutral_face: `Repository<T, ID>`

    Central repository marker interface. Captures the domain type to manage as well as the domain type's id type. General purpose is to hold type information as well as being able to discover interfaces that extend this one during classpath scanning for easy Spring bean creation.

- :astonished: `CrudRepository<T, ID> extends Repository<T, ID>`

    Interface for generic CRUD operations on a repository for a specific type.

- :scream: `PagingAndSortingRepository<T, ID> extends CrudRepository<T, ID>`

    Extension of CrudRepository to provide additional methods to retrieve entities using the pagination and sorting abstraction.

- :smiling_imp: `JpaRepository<T, ID> extends PagingAndSortingRepository<T, ID>`

    JPA specific extension of Repository.

**Atividades**
- Criar uma interface de Repository
- Implementar a interface com a estratégia "em memória"
- Alterar a interface para ser um "Spring Data Repository" e apagar a implementação

## ~~Mágica~~ Consultas somente com assinatura

- [Query By Name](https://www.baeldung.com/spring-data-derived-queries)


```java
public interface MotoristaRepository extends Repository<Motorista, Long> {

    Motorista findByNome(String nome);

    // Equivalente ao like, mas não precisamos nos preocupar com o sinal de percentual. Podemos usar também EndingWith, Containing.
    List<Motorista> findByNomeStartingWith(String nome);

    // Ordenando pelo nome.
    List<Motorista> findByNomeStartingWithOrderByNome(String nome);

    // Não levar em consideração a caixa.
    List<Motorista> findByNomeStartingWithIgnoreCase(String nome);

    // Pesquisando por duas propriedades: nome e ativo.
    List<Motorista> findByNomeStartingWithIgnoreCaseAndAtivoEquals(String nome, boolean ativo);

    // Nesse caso, precisamos usar o sinal de percentual (%) em nossas consultas.
    List<Motorista> findByNomeLike(String nome);

    // Podemos usar também IsNotNull ou NotNull.
    List<Motorista> findByEmailIsNull();

    // Quando você quer negar o que passa no parâmetro
    List<Motorista> findByNomeNot(String nome);

    // Todos os Motoristas com os IDs passados no varargs. Poderia usar NotIn para negar os IDs.
    List<Motorista> findByIdIn(Long... ids);

    // Todos onde a propriedade ativo é true. Poderia ser falso, usando False.
    List<Motorista> findByAtivoTrue();

    // Buscar onde a data de nascimento é depois do parâmetro passado.  Pode ser usado Before também.
    List<Motorista> findByDataNascimentoAfter(LocalDate data);

    // Buscar onde a data nascimento está dentro de um período.
    List<Motorista> findByCadastroBetween(LocalDate inicio, LocalDate fim);
}
```

![magic](resources/magic.gif)

**Atividades**
- Ajustar implementação do "contains"
    - Remover usos de listas
    - Cuidar pontos onde era usada a referência do Java
- Implementar Soft Delete

# Spring Data Repository - Tópicos Avançados

- [Documentação](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.definition)

- Paginação e Ordenação `PagingAndSortingRepository<T, K>`
   - Receber `Pageable`
   - Retornar `Page`
   - Swagger não sabe demonstrar `Pageable`
   - <details><summary>Spoiler</summary>
      ?sort=email,DESC&size=2&page=1
      </details>

- Filtros
   - `findAllByNomeCompletoStartingWith`
   - <details><summary>Spoiler</summary>
      Page<Motorista> findAllByNomeCompletoStartingWithIgnoreCase(String filter, Pageable pageable);
      </details>

- `@Query`

  - Ref: https://www.baeldung.com/spring-data-jpa-query

    ```java
    @Query("SELECT m FROM Motorista m WHERE m.ativo = true")
    List<Motorista> buscarTodosMotoristasAtivos();
    ```

    ```java
    @Query("SELECT c FROM Corrida c WHERE c.passageiro.id = ?1")
    List<Corrida> listarCorridasDoPassageiro(Long idPassageiro);
    ```

- Query Nativa
    ```java
    @Query(
        value = "SELECT MAX(ID) FROM MOTORISTA",
        nativeQuery = true)
    Integer buscarIdMaisAlto();
    ```

- Projeção para um Objeto que não é uma entidade (DTO/VO)
   - `@Query` + DTO
   
    ```java
    @Query("SELECT new br.com.cwi.crescer.melevaai.dto.RelatorioCustoDto(c.custo, c.veiculo.proprietario.nomeCompleto, c.passageiro.nomeCompleto) FROM Corrida c WHERE c.dataHoraInicio BETWEEN ?1 AND ?2")
    List<RelatorioCustoDto> montarRelatorioCusto(LocalDateTime filtroInicio, LocalDateTime filtroFim);
    ```