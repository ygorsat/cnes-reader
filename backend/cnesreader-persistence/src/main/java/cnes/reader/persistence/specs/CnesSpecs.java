package cnes.reader.persistence.specs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import cnes.reader.dto.cnes.SearchFilterCnesDTO;
import cnes.reader.persistence.jpa.model.Cnes;

/**
 * @author ygor.satiro
 * Classe para especificações e predicados utilizando Criteria API
 */
public final class CnesSpecs {
	
	private static final String CNES = "codigoCnes";	
	private static final String NOME_FANTASIA = "nomeFantasia";
	private static final String TIPO_UNIDADE = "descricaoTipoUnidade";	
	private static final String PCT = "%";
	private static final String TIPO = "tipoGestao";
	private static final String UF = "uf";
	
	public static Specification<Cnes> filterSpecs(SearchFilterCnesDTO dto) {
		return new Specification<Cnes>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -3107153401151357235L;

			public Predicate toPredicate(Root<Cnes> root, CriteriaQuery<?> query,
					CriteriaBuilder builder) {

				List<Predicate> predicates = new ArrayList<Predicate>();						
			
				definirPredicados(predicates, builder, dto, root);

				return builder.and(predicates.toArray(new Predicate[predicates.size()]));
			}

			private void definirPredicados(List<Predicate> predicates, CriteriaBuilder builder,
					SearchFilterCnesDTO dto, Root<Cnes> root) {

				if(dto.getCnes() != null) {
					predicates.add(builder.equal(root.get(CNES), dto.getCnes()));
				}

				if(dto.getNomeFantasia() != null) {
					predicates.add(builder.like(root.get(NOME_FANTASIA), PCT + dto.getNomeFantasia() + PCT));
				}
				
				if(dto.getTipoUnidade() != null) {
					predicates.add(builder.like(root.get(TIPO_UNIDADE), PCT + dto.getTipo() + PCT));
				}
				
				if(dto.getTipo() != null) {
					predicates.add(builder.equal(root.get(TIPO), dto.getTipo()));
				}
				
				if(dto.getUf() != null) {
					predicates.add(builder.equal(root.get(UF), dto.getUf()));
				}
			

			}


		};
	}
}