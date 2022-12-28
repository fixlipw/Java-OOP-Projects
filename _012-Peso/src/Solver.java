

import java.util.Scanner;
import java.util.Locale;

@SuppressWarnings("ALL")
enum Planeta {
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27  , 7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);
    private final double mass;   // in kilograms
    private final double radius; // in meters
    Planeta(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public static final double G = 6.67300e-11;

    double forcaGravitacional() {
        return (G * this.mass)/Math.pow(this.radius,2);
    }

    double pesoSuperficie(double otherMass) {
        return otherMass/forcaGravitacional();
    }
}

class Pessoa{
    private final String nome;
    private final double mass;
    private final Planeta p;

    Pessoa(String nome, double mass, Planeta p){
        this.nome = nome;
        this.mass = mass;
        this.p = p;
    }

    public double massaEquivalente(Planeta otherPlanet){
        System.out.printf("A forca gravitacional no planeta %s é %.2f\n", otherPlanet, otherPlanet.forcaGravitacional());
        return otherPlanet.forcaGravitacional() * (this.mass / p.forcaGravitacional());
    }

    public String toString(){
        return String.format("nome: %s mass: %.2f planeta: %s", this.nome, this.mass, this.p);
    }
}

class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pessoa p = new Pessoa("", 0, Planeta.EARTH);

        label:
        while(true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            System.out.println("$" + line);
            switch (ui[0]) {
                case "end":
                    break label;
                case "init":
                    p = new Pessoa(ui[1],
                            Double.parseDouble(ui[2]),
                            Planeta.valueOf(ui[3]));
                    break;
                case "massaEquivalente":
                    System.out.printf(Locale.US, "%.2f\n", p.massaEquivalente(Planeta.valueOf(ui[1])));
                    break;
                case "show":
                    System.out.println(p);
                    break;
                default:
                    System.out.println("fail: comando invalido");
                    break;
            }
        }
        scanner.close();
    }
}