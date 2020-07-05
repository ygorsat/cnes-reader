package cnes.reader.persistence.enumeration;


/***
 * Enum com os valores de UF
 * @author ygor.bandin
 *
 */
public enum UnidadeFederativaEnum {
	
	AC("Acre"),
	AL ("Alagoas"),
	AP ("Amapá"),
	AM ("Amazonas"),
	BA ("Bahia"),
	CE ("Ceará"),
	DF ("Distrito Federal"),
	ES ("Espirito Santo"),
	GO ("Goiás"),
	MA ("Maranhão"),
	MT ("Mato Grosso"),
	MS ("Mato Grosso do Sul"),
	MG ("Minas Gerais"),
	PA ("Pará"),
	PB ("Paraíba"),
	PR ("Paraná"),
	PE ("Pernambuco"),
	PI ("Piauí"),
	RJ ("Rio de Janeiro"),
	RN ("Rio Grande do Norte"),
	RS ("Rio Grande do Sul"),
	RO ("Rondônia"),
	RR ("Roraima"),
	SC ("Santa Catarina"),
	SP ("São Paulo"),
	SE ("Sergipe"),
	TO ("Tocantins");

	private String name;

	private UnidadeFederativaEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
