package co.edu.unicundi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "solicitudaulas")
public class SolicitudAulas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer soau_id;
	
	@Column(name = "soau_fecha", length = 30, nullable = false)
	private String fecha;

	@Column(name = "soau_estado", length = 30, nullable = false)
	private String estado;

	@Column(name = "soau_registradopor", length = 30, nullable = false)
	private String registradoPor;

	@Column(name = "soau_fechacambio", length = 60, nullable = false)
	private String fechaCambio;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToOne
	@JoinColumn(name = "docente_doce_id", nullable = false, foreignKey = @ForeignKey(name = "doce_id"))
	private Docente docente;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToOne
	@JoinColumn(name = "materia_mate_id", nullable = false, foreignKey = @ForeignKey(name = "mate_id"))
	private Materia materia;

	
	
	public SolicitudAulas() {
	}

	public SolicitudAulas(Integer soau_id, String fecha, String estado, String registradopor, String fechacambio,
			Docente docente, Materia materia) {
		super();
		this.soau_id = soau_id;
		this.fecha = fecha;
		this.estado = estado;
		this.registradoPor = registradopor;
		this.fechaCambio = fechacambio;
		this.docente = docente;
		this.materia = materia;
	}

	public Integer getSoau_id() {
		return soau_id;
	}

	public void setSoau_id(Integer soau_id) {
		this.soau_id = soau_id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRegistradopor() {
		return registradoPor;
	}

	public void setRegistradopor(String registradopor) {
		this.registradoPor = registradopor;
	}

	public String getFechacambio() {
		return fechaCambio;
	}

	public void setFechacambio(String fechacambio) {
		this.fechaCambio = fechacambio;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
	@JsonIgnore
	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	

}
