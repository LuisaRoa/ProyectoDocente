package co.edu.unicundi.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import co.edu.unicundi.entity.AcuerdoPedagogico;
import co.edu.unicundi.entity.Administrativo;
import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.Facultad;
import co.edu.unicundi.entity.Rol;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IAdministrativoRepo;
import co.edu.unicundi.repo.IDocenteRepo;
import co.edu.unicundi.repo.IRolRepo;
import co.edu.unicundi.service.IDocenteService;

@Service
public class DocenteServiceImp implements IDocenteService, UserDetailsService {

	@Autowired
	private IDocenteRepo repo;

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Autowired
	private IAdministrativoRepo repoAdmi;

	@Autowired
	private IRolRepo repoRol;

	List<Docente> docentes = new ArrayList<Docente>();

	@Override
	public Docente buscarId(int id) throws ModelNotFoundException {

		Docente docente = repo.findById(id).orElseThrow(() -> new ModelNotFoundException("Docente no exontrado"));
		return docente;

	}

	@Override
	public List<Docente> mostrarDocentes() throws ModelNotFoundException {
		return this.repo.findAll();
	}

	@Override
	public void guardar(Docente docente) throws Exception {
		for (Docente p : docentes) {
			if (p.getDocumento() == docente.getDocumento()) {
				throw new Exception("Ya existe el docente");
			}

		}
		// docentes.add(docente);
		Rol rol = repoRol.findById(22).orElseThrow(() -> new ModelNotFoundException("rol no  exontrado"));
		docente.setRol(rol);

		docente.setPassword(bcrypt.encode(docente.getDocumento()));
		this.repo.save(docente);
	}

	@Override
	public void editar(Docente docente) throws Exception, ModelNotFoundException {
		Docente pro = this.buscarId(docente.getId());

		Administrativo admi = repoAdmi.findById(docente.getAdministrativo().getAdmi_id())
				.orElseThrow(() -> new ModelNotFoundException("administrativo no  exontrado"));
		pro.setDocumento(docente.getDocumento());
		pro.setNombre(docente.getNombre());
		pro.setCodigo(docente.getCodigo());
		pro.setPassword(bcrypt.encode(docente.getPassword()));
		pro.setFechaNacimiento(docente.getFechaNacimiento());
		pro.setSexo(docente.getSexo());
		pro.setDireccion(docente.getDireccion());
		pro.setCelular(docente.getCelular());
		pro.setFechaIngreso(docente.getFechaIngreso());
		pro.setCorreo(docente.getCorreo());
		pro.setSede(docente.getSede());
		pro.setAdministrativo(admi);
		this.repo.save(pro);
	}

	@Override
	public void eliminar(int id) throws ModelNotFoundException {
		this.repo.delete(this.buscarId(id));
	}

	@Override
	public Docente buscarCorreo(String correo) throws ModelNotFoundException {

		Docente docente = repo.findByCorreo(correo)
				.orElseThrow(() -> new ModelNotFoundException("Docente no exontrado"));
		return docente;

	}

	@Override
	public Docente buscarCorreo1(String correo) throws ModelNotFoundException {

		Docente docente = repo.findOneByCorreo(correo);
		return docente;

	}

	public List<Docente> listarAdministrativo(int id) {
		List<Docente> docente = new ArrayList<Docente>();
		for (Docente p : repo.findAll()) {
			if (p.getAdministrativo().getId() == id) {
				docente.add(p);
			}

		}

		return docente;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Docente doce = repo.findOneByCorreo(username);

		if (doce == null) {
			Administrativo admi = repoAdmi.findOneByCorreo(username);
			if (admi == null) {
				throw new UsernameNotFoundException("----Usuario no encontrado");

			} else {
				List<GrantedAuthority> roles = new ArrayList<>();
				roles.add(new SimpleGrantedAuthority(admi.getRol().getNombre()));

				UserDetails ud = new User(admi.getCorreo(), admi.getPassword(), roles);
				return ud;
			}

		} else {
			List<GrantedAuthority> roles = new ArrayList<>();
			roles.add(new SimpleGrantedAuthority(doce.getRol().getNombre()));

			UserDetails ud = new User(doce.getCorreo(), doce.getPassword(), roles);
			return ud;
		}
	}

	

	

	@Override
	public void subirFoto(int idDocente, String nombre, String url, String id)
			throws Exception, ModelNotFoundException {
		Docente pro = this.buscarId(idDocente);
		pro.setFotoId(id);
		pro.setFotoUrl(url);
		pro.setName(nombre);
		this.repo.save(pro);

	}

	@Override
	public void cambiarPassword(int idDocente, String password) throws ModelNotFoundException {
		// TODO Auto-generated method stub
		Docente pro = this.buscarId(idDocente);
		pro.setPassword(bcrypt.encode(password));
		this.repo.save(pro);
	}
	
	@Override
	public List<Docente> listarNoMiembros(Integer id) {
		List<Docente> docentes = repo.buscarNoMiembros(id);
		return docentes;
	}

	public void buscarPassword(int idDocente, String password) throws ModelNotFoundException {
		
		Docente pro = this.buscarId(idDocente);
		if(password != null) {
			boolean f= bcrypt.matches(password, pro.getPassword());
			if(f) {
				
			}else {
				new ModelNotFoundException("Password no encontrada");
			}
		}
	}
	
	
}
