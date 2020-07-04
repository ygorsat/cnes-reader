package cnes.reader.persistence.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * The persistent class for the CNES database table.
 * @author ygor.satiro
 */
@Entity
@SequenceGenerator(name="seq_cnes", sequenceName="seq_cnes", allocationSize = 1)
@Table(schema = "public", name="cnes")
@NamedQuery(name="Cnes.findAll", query="SELECT c FROM Cnes c")
public class Cnes implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2204888521187497780L;

	@Id	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_cnes")
	@Column(name="id_cnes")
	private Long id;
	
	@Column(name="co_cnes")
	private String codigoCnes;

	@Column(name="co_ibge")
	private String codigoIbge;

	@Column(name="no_fantasia")
	private String nomeFantasia;

	@Column(name="ds_tipo_unidade")
	private String descricaoTipoUnidade;

	@Column(name="tp_gestao")
	private String tipoGestao;

	@Column(name="no_logradouro")
	private String nomeLogradouro;

	@Column(name="nu_endereco")
	private String nomeEndereco;

	@Column(name="no_bairro")
	private String nomeBairro;

	@Column(name="co_cep")
	private String cep;

	@Column(name="uf")
	private String uf;

	@Column(name="municipio")
	private String municipio;

	@Column(name="nu_telefone")
	private String numeroTelefone;

	public Cnes() {
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((codigoCnes == null) ? 0 : codigoCnes.hashCode());
		result = prime * result + ((codigoIbge == null) ? 0 : codigoIbge.hashCode());
		result = prime * result + ((descricaoTipoUnidade == null) ? 0 : descricaoTipoUnidade.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
		result = prime * result + ((nomeBairro == null) ? 0 : nomeBairro.hashCode());
		result = prime * result + ((nomeEndereco == null) ? 0 : nomeEndereco.hashCode());
		result = prime * result + ((nomeFantasia == null) ? 0 : nomeFantasia.hashCode());
		result = prime * result + ((nomeLogradouro == null) ? 0 : nomeLogradouro.hashCode());
		result = prime * result + ((numeroTelefone == null) ? 0 : numeroTelefone.hashCode());
		result = prime * result + ((tipoGestao == null) ? 0 : tipoGestao.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cnes other = (Cnes) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (codigoCnes == null) {
			if (other.codigoCnes != null)
				return false;
		} else if (!codigoCnes.equals(other.codigoCnes))
			return false;
		if (codigoIbge == null) {
			if (other.codigoIbge != null)
				return false;
		} else if (!codigoIbge.equals(other.codigoIbge))
			return false;
		if (descricaoTipoUnidade == null) {
			if (other.descricaoTipoUnidade != null)
				return false;
		} else if (!descricaoTipoUnidade.equals(other.descricaoTipoUnidade))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (municipio == null) {
			if (other.municipio != null)
				return false;
		} else if (!municipio.equals(other.municipio))
			return false;
		if (nomeBairro == null) {
			if (other.nomeBairro != null)
				return false;
		} else if (!nomeBairro.equals(other.nomeBairro))
			return false;
		if (nomeEndereco == null) {
			if (other.nomeEndereco != null)
				return false;
		} else if (!nomeEndereco.equals(other.nomeEndereco))
			return false;
		if (nomeFantasia == null) {
			if (other.nomeFantasia != null)
				return false;
		} else if (!nomeFantasia.equals(other.nomeFantasia))
			return false;
		if (nomeLogradouro == null) {
			if (other.nomeLogradouro != null)
				return false;
		} else if (!nomeLogradouro.equals(other.nomeLogradouro))
			return false;
		if (numeroTelefone == null) {
			if (other.numeroTelefone != null)
				return false;
		} else if (!numeroTelefone.equals(other.numeroTelefone))
			return false;
		if (tipoGestao == null) {
			if (other.tipoGestao != null)
				return false;
		} else if (!tipoGestao.equals(other.tipoGestao))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}

	public String getCodigoCnes() {
		return codigoCnes;
	}

	public void setCodigoCnes(String codigoCnes) {
		this.codigoCnes = codigoCnes;
	}

	public String getCodigoIbge() {
		return codigoIbge;
	}

	public void setCodigoIbge(String codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getDescricaoTipoUnidade() {
		return descricaoTipoUnidade;
	}

	public void setDescricaoTipoUnidade(String descricaoTipoUnidade) {
		this.descricaoTipoUnidade = descricaoTipoUnidade;
	}

	public String getTipoGestao() {
		return tipoGestao;
	}

	public void setTipoGestao(String tipoGestao) {
		this.tipoGestao = tipoGestao;
	}

	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}

	public String getNomeEndereco() {
		return nomeEndereco;
	}

	public void setNomeEndereco(String nomeEndereco) {
		this.nomeEndereco = nomeEndereco;
	}

	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}