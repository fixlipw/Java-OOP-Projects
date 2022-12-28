import java.util.Scanner;

class Car{
    public int pass;        // Passageiros
    public int passMax;     // limite de Passageiros
    public int gas;         // tanque
    public int gasMax;      // limite do tanque
    public int km;          // quantidade de quilometragem
    
    public Car() {
        gas = 0;
        pass = 0;
        km = 0;
        
        passMax = 2;
        gasMax = 100;
    }
    public String toString(){
        return "pass: " +this.pass+ ", gas: " +this.gas+ ", km: " +this.km;
    }
    public void enter(){
        if(pass < passMax){
            this.pass++;
        }
        else{
            System.out.println("fail: limite de pessoas atingido");
        }
    }
    public void leave(){
        if(pass != 0){
            this.pass--;
        }
        else{
            System.out.println("fail: nao ha ninguem no carro");
        }
    }
    public void fuel(int gas){
        if(gas >= this.gasMax){
            this.gas = this.gasMax; 
        }
        else if(this.gas + gas >= gasMax){
            this.gas = this.gasMax;
        }
        else{
            this.gas += gas;
        }
    }
    public void drive (int km){
        if(this.pass == 0){
            System.out.println("fail: nao ha ninguem no carro");
        }
        else if(this.gas > 0 && this.gas < km){
            System.out.printf("fail: tanque vazio apos andar %d km\n", this.gas);
            this.km += km - (km - this.gas);
            this.gas = 0;
        }
        else if(this.gas == 0){
            System.out.println("fail: tanque vazio");
        }
        else{
            this.gas -= km;
            this.km += km;
        }
    }
}

class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car();

        label:
        while(true) {
            String line = scanner.nextLine();   // Recebe uma frase;
            String[] ui = line.split(" ");      // Separa cada string e aloca em um espaço do vetor;
            System.out.println("$" + line);     // Imprime o comando shell;

            switch (ui[0]) {
                case "end":            // O "ui[0].equals()" compara a string dentro da vareavel com a passada por parametro;
                    break label;
                case "enter":
                    car.enter();
                    break;
                case "leave":
                    car.leave();
                    break;
                case "show":
                    System.out.println(car);
                    break;
                case "drive": //km
                    car.drive(Integer.parseInt(ui[1]));     // O "Integer.parseInt()" transforma string em inteiro;

                    break;
                case "fuel": //gas
                    car.fuel(Integer.parseInt(ui[1]));
                    break;
                default:
                    System.out.println("fail: comando invalido");
                    break;
            }
        }
        scanner.close();    // Fecha a classe scanner;
    }
}