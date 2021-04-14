package br.com.cwi.crescer.melevaai.domain;

import br.com.cwi.crescer.melevaai.exception.MotoristaComCNHVencidaException;
import br.com.cwi.crescer.melevaai.exception.MotoristaNaoHabilitadoException;
import br.com.cwi.crescer.melevaai.exception.ProprietarioObrigatorioException;

import java.time.LocalDate;

public class Veiculo {

    private Placa placa;
    private Marca marca;
    private String modelo;
    private int ano;
    private Cor cor;
    private URL foto;
    private String categoria;
    private int qtdLugares;
    private Motorista proprietario;

    public Veiculo(Placa placa, Marca marca, String modelo, int ano, Cor cor, URL foto, String categoria, int qtdLugares, Motorista proprietario) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.foto = foto;
        this.categoria = categoria;
        this.qtdLugares = qtdLugares;
        this.proprietario = proprietario;

        validarMotorista();
        validarCNHCompativel();
        validarCNHNaoVencida();
    }

    public Placa getPlaca() {
        return placa;
    }

    public Marca getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public Cor getCor() {
        return cor;
    }

    public URL getFoto() {
        return foto;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQtdLugares() {
        return qtdLugares;
    }

    public Motorista getProprietario() {
        return proprietario;
    }

    private void validarMotorista() {
        if (proprietario != null)
            throw new ProprietarioObrigatorioException();
    }

    private void validarCNHCompativel() {
        if (!proprietario.getCnh().getCategoria().equals(categoria))
            throw new MotoristaNaoHabilitadoException();
    }

    private void validarCNHNaoVencida() {
        if (proprietario.getCnh().getDataVencimento().isBefore(LocalDate.now()))
            throw new MotoristaComCNHVencidaException();
    }
}
