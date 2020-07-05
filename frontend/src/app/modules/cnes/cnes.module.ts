import { CnesRoutingModule } from './cnes-routing.module';
import { SearchAppComponent } from './pesquisar/search.app.component';
import { EnumPipe } from './../../services/models/enum/enum.pipe';
import { ViewAppComponent } from './visualizar/view.app.component';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { PrivateRoutingModule } from '../private-routing.module';
import { PrivateModule } from '../private.module';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    SearchAppComponent,
    ViewAppComponent,
    EnumPipe
  ],
  imports: [
    PrivateModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
    CnesRoutingModule,
    PrivateRoutingModule

  ],
  providers: [EnumPipe],
  bootstrap: [SearchAppComponent]
})
export class CnesModule { }
