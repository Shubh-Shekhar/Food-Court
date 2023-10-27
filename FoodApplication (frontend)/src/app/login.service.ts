import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { login } from './login';
import { signup } from './signup';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  

  constructor(private httpclient:HttpClient) { }

 logincheck(logindata: login) {
    return this.httpclient.post<any>("http://localhost:8050/user/login",logindata)
  }
  
  
  register(signupdata:any) {
    return this.httpclient.post<any>("http://localhost:8050/userprofile/signup","imageFile",signupdata)
  }
 

}
