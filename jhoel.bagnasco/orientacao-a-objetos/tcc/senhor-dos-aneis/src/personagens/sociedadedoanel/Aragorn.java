package personagens.sociedadedoanel;

import classes.Guerreiro;
import racas.Humano;

public class Aragorn extends Guerreiro implements Humano, MembroSociedadeDoAnel {

    private static final int FORCA = 10;

    private static final int AGILIDADE = 7;

    private static final int INTELIGENCIA = 6;

    private static final int CONSTITUICAO_INICIAL = 60;

    private static final int DANO_POR_ENVELHECIMENTO = 1;

    private static final String FALA = "A day may come when the courage of men fails… but it is not THIS day.";

    private static final String INDICADOR = "A";

    public Aragorn() {
        super(INDICADOR, FORCA, AGILIDADE, INTELIGENCIA, CONSTITUICAO_INICIAL);
    }

    @Override
    public String falar() {
        return FALA;
    }

    public void envelhecer() {
        receberDano(DANO_POR_ENVELHECIMENTO);
    }

}
