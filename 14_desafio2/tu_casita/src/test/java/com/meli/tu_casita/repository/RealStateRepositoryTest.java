package com.meli.tu_casita.repository;

import com.meli.tu_casita.model.RealState;
import com.meli.tu_casita.util.TestUtilGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RealStateRepositoryTest {

    IRealStateRepository realStateRepository;

    @BeforeEach
    @AfterEach
    public void setUp() {
        String fileName = "realStatesEmpty";
        TestUtilGenerator.emptyFile(fileName);
        this.realStateRepository = new RealStateRepositoryImpl(fileName);
    }

    @Test
    public void saveTest() {
        //Arrange
        RealState realState = TestUtilGenerator.getRealState();
        //Act
        realStateRepository.save(realState);
        //Assert
        Assertions.assertEquals(1, realState.getId());
    }

    @Test
    public void existsTestTrue() {
        //Arrange
        RealState realState = TestUtilGenerator.getRealState();
        realStateRepository.save(realState);
        //Act
        boolean received = realStateRepository.exists(realState);
        //Assert
        Assertions.assertTrue(received);
    }

    @Test
    public void existsTestFalse() {
        //Arrange
        RealState realState = TestUtilGenerator.getRealState();
        //Act
        boolean received = realStateRepository.exists(realState);
        //Assert
        Assertions.assertFalse(received);
    }

    @Test
    public void findByIdTest() {
        //Arrange
        RealState realState = TestUtilGenerator.getRealState();
        realStateRepository.save(realState);
        //Act
        RealState received = realStateRepository.findById(realState.getId());
        //Assert
        Assertions.assertEquals(realState, received);
    }

    @Test
    public void findByNameTest() {
        //Arrange
        RealState realState = TestUtilGenerator.getRealState();
        realStateRepository.save(realState);
        //Act
        RealState received = realStateRepository.findByName(realState.getName());
        //Assert
        Assertions.assertEquals(realState, received);
    }

    @Test
    public void getRealStateListTest() {
        //Arrange
        List<RealState> realStateList = TestUtilGenerator.getRealStateList();
        realStateList.forEach(realState -> realStateRepository.save(realState));
        //Act
        List<RealState> received = realStateRepository.getRealStateList();
        //Assert
        Assertions.assertEquals(realStateList.size(), received.size());

    }

}
