import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  status: any;

  constructor() { }

  IsLoggedIn(){
    return !! window.localStorage.getItem('token')
  
  }
}
