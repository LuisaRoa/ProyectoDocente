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
@Table(name = "cronograma")
public class Cronograma {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String cronogramaUrl;
	private String cronogramaId;
	private String nombre;
	private String fecha;
	private String tipoArchivo;
	private String tamaño;
	
	@ManyToOne
	@JoinColumn(name = "comite_comi_id", nullable = true, foreignKey = @ForeignKey(name = "comi_id"))
	private Comite comite;
	
	public Cronograma() {
		
	}

	public Cronograma(int id, String name, String cronogramaUrl, String cronogramaId, String nombre, String fecha,
			String tipoArchivo, String tamaño, Comite comite) {
		super();
		this.id = id;
		this.name = name;
		this.cronogramaUrl = cronogramaUrl;
		this.cronogramaId = cronogramaId;
		this.nombre = nombre;
		this.fecha = fecha;
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

	public Comite getComite() {
		return comite;
	}

	public void setComite(Comite comite) {
		this.comite = comite;
	}
	
	
}
