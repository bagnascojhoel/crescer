package veiculos;

import militares.Elite;
import militares.PilotoAviaoImpl;
import militares.Militar;
import militares.PilotoAviao;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AviaoTest {

    // eu deveria fazer um teste, de licenca invalida igual hoje, outro para antes de hoje, ou apenas um esta okay?
    /*
     * deveRetornarFalsoQuandoValidadeLicencaIgualHojeETripulacaoTotalIgualUm
     * deveRetornarFalsoQuandoValidadeLicencaAntesDeHojeETripulacaoTotalIgualUm
     * deveRetornarFalsoQuandoValidadeLicencaDepoisDeHojeETripulacaoTotalIgualUm
     *
     * deveRetornarFalsoQuandoValidadeLicencaIgualHojeETripulacaoTotalDiferenteDeUm
     * deveRetornarFalsoQuandoValidadeLicencaAntesDeHojeETripulacaoTotalDiferenteDeUm
     * deveRetornarFalsoQuandoValidadeLicencaDepoisDeHojeETripulacaoTotalDiferenteDeUm
     *
     * Nao poderia testar com dois asserts em um metodo nesse caso?
     * Ou nao posso considerar que esta correto sendo que tenho testes unitarios para o metodo que faz a validacao
     * da data de validade da licenca?
     * */

    @Test
    public void deveRetornarVerdadeiroQuandoLicencaAviaoValidaETripulacaoTotalMenorQueUm() {
        PilotoAviao pilotoAviao = new PilotoAviaoImpl(1000, LocalDate.now().plusDays(1));
        List<Militar> tripulacao = new ArrayList<>();
        Aviao aviao = new Aviao(pilotoAviao, tripulacao, 1, 1);

        // act
        boolean validadeReal = aviao.tripulacaoValida();

        // assert
        Assert.assertTrue(validadeReal);
    }

    @Test
    public void deveRetornarVerdadeiroQuandoLicencaAviaoValidaETripulacaoTotalIgualUm() {
        PilotoAviao pilotoAviao = new PilotoAviaoImpl(1000, LocalDate.now().plusDays(1));
        List<Militar> tripulacao = new ArrayList<>();
        tripulacao.add(new Militar(1000));

        Aviao aviao = new Aviao(pilotoAviao, tripulacao, 1, 1);

        // act
        boolean validadeReal = aviao.tripulacaoValida();

        // assert
        Assert.assertTrue(validadeReal);
    }

    @Test
    public void deveRetornarFalsoQuandoLicencaAviaoValidaETripulacaoTotalMaiorQueUm() {
        PilotoAviao pilotoAviao = new PilotoAviaoImpl(1000, LocalDate.now().plusDays(1));
        List<Militar> tripulacao = new ArrayList<>();
        for (int i = 2; i > 0; i--) tripulacao.add(new Militar(1000));

        Aviao aviao = new Aviao(pilotoAviao, tripulacao, 1, 1);

        // act
        boolean validadeReal = aviao.tripulacaoValida();

        // assert
        Assert.assertFalse(validadeReal);
    }

    @Test
    public void deveRetornarFalsoQuandoLicencaAviaoInvalidaETripulacaoTotalValida() {
        PilotoAviao pilotoAviao = new PilotoAviaoImpl(1000, LocalDate.now());
        List<Militar> tripulacao = new ArrayList<>();
        Aviao aviao = new Aviao(pilotoAviao, tripulacao, 1, 1);

        // act
        boolean validadeReal = aviao.tripulacaoValida();

        // assert
        Assert.assertFalse(validadeReal);
    }

}
