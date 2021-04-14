package br.com.cwi.crescer.melevaai.repository;

import br.com.cwi.crescer.melevaai.domain.Motorista;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MotoristaRepository {

    public static List<Motorista> motoristas = new ArrayList<>();

    public Optional<Motorista> findByCpf(String cpf){
       return  motoristas
                .stream()
                .filter(m -> m.getCpf().getNumero().equals(cpf))
                .findFirst();
    }
}
