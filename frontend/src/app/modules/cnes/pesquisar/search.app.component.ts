import { FormGroup, FormBuilder } from '@angular/forms';
import { SearchFilterCnesDTO } from '../../../services/models/dtos/search-filter-cnes.dto';
import { TipoCnesEnumMsg, TipoCnesEnum } from '../../../services/models/enum/tipo-cnes.enum';
import { CnesService } from '../../../services/cnes.service';
import { UfEnum, UfEnumMsg } from '../../../services/models/enum/unidade-federativa.enum';
import { ViewCnesDTO } from '../../../services/models/dtos/view-cnes.dto';
import { NewPageModel } from '../../../services/models/dtos/new-page.model';
import { ResultPageModel } from '../../../services/models/dtos/result.page.model';
import { Router } from '@angular/router';

import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';



@Component({
  selector: 'app-search-root',
  templateUrl: './search.app.component.html',
  styleUrls: ['./search.app.component.css']
})
export class SearchAppComponent implements OnInit {
  title = 'Consultar CNES';
  itemsPerPage = 20;
  pageSize: number;
  readonly defaultPage: number = 1;

  page = this.defaultPage;
  currentResultPage: ResultPageModel<ViewCnesDTO>;
  pageModel: NewPageModel = { pageNumber: this.defaultPage, itemsPerPage: this.itemsPerPage };

  tipoEnum = TipoCnesEnum;
  tipoEnumMsg = TipoCnesEnumMsg;
  unidadeFederativaEnum = UfEnum;
  unidadeFederativaEnumMsg = UfEnumMsg;
  formGet: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private service: CnesService,
    private router: Router
  ){}

  ngOnInit(): void {
    this.formCreate();
  }

  formCreate(): void {
    this.formGet = this.formBuilder.group({
      cnes: [],
      tipoUnidade: [],
      nomeFantasia: [],
      tipo: [],
      uf: [],

      orderBy: [],
      pageNumber: [],
      itemsPerPage: []
    });
  }

  objectKeys(obj: any): Array<any> {
    return Object.keys(obj);
  }

  retrieveGetData(pagina?: NewPageModel, queryParams?: SearchFilterCnesDTO){
    this.currentResultPage = null;
    queryParams = queryParams || this.mappingGet(pagina);

    this.service.retrieveDataFilter(queryParams).subscribe(response => {
      this.currentResultPage = response;
      $('#container-error').remove();
    },
    err => {
      $('#container-error').remove();
      this.retrieveContainerAppend(err.error.mensagem);
    });
  }

  btnGet(pagina?: NewPageModel): void {
    this.retrieveGetData(pagina);
  }

  mappingGet(pagina?: NewPageModel): SearchFilterCnesDTO {
    const params: SearchFilterCnesDTO = this.formGet.getRawValue();
    this.addPageInfo(params, pagina);
    Object.seal(params);
    return params;
  }
  addPageInfo(dto: SearchFilterCnesDTO, pagina: NewPageModel): SearchFilterCnesDTO {
    const paginaAtual = pagina || this.pageModel;
    dto.pageNumber = paginaAtual.pageNumber;
    dto.itemsPerPage = paginaAtual.itemsPerPage;
    Object.seal(dto);
    return dto;
  }

  cleanData(): void {
    this.formGet.reset();
    this.currentResultPage = null;
    this.pageModel = { pageNumber: this.defaultPage, itemsPerPage: this.pageSize };
    $('#container-error').remove();
  }

  private generateHashId(): string {
    let text = '';
    const possible = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    for (let i = 0; i < 5; i++) {
      text += possible.charAt(Math.floor(Math.random() * possible.length));
    }
    return text;
  }

  private createAlertDiv(messageId: string, message: string) {
    return `<div id="container-error" style="font-size: 16px;text-align: center;"
                    class="alert alert-danger ngc-error-container" style="font-weight: bold;">
              <a class="close cursor-pointer" data-dismiss="alert"
                    title="">×</a>
              <i style="font-size: 1.50em;" class="fa fa-exclamation-circle"></i>
              <p id="${messageId}" name="Erro">${message}</p>
            </div>`;
  }

  private retrieveContainerAppend(message: string) {
    const htmlElementContainer = $(' .container');
    const div = document.createElement('div');
    div.innerHTML = this.createAlertDiv(`NGC_MESSAGE_${this.generateHashId()}`, message);
    htmlElementContainer.prepend(div);
  }

  onPageChange(){
   const newPageModel = { pageNumber: this.page, itemsPerPage: this.itemsPerPage };
   this.btnGet(newPageModel);
  }

}
