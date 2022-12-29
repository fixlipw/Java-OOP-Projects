# Carro

O objetivo dessa atividade é implementar um carro ecológico que pode passear pela cidade. 
* Ele deve poder embarcar e desembarcar pessoas.
* Colocar combustível e andar.

### Recursos

* Inicializar
  * Inicia de tanque vazio, sem ninguém dentro e com 0 de quilometragem.
  * O carro comporta até 2 pessoas e seu tanque suporta até 100 litros de água como combustível.
* Entrar e Sair
  * Embarca uma pessoa por vez.
  * Desembarca uma pessoa por vez.
    * Não embarca além do limite e não desembarca se não houver ninguém no carro.
* Abastecer
  * Abastecer o tanque passando a quantidade de litros de combustível.
    * Caso tente abastecer acima do limite, descarta o valor que passou.
* Dirigir
  * Caso haja pelo menos uma pessoa no carro e algum combustível, ele deve gastar combustível andando e aumentar a quilometragem.
  * O carro faz um quilômetro por litro de água.
  * Caso não exista combustível suficiente para completar a viagem inteira, dirije o que for possível e emite uma mensagem indicando quanto foi percorrido.

### Shell
```
"$enter" insere uma pessoa no carro.
"$leave" retira uma pessoa do carro.
"$enter" adiciona um passageiro ao carro.
"$leave" retira um passageiro do carro.
"$show" mostra o estado do carro.
"$drive <Int> a" dirige 'a' quilômetros.
"fuel <Int> a" adiciona 'a' litros de água no tanque.
"$end" finaliza o programa.
