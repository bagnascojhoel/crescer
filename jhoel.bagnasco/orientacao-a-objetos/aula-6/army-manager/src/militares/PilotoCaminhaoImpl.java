package militares;

import java.time.LocalDate;

public class PilotoCaminhaoImpl extends Militar implements PilotoCaminhao {

    private LocalDate validadeLicencaCaminhao;

    public PilotoCaminhaoImpl(double salario, LocalDate validadeLicencaCaminhao) {
        super(salario);
        this.validadeLicencaCaminhao = validadeLicencaCaminhao;
    }

    @Override
    public LocalDate getValidadeLicencaCaminhao() {
        return this.validadeLicencaCaminhao;
    }
}
