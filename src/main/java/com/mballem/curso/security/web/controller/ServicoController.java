package com.mballem.curso.security.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mballem.curso.security.domain.Servicos;
import com.mballem.curso.security.service.ServicosService;

@Controller
@RequestMapping("servicos")
public class ServicoController {

	@Autowired
	private ServicosService service;
	
	@GetMapping("cadastros")
	public String abrir(Servicos servicos) {
		return "servico/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Servicos servicos, RedirectAttributes attr) {
		service.gravar(servicos);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso!");
		return "redirect:/servicos/cadastros";
	}
}
