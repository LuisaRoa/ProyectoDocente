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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "solicitudsalidas")
public class SolicitudSalidas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sosa_id;

	@Column(name = "sosa_fechasolicitud", length = 30, nullable = false)
	private String fechaSolicitud;

	@Column(name = "sosa_estado", length = 30, nullable = false)
	private String estado;

	@Column(name = "sosa_semestre", length = 30, nullable = false)
	private String semestre;

	@Column(name = "sosa_registradopor", length = 30, nullable = false)
	private String registradoPor;

	@Column(name = "sosa_fechacambio", length = 30, nullable = false)
	private String fechaCambio;
	
	@Column(name = "sosa_fechainicio", length = 30, nullable = false)
	private String fechaInicio;
	
	@Column(name = "sosa_fechaterminacion", length = 30, nullable = false)
	private String fechaTerminacion;
	
	@Column(name = "sosa_nombre", length = 60, nullable = false)
	private String nombre;
	
	@Column(name = "sosa_tipo", length = 40, nullable = false)
	private String tipo;
	
	@Column(name = "sosa_periodo", length = 40, nullable = true)
	private String periodo;
	
	@Column(name = "sosa_numeroestudiantes", length = 30, nullable = false)
	private int noEstudiantes;
	
	@Column(name = "sosa_tematica", length = 30, nullable = false)
	private String tematica;

	@ManyToOne
	@JoinColumn(name = "docente_doce_id", nullable = false, foreignKey = @ForeignKey(name = "doce_id"))
	private Docente docente;

	@ManyToOne
	@JoinColumn(name = "programaacademico_prac_id", nullable = false, foreignKey = @ForeignKey(name = "prac_id"))
	private ProgramaAcademico programaacademico;
	
	
	@OneToMany(mappedBy ="solicitudsalidas", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	//@JsonIgnore
	private List<MateriaSalida> materiaSalida ;
	
	public SolicitudSalidas() {
		
	}

	public SolicitudSalidas(Integer sosa_id, String fechaSolicitud, String estado, String semestre,
			String registradoPor, String fechaCambio, String fechaInicio, String fechaTerminacion, String nombre,
			String tipo,String periodo, int noEstudiantes, String tematica, Docente docente,
			ProgramaAcademico programaacademico, List<MateriaSalida> materiaSalida) {
		super();
		this.sosa_id = sosa_id;
		this.fechaSolicitud = fechaSolicitud;
		this.estado = estado;
		this.semestre = semestre;
		this.registradoPor = registradoPor;
		this.fechaCambio = fechaCambio;
		this.fechaInicio = fechaInicio;
		this.fechaTerminacion = fechaTerminacion;
		this.nombre = nombre;
		this.tipo = tipo;
		this.periodo = periodo;
		this.noEstudiantes = noEstudiantes;
		this.tematica = tematica;
		this.docente = docente;
		this.programaacademico = programaacademico;
		this.materiaSalida = materiaSalida;
	}

	
	
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Integer getSosa_id() {
		return sosa_id;
	}

	public void setSosa_id(Integer sosa_id) {
		this.sosa_id = sosa_id;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
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

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaTerminación() {
		return fechaTerminacion;
	}

	public void setFechaTerminación(String fechaTerminacion) {
		this.fechaTerminacion = fechaTerminacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoSalida() {
		return tipo;
	}

	public void setTipoSalida(String tipo) {
		this.tipo = tipo;
	}

	public int getNoEstudiantes() {
		return noEstudiantes;
	}

	public void setNoEstudiantes(int noEstudiantes) {
		this.noEstudiantes = noEstudiantes;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public ProgramaAcademico getProgramaacademico() {
		return programaacademico;
	}

	public void setProgramaacademico(ProgramaAcademico programaacademico) {
		this.programaacademico = programaacademico;
	}

	
	public List<MateriaSalida> getMateriaSalida() {
		return materiaSalida;
	}

	public void setMateriaSalida(List<MateriaSalida> materiaSalida) {
		this.materiaSalida = materiaSalida;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sosa_id == null) ? 0 : sosa_id.hashCode());
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
		SolicitudSalidas other = (SolicitudSalidas) obj;
		if (sosa_id == null) {
			if (other.sosa_id != null)
				return false;
		} else if (!sosa_id.equals(other.sosa_id))
			return false;
		return true;
	}

	


	
	
	
}
