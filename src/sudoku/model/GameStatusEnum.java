package sudoku.model;

/**
 * Enum que representa os possíveis status do jogo.
 */
public enum GameStatusEnum {

    NON_STARTED("não iniciado"),  // Jogo não iniciado
    INCOMPLETE("incompleto"),     // Jogo iniciado mas não completo
    COMPLETE("completo");         // Jogo completo

    // Descrição do status
    private String label;

    /**
     * Construtor do enum.
     * @param label Descrição do status
     */
    GameStatusEnum(final String label){
        this.label = label;
    }

    /**
     * @return Descrição do status
     */
    public String getLabel() {
        return label;
    }
}
