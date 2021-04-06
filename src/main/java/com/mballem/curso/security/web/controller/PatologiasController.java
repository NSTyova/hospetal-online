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

import com.mballem.curso.security.domain.Patologias;
import com.mballem.curso.security.service.PatologiasService;

@Controller
@RequestMapping("patologias")
public class PatologiasController {

	@Autowired
	public PatologiasService service;
	
	@GetMapping("cadastros")
	public String abrir(Patologias patologias) {
		return "patologias/cadastro";
	}
	
	@PostMapping("/salvar")
	public String gravar(Patologias patologias, RedirectAttributes attr) {
		service.gravar(patologias);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso!");
		return "redirect:/patologias/cadastros";
	}
	
	@GetMapping("/datatables/server")
	public ResponseEntity<?> getPatologias(HttpServletRequest request) {

		return ResponseEntity.ok(service.buscarPatologias(request));
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("patologias", service.buscarPorId(id));
		return "patologias/cadastro";
	}
	
	@GetMapping("/excluir/{id}")
	public String abrir(@PathVariable("id") Long id, RedirectAttributes attr) {
		service.remover(id);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
		return "redirect:/especialidades";
	}
}
