package co.edu.unicundi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notificaciones")
public class Notificaciones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer noti_id;

	@Column(name = "noti_observacion", length = 500, nullable = false)
	private String noti_observacion;

	@Column(name = "noti_tipo_actividad", length = 100, nullable = false)
	private String noti_actividad;
	
	@ManyToOne
	@JoinColumn(name = "docente_doce_id", nullable = false, foreignKey = @ForeignKey(name = "doce_id"))
	private Docente docente;

	public Notificaciones() {
	}

	public Notificaciones(Integer noti_id, String noti_observacion, String noti_actividad, Docente docente) {
		super();
		this.noti_id = noti_id;
		this.noti_observacion = noti_observacion;
		this.noti_actividad = noti_actividad;
		this.docente = docente;
	}

	public Integer getNoti_id() {
		return noti_id;
	}

	public void setNoti_id(Integer noti_id) {
		this.noti_id = noti_id;
	}

	public String getNoti_observacion() {
		return noti_observacion;
	}

	public void setNoti_observacion(String noti_observacion) {
		this.noti_observacion = noti_observacion;
	}

	public String getNoti_actividad() {
		return noti_actividad;
	}

	public void setNoti_actividad(String noti_actividad) {
		this.noti_actividad = noti_actividad;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
	
	
}
