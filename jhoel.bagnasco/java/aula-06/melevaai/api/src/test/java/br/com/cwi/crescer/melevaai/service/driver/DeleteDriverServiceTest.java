package br.com.cwi.crescer.melevaai.service.driver;

import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.repository.DriverRepository;
import br.com.cwi.crescer.melevaai.repository.VehicleRepository;
import br.com.cwi.crescer.melevaai.validators.driver.DriverLinkedToVehicleValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class DeleteDriverServiceTest {

    @InjectMocks
    private DeleteDriverService subject;

    @Mock
    private DriverRepository driverRepository;

    @Mock
    private VehicleRepository vehicleRepository;

    @Mock
    private FetchDomainDriverByCpfService fetchDomainDriverByCpfService;

    @Mock
    private DriverLinkedToVehicleValidator driverLinkedToVehicleValidator;

    @Test
    public void shouldCallDriverRepositoryRemoveWhenRemove() {
        // arrange
        String cpf = "0";
        Driver driver = new Driver();
        driver.setCpf(cpf);

        Mockito.when(fetchDomainDriverByCpfService.fetch(cpf))
                .thenReturn(driver);

        Vehicle vehicle = new Vehicle();
        vehicle.setOwner(driver);

        Mockito.when(vehicleRepository.findByOwnerCpf(cpf))
                .thenReturn(Optional.of(vehicle));
        // act
        subject.delete(cpf);

        // assert
        Mockito.verify(fetchDomainDriverByCpfService).fetch(cpf);
        Mockito.verify(vehicleRepository).findByOwnerCpf(cpf);
        Mockito.verify(driverLinkedToVehicleValidator).validate(Optional.of(vehicle));
        Mockito.verify(driverRepository).remove(driver);
    }

}