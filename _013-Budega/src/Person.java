

public class Person {
    private String nome;

    public Person(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String toString(){
        return this.nome;
    }
}