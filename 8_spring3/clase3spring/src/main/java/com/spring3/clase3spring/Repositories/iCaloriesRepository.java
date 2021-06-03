package com.spring3.clase3spring.Repositories;

import com.spring3.clase3spring.Entities.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface iCaloriesRepository {

    CaloriesDTO findCaloriesByFood(String food);
}
