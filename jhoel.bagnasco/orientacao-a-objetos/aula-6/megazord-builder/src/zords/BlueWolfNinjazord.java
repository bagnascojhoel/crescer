package zords;

import megazord.battlemode.parts.PernaDireita;
import megazord.battlemode.parts.PernaEsquerda;

public class BlueWolfNinjazord extends Zord implements PernaDireita, PernaEsquerda {

    private static final int COMPRIMENTO = 33;
    private static final int ALTURA = 39;
    private static final int PESO = 1300;
    private static final int VELOCIDADE = 90;

    public BlueWolfNinjazord() {
        super(COMPRIMENTO, ALTURA, PESO, VELOCIDADE);
    }
}