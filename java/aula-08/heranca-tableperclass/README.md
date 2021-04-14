# Herança (TABLE PER CLASS)

## Setup
- Oracle 12c

## Mudanças pro projeto de Herança

- Mapeamento da chave precisa ser com **SEQUENCE** (**IDENTITY** não funciona).

```java
@SequenceGenerator(name = "a_seq_pessoa", sequenceName = "a_seq_pessoa", allocationSize = 1)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "a_seq_pessoa")
private Integer id;

```

## Extra
- Scripts SQL e JSON da Collection do postman no diretório de `resources`
 