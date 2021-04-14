package br.com.cwi.crescer.pet.service;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.cwi.crescer.pet.controller.CondominioController;
import br.com.cwi.crescer.pet.controller.request.ConfiguracaoCondominioRequest;
import br.com.cwi.crescer.pet.controller.request.IncluirCondominioRequest;
import br.com.cwi.crescer.pet.controller.response.IncluirCondominioResponse;
import br.com.cwi.crescer.pet.domain.Condominio;
import br.com.cwi.crescer.pet.domain.Tipo;
import br.com.cwi.crescer.pet.exception.NegocioException;

@RunWith(MockitoJUnitRunner.class)
public class IncluirCondominioServiceTest {

    private IncluirCondominioService tested;

    @Before
    public void setUp() {
        tested = new IncluirCondominioService();
    }

    @Test
    public void deveIncluirComSucesso() {

        // Cenário - Arrange
        IncluirCondominioRequest request = new IncluirCondominioRequest();
        request.setNome("Condomínio 1");

        ConfiguracaoCondominioRequest config = new ConfiguracaoCondominioRequest();
        config.setAceitaPet(true);
        config.setTiposPet(Arrays.asList(Tipo.GATO));

        request.setConfig(config);


        // Ação - Act
        IncluirCondominioResponse result = tested.incluir(request);


        // Verificação - Assert
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.getIdentificador());
    }

    @Test(expected = NegocioException.class)
    public void deveLancarExcecaoQuandoCondominioDuplicado() {

        // Cenário - Arrange
        Condominio condominioA = new Condominio();
        condominioA.setNome("Condominio A");

        CondominioController.LISTA.add(condominioA);

        IncluirCondominioRequest request = new IncluirCondominioRequest();
        request.setNome("Condominio A");

        ConfiguracaoCondominioRequest config = new ConfiguracaoCondominioRequest();
        request.setConfig(config);

        // Ação - Act
        try {

            tested.incluir(request);

        } catch (NegocioException exception) {
            Assert.assertEquals("Já existe um condomínio com este nome", exception.getMensagem());
            throw exception;
        }
    }
}