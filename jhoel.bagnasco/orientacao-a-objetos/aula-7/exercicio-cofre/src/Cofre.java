import com.sun.xml.internal.ws.api.message.Message;
import exceptions.BiometriaComFormatoIncorretoException;
import exceptions.GeolocalizacaoComFormatoIncorretoException;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class Cofre {

    private final double diferencaMaxima; // biometria

    private final double distanciaMaxima; // localizacao

    private final Map<String, Pessoa> pessoalAutorizado; // <login, instancia de pessoa>

    public Cofre(Map<String, Pessoa> pessoalAutorizado, double diferencaMaxima, double distanciaMaxima) {
        this.pessoalAutorizado = pessoalAutorizado;
        this.diferencaMaxima = diferencaMaxima;
        this.distanciaMaxima = distanciaMaxima;
    }

    public boolean abrir(
            String login,
            Perfil perfil,
            String senha,
            double[] biometria,
            double[] localizacao)
            throws NoSuchAlgorithmException,
            BiometriaComFormatoIncorretoException,
            GeolocalizacaoComFormatoIncorretoException {

        Pessoa pessoaAutorizada = pessoalAutorizado.get(login);
        return pessoaAutorizada != null &&
                pessoaAutorizada.getPerfil() == perfil &&
                validarSenha(pessoaAutorizada, senha) &&
                validarBiometria(pessoaAutorizada, biometria) &&
                validarLocalizacao(pessoaAutorizada, localizacao);
    }

    private boolean validarSenha(Pessoa pessoaAutorizada, String senhaSolicitante) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] senhaComoArrayByte = md5.digest(senhaSolicitante.getBytes());
        String hashSenhaSolicitante = DatatypeConverter.printHexBinary(senhaComoArrayByte).toLowerCase();
        String hashSenhaAutorizada = pessoaAutorizada.getSenha();

        return hashSenhaAutorizada.equals(hashSenhaSolicitante);
    }

    private boolean validarBiometria(Pessoa pessoaAutorizada, double[] biometriaSolicitante) throws BiometriaComFormatoIncorretoException {

        if (!Pessoa.validarBiometria(biometriaSolicitante)) return false;

        double diferenca = calcularDistanciaEuclidiana(pessoaAutorizada.getBiometria(), biometriaSolicitante);
        return diferenca < diferencaMaxima;
    }

    private boolean validarLocalizacao(Pessoa pessoaAutorizada, double[] localizacaoSolicitante) throws GeolocalizacaoComFormatoIncorretoException {
        if (!Pessoa.validarLocalizacao(localizacaoSolicitante)) return false;

        double distancia = calcularDistanciaEuclidiana(pessoaAutorizada.getLocalizacao(), localizacaoSolicitante);
        return distancia < distanciaMaxima;
    }


    private static double calcularDistanciaEuclidiana(double[] pontosAutorizado, double[] pontosSolicitante) {

        double soma = 0;
        for (int i = 0; i < pontosAutorizado.length; i++) {
            soma += Math.pow(pontosAutorizado[i] - pontosSolicitante[i], 2);
        }

        return Math.sqrt(soma);
    }
}
