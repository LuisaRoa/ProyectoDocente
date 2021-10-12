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
@Table(name = "cierreacademico")
public class CierreAcademico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String informeUrl;
	private String informeId;
	private String nombre;
	private String semestre;
	private String periodoAca;
	private String fecha;
	private String tipoArchivo;
	private String tamaño;
	
	@ManyToOne
	@JoinColumn(name = "administrativo_admi_id", nullable = true, foreignKey = @ForeignKey(name = "admi_id"))
	private Administrativo administrativo;
	
	public CierreAcademico() {
		
	}

	public CierreAcademico(int id, String name, String informeUrl, String informeId, String nombre, String semestre,
			String periodoAca, String fecha, String tipoArchivo, String tamaño, Administrativo administrativo) {
		super();
		this.id = id;
		this.name = name;
		this.informeUrl = informeUrl;
		this.informeId = informeId;
		this.nombre = nombre;
		this.semestre = semestre;
		this.periodoAca = periodoAca;
		this.fecha = fecha;
		this.tipoArchivo = tipoArchivo;
		this.tamaño = tamaño;
		this.administrativo = administrativo;
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

	public Administrativo getAdministrativo() {
		return administrativo;
	}

	public void setAdministrativo(Administrativo administrativo) {
		this.administrativo = administrativo;
	}
	
	
	
	
}
