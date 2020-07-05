package cnes.reader.service.impl;

import static cnes.reader.service.constants.ServiceConstants.ENTITY_POST;
import static cnes.reader.service.constants.ServiceConstants.ENTITY_PUT;
import static cnes.reader.service.constants.ServiceConstants.SEPARATOR;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import cnes.reader.dto.base.MessageApiDTO;
import cnes.reader.dto.base.PaginationDTO;
import cnes.reader.dto.cnes.SearchFilterCnesDTO;
import cnes.reader.dto.cnes.ViewCnesDTO;
import cnes.reader.persistence.CnesDAO;
import cnes.reader.persistence.jpa.model.Cnes;
import cnes.reader.rest.client.RestCnesClient;
import cnes.reader.service.CnesService;
import cnes.reader.service.exception.BusinessException;
import cnes.reader.service.mapper.CnesMapper;
import cnes.reader.service.util.ResponseUtil;

/**
 * @author ygor.satiro
 * Classe de implementação das regras de negócio (camada de serviços)
 */
@Service
public class CnesServiceImpl implements CnesService {	
	
	private static final Logger LOGGER = Logger.getLogger(CnesServiceImpl.class.getName());
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private RestCnesClient restClient;
	
	@Value("${file.cnes.name}")
	private String cnesFileName;	
	
	@Value("${root.dir}")
	private String rootDir;
	
	@Value("${sample.cnes.csv.limit}")
	private Integer sampleCnesCsv;
	
	@Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
	private Integer batchLimit;
	
	@Autowired
	private CnesDAO cnesDAO;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void retrieveCnesInfo() throws Exception {
		byte[] arrayByte = restClient.downloadCSV();
		if(writeCsvFile(arrayByte)) {
			BufferedReader csvReader = new BufferedReader(new FileReader(this.rootDir + File.separator + this.cnesFileName));
			String row;
			int countActualLine = 0;
			Set<Cnes> cnesModel = new HashSet<>();
			while ((row = csvReader.readLine()) != null && countActualLine <= sampleCnesCsv) {
				if(countActualLine > 0) {
					cnesModel.add(CnesMapper.mapper(row.split(SEPARATOR)));
				}
				verifyBatchLimit(cnesModel);
				
				countActualLine++;
			}
			cnesDAO.save(cnesModel);
			cnesModel.clear();
			
			csvReader.close();
			new File(this.rootDir + File.separator + this.cnesFileName).delete();
		}

	}
	
	@Override
	public PaginationDTO<ViewCnesDTO> retrieveCnes(SearchFilterCnesDTO dto) {

		List<ViewCnesDTO> cnes = new ArrayList<>();		
		Page<Cnes> pageReports = cnesDAO.retrieveCnes(dto);

		if(pageReports.isEmpty()) {
			throw new BusinessException("Não foram encontrados registros para os filtros informados.");
		}
		pageReports.stream().forEach(item -> cnes.add(convert(item)));

		return new PaginationDTO<>(pageReports.getTotalElements(), cnes);

	}
	
	@Override
	public ViewCnesDTO retrieveCnesById(Long id) {
		return cnesDAO.find(id).map(item -> convert(item))
			   .orElseThrow(() -> new BusinessException("CNES não encontrado com ID informado."));
	
	}
	
	private void verifyBatchLimit(Set<Cnes> cnesModel) {
		if(cnesModel.size() >= batchLimit) {
			cnesDAO.save(cnesModel);
			cnesModel.clear();
		}
		
	}

	private boolean writeCsvFile(byte[] arrayByte) throws Exception {
		try {
			File file = new File(this.rootDir);

			if (!file.exists()) {
				file.mkdir();
			}
			verifyWritingPermission(file);

			file = new File(this.rootDir + File.separator + this.cnesFileName);

			writeFile(file, arrayByte);

			return true;

		} catch (Exception e) {			
			LOGGER.error("Error while writing CSV file", e);			
			return false;
		}
	}
	
	private void verifyWritingPermission(File file) throws Exception {
		if (!file.canWrite()) {
			LOGGER.error("No permission to write file in selected folder");
			throw new Exception();
		}
	}
	
	private void writeFile(File file, byte[] arrayByte) throws IOException {		
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(arrayByte);
		fos.flush();
		fos.close();
	}
	
	private ViewCnesDTO convert(Cnes cnes) {
		return modelMapper.map(cnes, ViewCnesDTO.class);
	}
	
	private Cnes convert(ViewCnesDTO dto) {
		return modelMapper.map(dto, Cnes.class);
	}

	@Override
	public Set<ViewCnesDTO> retrieveCnes() {
		Set<ViewCnesDTO> dto = new HashSet<>();
		Iterator<Cnes> iterator = cnesDAO.findAll().iterator();
		while(iterator.hasNext()) {
			dto.add(convert(iterator.next()));
		}
		if(dto.isEmpty()) {
			throw new BusinessException("Não foram encontrados registros para CNES na base de dados.");
		}
		return dto;
	}

	@Override
	public MessageApiDTO createCnes(ViewCnesDTO dto) {		
		Cnes cnes = convert(dto);
		cnes.setId(null);
		return ResponseUtil.mountResponse(cnesDAO.save(cnes), ENTITY_POST);
	}

	@Override
	public MessageApiDTO putCnes(Long id, ViewCnesDTO dto) {		
		if(!cnesDAO.find(id).isPresent()) {
			throw new BusinessException("CNES não encontrado com ID informado.");
		}
		
		Cnes cnes = convert(dto);
		cnes.setId(id);

		return ResponseUtil.mountResponse(cnesDAO.save(cnes), ENTITY_PUT);		

	}


}
