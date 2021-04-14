package br.com.cwi.crescer.melevaai.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StartRideResponse {

    private LocalDateTime expectedArrivalDateTime;

    private double expectedPrice;
}
