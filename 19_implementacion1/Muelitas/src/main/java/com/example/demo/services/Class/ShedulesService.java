package com.example.demo.services.Class;

import com.example.demo.model.Shedule;
import com.example.demo.repositories.ISheduleRepository;
import com.example.demo.services.Interface.ISheduleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShedulesService implements ISheduleService {

    ISheduleRepository iSheduleRepository;


    @Override
    public void createShedule(Shedule shedule) {
        iSheduleRepository.save(shedule);
    }
}
