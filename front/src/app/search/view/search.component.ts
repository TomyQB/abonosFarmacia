import { Abono } from '../model/AbonoInput';
import { HttpService } from '../service/http.service';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  displayedColumns: string[] = ['Albaran', 'Codigo', 'Nombre', 'Fecha', 'Unidades', 'Acciones'];
  dataSource: MatTableDataSource<Abono>;

  
  filtroFormControl = new FormControl('');

  constructor(private httpService: HttpService, private router: Router) { }

  ngOnInit(): void {
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
    this.httpService.delete(id).subscribe(() => {
      this.getAbonos();
    });
  }

  nuevo() {
    this.router.navigateByUrl("/create")
  }

  openPDF(id: number) {
    this.httpService.getPDF(id).subscribe(data => {
      let file = new Blob([data], { type: 'application/pdf' });  
      var fileURL = URL.createObjectURL(file);
      window.open(fileURL);
    });
  }
  
}

