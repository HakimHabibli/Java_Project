package com.example.java_projectv2.repository.base;

public interface  IWriteRepository<T,ID>
{
//    T save(T t);
    void deleteById(ID id);
}
