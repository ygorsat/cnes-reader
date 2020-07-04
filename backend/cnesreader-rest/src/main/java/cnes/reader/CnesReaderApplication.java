package cnes.reader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ygor.satiro
 * Classe main para execução da aplicação
 */

@SpringBootApplication
@ComponentScan(basePackages = "cnes.reader")
public class CnesReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CnesReaderApplication.class, args);
	}
}
