import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { PrivateRoutingModule } from './private-routing.module';
import { AdminComponent } from './admin/admin.component';

@NgModule({
    declarations: [
        AdminComponent
    ],
  imports: [
    CommonModule,
    PrivateRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule
  ],
  exports: [
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    PrivateRoutingModule
  ]
})
export class PrivateModule { }
