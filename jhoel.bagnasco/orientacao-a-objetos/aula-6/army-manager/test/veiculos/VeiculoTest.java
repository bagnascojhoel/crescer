package veiculos;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class VeiculoTest {


    @Test
    public void deveRetornarVerdadeiroQuandoValidadeDaLicencaDepoisDeHoje() {
        LocalDate licenca = LocalDate.now().plusDays(1);

        boolean validadeRetornada = Veiculo.licencaValida(licenca);

        Assert.assertTrue(validadeRetornada);
    }

    @Test
    public void deveRetornarFalsoQuandoValidadeDaLicencaIgualHoje() {
        LocalDate licenca = LocalDate.now();

        boolean validadeRetornada = Veiculo.licencaValida(licenca);

        Assert.assertFalse(validadeRetornada);
    }

    @Test
    public void deveRetornarFalsoQuandoValidadeDaLicencaAntesHoje() {
        LocalDate licenca = LocalDate.now().minusDays(1);

        boolean validadeRetornada = Veiculo.licencaValida(licenca);

        Assert.assertFalse(validadeRetornada);
    }
}
