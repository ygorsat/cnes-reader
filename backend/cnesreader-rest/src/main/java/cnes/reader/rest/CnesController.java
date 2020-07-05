package cnes.reader.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cnes.reader.dto.base.MessageApiDTO;
import cnes.reader.dto.base.PaginationDTO;
import cnes.reader.dto.cnes.SearchFilterCnesDTO;
import cnes.reader.dto.cnes.ViewCnesDTO;
import cnes.reader.service.CnesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author ygor.satiro
 * Controller CNES
 */
@RestController
@Api(value = "CNES") 
@RequestMapping("cnes")
@CrossOrigin
public class CnesController {
	
	@Autowired
	private CnesService service;
	
	@GetMapping
	@ApiOperation(value = "Operação para consultar CNES por filtros", produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = ViewCnesDTO.class, message = "Sucesso"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public PaginationDTO<ViewCnesDTO> retrieveCnes(@Valid SearchFilterCnesDTO dto) {
		return service.retrieveCnes(dto);
	}
	
	@GetMapping("/all")
	@ApiOperation(value = "Operação para consultar todos os CNES sem filtro", produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = ViewCnesDTO.class, message = "Sucesso"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public Set<ViewCnesDTO> retrieveCnes() {
		return service.retrieveCnes();
	}
	
	@GetMapping("{id}")
	@ApiOperation(value = "Operação para consultar todos os CNES sem filtro", produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = ViewCnesDTO.class, message = "Sucesso"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public ViewCnesDTO retrieveCnesById(@PathVariable Long id) {
		return service.retrieveCnesById(id);
	}
	
	@PostMapping
	@ApiOperation(value = "Operação para Cadastrar CNES", produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = MessageApiDTO.class, message = "Sucesso"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public MessageApiDTO createCnes(@RequestBody @Valid ViewCnesDTO dto) {
		return service.createCnes(dto);
	}
	
	@PutMapping("{id}")
	@ApiOperation(value = "Operação para Cadastrar CNES", produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = MessageApiDTO.class, message = "Sucesso"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public MessageApiDTO putCnes(@PathVariable Long id, @RequestBody @Valid ViewCnesDTO dto) {
		return service.putCnes(id, dto);
	}
	

}
