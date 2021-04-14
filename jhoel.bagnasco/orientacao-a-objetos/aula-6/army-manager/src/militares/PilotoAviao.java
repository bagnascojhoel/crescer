package militares;

import java.time.LocalDate;

public interface PilotoAviao extends Piloto {
    LocalDate getValidadeLicencaAviao();
}
