package br.com.cwi.crescer.melevaai.fixture;

import br.com.cwi.crescer.melevaai.domain.Passenger;

import java.time.LocalDate;

public class PassengerFixture {

    private Passenger passenger = new Passenger();

    public static PassengerFixture builder() {
        return new PassengerFixture();
    }

    public Passenger build() {
        return this.passenger;
    }

    public PassengerFixture withCpf(String cpf) {
        this.passenger.setCpf(cpf);
        return this;
    }

    public PassengerFixture withBirthDate(LocalDate birthDate) {
        this.passenger.setBirthDate(birthDate);
        return this;
    }

}
