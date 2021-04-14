package militares;

import java.time.LocalDate;

public class EspecialistaDoAr extends Militar implements PilotoAviao, PilotoHelicoptero {

    private LocalDate validadeLicencaAviao;

    private LocalDate validadeLicencaHelicoptero;

    public EspecialistaDoAr(double salario, LocalDate validadeLicencaAviao, LocalDate validadeLicencaHelicoptero) {
        super(salario);
        this.validadeLicencaAviao = validadeLicencaAviao;
        this.validadeLicencaHelicoptero = validadeLicencaHelicoptero;
    }

    @Override
    public LocalDate getValidadeLicencaAviao() {
        return this.validadeLicencaAviao;
    }

    @Override
    public LocalDate getValidadeLicencaHelicoptero() {
        return this.validadeLicencaHelicoptero;
    }
}
