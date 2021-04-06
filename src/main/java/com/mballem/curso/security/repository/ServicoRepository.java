package com.mballem.curso.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mballem.curso.security.domain.Servicos;

@Repository
public interface ServicoRepository extends JpaRepository<Servicos, Long> {

}
