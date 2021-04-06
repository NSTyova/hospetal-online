package com.mballem.curso.security.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.mballem.curso.security.datatables.Datatables;
import com.mballem.curso.security.datatables.DatatablesColunas;
import com.mballem.curso.security.domain.Localizacao;
import com.mballem.curso.security.repository.LocalizacaoRepository;

@Service
public class LocalizacaoServive {

	
	@Autowired
	private LocalizacaoRepository repository;
	
	@Autowired
	private Datatables datatables;
	
	public void gravar(Localizacao localizacao) {
		repository.save(localizacao);
	}
	
	//@Transactional(readOnly = true)
		public Map<String, Object> buscarLocalizacao(HttpServletRequest request) {
			datatables.setRequest(request);
			datatables.setColunas(DatatablesColunas.PATOLOGIAS);
			Page<?> page = datatables.getSearch().isEmpty()
					? repository.findAll(datatables.getPageable())
					: repository.findAllByDescricao(datatables.getSearch(), datatables.getPageable());
			return datatables.getResponse(page);
		}
		
		
		public Localizacao buscarPorId(Long id) {
			
			return repository.findById(id).get();
		}


		public void remover(Long id) {
			
			repository.deleteById(id);
		}
		
		public List<Localizacao> listarLocalizacao(){
			return repository.findAll();
		}
}
