# Lapiseira

O objetivo dessa atividade é implementar uma lapiseira que contém um grafite.

* Cria lapiseiras, insere e remove grafites.
* Escreve folhas gastando grafite.

### Recursos
* Iniciar lapiseira
  * Inicia uma lapiseira de determinado calibre sem grafite no bico.
* Inserir grafite
  * Insere um grafite passando
    * o calibre: float
    * a dureza: string
    * o tamanho em mm: integer
  * Não aceita grafite com calibre incompaível.
* Remover grafite
  * Retira o grafite se houver algum.
* Escrever folha
  * Não é possível escrever se não há grafite ou o grafite tem tamanho menor, ou igual a 10 mm.
  * Quanto mais macio o grafite, mais rapidamente ele se acaba. Para simplificar, use a seguinte regra: 
    * Grafite HB: 1mm por folha. 
    * Grafite 2B: 2mm por folha. 
    * Grafite 4B: 4mm por folha. 
    * Grafite 6B: 6mm por folha.
  * O último centímetro de um grafite não pode ser aproveitado, quando o grafite estiver com 10 mm, não é mais possível escrever.
  * Se não houver grafite suficiente para terminar a folha, uma mensagem informará que o texto ficou incompleto.

### Shell
````
"$init <Float> a" cria uma nova lapiseira de calibre 'a'.
"$insert <Float> a, <String> b, <Int> c" insere um grafite de calibre 'a', de dureza 'b' e tamanho 'c' mm.
"$remove" remove o grafite inserido na lapiseira.
"$write" escreve uma página com a lapiseira.
"$end" finaliza o programa.
