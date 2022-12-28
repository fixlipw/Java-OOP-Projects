package br.com.crudProject;

import br.com.crudProject.dao.DespesaDAO;
import br.com.crudProject.model.Categoria;
import br.com.crudProject.model.Despesa;
import java.time.LocalDate;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {

        DespesaDAO despesaDAO = new DespesaDAO();
        despesaDAO.findById(3).ifPresent(System.out::println);
        despesaDAO.delete(3);
    }
}
