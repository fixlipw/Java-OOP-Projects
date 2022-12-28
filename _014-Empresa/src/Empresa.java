
import java.util.ArrayList;

public class Empresa{

    public ArrayList<Empregado> funcionarios;

    Empresa(){
        funcionarios = new ArrayList<>();
    }

    public void adicionaEmpregado(Empregado e){
        funcionarios.add(e);
    }

    public void mostraEmpregado(){
        System.out.println("Empresa: ");
        for(Empregado e : funcionarios){
            System.out.println(e);
        }
    }

    public double calculaFolha(){
        double pagamento = 0;
        for(Empregado e : funcionarios){
            pagamento += e.pagamento();
        }
        return pagamento;
    }

}