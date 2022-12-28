package br.com.crudProject.model;

import java.time.LocalDate;

public class Despesa {

    private long id;
    private String description;
    private LocalDate date;
    private double value;
    private Categoria category;

    @Override
    public String toString() {
        return  "id= " + id +
                ", description= '" + description + '\'' +
                ", date= " + date +
                ", value= " + value +
                ", category= " + category;
    }

    public Despesa(long id, String description, LocalDate date, double value, Categoria category) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.value = value;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }
}
