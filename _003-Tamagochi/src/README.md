# Tamagochi

O objetivo dessa atividade é implementar um simulador de bichinho virtual.
* Ele poderá comer, brincar, dormir e tomar banho.
* E eventualmente morrerá, se você não cuidar bem dele.

### Recursos
* Inicializar 
  * Passando energia, saciedade e limpeza máximas do pet. 
  * Todos os níveis devem ser iniciados no máximo na criação do pet.
  * Os outros atributos são
    *  diamantes, que ele vai ganhar jogando.
    * e idade que aumenta a cada ação realizada, ambos iniciando em 0.
* Comendo, Jogando, Dormindo e tomando banho
  * Cada operação causa aumento e reduções nos atributos.
  * Nenhum atributo pode passar do máximo ou ir abaixo de 0.
* Morrendo
  * Se algum atributo chegar a 0, o pet morre e nenhuma ação pode ser feita a não ser mostrar os dados.

### Shell
```
"$init <Int> t, <Int>  u, <Int> v" inicia energia, saciedade e limpeza de um novo bichinho.
"$show" mostra os parâmetros do Pet na seguinte ordem:
    Energia/Max, Saciedade/Max, Limpeza/Max, Diamantes, Idade.
"$play" altera em -2 energia, -1 saciedade, -3 limpeza, +1 diamante, +1 idade.
"$eat" altera em -1 a energia, +4 a saciedade, -2 a limpeza, +0 diamantes, +1 a idade.
"$sleep" aumenta energia ao máximo, perde 1 de saciedade e idade aumenta do número de turnos que o pet dormiu.
"$clean" alteram em -3 energia, -1 na saciedade, MAX na limpeza, +0 diamantes, +2 na idade.
"$end" finaliza o programa.
