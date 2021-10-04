package co.edu.unicundi.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "materia_solicitudsalidas")
public class MateriaSalida {
	
	@EmbeddedId
    private MateriaSalidaPK MateriaSalidaId;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne
	@MapsId("idSolicitudSalida")
	@JoinColumn(name = "sosa_id", nullable = false, foreignKey = @ForeignKey(name = "sosa_id"))
	private SolicitudSalida solicitudsalidas;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ManyToOne
	@MapsId("idMateria")
	@JoinColumn(name = "mate_id", nullable = false, foreignKey = @ForeignKey(name = "mate_id"))
	private Materia materia;

	public MateriaSalida() {
		
	}
	
	public MateriaSalida(SolicitudSalida solicitudsalidas, Materia materia) {
		super();
		this.solicitudsalidas = solicitudsalidas;
		this.materia = materia;
	}

	public SolicitudSalida getSolicitudsalida() {
		return solicitudsalidas;
	}

	public void setSolicitudsalida(SolicitudSalida solicitudsalida) {
		this.solicitudsalidas = solicitudsalida;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public MateriaSalidaPK getMateriaSalidaId() {
		return MateriaSalidaId;
	}

	public void setMateriaSalidaId(MateriaSalidaPK materiaSalidaId) {
		MateriaSalidaId = materiaSalidaId;
	}
	
	
}
