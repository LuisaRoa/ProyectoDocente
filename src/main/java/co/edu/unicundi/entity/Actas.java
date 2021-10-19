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
	private String nombre;
	private String fecha;
	private String lugar;
	private String tipoArchivo;
	private String tamaño;
	
	@ManyToOne
	@JoinColumn(name = "comite_comi_id", nullable = true, foreignKey = @ForeignKey(name = "comi_id"))
	private Comite comite;
	

	public Actas() {
	}


	public Actas(int id, String name, String actaUrl, String actaId, String nombre, String fecha, String lugar,
			String tipoArchivo, String tamaño, Comite comite) {
		super();
		this.id = id;
		this.name = name;
		this.actaUrl = actaUrl;
		this.actaId = actaId;
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
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


	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
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
