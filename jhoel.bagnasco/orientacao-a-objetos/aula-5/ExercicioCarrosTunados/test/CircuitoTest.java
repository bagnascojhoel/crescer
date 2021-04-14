import org.junit.Assert;
import org.junit.Test;
import pecas.Freio;
import pecas.Motor;
import pecas.Pneu;
import trajetos.Curva;
import trajetos.Reta;
import trajetos.Trajeto;

import java.util.Arrays;
import java.util.List;

public class CircuitoTest {
    @Test
    public void deveRealizarCorridaComTodosOsCarrosCompletandoQuandoPistaForFacil() {
        List<Trajeto> pista = Arrays.asList(new Reta(2), new Curva(2), new Reta(2));
        List<Carro> grid = Arrays.asList(new Carro(), new Carro(), new Carro());
        Circuito interlagos = new Circuito(pista);
        int quantidadeEsperada = 3;

        // act
        List<Carro> carrosQueCompletaram = interlagos.realizarCorrida(grid);
        int quantidadeReal = carrosQueCompletaram.size();


        // assert
        Assert.assertEquals(quantidadeEsperada, quantidadeReal);
    }

    @Test
    public void deveRealizarCorridaComNenhumCarroCompletandoQuandoPistaForDificil() {
        List<Trajeto> pista = Arrays.asList(new Reta(20), new Curva(30), new Reta(20));
        List<Carro> grid = Arrays.asList(new Carro(), new Carro(), new Carro());
        Circuito interlagos = new Circuito(pista);
        int quantidadeEsperada = 0;

        // act
        List<Carro> carrosQueCompletaram = interlagos.realizarCorrida(grid);
        int quantidadeReal = carrosQueCompletaram.size();

        // assert
        Assert.assertEquals(quantidadeEsperada, quantidadeReal);
    }

    @Test
    public void deveConcluirCorridaQuandoPossuiPecasSuficientementeTunadas() {
        List<Trajeto> pista = Arrays.asList(new Reta(20), new Curva(30), new Reta(20));
        Carro carroTunado = new Carro();
        carroTunado.tunar(new Pneu(600));
        carroTunado.tunar(new Motor(300));
        carroTunado.tunar(new Freio(300));
        List<Carro> grid = Arrays.asList(new Carro(), carroTunado, new Carro());
        Circuito interlagos = new Circuito(pista);
        int quantidadeEsperada = 1;

        // act
        List<Carro> carrosQueCompletaram = interlagos.realizarCorrida(grid);
        int quantidadeReal = carrosQueCompletaram.size();

        // assert
        Assert.assertEquals(quantidadeEsperada, quantidadeReal);
    }

}
