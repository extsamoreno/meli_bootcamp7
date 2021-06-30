package com.example.demo.repository;

import com.example.demo.models.UsuarioModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

    @Query("select u from UsuarioModel u where u.userName like :name order by u.userName")
    List<UsuarioModel> findUsuarioModelByName(@Param("name") String name);
}



