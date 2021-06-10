package com.socialmeli.desafio.socialRepository;

import com.socialmeli.desafio.model.PublicacionModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PublicationRepository implements IPublicationRepository {

    private static HashMap<Integer, PublicacionModel> publicationDataBase = new HashMap<>();



}
