# Exercícios (OPCIONAL)

## Exercício 1 - Configurar Security

1. Adicionar as dependências do pom.xml
1. Adicionar package security igual o projeto da aula. 
1. Alterar endpoint de Cadastro de Passageiro para não exigir autenticação e comunicar com a api de autenticação.
1. Alterar endpoint de Cadastro de Motorista para não exigir autenticação e comunicar com a api de autenticação.
1. Implementar login (/publico/usuario/autenticar).
1. Alterar Pessoa para que o email seja UNIQUE


## Exercício 2 - Limitar acessos

1. Alterar o endpoint de Cadastro de Veículos para ser possível apenas para Motoristas Logados
1. Alterar o endpoint de Chamar Corrida para ser possível apenas para Passageiros Logados
1. Alterar o endpoint de Iniciar Corrida para ser possível apenas para Motoristas Logados
1. Alterar o endpoint de Finalizar Corrida para ser possível apenas para Motoristas Logados
1. Alterar o endpoint de Avaliar Motorista para ser possível apenas para Passageiros Logados
1. Alterar o endpoint de Avaliar Passageiro para ser possível apenas para Motoristas Logados
1. Só é possível avaliar uma corrida quem participou dela
1. Alterar o endpoint de Listar Corridas de um Passageiro para o Passageiro Logado
1. Alterar o endpoint de Saque da Conta Virtual para ser possível apenas para Motoristas Logados
1. Alterar o endpoint de Depósito na Conta Virtual para ser possível apenas para Passageiros Logados
