package com.MJI.ExpenseTracker.services.stats;

import com.MJI.ExpenseTracker.dto.GraphDTO;
import com.MJI.ExpenseTracker.dto.StatsDTO;

public interface StatsService {

    GraphDTO getChartData();

    StatsDTO getStats();
}
