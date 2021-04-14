package individuos;

import habilidades.HabilidadeEspecial;
import locais.Posicao;
import armas.Arma;

public class Vingador {
    private Posicao posicao;
    private int vida;
    private String nome;
    private Arma arma;
    private HabilidadeEspecial habilidadeEspecial;

    public Vingador(String nome,
                    int vida,
                    Arma arma,
                    HabilidadeEspecial habilidadeEspecial,
                    Posicao posicao
    ) {
        this.posicao = posicao;
        this.vida = vida;
        this.nome = nome;
        this.arma = arma;
        this.habilidadeEspecial = habilidadeEspecial;
    }

    public void atacar(Vingador adversario) {
        if (!this.estaVivo()) return;

        int dano = this.calcularDano(adversario);
        adversario.sofrerAtaque(dano);
    }

    public String getNome() { return this.nome; }
    public Posicao getPosicao() { return this.posicao; }
    public int getVida() { return this.vida; }

    private boolean estaVivo() {
        return this.vida > 0;
    }

    private void sofrerAtaque(int dano) {
        int vidaFinal = this.vida - dano;
        this.vida = vidaFinal >= 0 ? vidaFinal : 0;
//        this.vida -= dano;
    }

    private int calcularDano(Vingador adversario) {
        int danoArma = this.arma.calcularDano(this.posicao, adversario.posicao);
        float percentualBonus = habilidadeEspecial.getTaxaBonus();
        return Math.toIntExact(Math.round(danoArma + (danoArma * percentualBonus)));
    }
}
