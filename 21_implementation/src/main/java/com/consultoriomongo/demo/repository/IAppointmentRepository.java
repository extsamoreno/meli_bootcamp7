package com.consultoriomongo.demo.repository;


import com.consultoriomongo.demo.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAppointmentRepository extends MongoRepository<Appointment, String>{

    @Query("{'doctor.name' : ?0}")
    List<Appointment> findAppointmentByDoctorName(String name);

    List<Appointment> findAppointmentByStatus(String status);

}
