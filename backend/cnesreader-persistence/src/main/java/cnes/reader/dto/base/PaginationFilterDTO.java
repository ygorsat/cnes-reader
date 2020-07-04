package cnes.reader.dto.base;

import static cnes.reader.persistence.constants.Constants.DEFAULT_NUMBER_PAGE;
import static cnes.reader.persistence.constants.Constants.DEFAULT_ORDER;
import static cnes.reader.persistence.constants.Constants.ITEMS_PER_PAGE;

import java.io.Serializable;

import lombok.Data;

/**
 * @author ygor.satiro
 * DTO de paginação para requisição por filtros de CNES
 */
@Data
public class PaginationFilterDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3481335698095727281L;

	private Integer itemsPerPage = ITEMS_PER_PAGE;
		
	private Integer pageNumber = DEFAULT_NUMBER_PAGE;
		
	private String orderBy = DEFAULT_ORDER;


}
