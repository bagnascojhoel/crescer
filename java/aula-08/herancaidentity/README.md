# Herança com Identity
Projeto para exemplificar persistência com herança, utilizando Oracle 12c e coluna IDENTITY

## Mudanças pro projeto de Herança

- Novo driver jdbc no `pom.xml`
```xml
<dependency>
    <groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc8</artifactId>
    <version>19.8.0.0</version>
</dependency>
````

- Nova configuração no `application.yml`
```yaml
spring:
  jpa:
    database-platform: org.hibernate.dialect.Oracle12cDialect
```

- Mapeamento da chave com `IDENTITY`
```java
@Entity
@Table(name = "z_pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
```

## Extra
- Scripts SQL e JSON da Collection do postman no diretório de `resources`
 