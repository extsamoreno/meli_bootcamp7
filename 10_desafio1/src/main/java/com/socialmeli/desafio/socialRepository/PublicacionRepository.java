package com.socialmeli.desafio.socialRepository;

import com.socialmeli.desafio.model.PublicacionModel;
import com.socialmeli.desafio.model.VendedorModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PublicacionRepository {

    private static HashMap<Integer, PublicacionModel> dataBasePublicacion = new HashMap<>();



}
