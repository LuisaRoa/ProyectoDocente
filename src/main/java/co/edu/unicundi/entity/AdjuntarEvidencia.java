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
@Table(name = "adjuntarevidencia")
public class AdjuntarEvidencia {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private String name;
		private String eviendeciaUrl;
		private String evidenciaId;
		private String nombre;
		private String fechaModificacion;
		private String corte;
		private String tipoArchivo;
		private String tamaño;
		
		@ManyToOne
		@JoinColumn(name = "aulavirtual_auvi_id", nullable = true, foreignKey = @ForeignKey(name = "auvi_id"))
		private AulasVirtuales aulasvirtuales;
		
		public AdjuntarEvidencia() {
			
		}
		

		public AdjuntarEvidencia(int id, String name, String eviendeciaUrl, String evidenciaId, String nombre, String fechaModificacion, String corte, String tipoArchivo,
				AulasVirtuales aulasvirtuales, String tamaño) {
			super();
			this.id = id;
			this.name = name;
			this.eviendeciaUrl = eviendeciaUrl;
			this.evidenciaId = evidenciaId;
			this.nombre = nombre;
			this.fechaModificacion = fechaModificacion;
			this.corte = corte;
			this.tipoArchivo = tipoArchivo;
			this.tamaño = tamaño;
			this.aulasvirtuales = aulasvirtuales;
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

		public String getEviendeciaUrl() {
			return eviendeciaUrl;
		}

		public void setEviendeciaUrl(String eviendeciaUrl) {
			this.eviendeciaUrl = eviendeciaUrl;
		}

		public String getEvidenciaId() {
			return evidenciaId;
		}

		public void setEvidenciaId(String evidenciaId) {
			this.evidenciaId = evidenciaId;
		}

		public AulasVirtuales getAulasvirtuales() {
			return aulasvirtuales;
		}

		public void setAulasvirtuales(AulasVirtuales aulasvirtuales) {
			this.aulasvirtuales = aulasvirtuales;
		}


		public String getFechaModificacion() {
			return fechaModificacion;
		}


		public void setFechaModificacion(String fechaModificacion) {
			this.fechaModificacion = fechaModificacion;
		}


		public String getCorte() {
			return corte;
		}


		public void setCorte(String corte) {
			this.corte = corte;
		}


		public String getTipoArchivo() {
			return tipoArchivo;
		}


		public void setTipoArchivo(String tipoArchivo) {
			this.tipoArchivo = tipoArchivo;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getTamaño() {
			return tamaño;
		}


		public void setTamaño(String tamaño) {
			this.tamaño = tamaño;
		}
		

		
}