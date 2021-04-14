package personagens.sociedadedoanel;

import classes.Guerreiro;
import racas.Anao;


public class Gimli extends Guerreiro implements Anao, MembroSociedadeDoAnel {

    private static final int FORCA = 9;

    private static final int AGILIDADE = 2;

    private static final int INTELIGENCIA = 4;

    private static final int CONSTITUICAO_INICIAL = 60;

    private static final int SOBRIEDADE_INICIAL = 3;

    private static final String FALA_ENQUANTO_SOBRIO = "Let them come. There is one Dwarf yet in Moria who still draws breath.";

    private static final String FALA_ENQUANTO_BEBADO = "What did I say? He can't hold his liquor!";

    private static final String INDICADOR = "I";

    private int sobriedade;

    public Gimli() {
        super(INDICADOR, FORCA, AGILIDADE, INTELIGENCIA, CONSTITUICAO_INICIAL);
        this.sobriedade = SOBRIEDADE_INICIAL;
    }

    @Override
    public String falar() {
        if (sobriedade > 0)
            return FALA_ENQUANTO_SOBRIO;
        else
            return FALA_ENQUANTO_BEBADO;
    }

    @Override
    public void beber() {
        sobriedade--;
    }

    public int getSobriedade() {
        return sobriedade;
    }

}
