package com.muelitas.demo.repositories;

import com.muelitas.demo.models.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ITurnRepository extends JpaRepository<Turn, Long> {
    @Transactional
    @Modifying
    @Query("update Turn t set t.status.id = 3 where t.id =:id")
    void cancelTurnById(@Param("id") Long id);

}
