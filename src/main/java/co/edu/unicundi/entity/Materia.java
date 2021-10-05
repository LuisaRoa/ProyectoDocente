package co.edu.unicundi.entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@Column(name = "mate_codigo", length = 30, nullable = false)
	private String codigo;

	@Column(name = "mate_registradopor", length = 30, nullable = false)
	private String registradopor;

	@Column(name = "mate_fechacambio", length = 60, nullable = false)
	private String fechacambio;

	@OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<AulasVirtuales> aulasvirtuales;
	
	@OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Syllabus> syllabus;
	
	@OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<InformeSemestral> informeSemestral;
	

	public Materia() {

	}

	public Materia(Integer mate_id,
			@NotNull(message = "Nombre  requerido") @Size(min = 3, max = 30, message = "Nombre entre 3 y 30 caracteres") String nombre,
			String semestre, String codigo, String registradopor, String fechacambio, List<AulasVirtuales> aulasvirtuales, List<Syllabus> syllabus, 
			List<InformeSemestral> informeSemestral) {
		super();
		this.mate_id = mate_id;
		this.nombre = nombre;
		this.semestre = semestre;
		this.codigo = codigo;
		this.registradopor = registradopor;
		this.fechacambio = fechacambio;
		this.aulasvirtuales = aulasvirtuales;
		this.syllabus = syllabus;
		this.informeSemestral = informeSemestral;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public AulasVirtuales getAulasvirtuales() {
		return (AulasVirtuales) aulasvirtuales;
	}

	public void setAulasvirtuales(List<AulasVirtuales> aulasvirtuales) {
		this.aulasvirtuales = (List<AulasVirtuales>) aulasvirtuales;
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

	public List<Syllabus> getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(List<Syllabus> syllabus) {
		this.syllabus = syllabus;
	}

	public List<InformeSemestral> getInformeSemestral() {
		return informeSemestral;
	}

	public void setInformeSemestral(List<InformeSemestral> informeSemestral) {
		this.informeSemestral = informeSemestral;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mate_id == null) ? 0 : mate_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		if (mate_id == null) {
			if (other.mate_id != null)
				return false;
		} else if (!mate_id.equals(other.mate_id))
			return false;
		return true;
	}




	
	
}
