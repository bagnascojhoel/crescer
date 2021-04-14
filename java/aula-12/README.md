# Aula 12

# SO(lid)

## Single Responsability Principle

> "A class should have one, and only one, reason to change." (Robert C. Martin)

## Open Closed Principle

> "You should be able to extend a classes behavior, without modifying it." (Robert C. Martin)

# Design Patterns
### O que são? De onde vem? Do que se alimentam?

- Soluções generalistas para problemas recorrentes durante o desenvolvimento de um software
- Não são um framework 
- Não é código pronto
- É uma definição de alto nível de como um problema comum pode ser solucionado

- 1978: alguns arquitetos escreveram um livro (“A Pattern Language: Towns, Buildings, Construction”), onde catalogaram 253 tipos de problemas e analisaram o que está por trás de cada situação, descrevendo-as na sua essência e propondo uma solução padrão.

- 1987: Kent Back (um dos criadores do XP e TDD) e Ward Cunningham apresentaram uma palestra intitulada “Using Pattern Languages for Object-Oriented Programs” onde propuseram cinco padrões de projetos no campo da ciência da computação.

- 1994: Erich Gamma, Richard Helm, Ralph Johnson e John Vlissides escreveram o livro “Design Patterns: Elements of Reusable Object-Oriented Software” onde catalogaram 23 padrões que utilizaram ao longo de suas carreiras. Os autores do livro ficaram conhecidos como Gang of Four (Gangue dos quatro) ou “GoF”.

### Quando aplicar ?

- Importante conhecer os padrões para saber se faz sentido aplicar
- Vamos aplicar quando a solução proposta pelo pattern resolver algum problema da nossa arquitetura

### Exemplos

- Singleton
- Strategy
- State
- Chain of Responsibility
- Template Method
- [Outros](https://cezbatistao.wordpress.com/2016/05/21/design-patterns/)

# Cobertura de Testes

- Porque?
    - Garantir que a implementação está segura
    - Facilitar a manutenção futura
    - Dar segurança para refatorações 
- Como?
    - Testes unitários
    - Testes de integração
- Sonar
    - Ferramenta para visualizar a qualidade do código
- Tratar bem o seu teste
  - Teste unitários também são código
  - Todas as dicas de código limpo e bem escrito servem também para testes unitários
  - https://github.com/AlexandreSNeto/testes-com-mockito

# Clean Code - Dicas Rápidas 

### Nomenclatura Importa
- Nomes precisos
- Sem medo de ~~ser feliz~~ nomes grandes
- Padrão: siga um padrão, mesmo que seja um padrão ruim
- Use Sufixos
- Use Prefixos
- Pense em como os arquivos serão exibidos na IDE

### Nomeie o que não tem nome
- Crie métodos apenas para dar nome às coisas
    - Ruim:
        - `if (nonNull(usuario) && service.validate(usuario) && usuario.getAlgumaCoisaQuePokemonHunterTem() > MINIMO_BECOME_POKEMON_HUNTER) {`
    - Bom:
        - `if (hasAllCriteriasToBecomePokemonHunter(usuario)) {`
- Crie variáveis apenas para dar nome às coisas
    - Ruim:
        - `if (usuario.isValid() && usuario.getType().equals(UserType.WIZARD) && usuario.getMana() > 0) {`
    - Bom:
        - `var isActiveWizard = usuario.isValid() && usuario.getType().equals(UserType.WIZARD) && usuario.getMana() > 0`

### Booleans
- Dê nome a eles
- Não crie métodos que mude o comportamente do acordo com flags. Prefira usar sobrecarga
    - Ruim:
        - `public void evoluirPersonagem(Personagem personagem, boolean isSayajin) {`
    - Bom:
        - `public void evoluirPersonagemComum(Personagem personagem) {`
        - `public void evoluirPersonagemSayajin(Personagem personagem) {`
- É melhor criar uma afirmação negativa do que negar uma afirmação! *WHAAAAT?*
    - Ruim:
        - `if (!isSayajin(usuario)) {`
    - Bom:
        - `if (isPersonagemComum(usuario)) {`
        - `if (isNotSayajin(usuario))`
- Nunca, mas sério, serião, nunca negue um if que tem um else

  ```java
    if (!isSayajin(usuario)) { 
      berraBemLoco();
    } else {
      berraBemLoco();
      mudaCorCabelo(Cor.DOURADO);
    }
  ```

### Styleguide
- Escolha um ou crie o seu
    - https://google.github.io/styleguide/javaguide.html
    - https://www.oracle.com/technetwork/java/codeconventions-150003.pdf
- Styleguide documentado nos projetos
- Quando trabalhando em time, o código deve parecer ter sido escrito por apenas uma pessoa

### Métodos
- Quanto menos parâmetros, melhor
  - Olá, Single Responsability
  - Olha! Um DTO
- Há duas regras para definir tamanho de métodos:
  - Regra 1: "Eles precisam ser pequenos" *
  - Regra 2: "Eles têm de ser ainda menores" *
  - (Robert C. Martin)

### DRY (Don't Repeat Yourself)
- Evitar repetição!
- Olá, Single Responsability!
- Prefira usar abstrações e/ou interface
- Interfaces menores

### KISS: Keep It Simple, Stupid

### Regra do Escoteiro
- Ao realizar uma entrega, o código deve estar mais limpo do que quando iniciou a atividade
- Oi? Sonar? Ajuda ae!

### Senso de Propriedade
- Sinta-se dono do código como um todo, e não apenas do código que escreveu
- O sentimento que tem que ficar: "Tire essas suas patas sujas do meu código"

> "Um código limpo sempre parece que foi escrito por alguém que se importava" (Michael Feathers)

### Nomenclatura Importa
- Nomes precisos
- Sem medo de ~~ser feliz~~ nomes grandes
- Padrão, siga um padrão, mesmo que seja um padrão ruim
- Use Sufixos
- Use Prefixos
- Pense em como os arquivos serão exibidos na IDE

### Cuidados :warning:

- Classes "Utils"
    - https://www.vojtechruzicka.com/avoid-utility-classes/
    - https://www.yegor256.com/2014/05/05/oop-alternative-to-utility-classes.html
    - Não representam um objeto
    - Não são injetáveis 
        - Dificuldade em testar
    - Podem ir contra o SRP
- findAll
    - Prefira queries específicas
    - Use paginação
- Responsabilidade da Controller
    - Deve servir como canal de entrada
    - Não deve possuir regra de negócio
    - Não deveria chamar diretamente um repository
    - Delega a responsabilidade para as services
- Responsabilidade do Validator
    - Evite injetar service ou repository
    - Implemente somente a regra de validação
    - Passe os parâmetros necessários para a validação ocorrer

### Analise de código

:white_check_mark:
```java
public boolean motoristaNaoCadastrado (String cpf) {
    return !repository.existsByCpfNumero(cpf);
}
```

:x: - "Validar" com retorno boolean
```java
public boolean validarCategoriaMotoristaVeiculo(Categoria categoria, String cpf) {
    Motorista motorista = procurarMotoristaPorCPFService.procurarMotoristaPorCPF(cpf);
    return motorista.getCnh()
            .getCategoria()
            .equals(categoria);
}
```

Melhor ?
```java
public boolean motoristaPossuiPermissaoParaCategoria(Categoria categoria, String cpf) {
    Motorista motorista = procurarMotoristaPorCPFService.procurarMotoristaPorCPF(cpf);
    return motorista.getCnh()
            .getCategoria()
            .equals(categoria);
}
```

---

:x: - Status.F ?
```java
@Getter
@AllArgsConstructor
public enum Status {

    C("Corrida Chamada"),
    I("Corrida Iniciada"),
    F("Corrida Finalizada");

    private String descricao;
}
```

```java
public List<Corrida> buscaCorridaFinalizadaPorIDMotorista(Long id){
    return repository.findByStatusEqualsAndMotorista_ID(Status.F, id);
}
```

Melhor ?
```java
@Getter
public enum Status {
    CHAMADA,
    INICIADA,
    FINALIZADA;
}
```

---

:x: - Redundante
```java
public void validar(Long id) {
    long quantidadeDeVeiculosDoMotorista = veiculoRepository.findAllByProprietario(id)
            .stream()
            .filter(veiculo -> veiculo.getProprietario().getIdMotorista().equals(id))
            .count();

    if (LIMITE_DE_VEICULOS_PARA_EXCLUIR_MOTORISTA >= quantidadeDeVeiculosDoMotorista) {
        throw new BadRequestException("Motorista não pode ter veiculos associados para ser excluido");
    }
}
```

```java
public void validar(Long id) {
    long quantidadeDeVeiculosDoMotorista = veiculoRepository.countByProprietario(id);

    if (LIMITE_DE_VEICULOS_PARA_EXCLUIR_MOTORISTA >= quantidadeDeVeiculosDoMotorista) {
        throw new BadRequestException("Motorista não pode ter veiculos associados para ser excluido");
    }
}
```

# Leitura Recomendada ~~que não será lida~~ :smirk:

- https://www.journaldev.com/1827/java-design-patterns-example-tutorial
- [Orientação a Objetos e SOLID para Ninjas](https://www.casadocodigo.com.br/products/livro-oo-solid)
- [Design Patterns com Java](https://www.casadocodigo.com.br/products/livro-design-patterns)
- [Clean Code: A Handbook of Agile Software Craftsmanship](https://www.amazon.com.br/dp/B001GSTOAM)
- https://www.amazon.com.br/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882


---
