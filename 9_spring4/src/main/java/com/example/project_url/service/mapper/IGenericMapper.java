package com.example.project_url.service.mapper;

public interface IGenericMapper<S, T, E> {
    T toDto(S model);
    S toModel(T dto);
    E toDtoResponse(S model);
}
