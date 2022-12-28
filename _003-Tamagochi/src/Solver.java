
import java.util.Scanner;

class Pet{
    private final int energyMax;
    private final int hungryMax;
    private final int cleanMax;
    private int energy, hungry, shower;
    private int diamonds;
    private int age;
    private boolean alive;

    // Atribui o valor de energia
    // Se o valor ficar abaixo de 0, o pet morre de fraqueza
    // Garanta que os valores ficarão no interalo 0 - max
    // Use esse modelo para fazer os outros métodos set

    void setEnergy(int value){
        if(value <= 0){
            this.energy = 0;
            System.out.println("fail: pet morreu de fraqueza");
            this.alive = false;
        }
        else this.energy = Math.min(value, this.energyMax);
    }

    public void setHungry(int value){
        if(value <= 0){
            this.hungry = 0;
            System.out.println("fail: pet morreu de fome");
            this.alive = false;
        }
        else this.hungry = Math.min(value, this.hungryMax);
    }

    void setClean(int value){
        if(value <= 0){
            this.shower = 0;
            System.out.println("fail: pet morreu de sujeira");
            this.alive = false;
        }
        else this.shower = Math.min(value, this.cleanMax);
    }

    public Pet(int energy, int hungry, int shower){
        this.energy = energyMax = energy;
        this.hungry = hungryMax = hungry;
        this.shower = cleanMax = shower;
        this.alive = true;
    }

    public String toString(){
        return String.format("E:%d/%d, S:%d/%d, L:%d/%d, D:%d, I:%d", this.energy,
                this.energyMax, this.hungry, this.hungryMax, this.shower, this.cleanMax,
                this.diamonds, this.age);
    }

    private boolean testAlive(){
        if(this.alive)
            return true;
        else
            System.out.println("fail: pet esta morto");
        return false;
    }
    // Invoca o método testAlive para verificar se o pet esta vivo
    // Se estiver vivo, altere os atributos utilizando os métodos set e get
    public void play(){
        if(!testAlive())
            return;
        setEnergy(getEnergy() - 2);
        setHungry(getHungry() - 1);
        setClean(getClean() - 3);
        diamonds += 1;
        age += 1;
    }

    public void shower(){
        if(!testAlive())
            return;
        setEnergy(getEnergy() - 3);
        setHungry(getHungry() - 1);
        setClean(this.energyMax);
        age += 2;
    }

    public void eat(){
        if(!testAlive())
            return;
        setEnergy(getEnergy() - 1);
        setHungry(getHungry() + 4);
        setClean(getClean() - 2);
        age += 1;
    }

    public void sleep(){
        if(!testAlive())
            return;
        if(this.energyMax - this.energy >= 5){
            age += this.energyMax - this.energy;
            setEnergy(this.energyMax);
            setHungry(getHungry() - 1);
        }
        else
            System.out.println("fail: nao esta com sono");
    }
    //Métodos GET
    int getClean(){
        return this.shower;
    }

    int getHungry(){
        return this.hungry;
    }

    int getEnergy(){
        return this.energy;
    }

    int getEnergyMax(){
        return this.energyMax;
    }

    int getCleanMax(){
        return this.cleanMax;
    }

    int getHungryMax(){
        return this.hungryMax;
    }

}

class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pet pet = new Pet(0, 0, 0);
        label:
        while(true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String[] ui = line.split(" ");
            switch (ui[0]) {
                case "end":
                    break label;
                case "show":
                    System.out.println(pet);
                    break;
                case "init":
                    int energy = Integer.parseInt(ui[1]);
                    int hungry = Integer.parseInt(ui[2]);
                    int shower = Integer.parseInt(ui[3]);
                    pet = new Pet(energy, hungry, shower);
                    break;
                case "play":
                    pet.play();
                    break;
                case "eat":
                    pet.eat();
                    break;
                case "clean":
                    pet.shower();
                    break;
                case "sleep":
                    pet.sleep();
                    break;
                default:
                    System.out.println("fail: comando invalido");
                    break;
            }
        }
        scanner.close();
    }
}