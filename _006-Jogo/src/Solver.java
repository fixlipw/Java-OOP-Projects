
import java.util.Arrays;
import java.util.Scanner;
import java.util.Locale;


class Jogo{

    private final int numJogadores;
    private final int [] armadilha;
    private final int [] posicao;
    private final boolean [] podeJogar;
    private int numArmadilha = 0;
    private final int numCasas;
    private int prox = 1;
    private boolean fimDoJogo = false;

    public Jogo(int numJogadores, int numCasas){
        this.numJogadores = numJogadores;
        this.numCasas = numCasas;
        posicao = new int[numJogadores];
        podeJogar = new boolean[numCasas];
        armadilha = new int[numCasas+1];
        Arrays.fill(armadilha,1);
        Arrays.fill(posicao,0);
        Arrays.fill(podeJogar,true);
    }

    public void addArmadilha(int t){
        if(numArmadilha < 3){
            armadilha[t] = 0;        // Armazena o indice das armadilhas;
            numArmadilha++;
        }
    }

    public void addMove(int d1, int d2){
        int casas = d1+d2;
        if(!fimDoJogo){
            if(prox > numJogadores){
                prox = 1;
            }
            if (podeJogar[posicao[prox - 1]]) {
                posicao[prox - 1] += casas;
                System.out.println("O jogador " + prox + " vai para a casa " + posicao[prox - 1]);
                if (posicao[prox - 1] > numCasas) {
                    System.out.println("O jogador " + (prox) + " venceu o jogo");
                    fimDoJogo = true;
                    this.prox++;
                    return;
                }
                if (armadilha[posicao[prox - 1]] == 0) {
                    System.out.println("O jogador " + (prox) + " caiu em um armadilha");
                    armadilha[posicao[prox - 1] + casas] = 1;
                    podeJogar[posicao[prox - 1]] = false;
                }
            }
            else {
                System.out.println("O jogador " + (prox) + " passa a vez");
                podeJogar[posicao[prox-1]] = true;
                prox++;
                addMove(d1, d2);
                prox--;
            }
            prox++;
        }
        else {
            System.out.println("O jogo acabou");
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i != posicao.length){
            if(i == posicao.length-1){
                sb.append("PosJogador[").append(i+1).append("] = ").append(posicao[i]);
            }
            else{
                sb.append("PosJogador[").append(i+1).append("] = ").append(posicao[i]).append(('\n'));
            }
            i++;
        }
        return sb.toString()+'\n';
    }

}

class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault ( Locale.US ) ;
        Jogo jogo = new Jogo(0,0);

        label:
        while(true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            System.out.println("$" + line);
            switch (ui[0]) {
                case "init":
                    jogo = new Jogo(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
                    break;
                case "end":
                    break label;
                case "addArmadilha":
                    jogo.addArmadilha(Integer.parseInt(ui[1]));
                    break;
                case "addMove":
                    int d1 = Integer.parseInt(ui[1]);
                    int d2 = Integer.parseInt(ui[2]);
                    jogo.addMove(d1, d2);
                    break;
                case "show":
                    System.out.println(jogo);
                    break;
                default:
                    System.out.println("fail: comando invalido");
                    break;
            }
        }
        scanner.close();
    }
}