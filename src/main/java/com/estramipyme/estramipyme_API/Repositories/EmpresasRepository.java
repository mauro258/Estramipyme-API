package com.estramipyme.estramipyme_API.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estramipyme.estramipyme_API.models.Empresas;


public interface  EmpresasRepository extends JpaRepository<Empresas, Long>{
    
}
