# Relógio

O objetivo dessa atividade é implementar um relógio digital.
* Pode-se setar e mostrar as horas do relógio.
* Pode-se iterar o horário de relógio em 1 segundo.

### Recursos
* Iniciando
  * O relógio inicia com hora, minuto e segundo setados como 0.
* Setar
  * Passando horas, minutos e segundos válidos.
    * Caso não, emite uma mensagem de erro.
* Mostrar
  * Imprime na tela o horário atual.
* Próximo
  * Itera os segundos em 1 segundo.
    * Caso necessário, horas e minutos também serão iterados.

### Shell
```
"$set <Int> h, <Int> m, <Int> s" inicia hora, minuto e segundo de um novo relógio.
"$next" itera o relógio em 1 segundo
"$show" imprime o horário atual na tela.
"$end" finaliza o programa.
