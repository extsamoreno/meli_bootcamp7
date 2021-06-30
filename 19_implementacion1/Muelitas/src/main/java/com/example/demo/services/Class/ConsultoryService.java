package com.example.demo.services.Class;

import com.example.demo.model.Consultory;
import com.example.demo.repositories.IConsultoryRepository;
import com.example.demo.services.Interface.IConsultoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConsultoryService implements IConsultoryService {

    IConsultoryRepository iConsultoryRepository;


    @Override
    public void createConsultory(Consultory consultory) {
        iConsultoryRepository.save(consultory);
    }
}
