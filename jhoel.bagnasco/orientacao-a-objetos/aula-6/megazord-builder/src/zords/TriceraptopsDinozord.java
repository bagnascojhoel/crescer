package zords;

import megazord.battlemode.parts.PernaDireita;
import megazord.battlemode.parts.PernaEsquerda;
import megazord.tankmode.parts.RodaDireita;
import megazord.tankmode.parts.RodaEsquerda;

public class TriceraptopsDinozord extends Zord implements PernaEsquerda, PernaDireita, RodaEsquerda, RodaDireita {

    private static final int COMPRIMENTO = 37;
    private static final int ALTURA = 11;
    private static final int PESO = 141;
    private static final int VELOCIDADE = 140;

    public TriceraptopsDinozord() {
        super(COMPRIMENTO, ALTURA, PESO, VELOCIDADE);
    }
}
