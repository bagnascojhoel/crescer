package militares;

import java.time.LocalDate;

public class PilotoTanqueImpl extends Militar implements PilotoTanque {

    private LocalDate validadeLicencaTanque;

    public PilotoTanqueImpl(double salario, LocalDate validadeLicencaTanque) {
        super(salario);
        this.validadeLicencaTanque = validadeLicencaTanque;
    }

    @Override
    public LocalDate getValidadeLicencaTanque() {
        return this.validadeLicencaTanque;
    }
}
