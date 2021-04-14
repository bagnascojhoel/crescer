// const soma = (valores) => valores.reduce((acc, curr) => acc + curr, 0);
// const subtracao = (valores) => valores.reduce((acc, curr) => curr - acc, curr);
// const multiplicacao = (valores) => valores.reduce((acc, curr) => acc * curr, 1);
// const divisao = (valores) => valores.reduce((acc, curr) => acc / curr, 1);

const soma = (valores) => {
  let res = 0;

  for (valor of valores)
    res += valor;

  return res;
}

const subtracao = (valores) => {
  let res = valores[0];
  
  
  for (let i = 1; i < valores.length; i++)
    res -= valores[i];

  return res;
}

const multiplicacao = (valores) => {
  let res = 1;

  for (valor of valores)
    res *= valor;

  return res;
}

const divisao = (valores) => {
  let res = 1;

  for (valor of valores)
    res /= valor;

  return res;
}

const operacoesPorNome = { soma, subtracao, multiplicacao, divisao };
const operacoesPorIndex = Object.values(operacoesPorNome);

const calcular = (operacao, valores) => operacoesPorNome[operacao]
  ? operacoesPorNome[operacao](valores)
  : operacoesPorIndex[operacao]
    ? operacoesPorIndex[operacao](valores)
    : 'OPERAÇÃO INVÁLIDA';

const deveSerSeteQuandoCalcularSomaTresEQuatro = calcular("soma", [3, 4]);
console.log(deveSerSeteQuandoCalcularSomaTresEQuatro); // 7

const deveSerDoisQuandoCalcularSubtracaoDeCincoPorDoisEUm = calcular("subtracao", [5, 2, 1]);
console.log(deveSerDoisQuandoCalcularSubtracaoDeCincoPorDoisEUm); // 2

const deveSerVinteECincoQuandoCalcularMultiplicacaoDeCincoPorCinco = calcular('multiplicacao', [5, 5]);
console.log(deveSerVinteECincoQuandoCalcularMultiplicacaoDeCincoPorCinco); // 25

const deveSerZeroQuandoCalcularMultiplicacaoDeSetePorZero = calcular('multiplicacao', [7, 0]);
console.log(deveSerZeroQuandoCalcularMultiplicacaoDeSetePorZero); // 0

const deveSerCincoQuandoCacularDivisaoDeVinteECincoPorCinco = calcular('divisao', [25, 5]);
console.log(deveSerCincoQuandoCacularDivisaoDeVinteECincoPorCinco);

const deveSerOperacaoInvalidaQuanoCalcularBatata = calcular('batata', [25, 40]);
console.log(deveSerOperacaoInvalidaQuanoCalcularBatata);

const deveSerCincoQuandoCalcularOperacaoZeroComDoisMaisUmMaisDois = calcular(0, [2, 1 ,2]);
console.log(deveSerCincoQuandoCalcularOperacaoZeroComDoisMaisUmMaisDois);

const deveSerSeisQuandoCalcularOperacaoUmComVinteEQuatroMenosQuatroMenosDezMenosQuatro = calcular(1, [24, 4, 10, 4]);
console.log(deveSerSeisQuandoCalcularOperacaoUmComVinteEQuatroMenosQuatroMenosDezMenosQuatro);

const deveSerDoisQuandoCalcularOperacaoDoisComDoisEUm = calcular(2, [2, 1]);
console.log(deveSerDoisQuandoCalcularOperacaoDoisComDoisEUm);

const deveSerZeroPontoCincoQuandoCalcularOperacaoUmComUmEDois = calcular(3, [1, 2]);
console.log(deveSerZeroPontoCincoQuandoCalcularOperacaoUmComUmEDois);

const deveSerOperacaoInvalidaQuandoCalcularComOperacaoQuatro = calcular(4, [0, 2]);
console.log(deveSerOperacaoInvalidaQuandoCalcularComOperacaoQuatro);
