package co.edu.unicundi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "comite")
public class Comite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String cronogramaUrl;
	private String cronogramaId;
	private String fechaModificacion;
	private String tipoArchivo;
	private String tamaño;
	
	@OneToMany(mappedBy ="comite", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Miembros> miembros ;
	
	public Comite() {
	}


	public Comite(int id, String name, String cronogramaUrl, String cronogramaId, String fechaModificacion,
			String tipoArchivo, String tamaño, List<Miembros> miembros) {
		super();
		this.id = id;
		this.name = name;
		this.cronogramaUrl = cronogramaUrl;
		this.cronogramaId = cronogramaId;
		this.fechaModificacion = fechaModificacion;
		this.tipoArchivo = tipoArchivo;
		this.tamaño = tamaño;
		this.miembros = miembros;
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

	public String getCronogramaUrl() {
		return cronogramaUrl;
	}

	public void setCronogramaUrl(String cronogramaUrl) {
		this.cronogramaUrl = cronogramaUrl;
	}

	public String getCronogramaId() {
		return cronogramaId;
	}

	public void setCronogramaId(String cronogramaId) {
		this.cronogramaId = cronogramaId;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
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


	public List<Miembros> getMiembros() {
		return miembros;
	}


	public void setMiembros(List<Miembros> miembros) {
		this.miembros = miembros;
	}
	
	
	
	
}
