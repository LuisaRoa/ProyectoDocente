package co.edu.unicundi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	
	@Column(name = "admi_lugarnacimiento", length = 30, nullable = false)
	private String lugarnacimiento;
	
	@Column(name = "admi_fechanacimiento", length = 30, nullable = false)
	private String fechanacimiento;
	
	@Column(name = "admi_sexo", length = 60, nullable = false)
	private String sexo;
	
	@Column(name = "admi_direccion", length = 60, nullable = false)
	private String direccion;	
	
	
	@Column(name = "admi_telefono", length = 60, nullable = false)
	private String telefono;	
	
	@Column(name = "admi_fechaingreso", length = 60, nullable = false)
	private String fechaingreso;	
	
	@Column(name = "admi_correo", length = 60, nullable = false)
	private String correo;	
	
	@Column(name = "admi_sede", length = 60, nullable = false)
	private String sede;

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



	public String getLugarnacimiento() {
		return lugarnacimiento;
	}

	public void setLugarnacimiento(String lugarnacimiento) {
		this.lugarnacimiento = lugarnacimiento;
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
		return telefono;
	}

	public void setCelular(String telefono) {
		this.telefono = telefono;
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

