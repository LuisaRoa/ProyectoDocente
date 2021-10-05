package co.edu.unicundi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class MateriaSalidaPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name= "mate_id", nullable= false)
    private Materia materia;
    
	@ManyToOne
	@JoinColumn(name= "sosa_id", nullable= false)
    private SolicitudSalidas solicitudsalidas;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((materia == null) ? 0 : materia.hashCode());
		result = prime * result + ((solicitudsalidas == null) ? 0 : solicitudsalidas.hashCode());
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
		if (materia == null) {
			if (other.materia != null)
				return false;
		} else if (!materia.equals(other.materia))
			return false;
		if (solicitudsalidas == null) {
			if (other.solicitudsalidas != null)
				return false;
		} else if (!solicitudsalidas.equals(other.solicitudsalidas))
			return false;
		return true;
	}

	

	

	
	
    
    
}
