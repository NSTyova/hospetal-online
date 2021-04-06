package com.mballem.curso.security.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.mballem.curso.security.datatables.Datatables;
import com.mballem.curso.security.datatables.DatatablesColunas;
import com.mballem.curso.security.domain.Patologias;
import com.mballem.curso.security.repository.PatologiasRepository;

@Service
public class PatologiasService {

	@Autowired
	private PatologiasRepository repository;
	
	@Autowired
	private Datatables datatables;
	
	
	//@Transactional(readOnly=false)
	public void gravar(Patologias patologias){
		repository.save(patologias);
	}
	
	//@Transactional(readOnly = true)
	public Map<String, Object> buscarPatologias(HttpServletRequest request) {
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.PATOLOGIAS);
		Page<?> page = datatables.getSearch().isEmpty()
				? repository.findAll(datatables.getPageable())
				: repository.findAllByDescricao(datatables.getSearch(), datatables.getPageable());
		return datatables.getResponse(page);
	}
	
	
	public Patologias buscarPorId(Long id) {
		
		return repository.findById(id).get();
	}


	public void remover(Long id) {
		
		repository.deleteById(id);
	}
}
