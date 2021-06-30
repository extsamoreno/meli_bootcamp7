package com.example.practica_1_integration;

import com.example.practica_1_integration.model.Patient;
import com.example.practica_1_integration.model.Professional;
import com.example.practica_1_integration.model.Turn;
import com.example.practica_1_integration.repositories.IPatientRepository;
import com.example.practica_1_integration.repositories.IProfessionalRepository;
import com.example.practica_1_integration.repositories.IServiceRepository;
import com.example.practica_1_integration.repositories.ITurnRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class Bootstrap implements InitializingBean {

    @Autowired
    IPatientRepository patientRepository;

    @Autowired
    IProfessionalRepository professionalRepository;

    @Autowired
    IServiceRepository serviceRepository;

    @Autowired
    ITurnRepository turnRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        loadPatient();
        System.out.println("Loaded patient");
        loadProfessional();
        System.out.println("Loaded professional");
        loadService();
        System.out.println("Loaded service");
        loadTurns();
        System.out.println("Loaded turn");

        turnRepository.findByProfessional_idAndDate(1L, new GregorianCalendar(2021, Calendar.JUNE, 5).getTime()).forEach(System.out::println);
        System.out.println("/n");
        turnRepository.findByProfessional_id(1L).forEach(System.out::println);
        System.out.println("/n");
        turnRepository.findByProfessional_idAndDate(1L, new GregorianCalendar(2021, Calendar.JUNE, 2).getTime()).forEach(System.out::println);
        System.out.println("/n");
        //getPatientsByProfessionalAndDate
        turnRepository.getPatientsByProfessionalAndDate(1L, new GregorianCalendar(2021, Calendar.JUNE, 5).getTime()).forEach(System.out::println);
        System.out.println("es este");

        turnRepository.getPatientsByDate(new GregorianCalendar(2021, Calendar.JUNE, 5).getTime()).forEach(System.out::println);
        System.out.println("es este otro");

        turnRepository.getProfessionalWithMoreThantTwoTurnsInADate(new GregorianCalendar(2021, Calendar.JUNE, 3).getTime()).forEach(System.out::println);
        System.out.println("es este otro otro");

        turnRepository.getTurnsByStateFinished().forEach(System.out::println);
        System.out.println("turnos finalizados");

        turnRepository.getTurnsByState("Canceled").forEach(System.out::println);
        System.out.println("turnos cancelados");

        turnRepository.findAllByState("Canceled").forEach(System.out::println);
        System.out.println("turnos cancelados con el find all");

        turnRepository.getTurnsByStateAndDate("Pending", new GregorianCalendar(2021, Calendar.JUNE, 5).getTime()).forEach(System.out::println);
        System.out.println("turnos getTurnsByStateAndDate");

        turnRepository.getTurnsByStatePendingOfADate(new GregorianCalendar(2021, Calendar.JUNE, 5).getTime()).forEach(System.out::println);
        System.out.println("turnos getTurnsByStatePendingOfADate");

        //findAllByStateAndDate
        turnRepository.findAllByStateAndDate("Pending", new GregorianCalendar(2021, Calendar.JUNE, 5).getTime()).forEach(System.out::println);
        System.out.println("turnos findAllByStateAndDate");

        //Faltan 5 en adelante
    }

    private void loadPatient() {
        for (int i = 0; i < 5; i++) {
            Patient patient = new Patient();
            patient.setName("Genaro".concat(i + ""));
            patient.setSurname("Loprete".concat(i + ""));
            patientRepository.save(patient);
        }
    }

    private void loadProfessional() {
        for(int i = 0; i < 5; i++) {
            Professional professional = new Professional();
            professional.setName("Gustavo".concat(i + ""));
            professional.setSurname("Sosa".concat(i + ""));
            professional.setProfesion("Odontologo");
            professional.setEnrollment("123a".concat(i + ""));

            professionalRepository.save(professional);
        }
    }

    private void loadService() {
        for(int i = 0; i < 5; i++) {
            com.example.practica_1_integration.model.Service service = new com.example.practica_1_integration.model.Service();
            service.setDescription("Limpieza de ".concat(i + "").concat(" dientes"));
            serviceRepository.save(service);
        }
    }

    private void loadTurns() {
        for(int i = 1; i <= 5; i++) {
            Turn turn = new Turn();
            turn.setDate(new GregorianCalendar(2021, Calendar.JUNE, 5).getTime());
            turn.setState("Pending");
            turn.setPatient(patientRepository.getById((long) i));
            turn.setProfessional(professionalRepository.getById((long) i));
            turn.setService(serviceRepository.getById((long) i));
            turnRepository.save(turn);
        }

        for(int i = 1; i <= 4; i++) {
            Turn turn = new Turn();
            turn.setDate(new GregorianCalendar(2021, Calendar.JUNE, 3).getTime());
            turn.setState("Finished");
            turn.setPatient(patientRepository.getById((long) i));
            turn.setProfessional(professionalRepository.getById(1L));
            turn.setService(serviceRepository.getById((long) i));
            turnRepository.save(turn);

            Turn turn2 = new Turn();
            turn2.setDate(new GregorianCalendar(2021, Calendar.JUNE, 3).getTime());
            turn2.setState("Canceled");
            turn2.setPatient(patientRepository.getById((long) i));
            turn2.setProfessional(professionalRepository.getById(2L));
            turn2.setService(serviceRepository.getById((long) i));
            turnRepository.save(turn2);
        }
    }
}
