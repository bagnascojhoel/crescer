package personagens.sociedadedoanel;

import personagens.ParticipanteDaGuerra;

public interface MembroSociedadeDoAnel extends ParticipanteDaGuerra {
    default boolean pertenceASociedadeDoAnel() {
        return true;
    }
}
