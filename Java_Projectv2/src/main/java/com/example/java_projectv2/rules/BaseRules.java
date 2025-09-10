package com.example.java_projectv2.rules;

import com.example.java_projectv2.exception.BusinessException;
import com.example.java_projectv2.exception.NotNullException;
import com.example.java_projectv2.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public abstract class BaseRules<S>
{
    protected final JpaRepository<S,Long> repository;
//    protected istifade edilmesi inheritance alacaq olan classlar uzerinde isledile bilsin deye

    protected BaseRules(JpaRepository<S, Long> repository) {
        this.repository = repository;
    }

    public void checkIfExistsById(Long id)
    {
        if(!repository.existsById(id)) throw new ResourceNotFoundException("Resource with id " + id + " does not exist");
    }

    public void checkNotNull(S obj)
    {
        if(obj == null) throw new NotNullException("obj is null");
    }

    public void checkIfUnique(S obj)
    {
    }
}
