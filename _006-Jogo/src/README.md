# Jogo
O objetivo dessa atividade é implementar um jogo de tabuleiro.

* O jogo consegue adicionar armadilhas
* Os peões iniciam posicionados antes da primeira casa do tabuleiro.
* Cada jogador joga dois dados por turno e anda a quantidade de casas dadas pelos dados.
* Ganha o jogador que chegar primeiro depois da última casa do percurso.

### Recursos

* Iniciar Jogo
  * inicia o jogo com a quantidade de jogadores e casas do jogo.
* Adicionar armadilha
  * Adiciona uma armadilha na casa informada.
  * Haverá no máximo 3 armadilhas no tabuleiro.
* Movimentar peões
  * Todos os jogadores rodam os dados em cada rodada e movimentam seus peões.
    * Caso um jogador caia em uma armadilha, ele ficará sem jogar 1 turno.
    * Depois de 1 turno, ele poderá jogar normalmente.

### Shell
````
"$init <Int> a, <Int> b" inicia um novo jogo com 'a' jogadores em um tabuleiro com 'b' casas.
"$addArmadilha <Int> a" adiciona uma armadilha na casa 'a'.
"$addMove <Int> a, <Int> b" movimenta o peão do jogador em 'a+b' casas.
"$end" finaliza o programa.