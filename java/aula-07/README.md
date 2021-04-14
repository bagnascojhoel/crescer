# Aula 7

- Daily
- Revisão (Hands On)
- Exercícios


----

# Regras Genéricas (vai ser atualizado)

- Service deve ter apenas um método público, a menos que tenha um motivo para ser diferente.
- Repository normalmente tem vários métodos públicos.

- Eu testo service, mapper, validator.
- Eu não teste controller


- Controller não injeta repository, mapper e validator.
- Repository não injeta outro repository, mapper e validator.
- Mapper não injeta outro mapper, repository e validator.