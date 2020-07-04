package cnes.reader.service;

import java.util.Set;

import cnes.reader.dto.base.MessageApiDTO;
import cnes.reader.dto.base.PaginationDTO;
import cnes.reader.dto.cnes.SearchFilterCnesDTO;
import cnes.reader.dto.cnes.ViewCnesDTO;

/**
 * @author ygor.satiro
 * Classe de interface de serviços
 */

public interface CnesService {
	
	/**
	 * Recuperar CNES de endereço configurável e inserir os dados em memory database (H2) 
	 * void
	 * @throws Exception 
	 */	
	public void retrieveCnesInfo() throws Exception;

	/**
	 * Consultar CNES cadastrados em memory database (H2) a partir de vários filtros
	 * 
	 * @return {@link PaginationDTO<ViewCnesDTO>} - CNES em memory database
	 * @throws BusinessException 
	 */
	public PaginationDTO<ViewCnesDTO> retrieveCnes(SearchFilterCnesDTO dto);

	/**
	 * Consultar CNES cadastrados em memory database (H2) - All
	 * 
	 * @return {@link Set<ViewCnesDTO>} - CNES em memory database
	 * @throws BusinessException 
	 */
	public Set<ViewCnesDTO> retrieveCnes();

	/**
	 * Consultar CNES por ID
	 * 
	 * @return {@link ViewCnesDTO} - CNES em memory database por ID
	 * @throws BusinessException 
	 */
	public ViewCnesDTO retrieveCnesById(Long id);

	
	/**
	 * Criar CNES a partir de dados inseridos
	 * 
	 * @return {@link MessageApiDTO} - Retorno com mensagem estática e ID gerado para item criado
	 * @throws BusinessException 
	 */
	public MessageApiDTO createCnes(ViewCnesDTO dto);

	/**
	 * Atualizar (totalmente ou parcialmente) CNES a partir de dados inseridos
	 * 
	 * @return {@link MessageApiDTO} - Retorno com mensagem estática e ID gerado para item atualizado
	 * @throws BusinessException 
	 */
	public MessageApiDTO putCnes(Long id, ViewCnesDTO dto);


}
