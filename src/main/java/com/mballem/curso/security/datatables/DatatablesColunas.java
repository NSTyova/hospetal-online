package com.mballem.curso.security.datatables;

public class DatatablesColunas {

	public static final String[] ESPECIALIDADES = {"id", "titulo"};

	public static final String[] MEDICOS = {"id", "nome", "crm", "dtInscricao", "especialidades"};
	
	public static final String[] AGENDAMENTOS = {"id", "paciente.nome", "dataConsulta", "medico.nome", "especialidade.titulo"};

	public static final String[] USUARIOS = {"id", "email", "ativo", "perfis"};	
	
	public static final String[] PATOLOGIAS = {"id", "descricao", "causa"};
	
	public static final String[] CLINICAS = {"id", "descricao", "contacto", "localizacao.descricao"};
	
	public static final String[] MORADAS = {"id", "descricao"};
	
	public static final String[] CANDIDATOS = {"id", "nome"};
	
	public static final String[] ARQUITETOS = {"id", "nome"};
}
