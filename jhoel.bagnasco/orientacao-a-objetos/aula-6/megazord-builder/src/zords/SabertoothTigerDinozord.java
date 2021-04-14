package zords;

import megazord.battlemode.parts.PernaDireita;
import megazord.battlemode.parts.PernaEsquerda;
import megazord.tankmode.parts.RodaDireita;
import megazord.tankmode.parts.RodaEsquerda;

public class SabertoothTigerDinozord extends Zord implements PernaEsquerda, PernaDireita, RodaEsquerda, RodaDireita {

    private static final int COMPRIMENTO = 37;
    private static final int ALTURA = 13;
    private static final int PESO = 141;
    private static final int VELOCIDADE = 150;

    public SabertoothTigerDinozord() {
        super(COMPRIMENTO, ALTURA, PESO, VELOCIDADE);
    }
}
