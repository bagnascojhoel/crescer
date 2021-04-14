package militares;

import java.time.LocalDate;

public class PilotoHelicopteroImpl extends Militar implements PilotoHelicoptero {

    private LocalDate validadeLicencaHelicoptero;

    public PilotoHelicopteroImpl(double salario, LocalDate validadeLicencaHelicoptero) {
        super(salario);
        this.validadeLicencaHelicoptero = validadeLicencaHelicoptero;
    }

    @Override
    public LocalDate getValidadeLicencaHelicoptero() {
        return this.validadeLicencaHelicoptero;
    }
}
