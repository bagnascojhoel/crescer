package br.com.cwi.crescer.heranca.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import br.com.cwi.crescer.heranca.domain.Motorista;
import br.com.cwi.crescer.heranca.repository.MotoristaRepository;

@RunWith(MockitoJUnitRunner.class)
public class BuscarTodosMotoristasPaginadoServiceTest {

    @InjectMocks
    BuscarTodosMotoristasPaginadoService tested;

    @Mock
    private MotoristaRepository motoristaRepository;

    @Test
    public void test() {

        PageRequest pageRequest = PageRequest.of(page, size);

        final Integer id = 1;

        Motorista motorista = new Motorista();

        List<Motorista> listaDeMotoristas = Arrays.asList(motorista);

        PageImpl<Motorista> retornoPaginado = new PageImpl<>(listaDeMotoristas);

        Mockito
            .when(motoristaRepository.findById(id))
            .thenReturn(retornoPaginado);

        tested.buscar(id, pagina, quantidade);

    }
}