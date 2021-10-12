package co.edu.unicundi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "programaacademico")
public class ProgramaAcademico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer prac_id;
	
	@NotNull(message = "Nombre  requerido")
	@Size(min = 3, max = 30, message = "Nombre entre 3 y 30 caracteres")
	@Column(name = "prac_nombre", length = 90, nullable = false)
	private String nombre;
	
	@Column(name = "prac_registradopor", length = 30, nullable = false)
	private String registradopor;

	@Column(name = "prac_fechacambio", length = 60, nullable = false)
	private String fechacambio;
	
	@ManyToOne
	@JoinColumn(name = "facultad_facu_id", nullable = false, foreignKey = @ForeignKey(name = "facu_id"))
	private Facultad facultad;
	
	@OneToMany(mappedBy ="programaacademico", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Administrativo> administrativo ;
	
	@OneToMany(mappedBy ="programaacademico", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<InformeSemestral> informesemestral ;
	
	@OneToMany(mappedBy ="programaacademico", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Syllabus> syllabus ;
	
	@OneToMany(mappedBy ="programaacademico", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<InformeHorasNoLectivas> informe ;
	

	public ProgramaAcademico() {
	}


	public ProgramaAcademico(Integer prac_id,String nombre,String registradopor, String fechacambio, Facultad facultad, List<Administrativo> administrativo,  List<InformeSemestral> informeSemestral,
			List<Syllabus> syllabus, List<InformeHorasNoLectivas> informe) {
		super();
		this.prac_id = prac_id;
		this.nombre = nombre;
		this.registradopor = registradopor;
		this.fechacambio = fechacambio;
		this.facultad = facultad;
		this.administrativo = administrativo;
		this.informesemestral = informeSemestral;
		this.syllabus = syllabus;
		this.informe = informe;
	}



	public List<InformeHorasNoLectivas> getInforme() {
		return informe;
	}


	public void setInforme(List<InformeHorasNoLectivas> informe) {
		this.informe = informe;
	}


	public Integer getPrac_id() {
		return prac_id;
	}

	public void setPrac_id(Integer prac_id) {
		this.prac_id = prac_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	@JsonBackReference 
	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}


	public List<Administrativo> getAdministrativo() {
		return administrativo;
	}


	public void setAdministrativo(List<Administrativo> administrativo) {
		this.administrativo = administrativo;
	}


	public List<InformeSemestral> getInformesemestral() {
		return informesemestral;
	}


	public void setInformesemestral(List<InformeSemestral> informesemestral) {
		this.informesemestral = informesemestral;
	}


	public List<Syllabus> getSyllabus() {
		return syllabus;
	}


	public void setSyllabus(List<Syllabus> syllabus) {
		this.syllabus = syllabus;
	}
	
	
}
