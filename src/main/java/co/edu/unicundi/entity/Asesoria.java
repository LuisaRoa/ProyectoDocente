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
@Table(name = "asesoria")
public class Asesoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String asesoriaUrl;
	private String asesoriaId;
	private String nombre;
	private String fecha;
	private String tipoArchivo;
	private String tamaño;
	private String semestre;
	private String nucleo;
	
	public Asesoria() {
		
	}
	
	public Asesoria(int id, String name, String eviendeciaUrl, String evidenciaId, String nombre, String fecha,
			String tipoArchivo, String tamaño, String semestre, String nucleo) {
		super();
		this.id = id;
		this.name = name;
		this.asesoriaUrl = eviendeciaUrl;
		this.asesoriaId = evidenciaId;
		this.nombre = nombre;
		this.fecha = fecha;
		this.tipoArchivo = tipoArchivo;
		this.tamaño = tamaño;
		this.semestre = semestre;
		this.nucleo = nucleo;
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
	public String getAsesoriaUrl() {
		return asesoriaUrl;
	}
	public void setAsesoriaUrl(String eviendeciaUrl) {
		this.asesoriaUrl = eviendeciaUrl;
	}
	public String getAsesoriaId() {
		return asesoriaId;
	}
	public void setAsesoriaId(String evidenciaId) {
		this.asesoriaId = evidenciaId;
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

	public String getNucleo() {
		return nucleo;
	}

	public void setNucleo(String nucleo) {
		this.nucleo = nucleo;
	}
	
	
	
	
}
