
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.prod'
import { HttpClient, HttpParams } from '@angular/common/http'
import { Abono, AbonoFormData } from '../model/AbonoOutput';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  url = environment.url

  constructor(private http: HttpClient) { }

  createAbono(abono: Abono): Observable<Abono> {
    return this.http.post<Abono>(this.url + '/create', abono);
  }

  uploadPDF(pdf: File): Observable<File> {
    const formData = new FormData();
    formData.append('multipartFile', pdf);
    return this.http.post<File>(this.url + "/uploadPDF", formData)
  }

}
