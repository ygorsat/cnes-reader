package cnes.reader.dto.base;

import java.io.Serializable;
import java.util.List;

/**
 * @author ygor.satiro
 * DTO base para retorno paginado dos CNES registrados em banco
 */
public class PaginationDTO<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1901750565792336182L;
	
	private Long totalRegistros;
    private List<T> itens;

    public PaginationDTO() {
        super();
    }

    public PaginationDTO(Long totalRegistros, List<T> itens) {
        this.totalRegistros = totalRegistros;
        this.itens = itens;
    }

    public Long getTotalRegistros() {
        return totalRegistros;
    }

    public void setTotalRegistros(Long totalRegistros) {
        this.totalRegistros = totalRegistros;
    }

    public List<T> getItens() {
        return itens;
    }

    public void setItens(List<T> itens) {
        this.itens = itens;
    }
}
