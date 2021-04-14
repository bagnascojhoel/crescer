public class Calculadora {
    public double soma(double valorUm, double valorDois) {
        return valorUm + valorDois;
    }

    public double subtracao(double valorUm, double valorDois) {
        return valorUm - valorDois;
    }

    public double multiplicacao(double valorUm, double valorDois) {
        return valorUm * valorDois;
    }

    public double divisao(double valorUm, double valorDois) {
        return valorUm / valorDois;
    }

    public double raizQuadrada(double valor) {
        return Math.sqrt(valor);
    }

    public double exponenciacao(double base, int expoente) {
        return Math.pow(base, expoente);
    }

    public double somaDasRaizesDaBhaskara(double a, double b, double c) {
        double delta = Math.sqrt((b * b) - (4 * a * c));
        double primeiraRaiz = ((-1 * b) + delta) / (2 * a);
        double segundaRaiz = ((-1 * b) - delta) / (2 * a);

        return (primeiraRaiz + segundaRaiz);
    }
}