package militares;

import java.time.LocalDate;

public class PilotoAviaoImpl extends Militar implements PilotoAviao {

    private LocalDate validadeLicencaAviao;

    public PilotoAviaoImpl(double salario, LocalDate validadeLicencaAviao) {
        super(salario);
        this.validadeLicencaAviao = validadeLicencaAviao;
    }

    @Override
    public LocalDate getValidadeLicencaAviao() {
        return this.validadeLicencaAviao;
    }
}
