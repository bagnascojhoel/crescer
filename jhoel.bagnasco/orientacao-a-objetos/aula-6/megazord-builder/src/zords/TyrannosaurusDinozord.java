package zords;

import megazord.battlemode.parts.Cabeca;
import megazord.tankmode.parts.Centro;

public class TyrannosaurusDinozord extends Zord implements Cabeca, Centro {

    private static final int COMPRIMENTO = 45;
    private static final int ALTURA = 27;
    private static final int PESO = 96;
    private static final int VELOCIDADE = 120;

    public TyrannosaurusDinozord() {
        super(COMPRIMENTO, ALTURA, PESO, VELOCIDADE);
    }
}
