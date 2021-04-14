package veiculos;

import militares.*;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TanqueTest {

    @Test
    public void deveRetornarVerdadeiroQuandoLicencaTanqueValidaETripulacaoTotalIgualTres() {
        PilotoTanque pilotoTanque = new PilotoTanqueImpl(1000, LocalDate.now().plusDays(1));
        List<Militar> tripulacao = new ArrayList<>();

        for (int i = 3; i > 0; i--) tripulacao.add(new Militar(1000));

        Tanque tanque = new Tanque(pilotoTanque, tripulacao, 1, 1);

        // act
        boolean validadeReal = tanque.tripulacaoValida();

        // assert
        Assert.assertTrue(validadeReal);
    }

    @Test
    public void deveRetornarFalsoQuandoLicencaTanqueValidaETripulacaoTotalDiferenteDeTres() {
        PilotoTanque pilotoTanque = new PilotoTanqueImpl(1000, LocalDate.now().plusDays(1));
        List<Militar> tripulacao = new ArrayList<>();
        for (int i = 5; i > 0; i--) tripulacao.add(new Militar(1000));

        Tanque tanque = new Tanque(pilotoTanque, tripulacao, 1, 1);

        // act
        boolean validadeReal = tanque.tripulacaoValida();

        // assert
        Assert.assertFalse(validadeReal);
    }

    @Test
    public void deveRetornarFalsoQuandoLicencaTanqueInvalidaETripulacaoValida() {
        PilotoTanque pilotoTanque = new PilotoTanqueImpl(1000, LocalDate.now());
        List<Militar> tripulacao = new ArrayList<>();
        for (int i = 3; i > 0; i--) tripulacao.add(new Militar(1000));

        Tanque tanque = new Tanque(pilotoTanque, tripulacao, 1, 1);

        // act
        boolean validadeReal = tanque.tripulacaoValida();

        // assert
        Assert.assertFalse(validadeReal);
    }
}
