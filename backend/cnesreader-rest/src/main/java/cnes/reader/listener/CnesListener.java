package cnes.reader.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import cnes.reader.service.CnesService;

/**
 * @author ygor.satiro
 * Listener para execução no momento do Application Ready. 
 * Responsável por baixar CNES csv via HTTP GET e inserir no H2 Memory Database
 */

@Component
@Order(0)
public class CnesListener implements ApplicationListener<ApplicationReadyEvent> {
	
	@Autowired
	private CnesService service;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		try {
			service.retrieveCnesInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
}
