package co.edu.unicundi.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	
	@ManyToOne
	@JoinColumn(name = "administrativo_admi_id", nullable = false, foreignKey = @ForeignKey(name = "admi_id"))
	private Administrativo administrativo;
	
	
	@OneToMany(mappedBy ="docente", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<AulasVirtuales> aulasvirtuales ;
	
	

	public Docente() {
	}

	public Docente(Integer doce_id, String documento,String nombre,	String codigo, String password, String fecha_nacimiento, String sexo, String direccion, String celular,
			String fecha_ingreso, String correo, String sede,Administrativo administrativo, List<AulasVirtuales> aulasvirtuales) {
		super();
		this.doce_id = doce_id;
		this.documento = documento;
		this.nombre = nombre;
		this.codigo = codigo;
		this.password = password;
		this.fechaNacimiento = fecha_nacimiento;
		this.sexo = sexo;
		this.direccion = direccion;
		this.celular = celular;
		this.fechaIngreso = fecha_ingreso;
		this.correo = correo;
		this.sede = sede;
		this.administrativo = administrativo;
		this.aulasvirtuales = (List<AulasVirtuales>) aulasvirtuales;
	}
	
	@JsonBackReference 
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

	public String getFechanacimiento() {
		return fechaNacimiento;
	}

	public void setFechanacimiento(String fecha_nacimiento) {
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
	
	
	
	
	
	
	
	




	
}
