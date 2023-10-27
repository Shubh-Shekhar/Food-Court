import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { restaurant } from './restaurant';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {
  

  constructor(private http:HttpClient) { }
  
  
  addRestaurant(registrationData: restaurant) {
    return this.http.post<any>("http://localhost:8050/admin/addrestaurant",registrationData);
  }

  getRestaurant(){
    
    let reqHeader = new HttpHeaders().set('Authorization', 'Bearer ' + window.localStorage.getItem('token'));
    reqHeader.set('Access-Control-Allow-Origin', 'http://localhost:4200')
    return this.http.get<any>("http://localhost:8050/admin/getrestaurant",{ 'headers': reqHeader })
  }

  deleteRestaurant(emailid:any)
  {
    let reqHeader = new HttpHeaders().set('Authorization', 'Bearer ' + window.localStorage.getItem('token'));
    return this.http.delete("http://localhost:8050/admin/removerestaurant/"+emailid,{ 'headers': reqHeader })
  }
  addProducts(products:any)
  {
    let reqHeader = new HttpHeaders().set('Authorization', 'Bearer ' + window.localStorage.getItem('token'));
    return this.http.post<any>("http://localhost:8050/admin/menu/addDetails",products,{ 'headers': reqHeader })
  }
}
