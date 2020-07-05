export interface SearchFilterCnesDTO {
  cnes: string;
  tipoUnidade: string;
  nomeFantasia: string;
  tipo: string;
  uf: string;
  pageNumber: number;
  orderBy?: string;
  itemsPerPage?: number;

}
