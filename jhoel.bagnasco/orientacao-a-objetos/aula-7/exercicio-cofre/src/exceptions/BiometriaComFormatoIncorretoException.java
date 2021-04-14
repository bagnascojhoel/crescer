package exceptions;

public class BiometriaComFormatoIncorretoException extends Exception {
    public BiometriaComFormatoIncorretoException() {
        super("Tamanho do array de biometria é diferente de 128.");
    }
}
