package cnes.reader.persistence.enumeration;


/***
 * Enum com os valores de Tipo Enum
 * @author ygor.bandin
 *
 */
public enum TipoCnesEnum {
	
	E ("Estadual"),
	M ("Municipal"),
	D ("Dupla");

	private String name;

	private TipoCnesEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
