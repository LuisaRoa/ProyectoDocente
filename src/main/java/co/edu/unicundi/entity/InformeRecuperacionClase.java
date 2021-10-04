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
@Table(name = "recuperacionclase")
public class InformeRecuperacionClase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String informeUrl;
	private String informeId;
	private String nombre;
	private String semestre;
	private String grupo;
	private String periodoAca;
	private String fecha;
	private String tipoArchivo;
	private String tamaño;
	private int horasRecuperadas;
	private String motivo;
	
	@ManyToOne
	@JoinColumn(name = "materia_mate_id", nullable = true, foreignKey = @ForeignKey(name = "mate_id"))
	private Materia materia;
	
	@ManyToOne
	@JoinColumn(name = "programaacademico_prac_id", nullable = true, foreignKey = @ForeignKey(name = "prac_id"))
	private ProgramaAcademico programaacademico;
	
	@ManyToOne
	@JoinColumn(name = "docente_doce_id", nullable = true, foreignKey = @ForeignKey(name = "doce_id"))
	private Docente docente;
	
	public InformeRecuperacionClase() {
		
	}

	public InformeRecuperacionClase(int id, String name, String informeUrl, String informeId, String nombre,
			String semestre, String grupo, String periodoAca, String fecha, String tipoArchivo, String tamaño,
			int horasRecuperadas, String motivo, Materia materia, ProgramaAcademico programaacademico,
			Docente docente) {
		super();
		this.id = id;
		this.name = name;
		this.informeUrl = informeUrl;
		this.informeId = informeId;
		this.nombre = nombre;
		this.semestre = semestre;
		this.grupo = grupo;
		this.periodoAca = periodoAca;
		this.fecha = fecha;
		this.tipoArchivo = tipoArchivo;
		this.tamaño = tamaño;
		this.horasRecuperadas = horasRecuperadas;
		this.motivo = motivo;
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

	public String getInformeUrl() {
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

	public int getHorasRecuperadas() {
		return horasRecuperadas;
	}

	public void setHorasRecuperadas(int horasRecuperadas) {
		this.horasRecuperadas = horasRecuperadas;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Materia getMateria() {
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
