package personagens.sociedadedoanel;

import classes.Arqueiro;
import racas.Elfo;

public class Legolas extends Arqueiro implements Elfo, MembroSociedadeDoAnel {

    private static final int FORCA = 5;

    private static final int AGILIDADE = 10;

    private static final int INTELIGENCIA = 6;

    private static final int CONSTITUICAO_INICIAL = 80;

    private static final String FALA = "They're taking the Hobbits to Isengard!";

    private static final String INDICADOR = "L";

    private static final String FALA_ELFICA = "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";

    public Legolas() {
        super(INDICADOR, FORCA, AGILIDADE, INTELIGENCIA, CONSTITUICAO_INICIAL);
    }

    @Override
    public String falar() {
        return FALA;
    }

    @Override
    public String falarElfico() {
        return FALA_ELFICA;
    }

}
