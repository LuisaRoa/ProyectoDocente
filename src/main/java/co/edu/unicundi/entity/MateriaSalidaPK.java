package co.edu.unicundi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MateriaSalidaPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name= "mate_id")
    private Integer idMateria;
    
    @Column(name= "sosa_id")
    private Integer idSolicitudSalida;

	public Integer getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}

	public Integer getIdSolicitudSalida() {
		return idSolicitudSalida;
	}

	public void setIdSolicitudSalida(Integer idSolicitudSalida) {
		this.idSolicitudSalida = idSolicitudSalida;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMateria == null) ? 0 : idMateria.hashCode());
		result = prime * result + ((idSolicitudSalida == null) ? 0 : idSolicitudSalida.hashCode());
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
		MateriaSalidaPK other = (MateriaSalidaPK) obj;
		if (idMateria == null) {
			if (other.idMateria != null)
				return false;
		} else if (!idMateria.equals(other.idMateria))
			return false;
		if (idSolicitudSalida == null) {
			if (other.idSolicitudSalida != null)
				return false;
		} else if (!idSolicitudSalida.equals(other.idSolicitudSalida))
			return false;
		return true;
	}
    
    
}
