# Aula 11 - Segurança

### Tipos de Ataques

- [Top 10 Web Application Security Risks](https://owasp.org/www-project-top-ten/)

### Conceitos

- Autenticação

  - A autenticação basicamente identifica quem está tentando solicitar um recurso, ou seja, **autenticação** representa a forma de como o usuário prova quem ele realmente é. Geralmente usa-se usuário (ou email) e senha para realizar a autenticação de um usuário em uma aplicação.

- Autorização

  - A autorização é utilizada para verificar se o determinado usuário previamente autenticado possui permissão para usar, manipular ou executar o recurso em questão.

- Perfis
  - As aplicações definem papéis aos usuários e baseando-se nos papéis desses usuários eles têm acesso a determinados recursos.


## Spring Security

### Configuração

- Adicionar no arquivo `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

- Copiar o pacote `security` do projeto de exemplo da aula.
- Ajustar caminhos das controllers/métodos de forma que: `/privado/**` vai exigir autenticação e `/publico/**` não precisa de autenticação.

### Regras de acesso

- Via Anotação no método:

```java
@RolesAllowed({ "ROLE_PASSAGEIRO" })
@GetMapping("/metodo/passageiro")
public String somentePassageiroViaMetodo() {
    return "Somente PASSAGEIRO pode ver.";
}

@Secured({ "ROLE_PASSAGEIRO" })
@GetMapping("/metodo/passageiro/secured")
public String somentePassageiroViaMetodoUsandoSecured() {
    return "Somente PASSAGEIRO pode ver (via anotação @Secured).";
}
```

### Acesso ao usuário logado

- Via programação:

```java
public String getUsuarioLogadoViaProgramacao() {
    CustomUserDetails usuarioLogado = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
    return "Usuário logado: " + usuarioLogado.getUsername();
}
```

- Via injeção de dependência, atráves de anotação (como parâmetro do método):

```java
public String getUsuarioLogadoViaAnotacao(@AuthenticationPrincipal CustomUserDetails usuarioLogado) {
    return "Usuário logado: " + usuarioLogado.getUsername();
}
```

## Leituras Recomendadas
- [Spring Boot Doc - Security](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-security)
- [Rest Template](https://www.baeldung.com/rest-template)
- [Tutoriais de Spring Security](https://www.baeldung.com/security-spring)
- [Restrição de acesso por ROLE no método](https://www.baeldung.com/spring-security-method-security)
- [OAuth 2.0 Simplified](https://www.oauth.com/)
- [CORS](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS)
- [Corrigindo problema de cors](https://www.baeldung.com/spring-security-cors-preflight)
- [CSRF](http://blog.caelum.com.br/protegendo-sua-aplicacao-web-contra-cross-site-request-forgerycsrf/)
- [Documentação Spring SpEL](https://docs.spring.io/autorepo/docs/spring-security/5.0.x/reference/html/el-access.html#el-common-built-in)
