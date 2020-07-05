import { SearchAppComponent } from './modules/cnes/pesquisar/search.app.component';
import { PrivateModule } from './modules/private.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule} from './app-routing.module';
import { AppComponent } from './app.component';
import { EnumPipe } from './services/models/enum/enum.pipe';
import { ViewAppComponent } from './modules/cnes/visualizar/view.app.component';



@NgModule({
  declarations: [
    AppComponent,
    SearchAppComponent,
    ViewAppComponent,
    EnumPipe

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    PrivateModule

  ],
  exports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    PrivateModule
  ],
  providers: [EnumPipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
