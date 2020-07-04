package cnes.reader.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import cnes.reader.dto.cnes.SearchFilterCnesDTO;
import cnes.reader.persistence.jpa.model.Cnes;
import cnes.reader.persistence.specs.CnesSpecs;

/**
 * @author ygor.satiro
 * Repositório para buscar por Specs/Predicates (filtros) e operações default de CRUD
 */
public interface CnesRepository extends CrudRepository<Cnes, Long>, JpaSpecificationExecutor<Cnes> {

	default Page<Cnes> retrieveCnes(SearchFilterCnesDTO dto, Pageable pageable){
		return findAll(CnesSpecs.filterSpecs(dto), pageable);
	};
	
}
