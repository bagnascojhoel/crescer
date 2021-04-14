package br.com.cwi.crescer.melevaai.domain;

import br.com.cwi.crescer.melevaai.controller.CorridaController;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Passageiro extends Pessoa {


    public Passageiro(String nome, String email, LocalDate dataNascimento, CPF cpf, BigDecimal carteiraVirtual, double nota) {
        super(nome, email, dataNascimento, cpf, carteiraVirtual, nota);
    }


    public BigDecimal transferir(BigDecimal valor) {
        super.debitar(valor);
        return super.getCarteiraVirtual();
    }

    public BigDecimal depositar(BigDecimal valor){
        super.creditar(valor);
        return super.getCarteiraVirtual();
    }

    public void calcularMedia() {
        double accNota = 0;
        int count = 0;
        for(Corrida corrida : CorridaController.corridaList){
            if(corrida.getPassageiro().getCpf().equals(super.getCpf())
                    && corrida.getStatus() == CorridaStatus.FINALIZADA
                    && corrida.getNotaParaPassageiro() != 0){
                accNota += corrida.getNotaParaPassageiro();
                count++;
            }
        }
        super.setNotaMedia(accNota/count);
    }
}
