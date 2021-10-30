package co.edu.unicundi.dto;


import co.edu.unicundi.entity.Comite;
import co.edu.unicundi.entity.Docente;

public class MiembrosDto {

	private Integer docente;
	

	private Integer comite;

	public MiembrosDto() {
		
	}
	
	public MiembrosDto(Integer docente, Integer comite) {
		super();
		this.docente = docente;
		this.comite = comite;
	}


	public Integer getDocente() {
		return docente;
	}


	public void setDocente(Integer docente) {
		this.docente = docente;
	}


	public Integer getComite() {
		return comite;
	}


	public void setComite(Integer comite) {
		this.comite = comite;
	}


	
	
}
