import java.util.*;
class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Topic topic = new Topic(0, 0);
        label:
        while(true){
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String[] ui = line.split(" ");
            switch (ui[0]) {
                case "end":
                    break label;
                case "init":    //capacity qtdPriority
                    topic = new Topic(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
                    break;
                case "show":
                    System.out.println(topic);
                    break;
                case "in":
                    topic.insert(new Pass(ui[1], Integer.parseInt(ui[2])));
                    break;
                case "out":   //value value
                    topic.remove(ui[1]);
                    break;
                default:
                    System.out.println("fail: comando invalido");
                    break;
            }
        }
        scanner.close();
    }
}