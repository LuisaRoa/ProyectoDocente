package co.edu.unicundi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "rol")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rol_id;
	
	@Column(name = "rol_nombre", length = 15, nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy ="rol", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Docente> docente ;
	
	@OneToMany(mappedBy ="rol", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Administrativo> administrativo ;
	
	public Rol() {
	}

	public Rol(Integer rol_id, String nombre, List<Docente> docente, List<Administrativo> administrativo) {
		super();
		this.rol_id = rol_id;
		this.nombre = nombre;
		this.docente = docente;
		this.administrativo = administrativo;
	}

	public Integer getRol_id() {
		return rol_id;
	}

	public void setRol_id(Integer rol_id) {
		this.rol_id = rol_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Docente> getDocente() {
		return docente;
	}

	public void setDocente(List<Docente> docente) {
		this.docente = docente;
	}

	public List<Administrativo> getAdministrativo() {
		return administrativo;
	}

	public void setAdministrativo(List<Administrativo> administrativo) {
		this.administrativo = administrativo;
	}
	
	
}
