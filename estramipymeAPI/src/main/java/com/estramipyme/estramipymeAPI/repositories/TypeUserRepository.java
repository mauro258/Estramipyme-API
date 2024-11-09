package com.estramipyme.estramipymeAPI.repositories;

import org.springframework.stereotype.Repository;
import com.estramipyme.estramipymeAPI.models.TypeUser;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface TypeUserRepository extends JpaRepository<TypeUser, Long> {
}