import org.junit.Assert;
import org.junit.Test;
import pecas.Freio;
import pecas.Motor;
import pecas.Peca;
import pecas.Pneu;
import trajetos.Curva;
import trajetos.Reta;
import trajetos.Trajeto;

import java.util.Arrays;
import java.util.List;

public class CarroTest {

//      Vale a pena mudar a privacidade de um metodo para poder testa-lo?


//    @Test
//    public void deveSubstituirOMotorQuandoTunarReceberInstanciaDeMotorComQualidadeMaior() {
//        Carro carro = new Carro();
//        Motor peca = new Motor(200);
//        int qualidadeEsperada = 200;
//
//        // act
//        carro.tunar(peca);
//        int qualidadeReal = carro.
//
//        // assert
//        Assert.assertEquals(qualidadeEsperada);
//    }
//
//    @Test
//    public void deveSubstituirOFreioQuandoTunarReceberInstanciaDeFreioComQualidadeMaior() {
//        Carro carro = new Carro();
//        Freio peca = new Freio(200);
//
//        carro.tunar(peca);
//
//
//    }
//
//    @Test
//    public void deveSubstituirOPneuQuandoTunarReceberInstanciaDePneuComQualidadeMaior() {
//        Carro carro = new Carro();
//        Pneu peca = new Pneu(200);
//
//
//        carro.tunar(peca);
//
//
//    }
    /*
        TODO por enquanto, não tem problema adicionar métodos para possibilitar testes (mesmo expondo mais do que o
        necessário)
    */
    // TODO implementar os testes sobre as regras de negocio (mesmo específicas)

    @Test
    public void deveRetornarFalsoQuandoAlgumaPecaEstragar() {
        Carro carro = new Carro();
        List<Trajeto> pista = Arrays.asList(new Curva(30), new Curva(10));
        boolean estadoEsperado = false;

        boolean estadoReal = carro.correr(pista);

        Assert.assertEquals(estadoEsperado, estadoReal);
    }

    @Test
    public void deveRetornarTrueQuandoNenhumaPecaEstragar() {
        Carro carro = new Carro();
        List<Trajeto> pista = Arrays.asList(new Reta(10), new Reta(10));
        boolean estadoEsperado = true;

        boolean estadoReal = carro.correr(pista);

        Assert.assertEquals(estadoEsperado, estadoReal);
    }
}
