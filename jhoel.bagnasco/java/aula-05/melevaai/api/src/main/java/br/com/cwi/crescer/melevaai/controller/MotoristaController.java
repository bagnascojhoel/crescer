package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.controller.request.MotoristaRequest;
import br.com.cwi.crescer.melevaai.controller.response.MotoristaResponse;
import br.com.cwi.crescer.melevaai.domain.*;
import br.com.cwi.crescer.melevaai.service.driver.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("motoristas")
public class MotoristaController {

    public static List<Motorista> motoristaList = new ArrayList<>();
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired FetchDriverByCpfService fetchDriverByCpfService;

    @Autowired ListDriversService listDriversService;

    @Autowired
    AddDriverService addDriverService;

    @Autowired
    RemoveDriverService removeDriverService;

    @Autowired WithdrawMoneyDriverService withdrawMoneyDriverService;

    @GetMapping("{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public MotoristaResponse fetchDriver(@PathVariable String cpf) {
        return fetchDriverByCpfService.fetch(cpf);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Motorista> listDrivers() {
        return listDriversService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MotoristaResponse addDriver(@RequestBody @Valid MotoristaRequest request) {
        return addDriverService.add(request);
    }

    @DeleteMapping("{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeDriver(@PathVariable String cpf) {
        removeDriverService.remove(cpf);
    }

    @PutMapping("{cpf}/conta-virtual")
    @ResponseStatus(HttpStatus.OK)
    public void withdraw(@PathVariable String cpf, @RequestParam String amount) {
        withdrawMoneyDriverService.withdraw(cpf, amount);
    }
}
