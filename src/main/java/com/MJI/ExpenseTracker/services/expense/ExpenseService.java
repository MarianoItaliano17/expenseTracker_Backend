package com.MJI.ExpenseTracker.services.expense;

import com.MJI.ExpenseTracker.dto.ExpenseDTO;
import com.MJI.ExpenseTracker.entity.Expense;

import java.util.List;

public interface ExpenseService {

    Expense postExpense(ExpenseDTO expenseDTO);

    List<Expense> getAllExpense();

    Expense getExpenseById(Long id);

    Expense updateExpense(Long id, ExpenseDTO expenseDTO);

    void deleteExpense(Long id);
}
