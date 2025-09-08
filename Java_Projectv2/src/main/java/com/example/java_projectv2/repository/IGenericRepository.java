package com.example.java_projectv2.repository;

import com.example.java_projectv2.repository.base.IReadRepository;
import com.example.java_projectv2.repository.base.IWriteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public  interface IGenericRepository<T,ID>
        extends JpaRepository<T,ID> , IWriteRepository<T,ID>, IReadRepository<T,ID>
{


}
