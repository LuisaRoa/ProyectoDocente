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
@Table(name = "actas")
public class Actas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String actaUrl;
	private String actaId;
	private String fechaModificacion;
	private String tipoArchivo;
	private String tamaño;
	
	@ManyToOne
	@JoinColumn(name = "comite_comi_id", nullable = true, foreignKey = @ForeignKey(name = "comi_id"))
	private Comite comite;
	

	public Actas() {
	}


	public Actas(int id, String name, String actaUrl, String actaId, String fechaModificacion, String tipoArchivo,
			String tamaño, Comite comite) {
		super();
		this.id = id;
		this.name = name;
		this.actaUrl = actaUrl;
		this.actaId = actaId;
		this.fechaModificacion = fechaModificacion;
		this.tipoArchivo = tipoArchivo;
		this.tamaño = tamaño;
		this.comite = comite;
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


	public String getActaUrl() {
		return actaUrl;
	}


	public void setActaUrl(String actaUrl) {
		this.actaUrl = actaUrl;
	}


	public String getActaId() {
		return actaId;
	}


	public void setActaId(String actaId) {
		this.actaId = actaId;
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


	public Comite getComite() {
		return comite;
	}


	public void setComite(Comite comite) {
		this.comite = comite;
	}
	
	

}
