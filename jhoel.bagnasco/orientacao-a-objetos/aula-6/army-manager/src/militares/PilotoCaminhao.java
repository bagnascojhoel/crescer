package militares;

import java.time.LocalDate;

public interface PilotoCaminhao extends Piloto {
    LocalDate getValidadeLicencaCaminhao();
}
