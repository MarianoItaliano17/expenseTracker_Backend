package com.MJI.ExpenseTracker.repository;

import com.MJI.ExpenseTracker.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}
