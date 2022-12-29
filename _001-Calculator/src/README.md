# Calculadora

O objetivo dessa atividade é implementar uma calculadora e sua bateria. 

* Se há bateria, ela executa operações de soma e divisão. 
* É possível também mostrar a quantidade de bateria e recarregar a calculadora.
* Ela avisa quando está sem bateria e se há tentativa de divisão por 0.

### Recursos

* Mostrar bateria da calculadora.
* Recarregar bateria.
* Realizar operações de soma e divisão.
* Se o usuário tentar realizar operações e a beteria estiver vazia, uma mensagem de aviso deve ser mostrada sobre a falta de bateria.
* Se tentar divisão por zero, deve ser notificado erro.

### Shell

````
"init M" inicia uma calculadora nova passando por parâmetro a bateria máxima.
"show" mostra o valor da última operação bem sucedida no display e o estado da bateria.
"charge t" recarrega a bateria com 't' de carga
