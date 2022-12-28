

import java.util.Scanner;

@SuppressWarnings("ALL")
enum Coin {
    M10(0.10, 1),
    M25(0.25, 2),
    M50(0.50, 3),
    M100(1.00, 4);

    public final double value;
    public final int volume;

    Coin(double value, int volume) {
        this.value = value;
        this.volume = volume;
    }
    public String getDescription() {
        return "Coin: " + value;
    }
    public String toString() {
        return "Coin: " + value + " Volume: " + value;
    }
}

class Item {
    private String description;
    private int volume;

    public Item(String description, int volume){
        this.description = description;
        this.volume = volume;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setVolume(int volume){
        this.volume = volume;
    }
    public int getVolume(){
        return volume;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", volume=" + volume +
                '}';
    }
}
class Pig{
    private String itens = "";
    private double value = 0;
    private int volume = 0;
    private final int volumeMax;
    private boolean broken = false;
    //inicializa o volumeMax
    public Pig(int volumeMax){
        this.volumeMax = volumeMax;
    }
    //se nao estiver quebrado e couber, adicione o value e o volume
    public boolean addCoin(Coin moeda){
        if(isBroken()){
            return false;
        }
        else{
            if(moeda.volume <= (this.volumeMax - this.volume)){
                this.volume += moeda.volume;
                this.value += moeda.value;
                return true;
            }
            else{
                return false;
            }
        }
    }
    //se não estiver quebrado e couber, adicione no volume e na descrição
    public boolean addItem(Item item){
        if(isBroken()){
            return false;
        }
        else{
            if(item.getVolume() <= (this.volumeMax - this.volume)){
                if(this.itens.length() < 1) {
                    this.itens += item.getDescription();
                }
                else{
                    this.itens += ", " + item.getDescription();
                }
                this.volume += item.getVolume();
                return true;
            }
            else{
                return false;
            }
        }
    }
    //quebre o pig
    public boolean breakPig(){
        if(!this.broken){
            this.broken = true;
            return true;
        }
        return false;
    }
    //se estiver quebrado, pegue e retorne o value
    public double getCoins(){
        if(isBroken()){
            return this.value;
        }
        else{
            System.out.println("You must break the pig first");
        }
        return 0;
    }
    //se estiver quebrado, pegue e retorno os itens
    public String getItens(){
        if(isBroken()){
            return this.itens;
        }
        else{
            return "You must break the pig first\n";
        }
    }

    public int getVolume() {
        return this.volume;
    }
    public int getVolumeMax(){
        return this.volumeMax;
    }
    public boolean isBroken(){
        return this.broken;
    }
    //mostre o conteúdo do pig

    @Override
    public String toString() {
        return String.format("I:(%s) M:%.1f V:%d/%d EQ:%b",this.itens,
                this.value,this.volume,this.volumeMax,this.broken);
    }
}

class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pig pig = new Pig(0);

        label:
        while(true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            System.out.println("$" + line);

            switch (ui[0]){
                case "init":
                    pig = new Pig(Integer.parseInt(ui[1]));
                    break;
                case "end":
                    break label;
                case "addCoin":
                    switch (ui[1]) {
                        case "10": pig.addCoin(Coin.M10);
                        case "25": pig.addCoin(Coin.M25);
                        case "50": pig.addCoin(Coin.M50);
                        case "100": pig.addCoin(Coin.M100);
                    }
                    break;
                case "addItem":
                    pig.addItem(new Item(ui[1], Integer.parseInt(ui[2])));
                    break;
                case "getItens":
                    System.out.println(pig.getItens());
                    break;
                case "getCoins":
                    System.out.println(pig.getCoins());
                    break;
                case "show":
                    System.out.println(pig);
                    break;
                case "breakPig":
                    pig.breakPig();
                    break;
                default:
                    System.out.println("fail: comando invalido");
                    break;
            }
        }
        scanner.close();
    }
}