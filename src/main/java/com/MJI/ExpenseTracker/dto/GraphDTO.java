package com.MJI.ExpenseTracker.dto;

import com.MJI.ExpenseTracker.entity.Expense;
import com.MJI.ExpenseTracker.entity.Income;
import lombok.Data;

import java.util.List;

@Data
public class GraphDTO {


    private List<Expense> expenseList;

    private List<Income> incomeList;
}
