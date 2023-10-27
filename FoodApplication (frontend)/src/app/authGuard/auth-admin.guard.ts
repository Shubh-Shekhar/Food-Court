import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthAdminService } from './auth-admin.service';

@Injectable({
  providedIn: 'root'
})
export class AuthAdminGuard implements CanActivate {
  constructor(private auth: AuthAdminService,private router: Router){}
  
  
  canActivate(){
    if(this.auth.IsLoggedIn()){ 
    return true;
    }
    this.router.navigate([''])
    return false;
  }
  
}
