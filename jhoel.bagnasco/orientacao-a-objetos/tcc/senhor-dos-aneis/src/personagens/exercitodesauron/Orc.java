package personagens.exercitodesauron;

import classes.Guerreiro;
import racas.Monstro;

public class Orc extends Guerreiro implements Monstro {

    private static final int FORCA = 7;

    private static final int AGILIDADE = 4;

    private static final int INTELIGENCIA = 1;

    private static final int CONSTITUICAO_INICIAL = 30;

    private static final String GRUNHIDO = "Arrrggghhh";

    private static final String INDICADOR = "O";

    public Orc() {
        super(INDICADOR, FORCA, AGILIDADE, INTELIGENCIA, CONSTITUICAO_INICIAL);
    }

    @Override
    public String grunir() {
        return GRUNHIDO;
    }

    @Override
    public boolean pertenceASociedadeDoAnel() {
        return false;
    }
}
