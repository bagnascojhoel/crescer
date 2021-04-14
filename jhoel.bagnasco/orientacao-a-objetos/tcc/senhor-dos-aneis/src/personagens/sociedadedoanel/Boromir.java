package personagens.sociedadedoanel;

import classes.Guerreiro;
import racas.Humano;

public class Boromir extends Guerreiro implements Humano, MembroSociedadeDoAnel {

    private static final int FORCA = 7;

    private static final int AGILIDADE = 6;

    private static final int INTELIGENCIA = 3;

    private static final int CONSTITUICAO_INICIAL = 40;

    private static final String FALA = "One does not simply walk into Mordor.";

    private static final String INDICADOR = "B";

    private static final int DANO_POR_ENVELHECIMENTO = 2;

    public Boromir() {
        super(INDICADOR, FORCA, AGILIDADE, INTELIGENCIA, CONSTITUICAO_INICIAL);
    }

    @Override
    public String falar() {
        return FALA;
    }

    @Override
    public void envelhecer() {
        this.receberDano(DANO_POR_ENVELHECIMENTO);
    }

}
