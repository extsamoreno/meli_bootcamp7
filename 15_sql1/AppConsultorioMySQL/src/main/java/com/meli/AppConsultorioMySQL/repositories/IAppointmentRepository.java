package com.meli.AppConsultorioMySQL.repositories;

import com.meli.AppConsultorioMySQL.repositories.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IAppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

    List<AppointmentEntity> findAllByInitBetween(
            Date start,
            Date end);
}
