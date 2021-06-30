package com.example.mongodbexample.repository;

import com.example.mongodbexample.domain.Turns;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TurnsRepository extends MongoRepository<Turns, String> {

    //@Query(value = "{'date' : 10-05-2021}", fields = "{'description' : 0}")
    //@Query( "{'date' : '10-05-2021'}")

   /* @Query("{$or :[{author: ?0},{name: ?1}]}")            //SQL Equivalent : select count(*) from book where author=? or name=?
    List<Book> getBooksByAuthorOrName(String author, String name);*/
    //@Query( "{'date' : '10-05-2021'}")
    @Query("{ 'doctor.firstName' : ?0}")

    List<Turns>  listsAgenda(@Param("dentista") String dentista);

    @Query("{ 'status' : ?0}")
    List<Turns>  listsAgendaBystatus(@Param("status") String status);

}
