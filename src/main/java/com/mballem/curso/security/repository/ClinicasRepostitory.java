package com.mballem.curso.security.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mballem.curso.security.domain.Clinicas;

@Repository
public interface ClinicasRepostitory extends JpaRepository<Clinicas, Long>{

	Page<Clinicas> findAllByDescricao(String search, Pageable pageable);

}
