package com.mballem.curso.security.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mballem.curso.security.domain.Localizacao;
import com.mballem.curso.security.service.LocalizacaoServive;

@Component
public class LocalizacaoConverter implements Converter<String, Localizacao> {

	@Autowired
	private LocalizacaoServive servive;
	
	@Override
	public Localizacao convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return servive.buscarPorId(id);
	}
}
