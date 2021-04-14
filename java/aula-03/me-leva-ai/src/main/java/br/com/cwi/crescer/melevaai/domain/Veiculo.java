package br.com.cwi.crescer.melevaai.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Veiculo {

    private String placa;

    private Marca marca;

    private String modelo;

    private int ano;

    private Cor cor;

    private String foto;

    private Categoria categoria;

    private int quantidadeLugares;

    @Valid
    @NotNull
    private Motorista proprietario;

    public Veiculo(String placa, Marca marca, String modelo, int ano, Cor cor, String foto,
        Categoria categoria, int quantidadeLugares, Motorista proprietario) {

        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.foto = foto;
        this.categoria = categoria;
        this.quantidadeLugares = quantidadeLugares;
        this.proprietario = proprietario;
    }

    public Veiculo() {

    }

    private void validarCnhVencida(Motorista proprietario) {
        if (proprietario.getCnh().isVencida()) {
            throw new ValidacaoNegocioException();
        }
    }

    private void validarCategoriaCnhProprietario(Categoria categoria, Motorista proprietario) {
        if (categoria != proprietario.getCnh().getCategoria()) {
            throw new ValidacaoNegocioException();
        }
    }

    private void validarProprietarioObrigatorio(Motorista proprietario) {
        if (proprietario == null) {
            throw new ValidacaoNegocioException();
        }
    }
}
