package co.edu.unicundi.entity;



import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "docente")
public class Docente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer doce_id;
	
	@Column(name = "name", length = 30, nullable = true)
	private String name;
	
	@Column(name = "fotoUrl", length = 90, nullable = true)
	private String fotoUrl;
	
	@Column(name = "fotoId", length = 30, nullable = true)
	private String fotoId;
	
	@Column(name = "doce_documento", length = 30, nullable = false)
	private String documento;
	
	@NotNull(message = "Nombre  requerido")
	@Size(min = 3, max = 30, message = "Nombre entre 3 y 30 caracteres")
	@Column(name = "doce_nombre", length = 30, nullable = false)
	private String nombre;

	
	@Column(name = "doce_codigo", length = 60, nullable = false)
	private String codigo;
	
	@Column(name = "doce_password", length = 60, nullable = false)
	private String password;
	
	@Column(name = "doce_fecha_nacimiento", length = 30, nullable = false)
	private String fechaNacimiento;
	
	@Column(name = "doce_sexo", length = 60, nullable = false)
	private String sexo;
	
	@Column(name = "doce_direccion", length = 60, nullable = false)
	private String direccion;	
	
	
	@Column(name = "doce_celular", length = 60, nullable = false)
	private String celular;	
	
	@Column(name = "doce_fecha_ingreso", length = 60, nullable = false)
	private String fechaIngreso;	
	
	@Column(name = "doce_correo", length = 60, nullable = false)
	private String correo;	
	
	@Column(name = "doce_sede", length = 60, nullable = false)
	private String sede;
	
	@Column(name = "doce_tipo_contrato", length = 60, nullable = true)
	private String contrato;
	
	@ManyToOne
	@JoinColumn(name = "rol_id", nullable = true, foreignKey = @ForeignKey(name = "rol_id"))
	private Rol rol;
	
	
	@ManyToOne
	@JoinColumn(name = "administrativo_admi_id", nullable = false, foreignKey = @ForeignKey(name = "admi_id"))
	private Administrativo administrativo;
	
	
	@OneToMany(mappedBy ="docente", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<AulasVirtuales> aulasvirtuales ;
	
	@OneToMany(mappedBy ="docente", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<SolicitudAulas> solicitudAulas ;
	
	@OneToMany(mappedBy ="docente", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<SolicitudSalidas> solicitudSalidas ;
	
	@OneToMany(mappedBy ="docente", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Miembros> miembros ;
	
	@OneToMany(mappedBy ="docente", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<InformeSemestral> informeSemes ;
	
	@OneToMany(mappedBy ="docente", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Asesoria> asesoria ;
	
	@OneToMany(mappedBy ="docente", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Syllabus> syllabus ;
	
	@OneToMany(mappedBy ="docente", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<InformeHorasNoLectivas> informe ;
	
	@OneToMany(mappedBy ="docente", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Notificaciones> notificacion; 
	

	public Docente() {
	}

	
	public Docente(Integer doce_id, String documento,
			String nombre,
			String codigo, String password, String fechaNacimiento, String sexo, String direccion, String celular,
			String fechaIngreso, String correo, String sede, String contrato, Rol rol, Administrativo administrativo,
			List<AulasVirtuales> aulasvirtuales, List<Miembros> miembros, List<InformeSemestral> informeSemes,
			List<Asesoria> asesoria, List<Syllabus> syllabus, List<InformeHorasNoLectivas> informe,  List<Notificaciones> notificacion) {
		super();
		this.doce_id = doce_id;
		this.documento = documento;
		this.nombre = nombre;
		this.codigo = codigo;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.direccion = direccion;
		this.celular = celular;
		this.fechaIngreso = fechaIngreso;
		this.correo = correo;
		this.sede = sede;
		this.contrato = contrato;
		this.rol = rol;
		this.administrativo = administrativo;
		this.aulasvirtuales = aulasvirtuales;
		this.miembros = miembros;
		this.informeSemes = informeSemes;
		this.asesoria = asesoria;
		this.syllabus = syllabus;
		this.informe = informe;
		this.notificacion = notificacion;
	}

	
	public List<SolicitudAulas> getSolicitudAulas() {
		return solicitudAulas;
	}


	public void setSolicitudAulas(List<SolicitudAulas> solicitudAulas) {
		this.solicitudAulas = solicitudAulas;
	}


	public List<SolicitudSalidas> getSolicitudSalidas() {
		return solicitudSalidas;
	}


	public void setSolicitudSalidas(List<SolicitudSalidas> solicitudSalidas) {
		this.solicitudSalidas = solicitudSalidas;
	}


	public List<Notificaciones> getNotificacion() {
		return notificacion;
	}


	public void setNotificacion(List<Notificaciones> notificacion) {
		this.notificacion = notificacion;
	}


	public String getContrato() {
		return contrato;
	}


	public void setContrato(String contrato) {
		this.contrato = contrato;
	}


	public List<InformeHorasNoLectivas> getInforme() {
		return informe;
	}


	public void setInforme(List<InformeHorasNoLectivas> informe) {
		this.informe = informe;
	}


	public Administrativo getAdministrativo() {
		return administrativo;
	}

	public void setAdministrativo(Administrativo administrativo) {
		this.administrativo = administrativo;
	}


	public List<AulasVirtuales> getAulasvirtuales() {
		return (List<AulasVirtuales>) aulasvirtuales;
	}

	public void setAulasvirtuales(List<AulasVirtuales> aulasvirtuales) {
		this.aulasvirtuales = (List<AulasVirtuales>) aulasvirtuales;
	}

	public Integer getId() {
		return doce_id;
	}

	public void setId(Integer id) {
		this.doce_id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fecha_nacimiento) {
		this.fechaNacimiento = fecha_nacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public List<Miembros> getMiembros() {
		return miembros;
	}

	public void setMiembros(List<Miembros> miembros) {
		this.miembros = miembros;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<InformeSemestral> getInformeSemes() {
		return informeSemes;
	}

	public void setInformeSemes(List<InformeSemestral> informeSemes) {
		this.informeSemes = informeSemes;
	}

	public List<Asesoria> getAsesoria() {
		return asesoria;
	}

	public void setAsesoria(List<Asesoria> asesoria) {
		this.asesoria = asesoria;
	}

	public List<Syllabus> getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(List<Syllabus> syllabus) {
		this.syllabus = syllabus;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFotoUrl() {
		return fotoUrl;
	}


	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}


	public String getFotoId() {
		return fotoId;
	}


	public void setFotoId(String fotoId) {
		this.fotoId = fotoId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doce_id == null) ? 0 : doce_id.hashCode());
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
		Docente other = (Docente) obj;
		if (doce_id == null) {
			if (other.doce_id != null)
				return false;
		} else if (!doce_id.equals(other.doce_id))
			return false;
		return true;
	}	
	
	
	
	
	
	
	
	




	
}
