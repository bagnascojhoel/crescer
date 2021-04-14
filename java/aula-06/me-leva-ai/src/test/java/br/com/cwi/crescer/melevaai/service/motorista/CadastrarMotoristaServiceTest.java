package br.com.cwi.crescer.melevaai.service.motorista;

import br.com.cwi.crescer.melevaai.controller.request.CadastrarMotoristaRequest;
import br.com.cwi.crescer.melevaai.controller.response.MotoristaResponse;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.mapper.MotoristaMapper;
import br.com.cwi.crescer.melevaai.mapper.MotoristaResponseMapper;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;
import br.com.cwi.crescer.melevaai.service.ValidarIdadeMinimaService;
import br.com.cwi.crescer.melevaai.validator.MotoristaRequestValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarMotoristaServiceTest {

    @Mock
    MotoristaResponse motoristaResponse;

    @InjectMocks
    CadastrarMotoristaService cadastrarMotoristaService;

    @Mock
    CadastrarMotoristaRequest cadastrarMotoristaRequest;

    @Mock
    ValidarIdadeMinimaService validarIdadeMinimaService;

    @Mock
    Motorista motorista;

    @Mock
    MotoristaRequestValidator validator;

    @Mock
    MotoristMapper motoristaMapper;

    @Mock
    ValidarCnhService validarCnhService;

    @Mock
    MotoristaRepository motoristaRepository;

    @Mock
    MotoristaResponseMapper motoristaResponseMapper;

    @Before
    public void setUp(){
        motorista.setDataNascimento(LocalDate.parse("1991-02-02"));
    }

    @Test
    public void cadastrarMotorista(){

        Mockito.when(motoristaMapper.converter(cadastrarMotoristaRequest)).thenReturn(motorista);

        Mockito.when(motoristaResponseMapper.apply(motorista)).thenReturn(motoristaResponse);

        Mockito.when(cadastrarMotoristaService.cadastrar(cadastrarMotoristaRequest))
                .thenReturn(motoristaResponse);

    }

}
