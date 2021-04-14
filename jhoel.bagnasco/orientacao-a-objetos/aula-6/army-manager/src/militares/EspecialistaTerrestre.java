package militares;

import java.time.LocalDate;

public class EspecialistaTerrestre extends Militar implements PilotoCaminhao, PilotoTanque {

    private LocalDate validateLicencaCaminhao;

    private LocalDate validateLicencaTanque;

    public EspecialistaTerrestre(double salario, LocalDate validateLicencaCaminhao, LocalDate validateLicencaTanque) {
        super(salario);
        this.validateLicencaCaminhao = validateLicencaCaminhao;
        this.validateLicencaTanque = validateLicencaTanque;
    }

    @Override
    public LocalDate getValidadeLicencaCaminhao() {
        return this.validateLicencaCaminhao;
    }

    @Override
    public LocalDate getValidadeLicencaTanque() {
        return this.validateLicencaTanque;
    }
}
