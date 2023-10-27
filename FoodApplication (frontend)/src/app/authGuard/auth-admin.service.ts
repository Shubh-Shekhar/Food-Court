import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthAdminService {
  status: any;

  constructor() { }

  IsLoggedIn(){
    return !! window.localStorage.getItem('tokenAdmin')
  
  }
}
