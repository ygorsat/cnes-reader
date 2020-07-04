package cnes.reader.service.mapper;

import org.apache.commons.lang3.StringUtils;

import cnes.reader.persistence.jpa.model.Cnes;

/**
 * @author ygor.satiro
 * Classe de mapper (utils) para tratamento de linhas do arquivo CSV
 */
public final class CnesMapper {

	public static Cnes mapper(String[] itemLinha) {
		Cnes cnes = new Cnes();
		
		cnes.setCodigoCnes(removeQuote(itemLinha[0]));
		cnes.setCodigoIbge(removeQuote(itemLinha[1]));
		cnes.setNomeFantasia(removeQuote(itemLinha[2]));
		cnes.setDescricaoTipoUnidade(removeQuote(itemLinha[3]));
		cnes.setTipoGestao(removeQuote(itemLinha[4]));
		cnes.setNomeLogradouro(removeQuote(itemLinha[5]));
		cnes.setNomeEndereco(removeQuote(itemLinha[6]));
		cnes.setNomeBairro(removeQuote(itemLinha[7]));
		cnes.setCep(removeQuote(itemLinha[8]));
		cnes.setUf(removeQuote(itemLinha[9]));
		cnes.setMunicipio(removeQuote(itemLinha[10]));
		cnes.setNumeroTelefone(removeQuote(itemLinha[11]));
		
		return cnes;
	}
	
	private static String removeQuote(String item) {
		return item.replaceAll("\"", StringUtils.EMPTY);
	}
	
	
}
