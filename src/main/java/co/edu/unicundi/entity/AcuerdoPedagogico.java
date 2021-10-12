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
@Table(name = "acuerdopedagogico")
public class AcuerdoPedagogico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String acuerdoUrl;
	private String acuerdoId;
	private String nombre;
	private String semestre;
	private String grupo;
	private String periodoAca;
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

	public AcuerdoPedagogico() {
		
	}
	
	public AcuerdoPedagogico(int id, String name, String acuerdoUrl, String acuerdoId, String nombre, String semestre,
			String grupo, String periodoAca, String fecha, String tipoArchivo, String tamaño, Materia materia,
			ProgramaAcademico programaacademico, Docente docente) {
		super();
		this.id = id;
		this.name = name;
		this.acuerdoUrl = acuerdoUrl;
		this.acuerdoId = acuerdoId;
		this.nombre = nombre;
		this.semestre = semestre;
		this.grupo = grupo;
		this.periodoAca = periodoAca;
		this.fecha = fecha;
		this.tipoArchivo = tipoArchivo;
		this.tamaño = tamaño;
		this.materia = materia;
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
		return acuerdoUrl;
	}

	public void setAcuerdoUrl(String acuerdoUrl) {
		this.acuerdoUrl = acuerdoUrl;
	}

	public String getAcuerdoId() {
		return acuerdoId;
	}

	public void setAcuerdoId(String acuerdoId) {
		this.acuerdoId = acuerdoId;
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
	
	
	
}
