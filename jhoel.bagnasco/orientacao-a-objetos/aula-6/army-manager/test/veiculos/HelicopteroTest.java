package veiculos;

import militares.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelicopteroTest {

    @Test
    public void deveRetornarVerdadeiroQuandoLicencaHelicopteroValidaETripulacaoTotalMenorDez() {
        PilotoHelicoptero pilotoHelicoptero = new PilotoHelicopteroImpl(1000, LocalDate.now().plusDays(1));
        List<Militar> tripulacao = new ArrayList<>();

        for (int i = 5; i > 0; i--) tripulacao.add(new Militar(1000));

        Helicoptero helicoptero = new Helicoptero(pilotoHelicoptero, tripulacao, 1, 1);

        // act
        boolean validadeReal = helicoptero.tripulacaoValida();

        // assert
        Assert.assertTrue(validadeReal);
    }

    @Test
    public void deveRetornarVerdadeiroQuandoLicencaHelicopteroValidaETripulacaoTotalIgualDez() {
        PilotoHelicoptero pilotoHelicoptero = new PilotoHelicopteroImpl(1000, LocalDate.now().plusDays(1));
        List<Militar> tripulacao = new ArrayList<>();

        for (int i = 10; i > 0; i--) tripulacao.add(new Militar(1000));

        Helicoptero helicoptero = new Helicoptero(pilotoHelicoptero, tripulacao, 1, 1);

        // act
        boolean validadeReal = helicoptero.tripulacaoValida();

        // assert
        Assert.assertTrue(validadeReal);
    }

    @Test
    public void deveRetornarFalsoQuandoLicencaHelicopteroValidaETripulacaoTotalMaiorDez() {
        PilotoHelicoptero pilotoHelicoptero = new PilotoHelicopteroImpl(1000, LocalDate.now().plusDays(1));
        List<Militar> tripulacao = new ArrayList<>();
        for (int i = 11; i > 0; i--) tripulacao.add(new Militar(1000));

        Helicoptero helicoptero = new Helicoptero(pilotoHelicoptero, tripulacao, 1, 1);

        // act
        boolean validadeReal = helicoptero.tripulacaoValida();

        // assert
        Assert.assertFalse(validadeReal);
    }

    @Test
    public void deveRetornarFalsoQuandoLicencaHelicopteroInvalidaETripulacaoValida() {
        PilotoHelicoptero pilotoHelicoptero = new PilotoHelicopteroImpl(1000, LocalDate.now());
        List<Militar> tripulacao = new ArrayList<>();
        for (int i = 5; i > 0; i--) tripulacao.add(new Militar(1000));

        Helicoptero helicoptero = new Helicoptero(pilotoHelicoptero, tripulacao, 1, 1);

        // act
        boolean validadeReal = helicoptero.tripulacaoValida();

        // assert
        Assert.assertFalse(validadeReal);
    }

}
