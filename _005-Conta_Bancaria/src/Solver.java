
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

class Conta {
    private final String titular;
    private final int numero;
    private double saldo;
    private static int totalContas = 0;

    public Conta(String titular){
        this.titular=titular;
        numero=totalContas;
        saldo=0;
        totalContas++;
    }
    private void deposita(double valor){
        saldo+=valor;
    }
    public static void deposita(Conta c, double valor){
        c.deposita(valor);
    }
    private void saca(double valor){
        if(this.getSaldo() < valor){
            System.out.printf("Conta ficou zerada após o saque %.2f reais\n", getSaldo());
            saldo = 0;
        }
        else {
            saldo -= valor;
        }
    }
    public static void saca(Conta c, double valor){
        c.saca(valor);
    }
    private void transfere(Conta c, double valor){
        c.deposita(valor);
    }
    public static void transfere(Conta origem, Conta destino, double valor){
        origem.transfere(destino,valor);
        origem.saldo-=valor;
    }
    public String toString(){
        return String.format("Nro da conta: %d, Titular: %s, Saldo: %.2f", numero, titular, saldo);
    }
    double getSaldo(){
        return saldo;
    }
}

class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault ( Locale.US ) ;

        ArrayList<Conta> contas = new ArrayList<>();

        label:
        while(true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            System.out.println("$" + line);

            switch (ui[0]) {
                case "init":
                    contas.add(new Conta(ui[1]));
                    break;
                case "end":
                    break label;
                case "deposita": {
                    try{
                        int nro = Integer.parseInt(ui[1]);
                        double valor = Double.parseDouble(ui[2]);
                        Conta.deposita(contas.get(nro), valor);
                        break;
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Conta não especificada\nErro: "+e);
                        break;
                    }

                }
                case "saca": {
                    try{
                        int nro = Integer.parseInt(ui[1]);
                        double valor = Double.parseDouble(ui[2]);
                        Conta.saca(contas.get(nro), valor);
                        break;
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Conta não especificada\nErro: "+e);
                        break;
                    }

                }
                case "transfere": {
                    try{
                        int origem = Integer.parseInt(ui[1]);
                        int destino = Integer.parseInt(ui[2]);
                        double valor = Double.parseDouble(ui[3]);
                        Conta.transfere(contas.get(origem), contas.get(destino), valor);
                        break;
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Erro na passagem de parâmetos\nErro: "+e);
                        break;
                    }

                }
                case "show":
                    try{
                        int i = Integer.parseInt(ui[1]);
                        System.out.println(contas.get(i));
                        break;
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Conta não especificada\nErro: "+e);
                        break;
                    }

                default:
                    System.out.println("fail: comando invalido");
                    break;
            }
        }
        scanner.close();
    }
}