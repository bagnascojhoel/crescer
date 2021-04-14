# Me Leva Aí

- Dúvidas

# Fundamentos

## Inversão de Controle (IoC)

Conhecido pela Sigla IoC é um Pattern que prega para usarmos o controle das instancias de uma determinada classe ser tratada externamente e não dentro da classe em questão, ou seja, Inverter o controle de uma classe delegando para uma outra classe, interface, componente, serviço, etc.

## Injeção de Dependências (DI)

Injeção de Dependência é apenas uma forma para resolvermos a Inversão de Controle. Ele trabalha baseado em abstrações, sejam elas classes abstratas ou interfaces e nada mais é do que delegar a criação  das classes das quais eu dependo para uma outra estrutura. Ou seja, quando menos ou souber sobre as minhas dependências melhor, seja a forma de instanciar ou como ela funciona internamente.

## Leituras Recomendadas

- https://www.ateomomento.com.br/acoplamento-e-coesao/
- http://blog.caelum.com.br/principios-do-codigo-solido-na-orientacao-a-objetos/
- https://www.devmedia.com.br/inversao-de-controle-x-injecao-de-dependencia/18763

# Injeção de Dependências com Spring

> The objects that form the backbone of your application and that are managed by the Spring IoC container are called beans. A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container.

- `@Autowired`
  - Onde posso usar
    - Construtores
    - Propriedades
    - Métodos

  - Stereotypes
    - `@Component`
    - `@Controller`
    - `@Service`
    - `@Repository`

  - Problemas comuns
    - [NoSuchBeanDefinitionException](https://www.baeldung.com/spring-nosuchbeandefinitionexception)

## Leituras Recomendadas

- https://blog.algaworks.com/injecao-de-dependencias-com-spring/
- https://www.devmedia.com.br/padrao-de-projeto-singleton-em-java/26392
- https://medium.com/the-resonant-web/spring-boot-2-0-project-structure-and-best-practices-part-2-7137bdcba7d3
