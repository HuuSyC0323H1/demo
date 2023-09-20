package com.example.demo.service;


import java.util.List;
import java.util.Optional;

public interface IGenerateService<T,ID> {
    List<T> findAll();

    Optional<T> findOne(ID id);

    void save(T t);

    void delete(ID id);
}