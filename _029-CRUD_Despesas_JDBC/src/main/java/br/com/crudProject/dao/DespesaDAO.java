package br.com.crudProject.dao;

import br.com.crudProject.infra.ConnectionFactory;
import br.com.crudProject.model.Categoria;
import br.com.crudProject.model.Despesa;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DespesaDAO implements IDespesaDAO{
    @Override
    public Despesa save(Despesa despesa) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO despesas (description, value, date, category) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, despesa.getDescription());
            statement.setDouble(2, despesa.getValue());
            statement.setDate(3, java.sql.Date.valueOf(despesa.getDate()));
            statement.setString(4, despesa.getCategory().toString());
            statement.executeUpdate();

            ResultSet result = statement.getGeneratedKeys();
            result.next();
            long generatedId = result.getLong("id");
            despesa.setId(generatedId);
            System.out.println("Exito ao inserir despesa no id: " + despesa.getId());
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return despesa;
    }

    @Override
    public Despesa update(Despesa despesa) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "UPDATE Despesas SET description = ?, value = ?, date = ?, category = ? WHERE id = ?;";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, despesa.getDescription());
            statement.setDouble(2, despesa.getValue());
            statement.setDate(3, java.sql.Date.valueOf(despesa.getDate()));
            statement.setString(4, despesa.getCategory().toString());
            statement.setLong(5, despesa.getId());
            statement.executeUpdate();

            System.out.println("Exito ao atualizar despesa no id: " + despesa.getId());
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return despesa;
    }

    @Override
    public void delete(long id) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "DELETE FROM Despesas WHERE ID = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1,id);
            statement.executeUpdate();

            System.out.println("Exito ao deletar despesa no id: " + id);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Despesa> findAll() {
        String sql = "SELECT id, description, date, value, category FROM despesas";
        List<Despesa> despesas = new ArrayList<>();

        try(Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                long id = resultSet.getLong("id");
                String description = resultSet.getString("description");
                LocalDate date = resultSet.getDate("date").toLocalDate();
                double value = resultSet.getDouble("value");
                Categoria category = Categoria.valueOf(resultSet.getString("category"));

                despesas.add(new Despesa(id, description, date, value, category));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return despesas;
    }

    @Override
    public Optional<Despesa> findById(long id) {
        String sql = "SELECT id, description, date, value, category FROM despesas WHERE id = ?";
        Despesa despesa = null;
        try(Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                long key = resultSet.getLong("id");
                String description = resultSet.getString("description");
                LocalDate date = resultSet.getDate("date").toLocalDate();
                double value = resultSet.getDouble("value");
                Categoria category = Categoria.valueOf(resultSet.getString("category"));
                despesa = new Despesa(key, description, date, value, category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(despesa);
    }

    @Override
    public List<Despesa> findByCategory(Categoria category) {
        String sql = "SELECT id, description, date, value, category FROM despesas WHERE category = ?";
        List<Despesa> despesas = new ArrayList<>();

        try(Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, category.toString());
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                long id = resultSet.getLong("id");
                String description = resultSet.getString("description");
                LocalDate date = resultSet.getDate("date").toLocalDate();
                double value = resultSet.getDouble("value");
                Categoria _category = Categoria.valueOf(resultSet.getString("category"));

                despesas.add(new Despesa(id, description, date, value, _category));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return despesas;
    }
}
