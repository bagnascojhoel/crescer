package br.com.cwi.crescer.melevaai.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "driver")
public class Driver extends Person {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cnh_id")
    private CNH cnh;

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
        super.setAvgScore((int) Math.round(accNota/count));
    }
}
