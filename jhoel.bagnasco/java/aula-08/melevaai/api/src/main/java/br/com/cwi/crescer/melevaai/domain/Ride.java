package br.com.cwi.crescer.melevaai.domain;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(of = "identificador")
public class Ride {

    private static final int MIN_ARRIVAL_TIME = 5;

    private static final int MAX_ARRIVAL_TIME = 10;

    private static final int AVG_SPEED = 30;

    private static final int ONE_HOUR_IN_SECONDS = 3600;

    public static final double PRICE_PER_SECOND = 0.2;

    private Long id;

    private Passenger passenger;

    private Vehicle vehicle;

    private Point startPoint;

    private Point finishPoint;

    private double arrivalTime;

    private LocalDateTime startDateTime;

    private LocalDateTime finishDateTime;

    private BigDecimal realPrice;

    private double expectedTime;

    private double expectedPrice;

    private RideStatus status;

    private int driverScore;

    private int passengerScore;

    public void measureExpectedPrice(){
        double distancia = startPoint.measureDistance(finishPoint);
        double tempoHoras = distancia/ AVG_SPEED;
        double tempoSegundos = tempoHoras* ONE_HOUR_IN_SECONDS;
        double valorEstimado = tempoSegundos* PRICE_PER_SECOND;

        setExpectedTime(tempoSegundos);
        setExpectedPrice(valorEstimado);
    }

    public void makeTransactions(List<Driver> driverList){

        this.getPassenger().transfer(this.getRealPrice());

        for (Driver driver : driverList) {
            if (driver.equals(this.getVehicle().getOwner()))
                driver.receive(this.getRealPrice());
        }
    }

    public static long getRandomExpectedArrivalTime() {
        return Math.round(Math.random() * (MAX_ARRIVAL_TIME - MIN_ARRIVAL_TIME) + MIN_ARRIVAL_TIME);
    }
}
