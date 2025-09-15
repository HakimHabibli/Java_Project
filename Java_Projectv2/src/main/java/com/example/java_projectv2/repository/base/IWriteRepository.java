package com.example.java_projectv2.repository.base;

public interface  IWriteRepository<T,ID>
{
    void deleteById(ID id);
}
