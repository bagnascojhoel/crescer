package br.com.cwi.crescer.melevaai.service.motorista;

import br.com.cwi.crescer.melevaai.controller.request.CadastrarMotoristaRequest;
import br.com.cwi.crescer.melevaai.controller.response.MotoristaResponse;
import br.com.cwi.crescer.melevaai.mapper.MotoristaMapper;
import br.com.cwi.crescer.melevaai.service.ValidarIdadeMinimaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.melevaai.mapper.MotoristaResponseMapper;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;
import br.com.cwi.crescer.melevaai.validator.MotoristaRequestValidator;

@Service
public class CadastrarMotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private ValidarCnhService validarCnhService;

    @Autowired
    private MotoristaRequestValidator validator;

    @Autowired
    private MotoristaMapper motoristaMapper;

    @Autowired
    private ValidarIdadeMinimaService validarIdadeMinimaService;

    @Autowired
    private MotoristaResponseMapper motoristaResponseMapper;

    public MotoristaResponse cadastrar(CadastrarMotoristaRequest cadastrarMotoristaRequest) {

        validator.accept(cadastrarMotoristaRequest);
        Motorista motorista =  motoristaMapper.converter(cadastrarMotoristaRequest);

        validarIdadeMinimaService.validar(Motorista.IDADE_MINIMA, motorista.getIdade());

        validarCnhService.validar(cadastrarMotoristaRequest.getCnh());

        if (motoristaRepository.exists(motorista)) {
            throw new ValidacaoNegocioException("Erro ao cadastrar motorista. Motorista já cadastrado.");
        }

        motoristaRepository.save(motorista);
        MotoristaResponse motoristaResponse = motoristaResponseMapper.apply(motorista);
        motoristaResponse.setNome("adsfasdf");

        return motoristaResponseMapper.apply(motorista);
    }

}
