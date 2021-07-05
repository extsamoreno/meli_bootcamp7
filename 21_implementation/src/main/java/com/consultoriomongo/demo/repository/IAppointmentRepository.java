package com.consultoriomongo.demo.repository;


import com.consultoriomongo.demo.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepository extends MongoRepository<Appointment, String>{

}
