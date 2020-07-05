export interface ResultPageModel<T> {
    paginaIndex?: number;
    totalNumber: number;
    items: Array<T>;
}
