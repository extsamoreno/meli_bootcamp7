package com.example.project_url.service.mapper;

public interface IGenericMapper<S, T> {
    T toDto(S model);
    S toModel(T dto);
}
