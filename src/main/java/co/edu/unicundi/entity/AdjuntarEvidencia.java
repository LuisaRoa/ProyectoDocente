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
		
		@ManyToOne
		@JoinColumn(name = "aulavirtual_auvi_id", nullable = true, foreignKey = @ForeignKey(name = "auvi_id"))
		private AulasVirtuales aulasvirtuales;
		
		public AdjuntarEvidencia() {
		}
		

		public AdjuntarEvidencia(int id, String name, String eviendeciaUrl, String evidenciaId,
				AulasVirtuales aulasvirtuales) {
			super();
			this.id = id;
			this.name = name;
			this.eviendeciaUrl = eviendeciaUrl;
			this.evidenciaId = evidenciaId;
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
		

		
}