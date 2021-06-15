package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.repository.StudentRepository;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class StudentRepositoryTest {
    @Test
    public void testHappyPath(){
        //arrange
        var repo = new StudentRepository("test");
        //act
        var result = repo.findAll();
        //assert
        assertTrue(result.size() > 0);
    }

    @Test
    public void testFileNotFound(){
        //arrange
        var repo = new StudentRepository("tesssss");
        //act
        var result = repo.findAll();
        //assert
        assertEquals(result.size(), 0);
    }

    @Test
    public void testFileBadFormat(){
        //arrange
        var repo = new StudentRepository("test/resourcesBroken");
        //act
        var result = repo.findAll();
        //assert
        assertEquals(result.size(), 0);
    }
}
