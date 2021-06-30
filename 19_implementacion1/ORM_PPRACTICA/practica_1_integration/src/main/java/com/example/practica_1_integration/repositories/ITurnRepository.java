package com.example.practica_1_integration.repositories;

import com.example.practica_1_integration.model.Patient;
import com.example.practica_1_integration.model.Professional;
import com.example.practica_1_integration.model.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Set;

@Repository
public interface ITurnRepository extends JpaRepository<Turn, Long> {

    Set<Turn> findByProfessional_idAndDate(long professional_id, Date date);

    Set<Turn> findByProfessional_id(long professional_id);

    @Query(value = "select t.patient from Turn t where t.professional.id = :professional_id and t.date = :date")
    Set<Patient> getPatientsByProfessionalAndDate(@Param("professional_id") long professional_id, @Param("date") Date date);

    @Query(value = "select t.patient from Turn t where t.date = :date")
    Set<Patient> getPatientsByDate(@Param("date") Date date);

    @Query(value = "select t.professional from Turn t where t.date = :date group by t.professional having count(t.professional) > 2")
    Set<Professional> getProfessionalWithMoreThantTwoTurnsInADate(@Param("date") Date date);

    @Query(value="select t from Turn t where t.state = :state")
    Set<Turn> getTurnsByState(@Param("state") String state);

    Set<Turn> findAllByState(String state);

    @Query(value="select t from Turn t where t.state = 'Finished'")
    Set<Turn> getTurnsByStateFinished();

    @Query(value="select t from Turn t where t.state = :state and t.date = :date")
    Set<Turn> getTurnsByStateAndDate(@Param("state") String state, @Param("date") Date date);

    Set<Turn> findAllByStateAndDate(String state, Date date);

    @Query(value="select t from Turn t where t.state = 'Pending' and t.date = :date")
    Set<Turn> getTurnsByStatePendingOfADate(@Param("date") Date date);

    @Query(value = "from Turn t where t.professional.id = :professional_id")
    Set<Turn> getTurnsByProfessionalId(@Param("professional_id") long professional_id);

    Set<Turn> findAllByProfessional_id(long professional_id);

    @Query(value="select t from Turn t where t.state = :state and t.professional.id = :professional_id")
    Set<Turn> getTurnsByStateAndProfessional(@Param("state") String state, @Param("professional_id") long professional_id);

    Set<Turn> getAllByStateAndProfessional_Id(String state, long professional_id);

    @Query(value="select t from Turn t where t.state = 'Reprogramed' and t.professional.id = :professional_id")
    Set<Turn> getTurnsByStateReprogramedAndProfessional(@Param("professional_id") long professional_id);

    Set<Turn> getAllByState(String state);

    @Query(value="select t from Turn t where t.state = 'Reprogramed'")
    Set<Turn> getTurnsByStateReprogramed();
}
