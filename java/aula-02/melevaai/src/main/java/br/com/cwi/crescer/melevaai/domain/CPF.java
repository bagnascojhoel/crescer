package br.com.cwi.crescer.melevaai.domain;

import java.util.Objects;

public class CPF {

    private String numero;

    public CPF(String numero) {
        this.numero = numero;
//        this.validaCpf();
    }

    public String getNumero() {
        return numero;
    }

//    public void validaCpf(){
//        if(this.numero.equals("")){
//            throw new IllegalArgumentException();
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPF cpf = (CPF) o;
        return numero.equals(cpf.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
