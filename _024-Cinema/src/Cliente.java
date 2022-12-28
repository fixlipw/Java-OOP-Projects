
public class Cliente {
    private final String fone;
    private final String id;

    public Cliente(String fone, String id){
        this.fone = fone;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + ":" + fone;
    }
}