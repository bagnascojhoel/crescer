package br.com.cwi.crescer.melevaai.fixture;

import org.apache.commons.lang.RandomStringUtils;

import br.com.cwi.crescer.melevaai.domain.CPF;
import br.com.cwi.crescer.melevaai.domain.Motorista;

public class MotoristaFixture {

    private Motorista motorista = new Motorista();

    public static MotoristaFixture builder() {
        return new MotoristaFixture();
    }

    public Motorista build() {
        return this.motorista;
    }

    public MotoristaFixture random() {
        this.comNome(RandomStringUtils.randomAlphabetic(10))
            .comEmail("email@email.com")
            .comCpf(RandomStringUtils.randomNumeric(11));
        return this;
    }

    public MotoristaFixture comNome(String nome) {
        this.motorista.setNome(nome);
        return this;
    }

    public MotoristaFixture comEmail(String email) {
        this.motorista.setEmail(email);
        return this;
    }

    public MotoristaFixture comCpf(String numeroCpf) {
        this.motorista.setCpf(new CPF(numeroCpf));
        return this;
    }
}
