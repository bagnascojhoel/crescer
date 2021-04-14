package veiculos;

import militares.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaminhaoTest {

    @Test
    public void deveRetornarVerdadeiroQuandoLicencaCaminhaoValidaETripulacaoTotalIgualACinco() {
        PilotoCaminhao pilotoCaminhao = new PilotoCaminhaoImpl(1000, LocalDate.now().plusDays(1));
        List<Militar> tripulacao = new ArrayList<>();

        for (int i = 5; i > 0; i--) tripulacao.add(new Militar(1000));

        Caminhao caminhao = new Caminhao(pilotoCaminhao, tripulacao, 1, 1);

        // act
        boolean validadeReal = caminhao.tripulacaoValida();

        // assert
        Assert.assertTrue(validadeReal);
    }

    @Test
    public void deveRetornarVerdadeiroQuandoLicencaCaminhaoValidaETripulacaoTotalMaiorCincoEMenorTrinta() {
        PilotoCaminhao pilotoCaminhao = new PilotoCaminhaoImpl(1000, LocalDate.now().plusDays(1));
        List<Militar> tripulacao = new ArrayList<>();

        for (int i = 10; i > 0; i--) tripulacao.add(new Militar(1000));

        Caminhao caminhao = new Caminhao(pilotoCaminhao, tripulacao, 1, 1);

        // act
        boolean validadeReal = caminhao.tripulacaoValida();

        // assert
        Assert.assertTrue(validadeReal);
    }

    @Test
    public void deveRetornarVerdadeiroQuandoLicencaCaminhaoValidaETripulacaoTotalIgualTrinta() {
        PilotoCaminhao pilotoCaminhao = new PilotoCaminhaoImpl(1000, LocalDate.now().plusDays(1));
        List<Militar> tripulacao = new ArrayList<>();

        for (int i = 30; i > 0; i--) tripulacao.add(new Militar(1000));

        Caminhao caminhao = new Caminhao(pilotoCaminhao, tripulacao, 1, 1);

        // act
        boolean validadeReal = caminhao.tripulacaoValida();

        // assert
        Assert.assertTrue(validadeReal);
    }

    @Test
    public void deveRetornarFalsoQuandoLicencaCaminhaoValidaETripulacaoTotalMenorCinco() {
        PilotoCaminhao pilotoCaminhao = new PilotoCaminhaoImpl(1000, LocalDate.now().plusDays(1));
        List<Militar> tripulacao = new ArrayList<>(Arrays.asList(new Militar(1000)));
        Caminhao caminhao = new Caminhao(pilotoCaminhao, tripulacao, 1, 1);

        // act
        boolean validadeReal = caminhao.tripulacaoValida();

        // assert
        Assert.assertFalse(validadeReal);
    }

    @Test
    public void deveRetornarFalsoQuandoLicencaCaminhaoValidaETripulacaoTotalMaiorTrinta() {
        PilotoCaminhao pilotoCaminhao = new PilotoCaminhaoImpl(1000, LocalDate.now().plusDays(1));
        List<Militar> tripulacao = new ArrayList<>();
        for (int i = 31; i > 0; i--) tripulacao.add(new Militar(1000));

        Caminhao caminhao = new Caminhao(pilotoCaminhao, tripulacao, 1, 1);

        // act
        boolean validadeReal = caminhao.tripulacaoValida();

        // assert
        Assert.assertFalse(validadeReal);
    }

    @Test
    public void deveRetornarFalsoQuandoLicencaCaminhaoInvalidaETripulacaoValida() {
        PilotoCaminhao pilotoCaminhao = new PilotoCaminhaoImpl(1000, LocalDate.now());
        List<Militar> tripulacao = new ArrayList<>();
        for (int i = 10; i > 0; i--) tripulacao.add(new Militar(1000));

        Caminhao caminhao = new Caminhao(pilotoCaminhao, tripulacao, 1, 1);

        // act
        boolean validadeReal = caminhao.tripulacaoValida();

        // assert
        Assert.assertFalse(validadeReal);
    }
}
