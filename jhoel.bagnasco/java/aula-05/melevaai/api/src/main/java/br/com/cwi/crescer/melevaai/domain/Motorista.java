package br.com.cwi.crescer.melevaai.domain;

import br.com.cwi.crescer.melevaai.controller.CorridaController;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Motorista extends Pessoa {


    private CNH cnh;

    public Motorista(String nome, String email, LocalDate dataNascimento, CPF cpf, BigDecimal carteiraVirtual, double notaMedia, CNH cnh) {
        super(nome, email, dataNascimento, cpf, carteiraVirtual, notaMedia);
        this.cnh = cnh;
    }

    public BigDecimal receber(BigDecimal valor){
        super.creditar(valor);
        return super.getCarteiraVirtual();
    }

    public BigDecimal sacar(BigDecimal valor) {
        super.debitar(valor);
        return super.getCarteiraVirtual();
    }

    public void calcularMedia() {
        double accNota = 0;
        int count = 0;
        for(Corrida corrida : CorridaController.corridaList){
            if(corrida.getVeiculo().getProprietario().getCpf().equals(super.getCpf())
                    && corrida.getStatus() == CorridaStatus.FINALIZADA
                    && corrida.getNotaParaMotorista() != 0){
                accNota += corrida.getNotaParaMotorista();
                count++;
            }
        }
        super.setNotaMedia(accNota/count);
    }
}
