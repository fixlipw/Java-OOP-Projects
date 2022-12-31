# Motoca
O objetivo da atividade é implementar uma motoca motorizada de um parque para crianças.

* Inicia uma nova motoca e sobe e desce crianças.
* Gerencia tempo das crianças e buzina.

### Recusos

* Iniciar
  * A moto inicia com 1 de potência, sem minutos e sem ninguém.
* Subir
  * Só pode estar uma pessoa na moto por vez. Para subir, informe nome e idade de quem está subindo.
* Descer
  * Só pode descer se tiver alguém na moto.
* Comprar tempo
  * O tempo em minutos é comprado e enquanto houver tempo, qualquer pessoa pode dirigir.
* Dirigir tempo
  * Se houver uma pessoa com 10 anos ou menos e houver minutos, então ela pode passear de moto. 
  * Se o tempo acabar no meio do passeio, informe o quanto a pessoa andou.
* Buzinar
  * O barulho da buzina é “Pem”, porém o número de e é igual ao valor da potência.
  * Ex: se a potência for 5, buzinar deve gerar: Peeeeem

### Shell
````
"$init <Int> a" cria uma nova motoca com potencia 'a', tempo zerado e sem criança em cima.
"$buy <Int> a" compra a quantidade de tempo 'a'.
"$entrer <String> a, <Int> b" coloca a criança 'a', de 'b' anos e coloca na motoca.
"$drive <Int> a" faz a criança dirigir 'a' quantidade de tempo.
"$honk" faz a motoca buzinar.
"$show" imprime o estado da motoca.
"$end" finaliza o programa.