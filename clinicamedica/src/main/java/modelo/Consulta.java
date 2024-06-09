package modelo;

import java.util.Date;

public class Consulta {

	private int id;
	private Date dataConsulta;
	private String horarioConsulta;
	private String nomePaciente;
	private String diagnostico;
	
    public Consulta(int id, Date dataConsulta, String horarioConsulta, String nomePaciente, String diagnostico) {
		this.id = id;
		this.dataConsulta = dataConsulta;
		this.horarioConsulta = horarioConsulta;
		this.nomePaciente = nomePaciente;
		this.diagnostico = diagnostico;
	}
    
	
	
	public String getDiagnostico() {
		return diagnostico;
	}



	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}



	public Consulta() {
        
    }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDataConsulta() {
		return dataConsulta;
	}


	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}


	public String getHorarioConsulta() {
		return horarioConsulta;
	}


	public void setHorarioConsulta(String horarioConsulta) {
		this.horarioConsulta = horarioConsulta;
	}


	public String getNomePaciente() {
		return nomePaciente;
	}


	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	
	
	
	
	
	
	
	
	
}
