package com.mballem.curso.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mballem.curso.security.domain.Servicos;
import com.mballem.curso.security.repository.ServicoRepository;

@Service
public class ServicosService {

	@Autowired
	private ServicoRepository repository;
	
	
	public void gravar(Servicos servicos) {
		repository.save(servicos);
	}
}
