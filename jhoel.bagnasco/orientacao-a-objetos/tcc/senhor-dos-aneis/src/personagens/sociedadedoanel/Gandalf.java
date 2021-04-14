package personagens.sociedadedoanel;

import classes.Mago;
import racas.Maia;

public class Gandalf extends Mago implements Maia, MembroSociedadeDoAnel {

    private static final int FORCA = 2;

    private static final int AGILIDADE = 3;

    private static final int INTELIGENCIA = 10;

    private static final int CONSTITUICAO_INICIAL = 80;

    private static final String FALA = "A Wizard is never late, nor is he early. He arrives precisely when he means to.";

    private static final String INDICADOR = "G";

    public Gandalf() {
        super(INDICADOR, FORCA, AGILIDADE, INTELIGENCIA, CONSTITUICAO_INICIAL);
    }

    @Override
    public Gandalf ressucitar() {
        if (getConstituicao() == 0)
            return new Gandalf();
        else
            return this;
    }

    @Override
    public String falar() {
        return FALA;
    }

}
