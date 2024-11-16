package com.MJI.ExpenseTracker.services.expense;

import com.MJI.ExpenseTracker.dto.ExpenseDTO;
import com.MJI.ExpenseTracker.entity.Expense;
import com.MJI.ExpenseTracker.repository.ExpenseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImp implements ExpenseService{

    private final ExpenseRepository expenseRepository;

    public Expense postExpense(ExpenseDTO expenseDTO){
        // Recibe los datos del gasto (DTO) y crea un nuevo registro en la base de datos.
        return saveOrUpdateExpense(new Expense(), expenseDTO); //Mapea y guarda la info
    }

    private Expense saveOrUpdateExpense(Expense expense, ExpenseDTO expenseDTO){
        // Mapea los datos del DTO a la entidad y los guarda en la base de datos.
        expense.setTitle(expenseDTO.getTitle());
        expense.setDate(expenseDTO.getDate());
        expense.setAmount(expenseDTO.getAmount());
        expense.setCategory(expenseDTO.getCategory());
        expense.setDescription(expenseDTO.getDescription());

        return expenseRepository.save(expense); // Guarda o actualiza en la base de datos.
    }

    public Expense updateExpense(Long id, ExpenseDTO expenseDTO){
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
            return saveOrUpdateExpense(optionalExpense.get(), expenseDTO);
        } else{
            throw new EntityNotFoundException("Expense is not present with id: " + id);
        }
    }

    public List<Expense> getAllExpense(){
        return expenseRepository.findAll().stream().sorted(Comparator.comparing(Expense::getDate).reversed()).
                collect(Collectors.toList());
    }

    public Expense getExpenseById(Long id){
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
            return optionalExpense.get();
        } else {
            throw new EntityNotFoundException("Expense is not present with id: " + id);
        }
    }

    public void deleteExpense(Long id){
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
            expenseRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Expense is not with id: " + id);
        }
    }
}
