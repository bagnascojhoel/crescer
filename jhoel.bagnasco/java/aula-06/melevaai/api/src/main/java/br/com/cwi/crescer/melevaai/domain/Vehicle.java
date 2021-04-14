package br.com.cwi.crescer.melevaai.domain;

import br.com.cwi.crescer.melevaai.exception.BusynessLogicException;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "placa")
public class Vehicle {

    private Plate plate;

    private Brand brand;

    private String model;

    private int year;

    private Color color;

    private URL photo;

    private Category category;

    private int qtySeats;

    private Driver owner;

    @JsonCreator
    public Vehicle(Plate plate, Brand brand, String model, int year, Color color, URL photo, Category category, int qtySeats, Driver owner) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.photo = photo;
        this.category = category;
        this.qtySeats = qtySeats;
        this.owner = owner;

        isValidDriver();
        isCompatibleCnh();
        isNotExpiredCnh();
    }

    private void isValidDriver() {
        if (owner == null)
            throw new BusynessLogicException("Proprietário do veículo obrigatório");
    }

    private void isCompatibleCnh() {
        if (!owner.getCnh().getCategory().equals(category))
            throw new BusynessLogicException("A carteira de habilitação nacional do proprietário não é compatível com a categoria do veículo.");
    }

    private void isNotExpiredCnh() {
        if (owner.getCnh().getDueDate().isBefore(LocalDate.now()))
            throw new BusynessLogicException("Um motorista não pode dirigir com a carteira de habilitação vencida.");
    }

    public void setOwner(Driver owner) {
        this.owner = owner;
    }
}
