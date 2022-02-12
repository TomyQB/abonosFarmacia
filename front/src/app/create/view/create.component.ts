import { HttpService } from './../../create/service/http.service';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Abono } from '../model/AbonoOutput';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit {
  
  @ViewChild('imagenInputFile', {static: false}) pdfFile!: ElementRef

  abono: Abono = {};
  pdf: File | undefined;

  
  albaranFormControl = new FormControl('', [
    Validators.required,
  ]);

  codigoFormControl = new FormControl('', [
    Validators.required,
  ]);

  nombreFormControl = new FormControl('', [
    Validators.required,
  ]);
  
  fechaFormControl = new FormControl('', [
    Validators.required,
  ]);

  unidadesFormControl = new FormControl('', [
    Validators.required,
  ]);

  constructor(private httpService: HttpService, private router: Router) { }

  ngOnInit(): void {
  }

  onFileChange(event: any) {
    this.pdf = event.target.files[0]
    const fr = new FileReader();
    // fr.onload = (evento: any) => {
    //   this.imagenMin = evento.target.result
    // }
    fr.readAsDataURL(this.pdf!)
  }

  guardar() {
    this.abono.albaran = this.albaranFormControl.value;
    this.abono.codigo = this.codigoFormControl.value;
    this.abono.nombre = this.nombreFormControl.value;
    this.abono.fecha = this.fechaFormControl.value;
    this.abono.unidades = this.unidadesFormControl.value;

    if(this.abono.albaran != null && this.abono.codigo != null && this.abono.nombre != null && this.abono.fecha != null && this.abono.unidades != null && this.pdf != null) {
      this.httpService.uploadPDF(this.pdf).subscribe(() => {

        this.httpService.createAbono(this.abono).subscribe(() => {
          alert("Abono creado correctamente")
          this.albaranFormControl.setValue(null);
          this.codigoFormControl.setValue(null);
          this.nombreFormControl.setValue(null);
          this.unidadesFormControl.setValue(null);
          this.pdf = null;
        })

      })
    } else alert("Todos los campos obligatorios")
  }

  exit() {
    this.router.navigateByUrl("/search")
  }

}
