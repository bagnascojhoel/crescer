package militares;

import java.time.LocalDate;

public class Elite extends Militar implements PilotoCaminhao, PilotoTanque, PilotoAviao, PilotoHelicoptero {

    private LocalDate validadeLicencaCaminhao;

    private LocalDate validadeLicencaTanque;

    private LocalDate validadeLicencaAviao;

    private LocalDate validadeLicencaHelicoptero;

    public Elite(double    salario,
                 LocalDate validadeLicencaCaminhao,
                 LocalDate validadeLicencaTanque,
                 LocalDate validadeLicencaAviao,
                 LocalDate validadeLicencaHelicoptero) {

        super(salario);
        this.validadeLicencaCaminhao = validadeLicencaCaminhao;
        this.validadeLicencaTanque = validadeLicencaTanque;
        this.validadeLicencaAviao = validadeLicencaAviao;
        this.validadeLicencaHelicoptero = validadeLicencaHelicoptero;
    }

    @Override
    public LocalDate getValidadeLicencaCaminhao() {
        return this.validadeLicencaCaminhao;
    }

    @Override
    public LocalDate getValidadeLicencaTanque() {
        return this.validadeLicencaTanque;
    }

    @Override
    public LocalDate getValidadeLicencaHelicoptero() {
        return this.validadeLicencaHelicoptero;
    }

    @Override
    public LocalDate getValidadeLicencaAviao() {
        return this.validadeLicencaAviao;
    }
}
