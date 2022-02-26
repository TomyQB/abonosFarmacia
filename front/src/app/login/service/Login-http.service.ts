import { UserOutput } from '../model/User';

import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.prod'
import { HttpClient, HttpParams } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class LoginHttpService {

  url = environment.url

  constructor(private http: HttpClient) { }

  login(user: UserOutput): Observable<UserOutput> {
    return this.http.post<UserOutput>(this.url + '/login', user);
  }

}
