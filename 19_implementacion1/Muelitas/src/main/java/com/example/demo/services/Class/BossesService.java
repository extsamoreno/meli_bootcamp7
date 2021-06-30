package com.example.demo.services.Class;

import com.example.demo.model.Boss;
import com.example.demo.model.Consultory;
import com.example.demo.repositories.IBossesRepository;
import com.example.demo.repositories.IConsultoryRepository;
import com.example.demo.services.Interface.IBossesService;
import com.example.demo.services.Interface.IConsultoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BossesService implements IBossesService {

    IBossesRepository iBossesRepository;

    @Override
    public void createBoss(Boss boss){
        iBossesRepository.save(boss);
    }
}
