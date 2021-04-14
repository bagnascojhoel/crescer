package br.com.cwi.crescer.melevaai.service.motorista;

import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.domain.Veiculo;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.melevaai.fixture.MotoristaFixture;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;
import br.com.cwi.crescer.melevaai.repository.VeiculoRepository;
import br.com.cwi.crescer.melevaai.validator.CpfValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class DeletarMotoristaServiceTest {

    @InjectMocks
    private DeletarMotoristaService tested;

    @Mock
    private CpfValidator cpfValidator;

    @Mock
    private BuscarMotoristaPorCpfService buscarMotoristaPorCpfService;

    @Mock
    private VeiculoRepository veiculoRepository;

    @Mock
    private MotoristaRepository motoristaRepository;

    private String cpf;
    private Motorista motorista;


    @Before
    public void setUp() {
        cpf = "00000000000";
        motorista = MotoristaFixture.builder().build();
    }

    @Test
    public void deveDeletarMotoristaComSucesso() {

        Mockito.when(buscarMotoristaPorCpfService.buscar(cpf))
            .thenReturn(motorista);

        Mockito.when(veiculoRepository.findByMotorista(motorista))
            .thenReturn(Optional.empty());

        tested.deletar(cpf);

        Mockito.verify(cpfValidator, Mockito.times(1)).accept(cpf);
        Mockito.verify(motoristaRepository, Mockito.times(1)).delete(motorista);
    }

    @Test(expected = ValidacaoNegocioException.class)
    public void deveLancarExcecaoQuandoMotoristaPossuirVeiculo() {

        Mockito.when(buscarMotoristaPorCpfService.buscar(cpf))
            .thenReturn(motorista);

        Mockito.when(veiculoRepository.findByMotorista(motorista))
            .thenReturn(Optional.of(new Veiculo()));


        try {

            tested.deletar(cpf);

        } finally {
            Mockito.verify(cpfValidator).accept(cpf);
            Mockito.verify(motoristaRepository, Mockito.never()).delete(motorista);
        }
    }
}