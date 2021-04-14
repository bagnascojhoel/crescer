import org.junit.Assert;
import org.junit.Test;

public class ExemploTesteUnitario {
    @Test
    public void soma() {
        // arrange
        int primeiroValor = 2;
        int segundoValor = 1;
        int valorEsperado = 3;

        // act
        int soma = primeiroValor + segundoValor;

        // assert
        Assert.assertEquals(3, valorEsperado);
    }

    @Test
    public void subtracao() {
        int primeiroValor = 50;
        int segundoValor = 25;
        int valorEsperado = 25;

        int resultado = primeiroValor - segundoValor;

        Assert.assertEquals(valorEsperado, resultado);
    }

    @Test
    public void multiplicacao() {
        int primeiroValor = 10;
        int segundoValor = 10;
        int valorEsperado = 100;

        int resultado = primeiroValor * segundoValor;

        Assert.assertEquals(valorEsperado, resultado);
    }

    @Test
    public void divisao() {
        double primeiroValor = 100;
        int segundoValor = 10;
        double valorEsperado = 10;

        double resultado = primeiroValor / segundoValor;

//        Assert.assertEquals(valorEsperado, resultado);
        Assert.assertEquals(valorEsperado, resultado, 0);
    }
}
