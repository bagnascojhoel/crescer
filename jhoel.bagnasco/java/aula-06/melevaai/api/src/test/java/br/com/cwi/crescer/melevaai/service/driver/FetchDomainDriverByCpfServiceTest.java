package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.repository.DriverRepository;
import br.com.cwi.crescer.melevaai.validators.driver.DriverDoesNotExistValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class FetchDomainDriverByCpfServiceTest {

    @InjectMocks
    FetchDomainDriverByCpfService subject;

    @Mock
    DriverRepository driverRepository;

    @Mock
    DriverDoesNotExistValidator driverDoesNotExistValidator;

    @Test
    public void shouldBeDriverWithSameCpfWhenFetch() {
        // arrange
        String cpf = "0";
        Driver driver = new Driver();
        driver.setCpf(cpf);

        Mockito.when(driverRepository.findByCpf(cpf)).thenReturn(Optional.of(driver));

        // act
        Driver actual = subject.fetch(cpf);

        // assert
        Mockito.verify(driverRepository).findByCpf(cpf);
        Mockito.verify(driverDoesNotExistValidator).validate(Optional.of(driver));

        Assert.assertEquals(driver, actual);
    }
}