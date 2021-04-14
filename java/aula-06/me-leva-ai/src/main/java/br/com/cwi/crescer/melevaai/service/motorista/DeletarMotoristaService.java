package br.com.cwi.crescer.melevaai.service.motorista;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.domain.Veiculo;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;
import br.com.cwi.crescer.melevaai.repository.VeiculoRepository;
import br.com.cwi.crescer.melevaai.validator.CpfValidator;

@Service
public class DeletarMotoristaService {

    @Autowired
    private CpfValidator cpfValidator;

    @Autowired
    private BuscarMotoristaPorCpfService buscarMotoristaPorCpfService;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;

    public void deletar(String cpf) {

        cpfValidator.accept(cpf);

        Motorista motorista = buscarMotoristaPorCpfService.buscar(cpf);

        verificarSeMotoristaPossuiVeiculo(motorista);

        motoristaRepository.delete(motorista);
    }

    private void verificarSeMotoristaPossuiVeiculo(Motorista motorista) {

        final Optional<Veiculo> veiculo = veiculoRepository.findByMotorista(motorista);

        if (veiculo.isPresent()) {
            throw new ValidacaoNegocioException("Erro ao deletar motorista. Motorista possui veículo cadastrado.");
        }
    }
}
