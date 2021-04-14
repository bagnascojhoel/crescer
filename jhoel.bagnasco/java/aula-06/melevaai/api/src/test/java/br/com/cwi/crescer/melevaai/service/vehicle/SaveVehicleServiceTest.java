package br.com.cwi.crescer.melevaai.service.vehicle;

import br.com.cwi.crescer.melevaai.controller.request.VehicleRequest;
import br.com.cwi.crescer.melevaai.controller.response.VehicleResponse;
import br.com.cwi.crescer.melevaai.domain.Category;
import br.com.cwi.crescer.melevaai.domain.Driver;
import br.com.cwi.crescer.melevaai.domain.Vehicle;
import br.com.cwi.crescer.melevaai.mapper.vehicle.FromVehicleRequestMapper;
import br.com.cwi.crescer.melevaai.mapper.vehicle.ToVehicleResponseMapper;
import br.com.cwi.crescer.melevaai.repository.VehicleRepository;
import br.com.cwi.crescer.melevaai.service.driver.FetchDomainDriverByCpfService;
import br.com.cwi.crescer.melevaai.validators.vehicle.VehicleDriverSameCategoryValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SaveVehicleServiceTest {

    @InjectMocks
    private SaveVehicleService subject;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private FromVehicleRequestMapper fromVehicleRequestMapper;

    @Mock
    private ToVehicleResponseMapper toVehicleResponseMapper;

    @Mock
    private VehicleRepository vehicleRepository;

    @Mock
    private FetchDomainDriverByCpfService fetchDomainDriverByCpfService;

    @Mock
    private VehicleDriverSameCategoryValidator vehicleDriverSameCategoryValidator;

    @Test
    public void shouldValidateAndSaveToRepositoryWhenSave() {
        String cpf = "5234";
        Category category = Category.ACC;

        Driver driver = new Driver();
        driver.setCpf(cpf);

        VehicleRequest vehicleRequest = new VehicleRequest();
        vehicleRequest.setCategory(category);
        vehicleRequest.setOwnerCpf(cpf);

        Vehicle vehicle = new Vehicle();

        Mockito.when(fetchDomainDriverByCpfService.fetch(cpf))
                .thenReturn(driver);
        Mockito.when(fromVehicleRequestMapper.map(vehicleRequest, driver))
                .thenReturn(vehicle);
        Mockito.when(toVehicleResponseMapper.map(vehicle))
                .thenReturn(Mockito.mock(VehicleResponse.class));

        subject.save(vehicleRequest);

        Mockito.verify(fetchDomainDriverByCpfService).fetch(cpf);
        Mockito.verify(vehicleDriverSameCategoryValidator).validate(category, driver);
        Mockito.verify(fromVehicleRequestMapper).map(vehicleRequest, driver);
        Mockito.verify(vehicleRepository).add(vehicle);
        Mockito.verify(toVehicleResponseMapper).map(vehicle);
    }
}