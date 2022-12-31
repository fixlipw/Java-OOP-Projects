# Zero Cancela

O objetivo dessa atividade é implementar um sistema que armazena números e cancela o último número informado, caso desejado pelo usuário.

* Cadastra um número
* Cancela o último número cadastrado.
* Mostra a soma de números cadastrados.

### Recursos
* Cadastrar
  * Cadastra um número diferente de 0 e armazena.
* Cancelar
  * Ao cadastrar o número 0, o sistema cancela o último número cadastrado.
    * O número 0 não é armazenado quando essa operação é efetuada.
* Computar
  * Soma todos os números armazenados e imprime na tela.

### Shell
````
"$cadastra <Int> a" cadastra o número 'a' ou cancela caso 'a' seja 0.
"$computa" soma os números e imprime na tela.
"$show" imprime a lista atual de números.
"$end" finaliza o programa.