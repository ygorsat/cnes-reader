import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { ViewCnesDTO } from './models/dtos/view-cnes.dto';
import { SearchFilterCnesDTO } from './models/dtos/search-filter-cnes.dto';
import { ResultPageModel } from './models/dtos/result.page.model';
import { Router, NavigationEnd } from '@angular/router';
import { take } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CnesService {

  readonly url = environment.apiUrl;
  moduleParentRouter = '';

  constructor(
    private http: HttpClient,
    router: Router
  ) {}

  retrieveDataFilter(params?: SearchFilterCnesDTO): Observable<ResultPageModel<ViewCnesDTO>> {
    return this.http.get<ResultPageModel<ViewCnesDTO>>(`${ this.url }/cnes`, {
        params: this.httpParamsRequest(params)
      });
  }

  retrieveDataId(id: number, params?: any): Observable<any> {
    return this.http.get<any>(`${ this.url }/cnes/${ id }`).pipe(take(1));
  }

  httpParamsRequest(objeto: object): {
    [param: string]: string | string[]
  } {
    const httpParams: {
      [param: string]: string | string[];
    } = {};
    if (objeto != null) {
      // tslint:disable-next-line:forin
      for (const key in objeto) {
        const parametro = objeto[key];
        if (parametro !== null && parametro !== 'null' && parametro !== 'undefined' && parametro !== undefined) {
          if (String(parametro).trim()) {
            httpParams[key] = String(objeto[key]);
          }
        }
      }
    }
    return httpParams;
  }
}


