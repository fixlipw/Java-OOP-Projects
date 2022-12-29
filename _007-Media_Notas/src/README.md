# Média de Notas
O objetivo dessa atividade é armazenar notas e gerenciá-las.
* Cria e remove notas.
* Retorna a maior e a menor nota.
* Retorna média das notas.
* Parametriza as notas.

### Recursos
* Adiciona nota
  * Adiciona uma nova nota.
* Remove nota
  * Remove nota no index desejado.
  * Caso o index seja inválido, imprime uma mensagem de erro.
* Maior nota
  * Retorna a maior nota.
  * Caso a quantidade seja insuficiente, imprime uma mensagem de erro.
* Menor nota
  * Retorna a menor nota.
  * Caso a quantidade seja insuficiente, imprime uma mensagem de erro.
* Media de notas
  * Retorna a média de todas as notas.
* Parametrizar
  * Divide todas as notas pela maior nota e multiplica por 10.

### Shell
````
"$addNota <Double> a" adiciona uma nova nota com valor 'a'.
"$removeNota <Int> a" remove a nota no index 'a'.
"$maiorNota" imprime a maior nota.
"$menorNota" imprime a menor nota.
"$media" imprime a média das notas.
"$parametriza" parametriza as notas criadas.
"$show" imprime todas as notas.
"$end" finaliza o programa.