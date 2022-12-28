
import java.util.LinkedList;
import java.util.Objects;

public class Trampoline {
    protected LinkedList<Kid> brincando;
    protected LinkedList<Kid> esperando;

    public Trampoline() {
        esperando = new LinkedList<>();
        brincando = new LinkedList<>();
    }

    private static int search(String name, LinkedList<Kid> kids){
        int i = -1;
        for(Kid kid : kids){
            if (Objects.equals(kid.getName(), name)) {
                i = kids.indexOf(kid);
                break;
            }
            else i = -1;
        }
        return i;
    }

    private static Kid removeFromList(String name, LinkedList<Kid> kids){
        int i = search(name,kids);
        if(i != -1){
            Kid temp = kids.get(i);
            kids.remove(i);
            return temp;
        }
        return null;
        // Feito.
    }

    public void arrive(Kid kid){
        esperando.offerFirst(kid);
    }

    public void enter(){
        if(esperando.isEmpty()){
            return;
        }
        brincando.offerFirst(esperando.removeLast());
    }

    public void leave(){
        if(!brincando.isEmpty()){
            esperando.offerFirst(brincando.removeLast());
        }
    }

    public Kid removeKid(String nome){
        Kid temp = removeFromList(nome, esperando);
        if(temp == null){
            return removeFromList(nome, brincando);
        }
        return temp;
    }

    @Override
    public String toString() {
        return esperando + " => " + brincando;
    }
}