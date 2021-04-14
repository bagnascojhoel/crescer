#### CRESCER 2020/2 - JAVA - TCC

# Minha Rede Social

O projeto **Minha Rede Social** consiste em desenvolver uma rede social com algum tema de livre escolha, seguindo alguns requisitos que serão explicados a seguir.

### Tema

Até **20/11/2020** deve ser enviado o tema escolhido para o email: `zanatta.everton@cwi.com.br`
  
### Formato

Trabalho individual.

### Organização do código

No diretório onde está esse README, existe o padrão de nomes de pastas e arquivos a serem seguidos de forma **rigorosa**. Seguir **estritamente** as seguintes definições:

  - Uma vez que usaremos scripts automatizados, os projetos que não seguirem esse padrão não serão considerados
  - Criar uma pasta `tcc-java` no root (primeiro nível) do repositório de vocês
  - Dentro dessa pasta, criar duas pastas: `api` (backend) e `app` (frontend)
  - Backend
    - Os fontes do projeto java deve estar diretamente na pasta api. Ou seja, o `pom.xml` deve estar em `{seu_repo}/tcc-java/api/pom.xml`
    - O *groupId* deverá ser, **obrigatoriamente**, `br.com.cwi.crescer.tcc`
    - O *artifactId* deverá ser, **obrigatoriamente**, o nome do seu usuário do gitlab, exemplo `zanatta.everton`
    - Deve haver um arquivo `.gitignore` que igore os arquivos da IDE e gerados automaticamente (pasta target, node_modules, etc)
    - A API deverá subir na porta `8090`
    - A API deverá subir com o contexto `tcc-java`
    - O projeto do postman deve ser exportado e comitado na pasta `resources` da API, ou seja, `tcc-java/api/src/main/resources`
  - Frontend
    - Os fontes do projeto react deve estar diretamente na pasta app. Ou seja, o `package.json` deve estar em `{seu_repo}/tcc-java/app/package.json`
    - No `package.json`, o *name* do projeto deverá ser, **obrigatoriamente**, o nome do seu usuário do gitlab, exemplo `zanatta.everton`
    - No `package.json`, deverá existir um comando `npm start` para iniciar a aplicação
    - Deve haver um arquivo `.gitignore` que igore os arquivos da ide e gerados automaticamente
    - Pode ser usado o Reactstrap / SemanticUI (frameworks) e derivados
  - DB
    - Todos os scripts necessários para criar a base de dados devem ficar na pasta `db`
  - Crie um arquivo `README.md` na raiz do projeto e descreva a sua rede social

### Entrega

Commitado no `gitlab` até às **10:59:59 do dia 23/11/2020** nem um minuto a mais.
  - Deve ser criada uma branch chamada `feature-rede-social`
  - A entrega será feita a partir de um **Merge Request** (MR) da branch `feature-rede-social` para a branch `master`
  - Não serão considerados os MR com commits após o horário estipulado

### Apresentação

- :calendar: **23/11/2020** 
- :clock130: 13:30.

---

## Requisitos Necessários: 

### 1. Cadastro de usuário

A rede social deve permitir o cadastro de um novo usuário. Serão necessários os seguintes dados:

| Dados Necessários  | Tipo                                          |
|--------------------|-----------------------------------------------|
| NOME COMPLETO      | String, Obrigatório, máximo de 255 caracteres |
| EMAIL              | String, Obrigatório, máximo de 255 caracteres |
| APELIDO            | String, Opcional, máximo de 50 caracteres     |
| DATA DE NASCIMENTO | LocalDate, Obrigatório                        |
| SENHA              | String, Obrigatório, máximo de 128 caracteres |
| IMAGEM DE PERFIL   | String, Opcional, máximo de 512 caracteres    |

**Observações:** 
- O e-mail deve ser único, ou seja, não deve permitir um cadastro caso o e-mail já exista;
- A senha deve ser criptografada.
    
### 2. Autenticação 

A rede social deve possuir uma tela de login, que será utilizada para acesso ao perfil de usuário.

**Observações:** 
 - Deverá mostrar uma mensagem informando quando o e-mail ou a senha estiverem incorretos.

### 3. Dashboard - Tela Principal (home)

A rede social deve possuir uma tela principal, que será o perfil do usuário, essa tela deve conter as seguintes funcionalidades:

- Exibir os dados do usuário logado.
- Exibir uma lista com as solicitações de amizade recebidas de outros usuários;
- Exibir um formulário simples para realizar uma postagem;
- Listar os posts do próprio usuário e de todos os amigos de forma paginada, sendo o mesmo ordenado pela data da postagem (mais recentes primeiro);
  - Em cada post deve ser possível curtir e também remover a curtida;
  - Em cada post deve ser possível adicionar comentários;

**Observações:** 
 - Os posts deverão possuir permissão de visualização: `público` (todos que acessarem o perfil podem visualizar) ou `privado` (apenas os amigos da pessoa que realizou a postagem, podem visualizar). Deve ser possível alterar a regra de visualização a qualquer momento.

### 4. Busca de Contatos

A rede social deve permitir buscar usuários (já cadastrados) para pesquisá-los e enviar solicitações de amizade.

**Observações:** 
 - Deverá ter um filtro de pesquisa por nome ou e-mail no **mesmo campo**, sem que o usuário precise definir o que está sendo buscado;
 - Não será possível enviar solicitação de amizade a si próprio ou a quem já está na lista de amizades;
 - A listagem de contatos deve possuir paginação.

### 5. Lista de Amigos

A rede social deve possuir uma tela com a listagem de amigos, onde será possível verificar todos os amigos e desfazer amizades.

**Observações:** 
 - Deverá ter um filtro de pesquisa por nome ou e-mail no **mesmo campo**, sem que o usuário precise definir o que está sendo buscado;
 - Será possível acessar o perfil de um amigo ao clicar em seu nome na listagem;
 - A listagem deve possuir paginação.

### 6. Perfil de Usuários

A rede social deve possuir uma tela para visualizar o perfil de outros usuários contendo o seu posts públicos. Se o perfil for de um usuário que já possua vínculo de amizado com o usuário logado, então deve ser possível ver os posts privados também.

**Observações:** 
 - Se o usuário já for amigo, deverá mostrar um botão para desfazer amizade, se ainda não for amigo, um botão para enviar uma solicitação.

### 7. Edição de Perfil

A rede social deve possuir uma tela de edição de perfil, onde será permitido editar o nome, o apelido e a imagem de perfil.

## Observações
- As definições passadas são cenários/regras de negócio e devem ser atendidas pela solução entregue, porém elas não definem COMO a mesma será implementada.
- Validações básicas devem ser feitas (mesmo que não tenham sido solicitadas de forma explícita). Exemplo: informações obrigatórias nas chamadas da API.
- O usuário deve ser notificado sobre a ação que ele está fazendo. Exemplo: Mensagens de erro de validação ou erros inesperados e mensagens de sucesso.
- Não é necessário atender cenários alternativos que não foram solicitados. Mas não é errado fazer isso.
- Os termos usados aqui são genéricos. Caso faça mais sentido na sua rede social chamar "curtir" de "gostar" ou "apoiar", não tem problema, desde que o contexto seja o mesmo. O mesmo serve para amizades, postagens, perfil, etc. Sejam criativos.

## Dicas
- Organização >> TUDO.
- Não comecem a pensar em firulas antes de atender ao escopo principal (o mesmo vale para cenários alternativos).
- Cogitem utilizar frameworks de frontend.
- Não subestimem a entrega.

**Boa Sorte!** :four_leaf_clover:
