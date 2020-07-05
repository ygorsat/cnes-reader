import { CnesService } from './../../../services/cnes.service';
import { UfEnum, UfEnumMsg } from './../../../services/models/enum/unidade-federativa.enum';
import { TipoCnesEnumMsg, TipoCnesEnum } from './../../../services/models/enum/tipo-cnes.enum';
import { ViewCnesDTO } from './../../../services/models/dtos/view-cnes.dto';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-visualizar-root',
  templateUrl: './view.app.component.html',
  styleUrls: ['./view.app.component.css']
})
export class ViewAppComponent implements OnInit {
  title = 'Visualizar CNES';
  _pathBack = '/admin/cnes';
  id: number;
  resultId: ViewCnesDTO;
  tipoEnum = TipoCnesEnum;
  tipoEnumMsg = TipoCnesEnumMsg;
  unidadeFederativaEnum = UfEnum;
  unidadeFederativaEnumMsg = UfEnumMsg;
  formGet: FormGroup;

  constructor(
    private cnesService: CnesService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ){}

  ngOnInit(): void {
    this.verifyIdParameter();

  }

  verifyIdParameter(): void {
    const id = this.activatedRoute.snapshot.params.id;
    if (id) {
      this.id = id;
      this.retrieveData(id);
    }
  }
  retrieveData(id: number): void {
    this.cnesService.retrieveDataId(id).subscribe(res => this.resultId = res);
  }

}
