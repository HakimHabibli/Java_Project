package com.example.java_projectv2.repository.base;

import java.util.List;
import java.util.Optional;

public interface IReadRepository<T,ID>
{
    Optional<T> findById(ID id);
    List<T> findAll();
}
