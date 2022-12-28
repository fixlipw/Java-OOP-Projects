

import java.util.Scanner;
import java.util.ArrayList;
class ComputaSequencia{

    ArrayList<Integer> vetor= new ArrayList<>();

    public void cadastra(int valor){
        if(valor != 0){
            vetor.add(valor);
        }
        else{
            vetor.remove(vetor.size()-1);
        }
    }

    public int computa(){
        // int soma = 0;
        // for(int x : vetor){
        //     soma += x;
        // }
        // return soma;
        return vetor.stream().mapToInt(i -> i).sum();
    }

    public String toString(){
        return String.format("valores = "+vetor.toString());
    }
}

class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComputaSequencia sequencia = new ComputaSequencia();

        label:
        while(true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            System.out.println("$" + line);
            switch (ui[0]) {
                case "end":
                    break label;
                case "cadastra":
                    sequencia.cadastra(Integer.parseInt(ui[1]));
                    break;
                case "computa":
                    System.out.println(sequencia.computa());
                    break;
                case "show":
                    System.out.println(sequencia);
                    break;
                default:
                    System.out.println("fail: comando invalido");
                    break;
            }
        }
        scanner.close();
    }
}