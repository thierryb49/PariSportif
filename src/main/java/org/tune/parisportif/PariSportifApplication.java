package org.tune.parisportif;

import java.util.Locale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2
@Configuration
public class PariSportifApplication implements CommandLineRunner, WebMvcConfigurer{
	
	/*@Autowired
	private UserRepository userRepository;
	*/
	/*@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
*/
	public static void main(String[] args) {
		SpringApplication.run(PariSportifApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//repositoryRestConfiguration.exposeIdsFor(Phase.class, Pronostic.class, Rencontre.class, Team.class, User.class);
		//Random rnd = new Random();
		/*userRepository.save(new User().withUserName("Thierry").withMail("thierry_bouillon@hotmail.com").withPassword("TBO"));
		userRepository.save(new User().withUserName("Julien").withMail("servais.julien@laposte.net").withPassword("JSO"));
		for(int i=0; i<10; i++) {
			String randomName=RandomString.make(20);
			userRepository.save(new User().withUserName(randomName).withMail(randomName + "@gfi.fr").withPassword(randomName));
		}	*/			
	}
	
	@Bean
	public LocaleResolver localResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(localeChangeInterceptor());
	}
	

}
