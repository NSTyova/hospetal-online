package com.mballem.curso.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mballem.curso.security.domain.Cliente;
import com.mballem.curso.security.domain.Paciente;
import com.mballem.curso.security.repository.ClienteRepository;

@Service
public class ClienteService {

	
	@Autowired
	private ClienteRepository repository;
	
	@Transactional (readOnly = false)
	public void gravar(Cliente cliente) {
		repository.save(cliente);
	}
	@Transactional(readOnly = true)
	public Cliente buscarPorUsuarioEmail(String email) {
		
		return repository.findByUsuarioEmail(email).orElse(new Cliente());
	}
	
	@Transactional(readOnly = false)
	public void editar(Cliente cliente) {
		Cliente c2 = repository.findById(cliente.getId()).get();
		c2.setNome(cliente.getNome());
		c2.setData_nascimento(cliente.getData_nascimento());
		c2.setLocalizacao(cliente.getLocalizacao());
		c2.setTelefone(cliente.getTelefone());
	}
	
	public void buscarLocalizacao() {
		repository.findAll();
	}
}
