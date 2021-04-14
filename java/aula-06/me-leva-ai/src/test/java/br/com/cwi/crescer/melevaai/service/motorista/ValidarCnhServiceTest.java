package br.com.cwi.crescer.melevaai.service.motorista;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.cwi.crescer.melevaai.domain.CarteiraNacionalHabilitacao;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;

@RunWith(MockitoJUnitRunner.class)
public class ValidarCnhServiceTest {

    @InjectMocks
    private ValidarCnhService tested;

    @Test
    public void deveValidarCnhComSucesso() {

        CarteiraNacionalHabilitacao cnh = new CarteiraNacionalHabilitacao();
        cnh.setDataVencimento(LocalDate.of(2030, 01, 01));

        tested.validar(cnh);
    }

    @Test(expected = ValidacaoNegocioException.class)
    public void deveLancarExcecaoQuandoCnhVencida() {

        CarteiraNacionalHabilitacao cnh = new CarteiraNacionalHabilitacao();
        cnh.setDataVencimento(LocalDate.of(2010, 01, 01));

        tested.validar(cnh);
    }
}