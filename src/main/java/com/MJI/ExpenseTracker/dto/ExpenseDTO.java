package com.MJI.ExpenseTracker.dto; //DTO (Data Transfer Object) Transfiere los datos de las variables
                                    //entre las capas del proyecto

import lombok.Data;

import java.time.LocalDate;

@Data // Genera automáticamente los métodos getters y setters
public class ExpenseDTO {

    private Long id;

    private String title;

    private String description;

    private String category;

    private LocalDate date;

    private Integer amount;
}
