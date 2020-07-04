package cnes.reader.service.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ygor.satiro
 * Classe para inicialização do ModelMapper
 */
@Configuration
public class MapperConfiguration {
	
	@Bean
	public ModelMapper modelMapper() {
	    ModelMapper modelMapper = new ModelMapper();	    
	    return modelMapper;
	    
	}

	
	
}
