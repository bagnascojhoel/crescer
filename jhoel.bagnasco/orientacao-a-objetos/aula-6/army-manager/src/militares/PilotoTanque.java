package militares;

import java.time.LocalDate;

public interface PilotoTanque extends Piloto {
    LocalDate getValidadeLicencaTanque();
}
