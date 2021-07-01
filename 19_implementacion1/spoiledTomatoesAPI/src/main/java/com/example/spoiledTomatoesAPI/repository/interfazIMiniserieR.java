package com.example.spoiledTomatoesAPI.repository;

import com.example.spoiledTomatoesAPI.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface interfazIMiniserieR extends CrudRepository<MiniSerie,Long> {
}
