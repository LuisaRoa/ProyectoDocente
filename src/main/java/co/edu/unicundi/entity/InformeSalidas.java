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
@Table(name = "informesalidas")
public class InformeSalidas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String informeUrl;
	private String informeId;
	private String nombre;
	private String fecha;
	private String periodo;
	private String tipoArchivo;
	private String tamaño;
	
	@ManyToOne
	@JoinColumn(name = "solicitudsalidas_sosa_id", nullable = true, foreignKey = @ForeignKey(name = "sosa_id"))
	private SolicitudSalidas solicitudSalida;
	
	@ManyToOne
	@JoinColumn(name = "docente_doce_id", nullable = true, foreignKey = @ForeignKey(name = "doce_id"))
	private Docente docente;

	public InformeSalidas() {
		
	}
	
	

	public InformeSalidas(int id, String name, String informeUrl, String informeId, String nombre, String fecha,
			String periodo, String tipoArchivo, String tamaño, SolicitudSalidas solicitudSalida, Docente docente) {
		super();
		this.id = id;
		this.name = name;
		this.informeUrl = informeUrl;
		this.informeId = informeId;
		this.nombre = nombre;
		this.fecha = fecha;
		this.periodo = periodo;
		this.tipoArchivo = tipoArchivo;
		this.tamaño = tamaño;
		this.solicitudSalida = solicitudSalida;
		this.docente = docente;
	}


	public String getPeriodo() {
		return periodo;
	}



	public void setPeriodo(String periodo) {
		this.periodo = periodo;
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

	public SolicitudSalidas getSolicitudSalida() {
		return solicitudSalida;
	}

	public void setSolicitudSalida(SolicitudSalidas solicitudSalida) {
		this.solicitudSalida = solicitudSalida;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
	
}
