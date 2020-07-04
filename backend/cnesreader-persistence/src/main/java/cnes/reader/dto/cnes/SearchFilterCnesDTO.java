package cnes.reader.dto.cnes;

import javax.validation.constraints.Size;

import cnes.reader.annotations.EnumValues;
import cnes.reader.dto.base.PaginationFilterDTO;
import cnes.reader.persistence.enumeration.TipoCnesEnum;
import cnes.reader.persistence.enumeration.UnidadeFederativaEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ygor.satiro
 * DTO de filtros para pesquisa de CNES
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SearchFilterCnesDTO extends PaginationFilterDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7620080490298367874L;

	@Size(max = 7, min = 7, message = "O número CNES deve ser composto de {max} dígitos. ")
	private String cnes;
	
	private String tipoUnidade;
	
	private String nomeFantasia;
	
	@EnumValues(enumClass = TipoCnesEnum.class, ignoreCase = true, acceptNull = true, message = "Para o Tipo de Estabelecimento deve ser utilizado um dos valores: E - Estadual | M - Municipal | D - Dupla.")
	private String tipo;
	
	@EnumValues(enumClass = UnidadeFederativaEnum.class, ignoreCase = true, acceptNull = true, message = "Deve ser utilizado uma das siglas válidas para as unidades federativas do Brasil.")
	private String uf;
}
