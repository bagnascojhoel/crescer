package br.com.cwi.crescer.melevaai.controller;

import br.com.cwi.crescer.melevaai.controller.request.PassageiroRequest;
import br.com.cwi.crescer.melevaai.controller.response.PassageiroResponse;
import br.com.cwi.crescer.melevaai.domain.Passageiro;
import br.com.cwi.crescer.melevaai.service.passenger.AddPassengerService;
import br.com.cwi.crescer.melevaai.service.passenger.DepositMoneyPassengerService;
import br.com.cwi.crescer.melevaai.service.passenger.FetchPassengerByCpfService;
import br.com.cwi.crescer.melevaai.service.passenger.ListPassengersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("passageiros")
public class PassageiroController {

    @Autowired
    AddPassengerService addPassengerService;

    @Autowired
    ListPassengersService listPassengersService;

    @Autowired
    DepositMoneyPassengerService depositMoneyPassengerService;

    @Autowired
    FetchPassengerByCpfService fetchPassengerByCpfService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PassageiroResponse addPassenger(@RequestBody @Valid PassageiroRequest request) {
        return addPassengerService.add(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Passageiro> listPassengers() {
        return listPassengersService.list();
    }

    @PutMapping("{cpf}/conta-virtual")
    @ResponseStatus(HttpStatus.OK)
    public void adicionarCredito(@PathVariable String cpf, @RequestParam(name = "valor") String amount) {
        depositMoneyPassengerService.deposit(cpf, amount);
    }

    @GetMapping("{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public PassageiroResponse mostrarPassageiro(@PathVariable String cpf) {
        return fetchPassengerByCpfService.fetch(cpf);
    }


}
