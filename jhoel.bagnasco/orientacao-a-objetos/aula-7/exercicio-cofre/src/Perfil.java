public enum Perfil {
    CRESCER(1),
    INSTRUTOR(2),
    MARKETING(2),
    GERENTE(2);

    private final int permissao;
    Perfil(int permissao) {
        this.permissao = permissao;
    }
}
