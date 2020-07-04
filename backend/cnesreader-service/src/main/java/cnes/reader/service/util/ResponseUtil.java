package cnes.reader.service.util;

import org.springframework.http.HttpStatus;

import cnes.reader.dto.base.MessageApiDTO;

/**
 * @author ygor.satiro
 * Classe de utils para montar resposta das operações de API
 */
public final class ResponseUtil {

	public static MessageApiDTO mountResponse(Long id, String mensagem) {
		return new MessageApiDTO(id, HttpStatus.OK.value(), mensagem);
	}
	
}
