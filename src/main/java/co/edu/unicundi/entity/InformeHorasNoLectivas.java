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
@Table(name = "informehorasnolectivas")
public class InformeHorasNoLectivas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String informeUrl;
	private String informeId;
	private String nombre;
	private String fechaElaboración;
	private String tipoArchivo;
	private String tamaño;
	private String periodoAca;
	private String año;
	
	@ManyToOne
	@JoinColumn(name = "programaacademico_prac_id", nullable = true, foreignKey = @ForeignKey(name = "prac_id"))
	private ProgramaAcademico programaacademico;
	
	@ManyToOne
	@JoinColumn(name = "docente_doce_id", nullable = true, foreignKey = @ForeignKey(name = "doce_id"))
	private Docente docente;
	

	public InformeHorasNoLectivas() {
	}

	public InformeHorasNoLectivas(int id, String name, String informeUrl, String informeId, String nombre,
			String fechaElaboración, String tipoArchivo, String tamaño, String periodoAca, String año,
			ProgramaAcademico programaacademico, Docente docente) {
		super();
		this.id = id;
		this.name = name;
		this.informeUrl = informeUrl;
		this.informeId = informeId;
		this.nombre = nombre;
		this.fechaElaboración = fechaElaboración;
		this.tipoArchivo = tipoArchivo;
		this.tamaño = tamaño;
		this.periodoAca = periodoAca;
		this.año = año;
		this.programaacademico = programaacademico;
		this.docente = docente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArchivoUrl() {
		return informeUrl;
	}

	public void setArchivoUrl(String informeUrl) {
		this.informeUrl = informeUrl;
	}

	public String getInformeId() {
		return informeId;
	}

	public void setInformeId(String informeId) {
		this.informeId = informeId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaElaboración() {
		return fechaElaboración;
	}

	public void setFechaElaboración(String fechaElaboración) {
		this.fechaElaboración = fechaElaboración;
	}

	public String getTipoArchivo() {
		return tipoArchivo;
	}

	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

	public String getTamaño() {
		return tamaño;
	}

	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}

	public String getPeriodoAcadémico() {
		return periodoAca;
	}

	public void setPeriodoAcadémico(String periodoAca) {
		this.periodoAca = periodoAca;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public ProgramaAcademico getProgramaacademico() {
		return programaacademico;
	}

	public void setProgramaacademico(ProgramaAcademico programaacademico) {
		this.programaacademico = programaacademico;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}


	
	
	
	
	
}
