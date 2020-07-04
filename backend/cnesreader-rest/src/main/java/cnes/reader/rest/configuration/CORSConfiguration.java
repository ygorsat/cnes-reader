package cnes.reader.rest.configuration;

import java.util.Arrays;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * @author ygor.satiro
 * Configuração de CORS para permissão geral (permit all)
 */
@Configuration
public class CORSConfiguration {

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList(CorsConfiguration.ALL));
		config.setAllowCredentials(true);
		config.setAllowedMethods(Arrays.asList(CorsConfiguration.ALL));		
		config.setAllowedHeaders(Arrays.asList(CorsConfiguration.ALL));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		
		return source;
	}

}
