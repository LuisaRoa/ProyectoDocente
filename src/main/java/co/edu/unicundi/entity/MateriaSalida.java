package co.edu.unicundi.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "materia_solicitudsalidas")
@IdClass(MateriaSalidaPK.class)
public class MateriaSalida {
	
	@Id
	private Materia materia;
	
	@Id
	private SolicitudSalidas solicitudsalidas;

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	@JsonIgnore
	public SolicitudSalidas getSolicitudSalidas() {
		return solicitudsalidas;
	}

	public void setSolicitudSalida(SolicitudSalidas solicitudsalidas) {
		this.solicitudsalidas = solicitudsalidas;
	}

	
	
	
}
