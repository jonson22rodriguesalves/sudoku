package model;

/**
 * Classe que representa uma célula/posição no tabuleiro do Sudoku.
 */
public class Space {

    // Valor atual na posição (pode ser nulo se não preenchido)
    private Integer actual;

    // Valor esperado/correto para esta posição
    private final int expected;

    // Indica se a posição é fixa (não pode ser alterada)
    private final boolean fixed;

    /**
     * Construtor da classe Space.
     * @param expected Valor esperado para esta posição
     * @param fixed Se a posição é fixa (não pode ser alterada)
     */
    public Space(final int expected, final boolean fixed) {
        this.expected = expected;
        this.fixed = fixed;
        if (fixed){
            actual = expected;
        }
    }

    /**
     * @return Valor atual na posição
     */
    public Integer getActual() {
        return actual;
    }

    /**
     * Define o valor atual na posição.
     * @param actual Novo valor a ser definido
     */
    public void setActual(final Integer actual) {
        if (fixed) return;
        this.actual = actual;
    }

    /**
     * Limpa o valor atual da posição.
     */
    public void clearSpace(){
        setActual(null);
    }

    /**
     * @return Valor esperado para esta posição
     */
    public int getExpected() {
        return expected;
    }

    /**
     * @return true se a posição é fixa, false caso contrário
     */
    public boolean isFixed() {
        return fixed;
    }
}
