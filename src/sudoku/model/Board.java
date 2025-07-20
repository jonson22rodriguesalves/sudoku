package sudoku.model;

import java.util.Collection;
import java.util.List;

import static sudoku.model.GameStatusEnum.COMPLETE;
import static sudoku.model.GameStatusEnum.INCOMPLETE;
import static sudoku.model.GameStatusEnum.NON_STARTED;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Classe que representa o tabuleiro do Sudoku.
 * Responsável por:
 * - Armazenar o estado atual do tabuleiro
 * - Verificar o status do jogo
 * - Gerenciar alterações nas posições
 */
public class Board {

    // Matriz de posições do tabuleiro (9x9)
    private final List<List<Space>> spaces;

    /**
     * Construtor do tabuleiro.
     * @param spaces Matriz de posições inicial
     */
    public Board(final List<List<Space>> spaces) {
        this.spaces = spaces;
    }

    /**
     * @return Matriz de posições do tabuleiro
     */
    public List<List<Space>> getSpaces() {
        return spaces;
    }

    /**
     * Verifica o status atual do jogo.
     * @return Status do jogo (não iniciado, incompleto ou completo)
     */
    public GameStatusEnum getStatus(){
        if (spaces.stream().flatMap(Collection::stream).noneMatch(s -> !s.isFixed() && nonNull(s.getActual()))){
            return NON_STARTED;
        }

        return spaces.stream().flatMap(Collection::stream).anyMatch(s -> isNull(s.getActual())) ? INCOMPLETE : COMPLETE;
    }

    /**
     * Verifica se o tabuleiro contém erros.
     * @return true se há erros, false caso contrário
     */
    public boolean hasErrors(){
        if(getStatus() == NON_STARTED){
            return false;
        }

        return spaces.stream().flatMap(Collection::stream)
                .anyMatch(s -> nonNull(s.getActual()) && !s.getActual().equals(s.getExpected()));
    }

    /**
     * Altera o valor de uma posição no tabuleiro.
     * @param col Coluna da posição
     * @param row Linha da posição
     * @param value Novo valor
     * @return true se a alteração foi bem sucedida, false se a posição é fixa
     */
    public boolean changeValue(final int col, final int row, final int value){
        var space = spaces.get(col).get(row);
        if (space.isFixed()){
            return false;
        }

        space.setActual(value);
        return true;
    }

    /**
     * Remove o valor de uma posição no tabuleiro.
     * @param col Coluna da posição
     * @param row Linha da posição
     * @return true se a remoção foi bem sucedida, false se a posição é fixa
     */
    public boolean clearValue(final int col, final int row){
        var space = spaces.get(col).get(row);
        if (space.isFixed()){
            return false;
        }

        space.clearSpace();
        return true;
    }

    /**
     * Limpa o tabuleiro, removendo todos os valores não fixos.
     */
    public void reset(){
        spaces.forEach(c -> c.forEach(Space::clearSpace));
    }

    /**
     * Verifica se o jogo foi concluído com sucesso.
     * @return true se o jogo está completo e sem erros, false caso contrário
     */
    public boolean gameIsFinished(){
        return !hasErrors() && getStatus().equals(COMPLETE);
    }
}