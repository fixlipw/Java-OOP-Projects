

import java.util.ArrayList;

public class Mercantil {

    ArrayList<Person> listaEspera = new ArrayList<>();
    Person[] caixas;

    Mercantil(int qtdCaixas) {
        this.caixas = new Person[qtdCaixas];
    }

    public void chegar(Person p) {
        this.listaEspera.add(p);
    }

    public boolean chamarNoCaixa(int indice) {
        if (this.listaEspera.size() > 0) {
            this.caixas[indice] = this.listaEspera.get(0);
            this.listaEspera.remove(0);
            return true;
        } else {
            System.out.println("fail: fila vazia");
            return false;
        }
    }

    public Person finalizarAtendimento(int indice){
        Person temp = this.caixas[indice];
        this.caixas[indice] = null;
        return temp;
    }

    public String toString(){
        StringBuilder returno = new StringBuilder("|");
        for(int i = 0; i < this.caixas.length; i++) {
            if (this.caixas[i] != null) {
                returno.append(i).append(":").append(this.caixas[i]).append("|");
            } else {
                returno.append(i).append(":-----|");
            }
        }
        returno.append("\nEspera: ").append(this.listaEspera);
        return returno.toString();
    }

}