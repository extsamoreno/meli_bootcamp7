package com.meli.AppConsultorioMySQL.repositories;

import com.meli.AppConsultorioMySQL.models.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepository extends JpaRepository<AppointmentEntity,Long> {
}
