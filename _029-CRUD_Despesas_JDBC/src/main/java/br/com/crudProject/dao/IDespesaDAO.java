package br.com.crudProject.dao;

import br.com.crudProject.model.Categoria;
import br.com.crudProject.model.Despesa;

import java.util.List;
import java.util.Optional;

public interface IDespesaDAO {

    Despesa save(Despesa despesa);
    Despesa update(Despesa despesa);
    void delete(long id);
    List<Despesa> findAll();
    Optional<Despesa> findById(long id);
    List<Despesa> findByCategory(Categoria category);
}
