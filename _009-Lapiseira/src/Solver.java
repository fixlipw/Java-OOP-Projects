
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;


class Lead { //todo
    private final float thickness;      //calibre
    private final String hardness;      //dureza
    private int size;                   //tamanho em mm

    public Lead(float thickness, String hardness, int size) { //todo
        this.thickness = thickness;
        this.hardness = hardness;
        this.size = size;
    }

    public float getThickness() { //todo
        return thickness;
    }

    public String getHardness() { //todo
        return hardness;
    }

    public int getSize() { //todo
        return size;
    }

    public void setSize(int size) { //todo
        this.size = size;
    }

    public int usagePerSheet() {
        switch (this.getHardness()) {
            case "HB": return 1;
            case "2B": return 2;
            case "4B": return 4;
            default: return 6;
        }
    }

    public String toString() {
        DecimalFormat form = new DecimalFormat("0.0");
        return form.format(thickness) + ":" + hardness + ":" + size;
    }
}


class Pencil { //todo
    private final float thickness;
    private Lead tip;

    public Pencil(float thickness) { //todo
        this.thickness = thickness;
        this.tip = null;
    }

    public float getThickness() { //todo
        return this.thickness;
    }

    public boolean hasGrafite() { //todo
        return this.tip != null;
    }

    public void insert(Lead grafite) { //todo
        if(grafite.getThickness() == this.getThickness()){
            if(!this.hasGrafite()){
                this.tip = grafite;
                return;
            }
            System.out.println("fail: ja existe grafite");
        }
        else{
            System.out.println("fail: calibre incompatível");
        }
    }

    public void remove() { //todo
        this.tip = null;
    }

    public void writePage() { //todo
        if(this.hasGrafite()){
            if(this.tip.getSize() <= 10){
                System.out.println("warning: grafite com tamanho insuficiente para escrever");
            }
            else if(this.tip.getSize()-this.tip.usagePerSheet() < 10){
                System.out.println("fail: folha incompleta");
                this.tip.setSize(10);
            }
            else{
                this.tip.setSize(this.tip.getSize()-this.tip.usagePerSheet());
            }
        }
        else{
            System.out.println("warning: não há grafite");
        }
    }

    public String toString() {
        String saida = "calibre: " + thickness + ", grafite: ";
        if (tip != null)
            saida += "[" + tip + "]";
        else
            saida += "null";
        return saida;
    }
}

public class Solver {

    static Pencil lap = new Pencil(0.5f);
    public static void main(String[] args) {
        chain.put("init",   () -> lap = new Pencil(Float.parseFloat(ui.get(1))));
        chain.put("insert", () -> lap.insert(new Lead(Float.parseFloat(ui.get(1)), ui.get(2), Integer.parseInt(ui.get(3)))));
        chain.put("remove", () -> lap.remove());
        chain.put("write",  () -> lap.writePage());
        chain.put("show",   () -> System.out.println(lap.toString()));

        execute(chain, ui);
    }

    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Runnable> chain = new HashMap<>();
    static ArrayList<String> ui = new ArrayList<>();

    static void execute(HashMap<String, Runnable> chain , ArrayList<String> ui) {
        do {
            ui.clear();
            String line = scanner.nextLine();
            Collections.addAll(ui, line.split(" "));
            System.out.println("$" + line);
            if (chain.containsKey(ui.get(0))) {
                chain.get(ui.get(0)).run();
            } else {
                System.out.println("fail: comando invalido");
            }
        } while (!ui.get(0).equals("end"));
    }
}