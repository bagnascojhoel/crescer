package br.com.cwi.crescer.melevaai.domain;

import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(of = "placa")
@NoArgsConstructor
public class Veiculo {

    private Placa placa;
    private Marca marca;
    private String modelo;
    private int ano;
    private Cor cor;
    private URL foto;
    private Categoria categoria;
    private int qtdLugares;
    private Motorista proprietario;

    @JsonCreator
    public Veiculo(Placa placa, Marca marca, String modelo, int ano, Cor cor, URL foto, Categoria categoria, int qtdLugares, Motorista proprietario) {
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

    private void validarMotorista() {
        if (proprietario == null)
            throw new ValidacaoNegocioException("Proprietário do veículo obrigatório");
    }

    private void validarCNHCompativel() {
        if (!proprietario.getCnh().getCategoria().equals(categoria))
            throw new ValidacaoNegocioException("A carteira de habilitação nacional do proprietário não é compatível com a categoria do veículo.");
    }

    private void validarCNHNaoVencida() {
        if (proprietario.getCnh().getDataVencimento().isBefore(LocalDate.now()))
            throw new ValidacaoNegocioException("Um motorista não pode dirigir com a carteira de habilitação vencida.");
    }
}
