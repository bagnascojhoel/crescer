package br.com.cwi.crescer.heranca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.heranca.domain.Motorista;
import br.com.cwi.crescer.heranca.repository.MotoristaRepository;

@Service
public class BuscarTodosMotoristasPaginadoService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public List<Motorista> listar(int pagina, int quantidade) {

        final Pageable pageable = PageRequest.of(pagina, quantidade);

        return motoristaRepository.findAll(pageable).toList();
    }
}
