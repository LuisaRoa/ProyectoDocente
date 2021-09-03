package co.edu.unicundi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "materia")
public class Materia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mate_id;

	@NotNull(message = "Nombre  requerido")
	@Size(min = 3, max = 30, message = "Nombre entre 3 y 30 caracteres")
	@Column(name = "mate_nombre", length = 30, nullable = false)
	private String nombre;
	
	@Column(name = "mate_semestre", length = 30, nullable = false)
	private String semestre;
	
	@Column(name = "mate_registradopor", length = 30, nullable = false)
	private String registradopor;

	@Column(name = "mate_fechacambio", length = 60, nullable = false)
	private String fechacambio;

	@OneToOne(mappedBy ="materia", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private AulasVirtuales aulasvirtuales ;
	
	
	
	public Materia() {
		
	}

	
	public Materia(Integer mate_id, String nombre,String semestre, String registradopor, String fechacambio, AulasVirtuales aulasvirtuales) {
		super();
		this.mate_id = mate_id;
		this.nombre = nombre;
		this.semestre = semestre;
		this.registradopor = registradopor;
		this.fechacambio = fechacambio;
		this.aulasvirtuales = aulasvirtuales;
	}




	public AulasVirtuales getAulasvirtuales() {
		return aulasvirtuales;
	}

	public void setAulasvirtuales(AulasVirtuales aulasvirtuales) {
		this.aulasvirtuales = aulasvirtuales;
	}

	public Integer getMate_id() {
		return mate_id;
	}

	public void setMate_id(Integer mate_id) {
		this.mate_id = mate_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getRegistradopor() {
		return registradopor;
	}

	public void setRegistradopor(String registradopor) {
		this.registradopor = registradopor;
	}

	public String getFechacambio() {
		return fechacambio;
	}

	public void setFechacambio(String fechacambio) {
		this.fechacambio = fechacambio;
	}

	
}
