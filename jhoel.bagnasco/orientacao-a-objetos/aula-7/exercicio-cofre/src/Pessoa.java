import exceptions.BiometriaComFormatoIncorretoException;
import exceptions.GeolocalizacaoComFormatoIncorretoException;

public class Pessoa {

    private static final int TAMANHO_BIOMETRIA = 128;

    private static final int TAMANHO_LOCALIZACAO = 2;

    private String nome;

    private String senha;

    private double[] biometria;

    private double[] localizacao;

    private Perfil perfil;

    public Pessoa() {}

    public static boolean validarBiometria(double[] biometria) throws BiometriaComFormatoIncorretoException {
        if (biometria.length != TAMANHO_BIOMETRIA)
            throw new BiometriaComFormatoIncorretoException();
        else
            return true;
    }

    public static boolean validarLocalizacao(double[] localizacao) throws GeolocalizacaoComFormatoIncorretoException {
        if (localizacao.length != TAMANHO_LOCALIZACAO)
            throw new GeolocalizacaoComFormatoIncorretoException();
        else
            return true;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public double[] getBiometria() {
        return biometria;
    }

    public double[] getLocalizacao() {
        return localizacao;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setBiometria(double[] biometria) {
        this.biometria = biometria;
    }

    public void setLocalizacao(double[] localizacao) {
        this.localizacao = localizacao;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
