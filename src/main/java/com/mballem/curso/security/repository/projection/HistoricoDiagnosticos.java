package com.mballem.curso.security.repository.projection;


import com.mballem.curso.security.domain.Medico;
import com.mballem.curso.security.domain.Paciente;

public interface HistoricoDiagnosticos {

	Long getId();
	
	Paciente getPaciente();
	
	String getHistoricos();
	
	Medico getMedico();
	
}
