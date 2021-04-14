package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.controller.request.VeiculoRequest;
import br.com.cwi.crescer.melevaai.controller.response.VeiculoResponse;
import br.com.cwi.crescer.melevaai.domain.*;
import br.com.cwi.crescer.melevaai.exception.RegistroNaoEncontratoException;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.melevaai.service.vehicle.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("veiculos")
public class VeiculoController {

    @Autowired
    AddVehicleService addVehicleService;

    @Autowired
    ListVehiclesService listVehiclesService;

    @Autowired
    ListAvailableVehiclesService listAvailableVehiclesService;

    @Autowired
    ListVehicleCategoriesService listVehicleCategoriesService;

    @Autowired
    ListVehicleColorsService listVehicleColorsService;

    @Autowired
    ListVehicleBrandsService listVehicleBrandsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoResponse addVehicle(@RequestBody @Valid VeiculoRequest veiculoRequest) {
       return addVehicleService.add(veiculoRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Veiculo> listVehicles() {
        return listVehiclesService.list();
    }

    @GetMapping("veiculos-disponiveis")
    @ResponseStatus(HttpStatus.OK)
    public List<Veiculo> listAvailableVehicles() {
        return listAvailableVehiclesService.list();
    }

    @GetMapping("categorias")
    @ResponseStatus(HttpStatus.OK)
    public List<Categoria> listCategories() {
        return listVehicleCategoriesService.list();
    }

    @GetMapping("cores")
    @ResponseStatus(HttpStatus.OK)
    public List<Cor> listColors() {
        return listVehicleColorsService.list();
    }

    @GetMapping("marcas")
    @ResponseStatus(HttpStatus.OK)
    public List<Marca> listBrands() {
        return listVehicleBrandsService.list();
    }


}
