package co.edu.unicundi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "administrativo")
public class Administrativo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer admi_id;
	
	
	@Column(name = "admi_documento", length = 30, nullable = false)
	private String documento;
	
	@NotNull(message = "Nombre  requerido")
	@Size(min = 3, max = 30, message = "Nombre entre 3 y 30 caracteres")
	@Column(name = "admi_nombre", length = 30, nullable = false)
	private String nombre;

	
	@Column(name = "admi_codigo", length = 60, nullable = false)
	private String codigo;
	
	@Column(name = "admi_password", length = 60, nullable = false)
	private String password;
	
	@Column(name = "admi_fecha_nacimiento", length = 30, nullable = false)
	private String fecha_nacimiento;
	
	@Column(name = "admi_sexo", length = 60, nullable = false)
	private String sexo;
	
	@Column(name = "admi_direccion", length = 60, nullable = false)
	private String direccion;	
	
	
	@Column(name = "admi_celular", length = 60, nullable = false)
	private String celular;	
	
	@Column(name = "admi_fecha_ingreso", length = 60, nullable = false)
	private String fecha_ingreso;	
	
	@Column(name = "admi_correo", length = 60, nullable = false)
	private String correo;	
	
	@Column(name = "admi_sede", length = 60, nullable = false)
	private String sede;
	
	@OneToOne(mappedBy ="administrativo", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Docente docente ;

	public Integer getId() {
		return admi_id;
	}

	public void setId(Integer id) {
		this.admi_id = id;
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
		return fecha_nacimiento;
	}

	public void setFechanacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
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

	public String getFechaingreso() {
		return fecha_ingreso;
	}

	public void setFechaingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
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

