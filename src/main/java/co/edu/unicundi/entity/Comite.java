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
	private int comi_id;
	private String nombre;
	
	@OneToMany(mappedBy ="comite", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	//@JsonIgnore
	private List<Miembros> miembros;
	
	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Comite() {
	}


	



	public int getComi_id() {
		return comi_id;
	}




	public void setComi_id(int comi_id) {
		this.comi_id = comi_id;
	}




	public List<Miembros> getMiembros() {
		return miembros;
	}


	public void setMiembros(List<Miembros> miembros) {
		this.miembros = miembros;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + comi_id;
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comite other = (Comite) obj;
		if (comi_id != other.comi_id)
			return false;
		return true;
	}

	
	
	
	
	
}
