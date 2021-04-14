package personagens;

public interface ParticipanteDaGuerra {
    default boolean pertenceASociedadeDoAnel() {
        return false;
    }
}
