
import java.util.ArrayList;
import java.util.Objects;

public class Sala {
    private final ArrayList<Cliente> cadeiras;
    public Sala(int capacidade){
        cadeiras = new ArrayList<>(capacidade);
        for(int i = 0; i < capacidade; i++){
            cadeiras.add(null);
        }
    }

    private int procurar(String nome){
        int i = 0;
        for(Cliente c : cadeiras){
            if(c == null){
                i = -1;
            }
            else if(Objects.equals(c.getId(), nome)){
                i = cadeiras.indexOf(c);
                break;
            }
            else{

                i = -1;
            }
        }
        return i;
    }

    private boolean verificarIndice(int indice){
        return indice >= cadeiras.size();
    }


    public void reservar(String id, String fone, int ind){
        if(verificarIndice(ind)){
            System.out.println("fail: cadeira nao existe");
        }
        else if(cadeiras.get(ind) != null){
            System.out.println("fail: cadeira ja esta ocupada");
        }
        else if(procurar(id) != -1){
            System.out.println("fail: cliente ja esta no cinema");
        }
        else{
            cadeiras.set(ind, new Cliente(fone, id));
        }
    }

    public void cancelar(String id){
        if(procurar(id) == -1){
            System.out.println("fail: cliente nao esta no cinema");
        }
        else{
            cadeiras.set(procurar(id), null);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < cadeiras.size(); i++){
            if(i < cadeiras.size()-1){
                if(cadeiras.get(i) != null) sb.append(cadeiras.get(i)).append(' ');
                else sb.append('-').append(' ');
            }
            else{
                if(cadeiras.get(i) != null) sb.append(cadeiras.get(i));
                else sb.append('-');
            }
        }
        sb.append("]");
        return sb.toString();
    }
}