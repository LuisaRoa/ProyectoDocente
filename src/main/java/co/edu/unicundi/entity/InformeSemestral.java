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
@Table(name = "informesemestral")
public class InformeSemestral {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int estudianteApro;
	private int estudianteNoApro;
	private int estudianteRetirado;
	private String name;
	private String informeUrl;
	private String informeId;
	private String nombre;
	private String fecha;
	private String tipoArchivo;
	private String tamaño;
	private String semestre;
	private String grupo;
	private String periodoAca;
	private String año;
	
	@ManyToOne
	@JoinColumn(name = "programaacademico_prac_id", nullable = true, foreignKey = @ForeignKey(name = "prac_id"))
	private ProgramaAcademico programaacademico;
	
	@ManyToOne
	@JoinColumn(name = "docente_doce_id", nullable = true, foreignKey = @ForeignKey(name = "doce_id"))
	private Docente docente;
	
	@ManyToOne
	@JoinColumn(name = "materia_mate_id", nullable = true, foreignKey = @ForeignKey(name = "mate_id"))
	private Materia materia;
	
	public InformeSemestral() {
		
	}

	public InformeSemestral(int id, int estudianteApro, int estudianteNoApro, int estudianteRetirado, String name, String informeUrl,
			String informeId, String nombre, String fecha, String tipoArchivo, String tamaño, String semestre,
		    String grupo, String periodoAca, String año, ProgramaAcademico programaAcademico,
			Docente docente, Materia materia) {
		super();
		this.id = id;
		this.estudianteApro = estudianteApro;
		this.estudianteNoApro = estudianteNoApro;
		this.estudianteRetirado = estudianteRetirado;
		this.name = name;
		this.informeUrl = informeUrl;
		this.informeId = informeId;
		this.nombre = nombre;
		this.fecha = fecha;
		this.tipoArchivo = tipoArchivo;
		this.tamaño = tamaño;
		this.semestre = semestre;
		this.materia = materia;
		this.grupo = grupo;
		this.periodoAca = periodoAca;
		this.año = año;
		this.programaacademico = programaAcademico;
		this.docente = docente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEstudianteApro() {
		return estudianteApro;
	}

	public void setEstudianteApro(int estudianteApro) {
		this.estudianteApro = estudianteApro;
	}

	public int getEstudianteNoApro() {
		return estudianteNoApro;
	}

	public void setEstudianteNoApro(int estudianteNoApro) {
		this.estudianteNoApro = estudianteNoApro;
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

	public void setInformeUrl(String informeUrl) {
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
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

	public Materia getNucleoTemático() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public int getEstudianteRetirado() {
		return estudianteRetirado;
	}

	public void setEstudianteRetirado(int estudianteRetirado) {
		this.estudianteRetirado = estudianteRetirado;
	}

	
	
	
}
