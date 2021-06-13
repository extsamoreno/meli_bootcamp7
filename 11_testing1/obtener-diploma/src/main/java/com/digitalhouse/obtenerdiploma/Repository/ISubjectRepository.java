package com.digitalhouse.obtenerdiploma.Repository;

import com.digitalhouse.obtenerdiploma.Repository.entities.Subject;

public interface ISubjectRepository {
    Subject getSubjectByname(String name);
}
