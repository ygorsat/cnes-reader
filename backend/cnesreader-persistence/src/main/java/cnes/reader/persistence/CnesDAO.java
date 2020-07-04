package cnes.reader.persistence;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;

import cnes.reader.dto.cnes.SearchFilterCnesDTO;
import cnes.reader.persistence.jpa.model.Cnes;

/**
 * @author ygor.satiro
 * Classe para DAO (Data Acess Object) do CNES
 */

public interface CnesDAO {
	
	/**
	 * Salvar em lote CNES
	 * 
	 * @return {@link Boolean} - TRUE para sucesso ao salvar
	 */
	public boolean save(Set<Cnes> cnes);

	/**
	 * Salvar em CNES
	 * 
	 * @return {@link Long} - ID do Cnes persistido
	 */
	public Long save(Cnes cnes);

	/**
	 * Remover CNES por ID informado
	 * 
	 * @return {@link Boolean} - TRUE para sucesso ao remover
	 */
	public boolean removeCnes(Long id);
	
	/**
	 * Recuperar CNES por ID informado
	 * 
	 * @return {@link Optional<Cnes}
	 */
	public Optional<Cnes> find(Long id);
	
	/**
	 * Recuperar CNES por filtros informados. Paginado.
	 * 
	 * @return {@link Page<Cnes>}
	 */
	public Page<Cnes> retrieveCnes(SearchFilterCnesDTO dto);

	/**
	 * Recuperar todos os CNES em base da dados.
	 * 
	 * @return {@link Iterable<Cnes>}
	 */
	Iterable<Cnes> findAll();

}
