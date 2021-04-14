package zords;

import megazord.battlemode.parts.Braco;

public class BlackFrogNinjazord extends Zord implements Braco {

    private static final int COMPRIMENTO = 20;
    private static final int ALTURA = 31;
    private static final int PESO = 2000;
    private static final int VELOCIDADE = 120;

    public BlackFrogNinjazord() {
        super(COMPRIMENTO, ALTURA, PESO, VELOCIDADE);
    }
}
