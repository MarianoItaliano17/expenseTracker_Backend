package com.MJI.ExpenseTracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity // Marca esta clase como una entidad de JPA que se mapeará a una tabla en la base de datos.
@Data  // Proporciona automáticamente getters, setters, equals, hashCode y toString mediante Lombok.
public class Expense {

    @Id //Llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El id sera generado automaticamente por la database y autoincrementado,

    private Long id;

    private String title;

    private String description;

    private String category;

    private LocalDate date;

    private Integer amount;

}
