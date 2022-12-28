

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;


class MediaNotas{

    public final ArrayList<Double> notas = new ArrayList<>();

    public void addNota(double nota){
        notas.add(nota);
    }
    public void removeNota(int index){
        notas.remove(index);
    }
    public void mudaNota(int index, double valor){
        notas.set(index,valor);
    }
    public double maiorNota(){
        // double t = 0;
        // for(double x : notas){
        //     if(x>t){
        //         t = x;
        //     }
        // }
        // return t;
        return notas.stream().mapToDouble(i -> i).max().orElse(-1);
    }
    public double menorNota(){
        // double t = 10;
        // for(double x : notas){
        //     if(x<t){
        //         t = x;
        //     }
        // }
        // return t;
        return notas.stream().mapToDouble(i -> i).min().orElse(-1);
    }
    double media(){
        // double t = 0;
        // for(double x : notas) t+=x;
        // return t/(double)notas.size();
        double media = notas.stream().mapToDouble(i -> i).sum();
        return media / notas.size();
    }
    void parametriza(){
        double t = maiorNota();
        notas.replaceAll(aDouble -> (aDouble / t) * 10);
    }
    public String toString(){
        StringBuilder o = new StringBuilder("[");
        for(int i = 0; i < notas.size(); i++){
            if(i == 0){
                o.append(String.format("%.2f", notas.get(i)));
            }
            else{
                o.append(String.format(", %.2f", notas.get(i)));
            }
        }
        o.append("]");
        return o.toString();
    }

}
class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MediaNotas m = new MediaNotas();

        label:
        while(true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            System.out.println("$" + line);
            switch (ui[0]) {
                case "end":
                    break label;
                case "addNota":
                    m.addNota(Double.parseDouble(ui[1]));
                    break;
                case "removeNota":
                    m.removeNota(Integer.parseInt(ui[1]));
                    break;
                case "maiorNota":
                    System.out.println(m.maiorNota());
                    break;
                case "menorNota":
                    System.out.println(m.menorNota());
                    break;
                case "media":
                    System.out.printf(Locale.US, "%.2f\n", m.media());
                    break;
                case "parametriza":
                    m.parametriza();
                    break;
                case "show":
                    System.out.println(m);
                    break;
                default:
                    System.out.println("fail: comando invalido");
                    break;
            }
        }
        scanner.close();
    }
}