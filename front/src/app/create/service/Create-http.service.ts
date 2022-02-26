
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.prod'
import { HttpClient, HttpParams } from '@angular/common/http'
import { AbonoOutput, AbonoFormData } from '../model/Abono';

@Injectable({
  providedIn: 'root'
})
export class CreateHttpService {

  url = environment.url

  constructor(private http: HttpClient) { }

  createAbono(abono: AbonoOutput): Observable<AbonoOutput> {
    return this.http.post<AbonoOutput>(this.url + '/create', abono);
  }

  uploadPDF(pdf: File): Observable<File> {
    const formData = new FormData();
    formData.append('multipartFile', pdf);
    return this.http.post<File>(this.url + "/uploadPDF", formData)
  }

}
