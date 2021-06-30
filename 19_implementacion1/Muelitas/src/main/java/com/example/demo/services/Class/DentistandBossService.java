package com.example.demo.services.Class;

import com.example.demo.model.Boss;
import com.example.demo.model.Dentist;
import com.example.demo.repositories.IBossesRepository;
import com.example.demo.repositories.IConsultoryRepository;
import com.example.demo.repositories.IDentistRepository;
import com.example.demo.services.Interface.IConsultoryService;
import com.example.demo.services.Interface.IDentistandBossService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DentistandBossService implements IDentistandBossService {
    @Autowired
    CrudRepository<Dentist, Integer> dentists;

    @Autowired
    CrudRepository<Boss, Integer> bosses;


    @Override
    public void createDentistandBoss(Integer dentista, Integer bosss) {
        Optional<Dentist> dentist = dentists.findById(dentista);
        Optional<Boss> bos = bosses.findById(bosss);
        dentist.get().getBosses().add(bos.get());
        dentists.save(dentist.get());

    }
}
