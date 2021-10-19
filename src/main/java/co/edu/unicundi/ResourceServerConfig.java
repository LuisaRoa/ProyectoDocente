package co.edu.unicundi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	//Trae todo lo que configuramos en el SecurityConfig
	@Autowired
	private ResourceServerTokenServices tokenServices;	
	
    @Value("${security.jwt.resource-ids}")
    private String resourceIds;	
    
    //De donde se van a crear los tokens y la configuración del resourcesIds
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceIds).tokenServices(tokenServices);
    } 
    

    //Url que vamos a proteger y como
    @Override
    public void configure(HttpSecurity http) throws Exception {
                http
                .exceptionHandling().authenticationEntryPoint(new AuthException())
                .and()
                .requestMatchers()
                .and()
                .authorizeRequests()                  
                .antMatchers("/actas/**" ).authenticated()                
                .antMatchers("/acuerdopedagogico/**" ).authenticated()
                .antMatchers("/evidencia/**" ).authenticated()
                .antMatchers("/comite/**" ).authenticated()
                .antMatchers("/asesoria/**" ).authenticated()
                .antMatchers("/desempeñoDocentes/**" ).authenticated()
                .antMatchers("/docente/**" ).authenticated()
                .antMatchers("/facultad/**" ).authenticated()
                .antMatchers("/informeHoras/**" ).authenticated()
                .antMatchers("/informeSalidas/**" ).authenticated()
                .antMatchers("/informeSemestral/**" ).authenticated()
                .antMatchers("/cloudinary/**" ).authenticated()
                .antMatchers("/materia/**" ).authenticated()
                .antMatchers("/programaacademico/**" ).authenticated()
                .antMatchers("/recuperacionclase/**" ).authenticated()
                .antMatchers("/notificacion/**" ).authenticated()
                .antMatchers("/solicitudaulas/**" ).authenticated()
                .antMatchers("/syllabus/**" ).authenticated()
                .antMatchers("/oauth/token/**" ).permitAll()
                .antMatchers("/cerrarSesion/**" ).authenticated();
    }    
    
    

}
