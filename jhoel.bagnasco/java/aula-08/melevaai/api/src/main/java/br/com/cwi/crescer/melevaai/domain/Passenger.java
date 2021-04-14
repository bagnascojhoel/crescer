package br.com.cwi.crescer.melevaai.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "passenger")
public class Passenger extends Person {

    public BigDecimal transfer(BigDecimal valor) {
        super.debit(valor);
        return super.getVirtualWallet();
    }

    public BigDecimal deposit(BigDecimal valor){
        super.credit(valor);
        return super.getVirtualWallet();
    }

    public void measureAvgScore(List<Ride> rideList)  {
        double accNota = 0;
        int count = 0;
        for(Ride ride : rideList){
            if(ride.getPassenger().getCpf().equals(super.getCpf())
                    && ride.getStatus() == RideStatus.FINALIZADA
                    && ride.getPassengerScore() != 0){
                accNota += ride.getPassengerScore();
                count++;
            }
        }
        super.setAvgScore((int) Math.round(accNota/count));
    }
}
