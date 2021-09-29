package co.edu.unicundi.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "miembros")
public class Miembros {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mien_id;
	
	@ManyToOne
	@JoinColumn(name = "docente_doce_id", nullable = false, foreignKey = @ForeignKey(name = "doce_id"))
	private Docente docente;
	
	@ManyToOne
	@JoinColumn(name = "comite_comi_id", nullable = false, foreignKey = @ForeignKey(name = "comi_id"))
	private Comite comite;

	public Miembros() {
	}

	public Miembros(Integer mien_id, Docente docente, Comite comite) {
		super();
		this.mien_id = mien_id;
		this.docente = docente;
		this.comite = comite;
	}

	public Integer getMien_id() {
		return mien_id;
	}

	public void setMien_id(Integer mien_id) {
		this.mien_id = mien_id;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Comite getComite() {
		return comite;
	}

	public void setComite(Comite comite) {
		this.comite = comite;
	}
	
	
	
	

	
}
