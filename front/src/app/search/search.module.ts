import { MatDialogModule } from '@angular/material/dialog';
import { SearchComponent } from './search/search.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchRoutingModule } from './search-routing.module';
import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule} from '@angular/forms'
import { MatButtonModule } from '@angular/material/button';
import { HistoryComponent } from './history/history.component';
import { MatIconModule } from '@angular/material/icon';


@NgModule({
  declarations: [
    SearchComponent,
    HistoryComponent
  ],
  imports: [
    CommonModule,
    SearchRoutingModule,
    MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatDialogModule,
    MatIconModule
  ],
  providers: [],
  bootstrap: [SearchComponent]
})
export class SearchModule { }
