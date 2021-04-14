# Aula 3

### Reforço

- Vincular Motorista e Veiculo
- Formatar Data (somente objeto -> json): `@JsonFormat(pattern = "dd/MM/yyyy")`
- Ignorar atributos: `@JsonIgnore`
- `@RequestMapping` x `@GetMapping`/`@PostMapping`/`@DeleteMapping`

### Atividades HandsOn

1. Criar regras de validação
    - Adicionar validações na MotoristaController
        - Possui idade mínima para dirigir
        - CNH não está vencida
        - CPF informado inválido
        - CPF em uso 
    - Exceptions customizadas para regras de negócio
        - `RegistroNaoEncontratoException`
            - `@ResponseStatus(HttpStatus.NOT_FOUND)`
        - `ValidacaoNegocioException` vs `ProblemaEspecificoException`
            - `@ResponseStatus(HttpStatus.BAD_REQUEST)`
    - [Bean validations (JSR 380)](https://beanvalidation.org/2.0/spec/#builtinconstraints)
        - :warning: `@Valid` nos parâmetros da Controller
        - `@Email(message = "O e-mail deve estar em um formato válido")`
        - `@NotEmpty(message = "O nome completo é obrigatório")`
        - Diferença entre `@NotEmpty` e `@NotNull`
        
        ```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
            <version>2.3.0.RELEASE</version>
        </dependency>
        ```

2. Criar objetos de Request e Response personalizados
    - Separar "contrato" do serviço do domínio da aplicação
    - Definir escopo do objeto

3. Copiando informações entre objetos
    - [Model Mapper](http://modelmapper.org/)

        ```xml
        <dependency>
            <groupId>org.modelmapper</groupId>
            <artifactId>modelmapper</artifactId>
            <version>2.3.5</version>
        </dependency>
        ```
    - Exemplo de uso

        ```java
        ModelMapper modelMapper = new ModelMapper();
        Motorista motorista = modelMapper.map(criarMotoristaRequest, Motorista.class);

### Extra

# [Lombok](https://projectlombok.org/)

Project Lombok é uma lib Java que se acopla à IDE e adiciona facilidades na sintaxe (Syntax Sugar).

## [@Getter / @Setter](https://projectlombok.org/features/GetterSetter)

Gera automaticamente Getters e Setters para atributos mutáveis, ou somente os Getters para atributos imutáveis.
Por padrão serão todos públicos, a menos que se especifique o `AccessLevel`.
Pode ser atribuído à classe inteira ou à uma propriedade específica.

## [@ToString](https://projectlombok.org/features/ToString)

Qualquer classe pode ser anotada com `@ToString` para dizer ao lombok gerar uma implementação do método `toString()` Por padrão, será impresso o nome da classe, seguido de todos os atributos, em ordem, separados por vírgula.

### Exemplo

```java
@Getter
@Setter
@ToString(callSuper = true)
public class Motorista extends Pessoa {

    private static final int IDADE_MINIMA = 18;

    private CarteiraNacionalHabilitacao cnh;

}
```

## [@EqualsAndHashCode](https://projectlombok.org/features/EqualsAndHashCode)

Qualquer classe pode ser anotada com `@EqualsAndHashCode` para dizer ao lombok gerar uma implementação dos métodos `equals(Object other)` e `hashCode()`. Por padrão, serão usados todos os atributos não estáticos, mas podemos definir quais atributos devem ser utilizados através da propriedade `of`.

**Atenção** para classes com herança. Caso faça sentido, deve ser usado o atributo `callSuper=true/false` para definir se o método gerado deve chamar a implementação da classe pai. 

## Exemplo

```java
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "numero")
public class CPF {

    private String numero;

}
```

# Importante

O lombok deve ser um **facilitador**. Caso enfrente algum problema com ele, não perca tempo, faça a implementação normal (usando a IDE para ajudar).

# Atividades

1. Adicionar a dependência do lombok no projeto

    ```xml
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.10</version>
        <scope>provided</scope>
    </dependency>
    ```
1. Adicionar plugin do lombok no IntelliJ 

---

### Referências 

- [Lombok Features](https://projectlombok.org/features/all)

