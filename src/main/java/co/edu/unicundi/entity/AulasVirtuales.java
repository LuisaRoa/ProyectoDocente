package co.edu.unicundi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "aulasvirtuales")
public class AulasVirtuales {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer auvi_id;

	@NotNull(message = "Nombre  requerido")
	@Size(min = 3, max = 30, message = "Nombre entre 3 y 30 caracteres")
	@Column(name = "auvi_nombre", length = 30, nullable = false)
	private String nombre;

	@Column(name = "auvi_grupo", length = 30, nullable = false)
	private Integer grupo;

	@Column(name = "auvi_semestre", length = 30, nullable = false)
	private String semestre;

	@Column(name = "auvi_sede", length = 30, nullable = false)
	private String sede;

	@Column(name = "auvi_registradopor", length = 30, nullable = false)
	private String registradoPor;

	@Column(name = "auvi_fechacambio", length = 60, nullable = false)
	private String fechaCambio;

	@ManyToOne
	@JoinColumn(name = "docente_doce_id", nullable = false, foreignKey = @ForeignKey(name = "doce_id"))
	private Docente docente;

	@ManyToOne
	@JoinColumn(name = "materia_mate_id", nullable = false, foreignKey = @ForeignKey(name = "mate_id"))
	private Materia materia;

	
	public AulasVirtuales() {
	}

	public AulasVirtuales(Integer auvi_id, String nombre, Integer grupo, String semestre, String sede,
			String registradopor, String fechacambio, Docente docente, Materia materia) {
		super();
		this.auvi_id = auvi_id;
		this.nombre = nombre;
		this.grupo = grupo;
		this.semestre = semestre;
		this.sede = sede;
		this.registradoPor = registradopor;
		this.fechaCambio = fechacambio;
		this.docente = docente;
		this.materia = materia;

	}	

	public Integer getAuvi_id() {
		return auvi_id;
	}

	public void setAuvi_id(Integer auvi_id) {
		this.auvi_id = auvi_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getGrupo() {
		return grupo;
	}

	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
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

	
	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

}
