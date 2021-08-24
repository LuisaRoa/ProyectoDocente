package co.edu.unicundi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	private String fechanacimiento;
	
	@Column(name = "doce_sexo", length = 60, nullable = false)
	private String sexo;
	
	@Column(name = "doce_direccion", length = 60, nullable = false)
	private String direccion;	
	
	
	@Column(name = "doce_celular", length = 60, nullable = false)
	private String celular;	
	
	@Column(name = "doce_fecha_ingreso", length = 60, nullable = false)
	private String fechaingreso;	
	
	@Column(name = "doce_correo", length = 60, nullable = false)
	private String correo;	
	
	@Column(name = "doce_sede", length = 60, nullable = false)
	private String sede;

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
		return fechanacimiento;
	}

	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
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
		return fechaingreso;
	}

	public void setFechaingreso(String fechaingreso) {
		this.fechaingreso = fechaingreso;
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
