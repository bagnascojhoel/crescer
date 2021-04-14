package personagens.exercitodesauron;

import classes.Guerreiro;
import racas.Humano;
import racas.Monstro;

public class Urukhai extends Guerreiro implements Monstro, Humano {

    private static final int FORCA = 8;

    private static final int AGILIDADE = 6;

    private static final int INTELIGENCIA = 3;

    private static final int CONSTITUICAO_INICIAL = 45;

    private static final String GRUNHIDO = "Uuurrrrrr";

    private static final String FALA = "Looks like meat's back on the menu boys!";

    private static final int DANO_POR_ENVELHECIMENTO = 2;

    private static final String INDICADOR = "U";

    public Urukhai() {
        super(INDICADOR, FORCA, AGILIDADE, INTELIGENCIA, CONSTITUICAO_INICIAL);
    }

    @Override
    public String grunir() {
        return GRUNHIDO;
    }

    @Override
    public String falar() {
        return FALA;
    }

    @Override
    public void envelhecer() {
        this.receberDano(DANO_POR_ENVELHECIMENTO);
    }

    @Override
    public boolean pertenceASociedadeDoAnel() {
        return false;
    }
}
