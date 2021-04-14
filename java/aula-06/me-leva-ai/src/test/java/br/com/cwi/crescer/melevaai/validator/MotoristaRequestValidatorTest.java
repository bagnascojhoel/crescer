package br.com.cwi.crescer.melevaai.validator;

import br.com.cwi.crescer.melevaai.controller.request.CadastrarMotoristaRequest;
import br.com.cwi.crescer.melevaai.domain.CarteiraNacionalHabilitacao;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MotoristaRequestValidatorTest {

    @Mock
    CpfValidator cpfValidator;

    @InjectMocks
    MotoristaRequestValidator motoristaRequestValidator;

    CadastrarMotoristaRequest cadastrarMotoristaRequest;

    @Before
    public void setUp(){
        cadastrarMotoristaRequest = CadastrarMotoristaRequest
                .builder()
                .cnh(new CarteiraNacionalHabilitacao())
                .build();
    }


    @Test(expected = ValidacaoNegocioException.class)
    public void accept(){
        motoristaRequestValidator.accept(cadastrarMotoristaRequest);
    }


}
