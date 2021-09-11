package co.edu.unicundi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "facultad")
public class Facultad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer facu_id;

	@NotNull(message = "Nombre  requerido")
	@Size(min = 3, max = 30, message = "Nombre entre 3 y 30 caracteres")
	@Column(name = "facu_nombre", length = 90, nullable = false)
	private String nombre;

	@Column(name = "facu_registradopor", length = 30, nullable = false)
	private String registradoPor;

	@Column(name = "facu_fechacambio", length = 60, nullable = false)
	private String fechaCambio;
	
	@OneToMany(mappedBy ="facultad", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<ProgramaAcademico> programaacademico ;

	
	
	public Facultad() {
	}

	public Facultad(Integer facu_id, String nombre,	String registradopor, String fechacambio, List<ProgramaAcademico> programaacademico) {
		super();
		this.facu_id = facu_id;
		this.nombre = nombre;
		this.registradoPor = registradopor;
		this.fechaCambio = fechacambio;
		this.programaacademico = programaacademico;
	}

	public List<ProgramaAcademico> getProgramaacademico() {
		return programaacademico;
	}

	public void setProgramaacademico(List<ProgramaAcademico> programaacademico) {
		this.programaacademico = programaacademico;
	}

	public Integer getFacu_id() {
		return facu_id;
	}

	public void setFacu_id(Integer facu_id) {
		this.facu_id = facu_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRegistradoPor() {
		return registradoPor;
	}

	public void setRegistradoPor(String registradoPor) {
		this.registradoPor = registradoPor;
	}

	public String getFechaCambio() {
		return fechaCambio;
	}

	public void setFechaCambio(String fechaCambio) {
		this.fechaCambio = fechaCambio;
	}

}
