package zords;

import megazord.battlemode.parts.Braco;
import megazord.tankmode.parts.Canhao;

public class MastodonDinozord extends Zord implements Braco, Canhao {

    private static final int COMPRIMENTO = 25;
    private static final int ALTURA = 15;
    private static final int PESO = 108;
    private static final int VELOCIDADE = 120;

    public MastodonDinozord() {
        super(COMPRIMENTO, ALTURA, PESO, VELOCIDADE);
    }
}
