package com.devsuperior.dsdeliver.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {//libera o acesso a aplicação para gerenciamento do banco de teste h2
			http.headers().frameOptions().disable();
		}
		
		http.cors().and().csrf().disable();//Libera o cros baseado na configuração no (CorsConfigurationSource).Como a aplicação não guarda dados em sessâo está sendo desabilitado o tipo de ataque em sessão
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//não armazena estado
		http.authorizeRequests().anyRequest().permitAll();//liberando o acesso a todas requisições
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {//liberação do cors pq o back está hospedado em um servidor e o front em outro 
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}