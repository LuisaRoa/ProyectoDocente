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
@Table(name = "syllabus")
public class Syllabus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String syllabusUrl;
	private String syllabusId;
	private String nombre;
	private String semestre;
	private String grupo;
	private String periodoAca;
	private int horasSemestral;
	private String fecha;
	private String tipoArchivo;
	private String tamaño;
	
	@ManyToOne
	@JoinColumn(name = "materia_mate_id", nullable = true, foreignKey = @ForeignKey(name = "mate_id"))
	private Materia materia;
	
	@ManyToOne
	@JoinColumn(name = "programaacademico_prac_id", nullable = true, foreignKey = @ForeignKey(name = "prac_id"))
	private ProgramaAcademico programaacademico;
	
	@ManyToOne
	@JoinColumn(name = "docente_doce_id", nullable = true, foreignKey = @ForeignKey(name = "doce_id"))
	private Docente docente;

	public Syllabus() {
		
	}
	public Syllabus(int id, String name, String syllabusUrl, String syllabusId, String nombre, String semestre, String grupo,
			String periodoAca, int horasSemestral, String fecha, Materia materia, ProgramaAcademico programaacademico,
			Docente docente, String tipoArchivo, String tamaño) {
		super();
		this.id = id;
		this.name = name;
		this.syllabusUrl = syllabusUrl;
		this.syllabusId = syllabusId;
		this.nombre = nombre;
		this.semestre = semestre;
		this.grupo = grupo;
		this.periodoAca = periodoAca;
		this.horasSemestral = horasSemestral;
		this.fecha = fecha;
		this.materia = materia;
		this.programaacademico = programaacademico;
		this.docente = docente;
		this.tipoArchivo = tipoArchivo;
		this.tamaño = tamaño;
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
	public String getSyllabusUrl() {
		return syllabusUrl;
	}
	public void setSyllabusUrl(String syllabusUrl) {
		this.syllabusUrl = syllabusUrl;
	}
	public String getSyllabusId() {
		return syllabusId;
	}
	public void setSyllabusId(String syllabusId) {
		this.syllabusId = syllabusId;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getPeriodoAca() {
		return periodoAca;
	}
	public void setPeriodoAca(String periodoAca) {
		this.periodoAca = periodoAca;
	}
	public int getHorasSemestral() {
		return horasSemestral;
	}
	public void setHorasSemestral(int horasSemestral) {
		this.horasSemestral = horasSemestral;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Materia getNucleoTemático() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	
}
