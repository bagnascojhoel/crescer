package megazord;

import megazord.tankmode.parts.*;

public class MegazordTankMode implements Megazord {

    private Centro centro;

    private Topo topo;

    private Canhao canhao;

    private RodaEsquerda rodaEsquerda;

    private RodaDireita rodaDireita;

    public MegazordTankMode(
            Centro centro,
            Topo topo,
            Canhao canhao,
            RodaEsquerda rodaEsquerda,
            RodaDireita rodaDireita) {

        this.centro = centro;
        this.topo = topo;
        this.canhao = canhao;
        this.rodaEsquerda = rodaEsquerda;
        this.rodaDireita = rodaDireita;
    }

    @Override
    public int getComprimento() {
        return this.rodaEsquerda.getComprimento() + this.rodaDireita.getComprimento();
    }

    @Override
    public int getAltura() {
        return (
            this.topo.getAltura()
            + this.centro.getAltura()
            + this.canhao.getAltura()
            + this.rodaEsquerda.getAltura()
            + this.rodaDireita.getAltura()
        );
    }

    @Override
    public int getPeso() {
        return (
            this.topo.getPeso()
            + this.centro.getPeso()
            + this.canhao.getPeso()
            + this.rodaEsquerda.getPeso()
            + this.rodaDireita.getPeso()
        );
    }

    @Override
    public int getVelocidade() {
        return (this.rodaEsquerda.getVelocidade() + this.rodaDireita.getVelocidade()) *2;
    }
}
