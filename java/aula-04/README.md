# Aula 4

## Java 8

### Pacotes
### Getters e Setters
### Modificadores de acesso
- public
- private
- default
- protected
- static
- final

### Primitivos VS Wrappers
- Primitivos
- Wrappers
- Autoboxing
- Unboxing

### Comparison
- Equals
- Hashcode

### Abstração
- Herança
- Interfaces
- Polimorfismo
- Sobreescrita
- Sobrecarga

### Enum
### Datas

A linguagem Java tem boas bibliotecas para se trabalhar com datas. Até a versão 7 da linguagem, as classes Date e Calendar dos pacotes básicos eram as mais utilizadas. Porém existe uma biblioteca muito famosa no mundo Java chamada JodaTime, que deixava o trabalho com datas muito mais simples. Na versão 8 do Java, a biblioteca JodaTime foi praticamente importada para dentro da linguagem.

Diversas operações com datas estão disponíveis no core da linguagem. Problemas como calculos de datas em diferentes fuso horários, podem ser resolvidos com os métodos padrão.

### Collections

Existem diversos tipos de coleção na linguagem Java. Elas nos auxiliam em situações onde precisamos guardar diversos dados em uma estrutura organizada.

#### List
Em Java temos array como um tipo primitivo. Mas geralmente utilizamos a interface List por fornecer métodos que tornam a manipulação de listas mais fácil. Existem diversas implementações da interface List, mas no geral a mais utilizada é a classe ArrayList. Outra implementação que merece destaque é a LinkedList, que pode ser utilizada para melhor performance quando muitas manipulações são feitas na lista.
[Aqui](http://www.javacreed.com/comparing-the-performance-of-various-list-implementations/) pode ser visto alguns testes de performance com as diferentes implementações de List, para conhecimento. Mas no dia-a-dia a menos que você utilize listas muito grandes, ou tenha uma questão muito critica de performance, ArrayList irá atender tranquilamente.

#### Sort
É muito comum termos a necessidade de ordenar listas de dados. Para isso podemos utilizar a classe Collections e seu método sort, que recebe uma lista e a ordena. Para que isso funcione corretamente o tipo de objeto que está na lista, deve implementar a interface Comparable, que irá fazer com que especifiquemos qual é o critério que deve ser utilizado durante a ordenação. Strings e números, já são ordenados de forma natural.

#### Map
A interface Map é utilizada quando precisamos de uma estrutura de chave valor. As chaves em um map são únicas (utilizando o método equals). Caso um novo objeto seja inserido com a mesma chave, o conteúdo anterior da chave é substituído. Podemos ter tipos complexos como listas e até outros maps no campo valor.

As três implementações da interface Map são:
Hashmap - Não garante nenhum tipo de ordenação dos elementos. Inclusive a ordem pode ser alterada conforme novos elementos são inseridos.
LinkedHashMap - Mantem a ordem em que os elementos foram inseridos
TreeMap - Ordena os elementos conforme sua ordem natural, determinada pelo método compareTo.

![collections](https://git.cwi.com.br/crescer/2018-02/aula/java/raw/master/aula-02/resources/collections.png)
 
### Annotations

### Generics

```java
public void doSomething(List<String> params) {}

public void doSomething(List<Integer> params) {}
```
[Referência](https://www.devmedia.com.br/usando-generics-em-java/28981)

### Lambda

A versão 8 do Java trouxe grandes mudanças para a linguagem. A maior delas foi a introdução de programação de estilo funcional utilizando lambdas. As funções lambdas acabam sendo avaliadas como uma interface funcional, e são largamente utilizadas em cima de coleções como `List`. Abaixo seguem algumas destas interfaces.

#### Predicate
Esta interface recebe um valor e retorna um boolean. É utilizada principalmente para realizar filtros.

#### Consumer
Está interface recebe um valor e não retorna nada. Utilizada por exemplo em loops for, onde uma ação é executada em cima de cada valor.

#### Function
Esta interface recebe um valor e retorna outro. É utilizada por exemplo para montar um map de um determinado conjunto de valores.

> Estas são as interfaces que vimos neste treinamento. Mas existem outras interfaces interessantes no pacote `java.util.function`. Se possível estude esta api para tirar melhor proveito destas funcionalidades.

### Sream

```java
List<String> myList =
    Arrays.asList("a1", "a2", "b1", "c2", "c1");

myList
    .stream()
    .filter(s -> s.startsWith("c"))
    .map(String::toUpperCase)
    .sorted()
    .forEach(System.out::println);

// C1
// C2
```

```java
Arrays.asList("a1", "a2", "a3")
    .stream()
    .findFirst()
    .ifPresent(System.out::println);  // a1
```

```java
List<Person> persons =
    Arrays.asList(
        new Person("Max", 18),
        new Person("Peter", 23),
        new Person("Pamela", 23),
        new Person("David", 12));

List<Person> filtered =
    persons
        .stream()
        .filter(p -> p.name.startsWith("P"))
        .collect(Collectors.toList());

System.out.println(filtered);
```

```java
List<Person> persons = Arrays.asList(
    new Person("mkyong", 30),
    new Person("jack", 20),
    new Person("lawrence", 40));

String name = persons.stream()
    .filter(x -> "jack".equals(x.getName()))
    .map(Person::getName)  //convert stream to String
    .findAny()
    .orElse("");
```

[Exemplos](https://howtodoinjava.com/java8/java-streams-by-examples/)

[Antes e Depois (Java8)](https://mkyong.com/java8/java-8-streams-filter-examples/)

---

## Arquitetura de Software

Mais importante do que desenvolver software que funciona, é desenvolver software que esteja preparado para as alterações que certamente virão e para novos cenários que surgem durante e após o desenvolviemento.

> "Baixo acoplamento e alta coesão"

No contexto de um software podemos entender que **Acoplamento** é uma medida *"inter"* componentes, e **Coesão** é uma medida *"intra"* componentes.

- A primeira refere-se ao mundo externo do componente, como ele se inter-relaciona com os outros componentes do sistema.
- A segunda refere-se ao mundo interno do componente, como ele se intra-relaciona consigo mesmo.

## Acoplamento

Indica quanto uma módulo depende de outro para funcionar. Códigos desacoplados são aqueles de relação fraca, e não dependem de outros para fazer sua funcionalidade básica. É sempre desejável um baixo nível de acoplamento.

## Coesão

Se refere ao relacionamento que os membros de um módulo possuem. Indica se os membros tem uma relação mais direta e importante. Códigos coesos são aqueles de relação forte, onde seus membros estão intimamente ligados e estão ali por um objetivo comum. Membros que não são absolutamente necessários para aquele módulo não devem estar presentes em códigos coesos

## Princípio da Responsabilidade Única

Esse princípio diz que as classes devem ser coesas, ou seja, terem uma única responsabilidade. Classes assim tendem a ser mais reutilizáveis, mais simples, e propagam menos mudanças para o resto do sistema.

---

## Lombok - EXTRA

## [@NoArgsConstructor, @RequiredArgsConstructor and @AllArgsConstructor](https://projectlombok.org/features/constructor)

`@NoArgsConstructor` gera um construtor sem parâmetros. 

`@RequiredArgsConstructor` gera um construtor com todos os campos "obrigatórios", ou seja, todos os atributos `final` não inicializados, bem como todos os atributos marcados com `@NonNull` que não foram inicalizados na sua declaração.

`@AllArgsConstructor` gera um construtor com um parâmetro para cada atributo da classe.

**Atenção** para classes com herança. Ao adicionar essa anotação na classe Pai, a classe filha precisará implementar um construtor com todos os atributos da classe Pai também, porém o Lombok não faz isso. Deve ser feito manualmente.

### Exemplos
```java
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {

    private String placa;

    private Marca marca;

    private String modelo;

    private int ano;

    private Cor cor;

    private String foto;

    private Categoria categoria;

    private int quantidadeLugares;

    private Motorista proprietario;

}
```

```java
@Getter
@Setter
@AllArgsConstructor
public class Pessoa {

    private String nomeCompleto;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataNascimento;

    private String email;

    private Boolean ativo;

}

@Getter
@Setter
// @AllArgsConstructor <- Não resolve!
public class Passageiro extends Pessoa {

    private static final int IDADE_MINIMA = 16;

    public Passageiro(String nomeCompleto, LocalDate dataNascimento, @Email String email, Boolean ativo) {
        super(nomeCompleto, dataNascimento, email, ativo);
    }

}
```

## [@Data](https://projectlombok.org/features/Data)

É um atalho que agrupo as anotações: `@ToString`, `@EqualsAndHashCode`, `@Getter`, `@Setter` e `@RequiredArgsConstructor`.

### Exemplo
```java
// Isso:
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class CarteiraNacionalHabilitacao {

    private String numero;

    private Categoria categoria;

    private LocalDate dataVencimento;

}

// Pode ser substituído por:
@Data
public class CarteiraNacionalHabilitacao {

    private String numero;

    private Categoria categoria;

    private LocalDate dataVencimento;

}
```

Caso seja necessário configurar alguma das anotações que estão implícitas, basta adicioná-la junto à `@Data`. 

### Exemplo

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "cpf")
public class Pessoa {

    private String nomeCompleto;

    private LocalDate dataNascimento;

    private String email;

    private CPF cpf;

}
```
