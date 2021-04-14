package exceptions;

public class GeolocalizacaoComFormatoIncorretoException extends Exception {
    public GeolocalizacaoComFormatoIncorretoException() {
        super("Tamanho do array é diferente a 2.");
    }
}
