package br.com.cwi.crescer.pet2.service;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.cwi.crescer.pet2.domain.Condominio;
import br.com.cwi.crescer.pet2.exception.NegocioException;
import br.com.cwi.crescer.pet2.mapper.IncluirCondominioRequestMapper;
import br.com.cwi.crescer.pet2.mapper.IncluirCondominioResponseMapper;
import br.com.cwi.crescer.pet2.repository.CondominioRepository;
import br.com.cwi.crescer.pet2.validator.IncluirCondominioValidator;
import br.com.cwi.crescer.pet2.controller.request.ConfiguracaoCondominioRequest;
import br.com.cwi.crescer.pet2.controller.request.IncluirCondominioRequest;
import br.com.cwi.crescer.pet2.controller.response.IncluirCondominioResponse;
import br.com.cwi.crescer.pet2.domain.Tipo;

@RunWith(MockitoJUnitRunner.class)
public class IncluirCondominioServiceTest {

    @InjectMocks
    private IncluirCondominioService tested;

    @Mock
    private IncluirCondominioValidator incluirCondominioValidator;

    @Mock
    private ValidarCondominioDuplicadoService validarCondominioDuplicadoService;

    @Mock
    private IncluirCondominioRequestMapper requestMapper;

    @Mock
    private IncluirCondominioResponseMapper responseMapper;

    @Mock
    private CondominioRepository condominioRepository;

    @Test
    public void deveIncluirComSucesso() {

        // Cenário - Arrange
        IncluirCondominioRequest request = new IncluirCondominioRequest();
        request.setNome("Condomínio 1");

        // request
        ConfiguracaoCondominioRequest config = new ConfiguracaoCondominioRequest();
        config.setAceitaPet(true);
        config.setTiposPet(Arrays.asList(Tipo.GATO));

        request.setConfig(config);

        // dominio
        Condominio condominio = new Condominio();

        // response
        IncluirCondominioResponse response = new IncluirCondominioResponse();
        response.setIdentificador(1);

        Mockito.when(requestMapper.apply(request)).thenReturn(condominio);
        Mockito.when(responseMapper.apply(condominio)).thenReturn(response);

        // Ação - Act
        IncluirCondominioResponse result = tested.incluir(request);


        // Verificação - Assert
        Mockito.verify(incluirCondominioValidator).accept(request);
        Mockito.verify(validarCondominioDuplicadoService).accept(request);
        Mockito.verify(requestMapper).apply(request);
        Mockito.verify(condominioRepository).save(condominio);
        Mockito.verify(responseMapper).apply(condominio);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.getIdentificador());
    }

    // Não é necessário ter este teste, pois o comportamento de validar
    // um condomínio duplicado é responsabilidade da service validaCondominioDuplicadoService
    // e lá que deve ter o teste.
    // Este teste existe apenas para demonstrar como fazer para um mock
    // lançar exception
    @Test(expected = NegocioException.class)
    public void deveLancarExcecaoQuandoCondominioDuplicado() {

        // Cenário - Arrange
        IncluirCondominioRequest request = new IncluirCondominioRequest();

        // método com retorno
//        Mockito
//            .when(validarCondominioDuplicadoService).accept(request)
//            .thenThrow(new NegocioException(""));

        // quando um método não tem retorno e precisa lançar o erro
        Mockito
            .doThrow(new NegocioException(""))
            .when(validarCondominioDuplicadoService).accept(request);

        try {

            // Ação - Act

            tested.incluir(request);

        } catch (NegocioException exception) {

            // Verificação - Assert
            Mockito.verify(incluirCondominioValidator).accept(request);
            Mockito.verify(validarCondominioDuplicadoService).accept(request);

            Mockito.verifyNoInteractions(requestMapper, condominioRepository, responseMapper);

            throw exception;
        }
    }
}