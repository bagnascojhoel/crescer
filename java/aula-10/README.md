# Aula 10

## Exercício
Cada aluno deve pensar e formular UMA dúvida sobre o conteúdo visto até aqui.
- Mandar via discord (direto pro @zanatta).
- Tempo 15 minutos.


## Dúvidas
- Como testar os mappers que usam ModelMapper para montar o retorno e porque testa-los se são compostos só por setter/getter (Lukão)
- quando eu fui começar o teste da service que me retorna um veículo randômico me disseram que era muito complexa e que seria mais fácil começar pelas outras e eu não tenho ideia agora de como fazer esse tipo de teste (Marcelo)
- Como faço pra testar um mapper que não tem nenhum set manual,  só utiliza o modelMapper? (Rafaela)
- há alguma forma de validar via teste que um valor atribuido via "set" em um objeto request seja passado para um objeto domain e depois para um objeto response com apenas a primeira atribuição feita no objeto request?
(considerando que essa primeira atribuição feita no objeto resquest seja de um atributo que tanto o request, quanto o domain e o response tenham em comum) (Rodrigo) = ver depois
- gostaria de saber se existe alguma forma da nossa api requisitar dados de uma api de terceiros, e se tem, como ? (Thiago)
- algum metodo fica na classe domain? ou é settado alguma coisa no construtor, do jeito que a gente ta programando? Guilherme Carmo
- Arthur Kist JuchemHoje às 14:21
Como testar alguma lógica que resulte em algo aleatório, como por exemplo o tempo da chegada da corrida? Não sabia muito bem o que colocar no assert
- Rafael GermannHoje às 14:16
Tenho uma dúvida só em relação a paginação e ordenação, tentei fazer no trabalho mas retornava vazio, agora olhando o git eu vi que tu tinha colocado o 
?sort=email,DESC&size=2&page=1
, só colocando isso na chamada já resolveria o problema de voltar vazio?   Se puder fazer um exemplo agradeceria, pois acho que será importante pro tcc
- Pedro BeckerHoje às 14:22
minha duvida é como se testa mappers, e como as annotations(@getter @getmapping, etc) funcionam 'por baixo do pano'
- leonardo.krugerHoje às 14:15
Qual era o minimo esperado para esta entrega do trabalho 2, pra não "dar ruim" ?
obs: no momento não me veio nenhuma pergunta técnica ao pensamento

- jenniferdiehlHoje às 14:16
Exercício aula 10 - dúvida

1 - Ainda sobre testes, quando e o que devo "mokar" ou não? 

2-  Se no meu request eu tenho anotações de @NotNull, @NotEmpty,etc... que o spring já valida pra mim, eu preciso ainda sim, remover isso das requests e subdividir em validators, para testar?

3 -Criei uma coluna saldo em NUMBER, mas com dica de uma colega, após estourar um erro na tabela ao rodar a aplicação, troquei por DOUBLE PRECISION, para que funcionasse, sabe me explicar o porque?

- A maior pergunta que eu tenho nesse momento, não é uma pergunta interessante nem nada, mas foi essa questão mesmo de injetar aquela classe config dentro do model mapper e conseguir usar ela dentro do test do mapper, eu tentei com mock, injectmock, tentei instanciado direto em um before, nada funcionou e minha solução foi fazer de conta que eu não tinha ela e instanciei um model mapper nas classes que precisei. (patricia)

- paulo steffenHoje às 14:11
Eai
Tem como realizar um teste pegando alguma informacao do banco?
Por exemplo eu inclui um passageiro
Ai no meu teste quero obter este passageiro, sem mock só um findByCpf simples?
Se for possível é correto utilizar esta abordagem
Por exemplo, todos meus testes eu fiz independente do banco, com insformacoes mockadas

- Taiane SchutzHoje às 14:12
Existe algum "passo a passo" para fazer testes? 
E a outra dúvida é por que testar mapper?

- Leonardo VargasHoje às 14:06
Zanatta, minha dúvida é quanto ao .when de métodos void

- Pedro JacobusHoje às 14:11
Uma duvida que eu tenho é sobre os testes em Mapper quando usar o model mapper não basta e tem que setar valores a mão. Não consegui entender como fazer, quais valores, dentro do teste, eu tenho que setar a mão; se são todos, só o que vão aparecer na response. Se puder explicar a lógica dele eu agradeço.

- capoaniHoje às 14:11
Oii, então, há alguma maneira de transformar um atributo de uma classe em uma tabela separada do restante?
Quando fui auxiliar um colega nesse ultimo trabalho ele tinha um atributo na classe corrida que era um array, então fiquei me perguntando se ele poderia criar uma tabela específica com esse array da corrida apenas com anotações do persistence ou se ele teria que transformar esse atributo em outra classe para fazer JoinColumn

- MaikeHoje às 14:11
Minha duvida seria como Mapper,achei meio confuso quando estava aprendendo, tem como testar com Mock, como seria?

- LuccaHoje às 14:11
Algum exemplo simples mostrando um fluxo pra fazer minha aplicação começando pelos testes... o que eu valido no teste e como que sigo pra ter minha aplicação... qual a principal vantagem de fazer assim...

- Derik MarceloHoje às 14:10
O que é melhor prática,  validar um dado e lançar exception ou tratar/normalizar o dado? Ex.: motorista tentou sacar mais do que tinha na conta, eu seto o valor de saque pra o máximo da conta ou lanço a exception?

- Jhoel GaleanoHoje às 14:10
Qual a vantagem de utilizar uma classe tipo a CPF, quando se utiliza os  validators e services pra garantir a validade de um dado? Não é melhor deixar a validação apenas nos validators, isolando o lançamento de exceptions esperadas?

- José RodriguesHoje às 14:10
Uma questão sobre classe de response: Vale a pena eu ter objetos dentro de objetos ou é melhor que a classe tenha mais atributos?(tipo os atributos de dentro de objeto, eu tiro e ponho só na classe de response msm)

Gabriel EnriconiHoje às 14:09
Não sei se é uma dúvida muito básica mas queria saber como funciona a Query + DTO

Marcelo LopesHoje às 14:10
Como testar services que usam LocalDateTime

angelakashyaHoje às 14:09
A minha dúvida é em relação a testar metodos void, se  usa o when, e caso sim como que se usa e?

GiulianoHoje às 14:09
Como testar uma função delete void que trabalha diretamente com o banco de dados? Fiquei na duvida de como conseguir alguma informação em um caso desses para poder avaliar o sucesso da operação.

Marlon SaldanhaHoje às 14:08
Durante os meus testes, eu senti a necessidade de acessar uma instancia a qual eu não tinha controle dentro de uma service. Foi aí que, pesquisando um pouco, eu descobri que existe o Captor.
Pelo meu entendimento, eu posso informar para um método mockado que sempre que houver uma chamada dele com um objeto de um tipo específico, eu posso dizer para ele capturar
a minha instância do teste. Minha dúvida é se eu realmente usei da maneira correta, pois ficou um pouco nebuloso esse @Captor. Usei da forma correta e no contexto correto?

Daniel BrochierHoje às 14:08
Duvida: Em testes, como fazer para testar services que tem algum valor optional, pq sempre que tentei fazer caia na exception ou dava o erro de "No values"

Gabriel BittencourtHoje às 14:07
Como fazer o teste de buscar todos os passageiros/motoristas com Page e Pageable? Meu Page ta ficando vazio, dai lança nullpointer no page.get()


João SchneiderHoje às 14:06
Opa, segue a dúvida
Na controller de motorista, tive que usar a anotação @Transactional pro endpoint de remoção; descobri ela pesquisando sobre um problema de Entity Manager na hora de fazer o delete do banco. Isso é normal? Existem outras opções pra solucionar isso?

YuriHoje às 14:07
uma forma para evitar os loops por causa de relacionado bidirecional

Guilherme Lemos
fiquei mais em dúvida com aquele negócio extra que tu mostrou na ultima aula, de paginação e tudo mais