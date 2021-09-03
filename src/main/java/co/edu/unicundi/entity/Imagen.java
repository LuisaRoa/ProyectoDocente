package co.edu.unicundi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Archivos")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String imagenUrl;
    private String imagenId;
    private String codigo;
	private String nombre;
	private String proceso;
	private String version;
	private String fechaAprobacion;

    public Imagen() {
    }

   
    public Imagen(int id, String name, String imagenUrl, String imagenId, String codigo, String nombre, String proceso,
			String version, String fechaAprobacion) {
		super();
		this.id = id;
		this.name = name;
		this.imagenUrl = imagenUrl;
		this.imagenId = imagenId;
		this.codigo = codigo;
		this.nombre = nombre;
		this.proceso = proceso;
		this.version = version;
		this.fechaAprobacion = fechaAprobacion;
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

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getImagenId() {
        return imagenId;
    }

    public void setImagenId(String imagenId) {
        this.imagenId = imagenId;
    }


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getProceso() {
		return proceso;
	}


	public void setProceso(String proceso) {
		this.proceso = proceso;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public String getFechaAprobacion() {
		return fechaAprobacion;
	}


	public void setFechaAprobacion(String fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}
    
    
}
