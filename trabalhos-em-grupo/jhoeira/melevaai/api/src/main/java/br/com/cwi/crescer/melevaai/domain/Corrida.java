package br.com.cwi.crescer.melevaai.domain;

import br.com.cwi.crescer.melevaai.controller.MotoristaController;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "identificador")
public class Corrida {

    private static final int TEMPO_MINIMO_CHEGADA = 5;
    private static final int TEMPO_MAXIMO_CHEGADA = 10;
    private static final int VELOCIDADE_MEDIA = 30;
    private static final int CONVERSAO_HORA_SEG = 3600;

    public static final double VALOR_POR_SEGUNDO = 0.2;
    public static final int NOTA_MAXIMA = 5;
    public static final int NOTA_MINIMA = 1;

    private int identificador;
    private Passageiro passageiro;
    private Veiculo veiculo;
    private Ponto inicio;
    private Ponto fim;
    private double tempoChegada;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private double valorReal;
    private double tempoEstimado;
    private double valorEstimado;
    private StatusCorrida status;
    private int notaParaMotorista;
    private int notaParaPassageiro;



    public void calcValorEstimado(){
        double distancia = inicio.calcDistancia(fim);
        double tempoHoras = distancia/VELOCIDADE_MEDIA;
        double tempoSegundos = tempoHoras*CONVERSAO_HORA_SEG;
        double valorEstimado = tempoSegundos*VALOR_POR_SEGUNDO;

        setTempoEstimado(tempoSegundos);
        setValorEstimado(valorEstimado);
    }

    public void realizarTransicoesPagamento(){
        this.getPassageiro().transferir(this.getValorReal());
        for (Motorista motorista : MotoristaController.motoristaList) {
            if (motorista.equals(this.getVeiculo().getProprietario()))
                motorista.receber(this.getValorReal());
        }
    }

    public static long calcularTempoChegadaEstimado() {
        return Math.round(Math.random() * (TEMPO_MAXIMO_CHEGADA - TEMPO_MINIMO_CHEGADA) + TEMPO_MINIMO_CHEGADA);
    }
}
