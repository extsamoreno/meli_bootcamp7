package com.example.demo.services.Class;

import com.example.demo.model.Dentist;
import com.example.demo.repositories.IDentistRepository;
import com.example.demo.services.Interface.IDentistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DentistService  implements IDentistService {

    IDentistRepository iDentistRepository;

    @Override
    public void createDentist(Dentist dentist){
        iDentistRepository.save(dentist);
    }
}
