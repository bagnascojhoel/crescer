package br.com.cwi.crescer.melevaai.controller.response;

import br.com.cwi.crescer.melevaai.domain.Categoria;
import lombok.Data;

@Data
public class MotoristaResponse {

    private String nome;

    private String numeroCpf;

    private String numeroCnh;

    private Categoria categoriaCnh;

    private boolean ocupado;
}