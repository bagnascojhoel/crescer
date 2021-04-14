package br.com.cwi.crescer.melevaai.domain;

import br.com.cwi.crescer.melevaai.controller.CorridaController;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Passageiro extends Pessoa {

    private static final int IDADE_MINIMA = 16;

    public Passageiro(String nome, String email, LocalDate dataNascimento, CPF cpf, double carteiraVirtual, double nota) {
        super(nome, email, dataNascimento, cpf, carteiraVirtual, nota);
    }

    public void validarIdade() {
        if (!temIdadeValida())
            throw new ValidacaoNegocioException("CPF do passageiro inválido.");
    }

    private boolean temIdadeValida() {
        return super.getIdade() >= IDADE_MINIMA;
    }

    public double transferir(double valor) {
        super.debitar(valor);
        return super.getCarteiraVirtual();
    }

    public double depositar(double valor){
        super.creditar(valor);
        return super.getCarteiraVirtual();
    }

    public void calcularMedia() {
        double accNota = 0;
        int count = 0;
        for(Corrida corrida : CorridaController.corridaList){
            if(corrida.getPassageiro().getCpf().equals(super.getCpf())
                    && corrida.getStatus() == StatusCorrida.FINALIZADA
                    && corrida.getNotaParaPassageiro() != 0){
                accNota += corrida.getNotaParaPassageiro();
                count++;
            }
        }
        super.setNotaMedia(accNota/count);
    }
}
