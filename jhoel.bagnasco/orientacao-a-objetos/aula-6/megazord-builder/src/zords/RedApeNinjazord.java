package zords;

import megazord.battlemode.parts.PernaDireita;
import megazord.battlemode.parts.PernaEsquerda;

public class RedApeNinjazord extends Zord implements PernaEsquerda, PernaDireita {

    private static final int COMPRIMENTO = 20;
    private static final int ALTURA = 31;
    private static final int PESO = 1300;
    private static final int VELOCIDADE = 60;

    public RedApeNinjazord() {
        super(COMPRIMENTO, ALTURA, PESO, VELOCIDADE);
    }
}
