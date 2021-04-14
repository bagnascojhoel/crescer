## Funcionalidades

1. Cadastro de Motoristas
   - Motorista:
      - Nome completo (obrigatório)
      - E-Mail (obrigatório)
      - Data de Nascimento (obrigatório)
      - CPF (obrigatório)
      - Carteira de Habilitação (obrigatório)
          - Número (obrigatório)
          - Categoria (obrigatório)
          - Data Vencimento (obrigatório)
   - Regras:
      - O motorista deve possuir mais de 18 anos.
      - A carteira de habilitação não pode estar vencida
      - O e-mail informado deve possuir um formato válido
      - O CPF deve ser válido
      - Não deve ser possível cadastrar 2 motoristas iguais, ou seja, com o mesmo CPF.

1. Exclusão de Motoristas
      - Não deve ser possível excluir um motorista que esteja vinculado à um veículo

1. Cadastro de Veículos
   - Veículo:
      - Placa (obrigatório)
      - Marca (obrigatório)
      - Modelo (obrigatório)
      - Ano (obrigatório)
      - Cor (obrigatório)
      - Foto (url da foto) (opcional)
      - Quantidade de Lugares (opcional)
      - Categoria (obrigatório)
      - Proprietário (Motorista) (obrigatório)
   - Regras:
      - O proprietário selecionado precisa possuir um documento com categoria que permita dirigir este veículo.
      - As categorias possíveis são: `A`, `B`, `C`, `D`, `E` e `ACC`

1. Cadastro de Passageiros
   - Passageiro:
      - Nome completo (obrigatório)
      - E-Mail (obrigatório)
      - Data de Nascimento (obrigatório)
      - CPF (obrigatório)
   - Regras:
      - O passageiro deve possuir mais de 16 anos.
      - O e-mail informado deve possuir um formato válido
      - O CPF deve ser válido
      - Não deve ser possível cadastrar 2 passageiros iguais, ou seja, com o mesmo CPF.

1. Chamar uma corrida
   - Parâmetros:
      - Identificador do Passageiro (obrigatório)
      - Ponto inicial (coordenadas x e y) (obrigatório)
      - Ponto final (coordenadas x e y) (obrigatório)
   - Funcionalidade:
      - Deve ser criada uma nova corrida com um identificador (id) que deve ser gerado automaticamente pela aplicação. Sugestão: `lista.size() + 1`
      - Deve ser escolhido um veículo aleatório
   - Retorno esperado:
      - Identificador da Corrida
      - Um veículo que fará a corrida
         - O proprietário deste veículo (motorista) não pode estar com o documento vencido
         - O proprietário deste veículo (motorista) não pode estar em outra corrida (não encerrada) ao mesmo tempo
      - O tempo estimado para chegada do motorista (aleatório entre 5 e 10 min)

1. Iniciar uma corrida
   - Parâmetros
      - Identificador da Corrida
   - Funcionalidade:
      - Deve ser definida a hora de início da corrida (data atual)
      - Deve ser calculado o tempo estimado (em segundos) para chegada no pontoFinal
            - A distância total a ser percorrida é a diferença entre as coordenadas inicial e final. O resultado deve ser a distância em Km.
            - Para o cálculo do tempo, deve ser considerada uma velocidade média de 30km/h
      - Deve ser calculado o valor estimado da corrida (calcular com base no tempo estimado calculado, sendo R$ 0,20 o segundo)
   - Retorno esperado:
      - Tempo estimado para chegada no destino
      - Valor estimado da corrida

1. Finalizar uma corrida
   - Funcionalidade:
      - Deve ser definida a hora final da corrida (data atual)
      - Deve ser calculado o valor final, baseado no tempo real da corrida (sendo R$ 0,20 o segundo)
            - O tempo real deve ser calculado com a diferença da data hora final com a data hora inicial.
      - Deve ser feita a cobrança do passageiro
   - Regras:
      - Somente uma corrida já iniciada poderá ser finalizada.
      - O valor cobrado deve ser retirado da conta do passageiro e debitado na conta do motorista
      - Caso o saldo do passageiro seja insuficiente, deve ser retornado um erro e a corrida não pode ser considerada finalizada.

1. Inclusão de crédito na conta virtual de um Passageiro
   - Regras:
      - O valor depositado deve ser maior que zero.

1. Saque da conta virtual do Motorista
   - Regras:
      - Não deve ser possível sacar um valor maior que o saldo da conta.

1. Avaliar o passageiro de uma corrida (a ser realizado pelo motorista)
   - Parâmetros:
      - Identificador do Passageiro
      - Nota (de 1 à 5)
   - Regras:
      - O sistema deve aceitar somente números inteiros de 1 a 5.

1. Avaliar o motorista de uma corrida (a ser realizado por um passageiro)
   - Parâmetros:
      - Identificador da Corrida
      - Nota (de 1 à 5)
   - Regras:
      - O sistema deve aceitar somente números inteiros de 1 a 5.
