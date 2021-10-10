package co.edu.unicundi.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


;

@Embeddable
public class MiembrosPk implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "doce_id", nullable = false)
	private Docente docente;
	
	@ManyToOne
	@JoinColumn(name = "comi_id", nullable = false)
	private Comite comite;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comite == null) ? 0 : comite.hashCode());
		result = prime * result + ((docente == null) ? 0 : docente.hashCode());
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
		MiembrosPk other = (MiembrosPk) obj;
		if (comite == null) {
			if (other.comite != null)
				return false;
		} else if (!comite.equals(other.comite))
			return false;
		if (docente == null) {
			if (other.docente != null)
				return false;
		} else if (!docente.equals(other.docente))
			return false;
		return true;
	}

	
}

