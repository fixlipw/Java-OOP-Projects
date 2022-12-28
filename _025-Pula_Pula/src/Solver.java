
import java.util.Scanner;

class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Trampoline tramp = new Trampoline();
        label:
        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String[] ui = line.split(" ");
            switch (ui[0]) {
                case "end":
                    break label;
                case "arrive":  // name age
                    tramp.arrive(new Kid(ui[1], Integer.parseInt(ui[2])));
                    break;
                case "enter":
                    tramp.enter();
                    break;
                case "leave":
                    tramp.leave();
                    break;
                case "remove": // name
                    tramp.removeKid(ui[1]);
                    break;
                case "show":
                    System.out.println(tramp);
                    break;
                default:
                    System.out.println("fail: comando invalido");
                    break;
            }
        }
        scanner.close();
    }
}