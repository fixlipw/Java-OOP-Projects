# Conta Bancária
O objetivo dessa atividade é implimentar uma conta bancária.

* É possível criar contas com nome, número, saldo e um id iteravel automático.
* Também é possível depositar, sacar, transferir e mostrar valores entre contas.

### Recusos

* Criar conta
  * Cria uma conta com o nome passado por parâmetro e com saldo 0, e adiciona a uma lista de contas.
* Depositar em uma conta
  * Tenta depositar um valor em uma conta.
  * Caso não consiga encontrar a conta,
  imprime uma mensagem.
* Sacar de uma conta
  * Tenta sacar o valor desejado.
  * Caso não encontre a conta ou a conta fique sem saldo após o saque, imprime uma mensagem.
* Transferir de conta para conta 
  * Tenta transferir valores de conta para outra.
  * Caso não encontre uma das contas ou a conta de origem fique sem saldo após a transferência, imprime uma mensagem.
* Mostrar contas
  * Tenta imprimir uma conta especificada.
  * Caso não conseguir, imprime uma mensagem.

### Shell
```
"$init <String> nome" cria uma conta com 'nome' sendo o titular.
"$deposita <Int> num, <Double> valor" deposita 'valor' na conta de número 'num'.
"$saca <Int> num, <Double> valor" saca 'valor' da conta de número 'num'.
"$transfere <Int> numOrigem, <Int> numDestino, <Double> valor" transfere 'valor' da conta 'numOrigem' para a conta 'numDestino'.
"$show <Int> numConta" imprime a conta de número 'numConta'.
"$end" finaliza o programa.
