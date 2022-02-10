import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CreateRoutingModule } from './create-routing.module';
import { CreateComponent } from './view/create.component';
import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule} from '@angular/forms'
import { MatButtonModule } from '@angular/material/button';


@NgModule({
  declarations: [
    CreateComponent
  ],
  imports: [
    CommonModule,
    CreateRoutingModule,
    MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [CreateComponent]
})
export class CreateModule { }
