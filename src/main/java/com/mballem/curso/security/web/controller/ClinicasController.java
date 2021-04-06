package com.mballem.curso.security.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mballem.curso.security.domain.Clinicas;
import com.mballem.curso.security.domain.Localizacao;
import com.mballem.curso.security.service.ClinicasService;
import com.mballem.curso.security.service.LocalizacaoServive;

@Controller
@RequestMapping("clinicas")
public class ClinicasController {

	@Autowired
	private ClinicasService service;
	
	@Autowired
	private LocalizacaoServive localizacao;
	
	@GetMapping("cadastros")
	public String abrir(Clinicas clinicas) {
		return "clinica/cadastro";
	}
	
	public void buscarLocalizacao() {
		service.buscarLocalizacao();
	}
	
	@PostMapping("/salvar")
	public String salvar(Clinicas clinicas, RedirectAttributes attr) {
		service.salvar(clinicas);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso!");
		return "redirect:/clinicas/cadastros";
	}
	
	@GetMapping("/datatables/server")
	public ResponseEntity<?> getEspecialidades(HttpServletRequest request) {

		return ResponseEntity.ok(service.buscarClinicas(request));
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("clinicas", service.buscarPorId(id));
		return "clinica/cadastro";
	}
	
	@GetMapping("/excluir/{id}")
	public String abrir(@PathVariable("id") Long id, RedirectAttributes attr) {
		service.remover(id);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
		return "redirect:/clinicas";
	}
	
	@ModelAttribute("localizacaos")
	public List<Localizacao> listaLocalizacao(){
		return localizacao.listarLocalizacao();
	}
	
}
