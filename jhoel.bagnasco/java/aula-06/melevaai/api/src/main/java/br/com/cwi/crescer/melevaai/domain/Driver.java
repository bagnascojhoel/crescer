package br.com.cwi.crescer.melevaai.domain;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Driver extends Person {


    private CNH cnh;

    public Driver(String nome, String email, LocalDate dataNascimento, String cpf, BigDecimal carteiraVirtual, double notaMedia, CNH cnh) {
        super(nome, email, dataNascimento, cpf, carteiraVirtual, notaMedia);
        this.cnh = cnh;
    }

    public BigDecimal receive(BigDecimal amount){
        super.credit(amount);
        return super.getVirtualWallet();
    }

    public BigDecimal withdraw(BigDecimal amount) {
        super.debit(amount);
        return super.getVirtualWallet();
    }

    public void measureAvgScore(List<Ride> rideList) {
        double accNota = 0;
        int count = 0;
        for(Ride ride : rideList){
            if(ride.getVehicle().getOwner().getCpf().equals(super.getCpf())
                    && ride.getStatus() == RideStatus.FINALIZADA
                    && ride.getDriverScore() != 0){
                accNota += ride.getDriverScore();
                count++;
            }
        }
        super.setAvgScore(accNota/count);
    }
}
