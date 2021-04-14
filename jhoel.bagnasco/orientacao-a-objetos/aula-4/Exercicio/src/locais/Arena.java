package locais;

import individuos.Vingador;

public class Arena {
    private final String EMPATE = "EMPATE";
    private int largura;
    private int profundidade;

    public Arena(int largura, int profundidade) {
        this.largura = largura;
        this.profundidade = profundidade;
    }

    public String batalhar(Vingador vingadorLocal, Vingador vingadorDesafiante) {
        boolean vingadorLocalNaArena = this.estaDentroDaArena(vingadorLocal);
        boolean vingadorDesafianteNaArena = this.estaDentroDaArena(vingadorDesafiante);
        if (vingadorLocalNaArena && !vingadorDesafianteNaArena) return vingadorLocal.getNome();
        if (!vingadorLocalNaArena && vingadorDesafianteNaArena) return vingadorDesafiante.getNome();
        if (!vingadorLocalNaArena && !vingadorDesafianteNaArena) return this.EMPATE;

        vingadorLocal.atacar(vingadorDesafiante);
        vingadorDesafiante.atacar(vingadorLocal);
        vingadorLocal.atacar(vingadorDesafiante);

        if (vingadorDesafiante.getVida() > vingadorLocal.getVida())
            return vingadorDesafiante.getNome();
        else if (vingadorDesafiante.getVida() < vingadorLocal.getVida())
            return vingadorLocal.getNome();
        else return this.EMPATE;
    }

    private boolean estaDentroDaArena(Vingador vingador) {
        return this.estaDentroDaLargura(vingador) && this.estaDentroDaProfundidade(vingador);
    }

    private boolean estaDentroDaLargura(Vingador vingador) {
        return vingador.getPosicao().getX() >= 1 && vingador.getPosicao().getX() <= this.largura;
    }

    private boolean estaDentroDaProfundidade(Vingador vingador) {
        return vingador.getPosicao().getY() >= 1 && vingador.getPosicao().getY() <= this.profundidade;
    }


}
