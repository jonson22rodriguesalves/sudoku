# Santander Boot Camp 2025

* 📱 Sudoku Game System
* 🎮 Sistema de Jogo Sudoku Completo
 
* Sistema Java que implementa um jogo de Sudoku completo com:
* Tabuleiro 9x9 com células fixas e editáveis
* Validação automática de erros
* Sistema de preenchimento e limpeza de células
* Visualização do tabuleiro formatado
* Controle de estado do jogo (iniciado, em andamento, completo)
 
* 🛠️ Tecnologias Utilizadas
* Java 21+
* Scanner para entrada de dados
* Programação orientada a objetos
* Matrizes bidimensionais para representação do tabuleiro
* Enum para controle de estado do jogo
* Template pattern para exibição do tabuleiro
 
* 📚 Pré-requisitos
* Java JDK 21 ou superior
* Conhecimento básico de compilação Java
* Terminal/Console para execução
  
* 🚀 Como Executar
* Compile o programa:
 
* bash
* javac sodoku/Main.java
* Execute o programa:
 
* bash
* java sodoku.Main
* Siga o fluxo interativo:
 
 
* Selecione uma das opções a seguir
* 1 - Iniciar um novo Jogo
* 2 - Colocar um novo número
* 3 - Remover um número
* 4 - Visualizar jogo atual
* 5 - Verificar status do jogo
* 6 - limpar jogo
* 7 - Finalizar jogo
* 8 - Sair
  
* 🎯 Funcionalidades Implementadas
* Inicialização do Jogo
* Tabuleiro padrão pré-definido
* Células fixas (não editáveis) e variáveis
* Status inicial do jogo
* Manipulação do Tabuleiro
* Inserção de números (1-9) em células editáveis
* Remoção de números de células editáveis
* Limpeza completa do tabuleiro (exceto células fixas)
 
* Visualização
* Exibição formatada do tabuleiro 9x9
* Destaque visual para blocos 3x3
* Mostra números atuais e posições vazias
* Controle do Jogo
* Verificação automática de erros
* Status do jogo (não iniciado, incompleto, completo)
* Validação de vitória
  
* 📝 Exemplo de Uso
 
* Selecione uma opção: 1
* O jogo está pronto para começar
 
* Selecione uma opção: 2
* Informe a coluna que em que o número será inserido: 0
* Informe a linha que em que o número será inserido: 0
* Informe o número que vai entrar na posição [0,0]: 5
 
* Selecione uma opção: 4
* Seu jogo se encontra da seguinte forma:
* [Tabuleiro exibido com o número 5 na posição 0,0]
 
* Selecione uma opção: 7
* Parabéns você concluiu o jogo
* [Tabuleiro completo exibido]
  
* ⚠️ Importante
* O jogo inicia com um tabuleiro pré-definido
* Células fixas não podem ser alteradas
* O sistema valida automaticamente os números inseridos
* O jogo só é considerado completo quando todas as células estão corretamente preenchidas
   
````mermaid
classDiagram
     direction TB
     
     class Main {
         -Scanner scanner
         -Board board
         +main(String[] args)
         +startGame(Map<String,String>)
         +inputNumber()
         +removeNumber()
         +showCurrentGame()
         +showGameStatus()
         +clearGame()
         +finishGame()
     }
     
     class Board {
         -List<List<Space>> spaces
         +getSpaces()
         +getStatus()
         +hasErrors()
         +changeValue(int,int,int)
         +clearValue(int,int)
         +reset()
         +gameIsFinished()
     }
     
     class Space {
         -Integer actual
         -int expected
         -boolean fixed
         +getActual()
         +setActual(Integer)
         +clearSpace()
         +getExpected()
         +isFixed()
     }
     
     class GameStatusEnum {
         <<enum>>
         NON_STARTED
         INCOMPLETE
         COMPLETE
         +getLabel()
     }
     
     class BoardTemplate {
         <<utility>>
         -BOARD_TEMPLATE
     }
     
     Main --> Board : Uses
     Board --> Space : Contains
     Board --> GameStatusEnum : Uses
     Main --> BoardTemplate : Uses for display
  
````
* [Início]
* ↓
* [Menu Principal]
* ↓
* ├─ 1. Iniciar Jogo → Cria novo tabuleiro
* ├─ 2. Inserir Número → Solicita posição e valor
* ├─ 3. Remover Número → Solicita posição
* ├─ 4. Visualizar Tabuleiro → Mostra estado atual
* ├─ 5. Verificar Status → Mostra progresso
* ├─ 6. Limpar Jogo → Reseta células editáveis
* ├─ 7. Finalizar Jogo → Verifica vitória
* └─ 8. Sair → Encerra programa

* Melhorias Implementadas
* As principais melhorias identificadas em relação à versão original são:
* Tabuleiro padrão pré-definido: Implementação do método getDefaultBoardArgs() que fornece um tabuleiro inicial válido
* Tratamento de argumentos: Lógica para usar o tabuleiro padrão quando nenhum argumento é passado
* Documentação: Atributos e métodos comentados para melhor legibilidade e manutenção
 
* Conclusão
* Esta implementação do Sudoku demonstra:
* Boa aplicação de conceitos OO
* Separação clara de responsabilidades
* Código bem estruturado e documentado
* Funcionalidades completas do jogo
* Interação amigável com o usuário
* As melhorias adicionadas, especialmente o tabuleiro padrão e a documentação, aumentam significativamente a usabilidade e manutenibilidade do código.
* Fontes da versão educacional original:
 
* https://github.com/digitalinnovationone/sudoku
 
* https://github.com/digitalinnovationone/sudoku/tree/ui
 
