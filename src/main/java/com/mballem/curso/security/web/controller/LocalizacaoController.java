package com.mballem.curso.security.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mballem.curso.security.domain.Localizacao;
import com.mballem.curso.security.service.LocalizacaoServive;

@Controller
@RequestMapping("localizacao")
public class LocalizacaoController {
	
	@Autowired
	private LocalizacaoServive service;

	@GetMapping("/cadastros")
	public String abrir(Localizacao localizacao) {
		return "localizacao/cadastro";
	}
	
	
	@PostMapping("/salvar")
	public String salvar(Localizacao localizacao, RedirectAttributes attr) {
		service.gravar(localizacao);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso!");
		return "redirect:/localizacao/cadastros";
	}
	
	@GetMapping("/datatables/server")
	public ResponseEntity<?> getEspecialidades(HttpServletRequest request) {

		return ResponseEntity.ok(service.buscarLocalizacao(request));
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("localizacao", service.buscarPorId(id));
		return "localizacao/cadastro";
	}
	
	@GetMapping("/excluir/{id}")
	public String abrir(@PathVariable("id") Long id, RedirectAttributes attr) {
		service.remover(id);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
		return "redirect:/localizacao";
	}
	
}
