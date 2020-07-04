package cnes.reader.persistence.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import cnes.reader.dto.cnes.SearchFilterCnesDTO;
import cnes.reader.persistence.CnesDAO;
import cnes.reader.persistence.jpa.model.Cnes;
import cnes.reader.persistence.repository.CnesRepository;

/**
 * @author ygor.satiro
 * Classe de implementação do DAO
 */
@Service
public class CnesDAOImpl implements CnesDAO {	
	
	@Autowired
	private CnesRepository crudRepo;

	private static final String SORT_DEFAULT_COLUMN = "nomeFantasia";
	
	@Override
	public Long save(Cnes cnes) {
		return crudRepo.save(cnes).getId();
	}

	@Override
	public boolean removeCnes(Long id) {
		crudRepo.deleteById(id);
		return true;
	}

	@Override
	public boolean save(Set<Cnes> cnes) {
		crudRepo.saveAll(cnes);
		return true;
	}

	@Override
	public Optional<Cnes> find(Long id) {
		return crudRepo.findById(id);
	}

	@Override
	public Page<Cnes> retrieveCnes(SearchFilterCnesDTO dto) {
		return crudRepo.retrieveCnes(dto, PageRequest.of(dto.getPageNumber() - 1, dto.getItemsPerPage(), Sort.by(Direction.valueOf(dto.getOrderBy()), SORT_DEFAULT_COLUMN)));
	}
	
	@Override
	public Iterable<Cnes> findAll() {
		return crudRepo.findAll();
	}

	

}
