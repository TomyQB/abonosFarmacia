import { ModalDeleteComponent } from '../../modal-delete/modal-delete.component';
import { Abono } from '../model/AbonoInput';
import { HttpService } from '../service/http.service';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  displayedColumns: string[] = ['Albaran', 'Codigo', 'Nombre', 'Fecha', 'Unidades', 'Acciones'];
  dataSource: MatTableDataSource<Abono>;

  
  filtroFormControl = new FormControl('');
  
  dialogConfig: MatDialogConfig = {
    width: '30%',
  }

  constructor(private httpService: HttpService, private router: Router, public dialog: MatDialog) { }

  ngOnInit(): void {
    if(!localStorage.getItem("user")) {
      this.router.navigateByUrl("/login");
    }
    this.getAbonos();
  }

  getAbonos() {
    this.httpService.getAllAbonos().subscribe(abonos => {
      this.dataSource = new MatTableDataSource(abonos);
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  delete(id: number) {
    
    const dialogRef = this.dialog.open(ModalDeleteComponent, this.dialogConfig)
    dialogRef.afterClosed().subscribe(res => {
      if(res) {
        console.log("borrar")
        this.httpService.delete(id).subscribe(() => {
          this.getAbonos();
        });
      }
    })
  }

  nuevo() {
    this.router.navigateByUrl("/create")
  }

  goToHistorial() {
    this.router.navigateByUrl("/search/history")
  }

  openPDF(id: number) {
    this.httpService.getPDF(id).subscribe(data => {
      let file = new Blob([data], { type: 'application/pdf' });  
      var fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    });
  }
  
}

