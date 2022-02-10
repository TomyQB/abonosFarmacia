import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.prod'
import { HttpClient, HttpParams } from '@angular/common/http'
import { Abono } from '../model/AbonoInput';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  url = environment.url

  constructor(private http: HttpClient) { }

  getAllAbonos(): Observable<Abono[]> {
    return this.http.get<Abono[]>(this.url + '/getAllAbonos');
  }

  getPDF(id: number) {
    const httpOptions = {
      'responseType'  : 'arraybuffer' as 'json'
      //'responseType'  : 'blob' as 'json'        //This also worked
    };

    return this.http.get<any>(this.url + "/getPDF/" + id, httpOptions);
  }

  delete(id: number) {
    let params = new HttpParams()
      .set("id", id.toString());
    return this.http.delete(this.url + "/delete", { params: params })
  }

}
