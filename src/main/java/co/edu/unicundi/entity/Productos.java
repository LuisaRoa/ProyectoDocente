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
@Table(name = "productos")
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String productoUrl;
	private String productoId;
	private String producto;
	private String nombre;
	private String fechaElaboracion;
	private String tipoArchivo;
	private String tamaño;
	
	@ManyToOne
	@JoinColumn(name = "comite_comi_id", nullable = true, foreignKey = @ForeignKey(name = "comi_id"))
	private Comite comite;

	public Productos() {
	}

	public Productos(int id, String name, String productoUrl, String productoId, String producto, String nombre,
			String fechaElaboracion, String tipoArchivo, String tamaño, Comite comite) {
		super();
		this.id = id;
		this.name = name;
		this.productoUrl = productoUrl;
		this.productoId = productoId;
		this.producto = producto;
		this.nombre = nombre;
		this.fechaElaboracion = fechaElaboracion;
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

	public String getProductoUrl() {
		return productoUrl;
	}

	public void setProductoUrl(String productoUrl) {
		this.productoUrl = productoUrl;
	}

	public String getProductoId() {
		return productoId;
	}

	public void setProductoId(String productoId) {
		this.productoId = productoId;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaElaboración() {
		return fechaElaboracion;
	}

	public void setFechaElaboración(String fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
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
