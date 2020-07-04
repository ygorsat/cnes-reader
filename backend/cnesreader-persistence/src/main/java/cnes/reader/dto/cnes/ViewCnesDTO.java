package cnes.reader.dto.cnes;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ygor.satiro
 * DTO unificado para operações de CRUD com CNES
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ViewCnesDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7670708210807830644L;
	
	
	private Long id;	
	
	private String codigoCnes;

	private String codigoIbge;

	private String nomeFantasia;
	
	private String descricaoTipoUnidade;
	
	private String tipoGestao;
	
	private String nomeLogradouro;
	
	private String nomeEndereco;
	
	private String nomeBairro;
	
	private String cep;
	
	private String uf;
	
	private String municipio;

	private String numeroTelefone;


}
