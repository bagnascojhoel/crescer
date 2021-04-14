import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTest {
    @Test
    public void deveRetornarSomaQuandoNumerosValidos() {
        double primeiroValor = 15;
        double segundoValor = 5;
        double resultadoEsperado = 20;

        Calculadora calculadora = new Calculadora();
        double resultadoReal = calculadora.soma(primeiroValor, segundoValor);

        Assert.assertEquals(resultadoEsperado, resultadoReal, 0.001);
    }

    @Test
    public void deveRetornarSubtracaoQuandoNumerosValidos() {
        double primeiroValor = 10;
        double segundoValor = 5;
        double resultadoEsperado = 5;

        Calculadora calculadora = new Calculadora();
        double resultadoReal = calculadora.subtracao(primeiroValor, segundoValor);

        Assert.assertEquals(resultadoEsperado, resultadoReal, 0.001);
    }

    @Test
    public void deveRetornarMultiplicacaoQuandoNumerosValidos() {
        double primeiroValor = 5;
        double segundoValor = 5;
        double resultadoEsperado = 25;

        Calculadora calculadora = new Calculadora();
        double resultadoReal = calculadora.multiplicacao(primeiroValor, segundoValor);

        Assert.assertEquals(resultadoEsperado, resultadoReal, 0.001);
    }

    @Test
    public void deveRetornarDivisaoQuandoNumerosValidos() {
        double primeiroValor = 25;
        double segundoValor = 5;
        double resultadoEsperado = 5;

        Calculadora calculadora = new Calculadora();
        double resultadoReal = calculadora.divisao(primeiroValor, segundoValor);

        Assert.assertEquals(resultadoEsperado, resultadoReal, 0.001);
    }

    @Test
    public void deveRetornarRaizQuadradaQuandoNumeroValido() {
        double valor = 25;
        double resultadoEsperado = 5;

        Calculadora calculadora = new Calculadora();
        double resultadoReal = calculadora.raizQuadrada(valor);

        Assert.assertEquals(resultadoEsperado, resultadoReal, 0.001);
    }

    @Test
    public void deveRetornarExponenciacaoQuandoExpoenteEBaseValidos() {
        int expoente = -1;
        double base = 10;
        double resultadoEsperado = 0.1;

        Calculadora calculadora = new Calculadora();
        double resultadoReal = calculadora.exponenciacao(base, expoente);

        Assert.assertEquals(resultadoEsperado, resultadoReal, 0);
    }

    @Test
    public void deveRetornarSomaRaizesBhaskaraQuandoValoresValidos() {
        double a = 10;
        double b = 20;
        double c = 10;
        double resultadoEsperado = -2;

        Calculadora calculadora = new Calculadora();
        double resutadoReal = calculadora.somaDasRaizesDaBhaskara(a, b, c);

        Assert.assertEquals(resultadoEsperado, resutadoReal, 0);
    }

}
