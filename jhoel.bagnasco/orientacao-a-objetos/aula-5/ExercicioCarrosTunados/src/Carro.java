import pecas.Freio;
import pecas.Motor;
import pecas.Peca;
import pecas.Pneu;
import trajetos.Trajeto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carro {

    private static final int QUALIDADE_INICIAL = 100;

    private Motor motor;
    private Freio freio;
    private Pneu pneu;

    public Carro() {
        this.motor = new Motor(QUALIDADE_INICIAL);
        this.freio = new Freio(QUALIDADE_INICIAL);
        this.pneu = new Pneu(QUALIDADE_INICIAL);
    }

    public boolean correr(List<Trajeto> pista) {
        int i = 0;
        while (this.nenhumaPecaEstragada() && i < pista.size()) {
            this.usarPecasNoTrajeto(pista.get(i));
            i++;
        }

        return this.nenhumaPecaEstragada();
    }

    public void tunar(Motor motor) {
        if (motor.qualidade > this.motor.qualidade)
            this.motor = motor;
    }

    public void tunar(Freio freio) {
        if (freio.qualidade > this.freio.qualidade)
            this.freio = freio;
    }

    public void tunar(Pneu pneu) {
        if (pneu.qualidade > this.pneu.qualidade) {
            this.pneu = pneu;
        }
    }

    private void usarPecasNoTrajeto(Trajeto trajeto) {
        this.motor.usarNoTrajeto(trajeto);
        this.freio.usarNoTrajeto(trajeto);
        this.pneu.usarNoTrajeto(trajeto);
    }

    private boolean nenhumaPecaEstragada() {
        boolean a =!this.motor.estaEstragada()
                && !this.freio.estaEstragada()
                && !this.pneu.estaEstragada();
        return a;
    }
}
