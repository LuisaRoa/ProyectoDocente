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
	
	@Column(name = "admi_password", length = 60, nullable = true)
	private String password;
	
	@Column(name = "admi_fecha_nacimiento", length = 30, nullable = false)
	private String fechaNacimiento;
	
	@Column(name = "admi_sexo", length = 60, nullable = false)
	private String sexo;
	
	@Column(name = "admi_direccion", length = 60, nullable = false)
	private String direccion;	
	
	
	@Column(name = "admi_celular", length = 60, nullable = false)
	private String celular;	
	
	@Column(name = "admi_fecha_ingreso", length = 60, nullable = false)
	private String fechaIngreso;	
	
	@Column(name = "admi_correo", length = 60, nullable = false)
	private String correo;	
	
	@Column(name = "admi_sede", length = 60, nullable = false)
	private String sede;
	
	@OneToMany(mappedBy ="administrativo", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Docente> docente ;
	
	@ManyToOne
	@JoinColumn(name = "programa_prac_id", nullable = false, foreignKey = @ForeignKey(name = "prac_id"))
	private ProgramaAcademico programaacademico;


	
	public Administrativo() {
	}

	public Administrativo(Integer admi_id, String documento,String nombre,String codigo, String password, String fechaNacimiento, String sexo, String direccion, String celular,
			String fecha_ingreso, String correo, String sede, List<Docente> docente,
			ProgramaAcademico programaacademico) {
		super();
		this.admi_id = admi_id;
		this.documento = documento;
		this.nombre = nombre;
		this.codigo = codigo;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.direccion = direccion;
		this.celular = celular;
		this.fechaIngreso = fecha_ingreso;
		this.correo = correo;
		this.sede = sede;
		this.docente = docente;
		this.programaacademico = programaacademico;
	}

	public Integer getAdmi_id() {
		return admi_id;
	}

	public void setAdmi_id(Integer admi_id) {
		this.admi_id = admi_id;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public List<Docente> getDocente() {
		return docente;
	}

	public void setDocente(List<Docente> docente) {
		this.docente = docente;
	}
	
	
	
	public Integer getId() {
		return admi_id;
	}
	
	
	public ProgramaAcademico getProgramaacademico() {
		return programaacademico;
	}

	public void setProgrmaacademico(ProgramaAcademico progrmaacademico) {
		this.programaacademico = progrmaacademico;
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

