import { HttpClient } from '@angular/common/http';

import { Component, OnInit } from '@angular/core';
import {  Router } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { RestaurantService } from '../restaurant.service';
import { RestaurantdishesComponent } from '../restaurantdishes/restaurantdishes.component';

@Component({
  selector: 'app-rest-dashboard',
  templateUrl: './rest-dashboard.component.html',
  styleUrls: ['./rest-dashboard.component.css']
})
export class RestDashboardComponent implements OnInit {
  data:any
  dishes:any
  retrievedImage: string;
  path: any;
  tempemail: any;
  tempname: any;

  totalLength:any
  page:number=1;

  constructor(private resService:RestaurantService,private http:HttpClient,private router:Router) { }

  ngOnInit(): void {
    this.resService.getRestaurant().subscribe(
      data => {
              console.log(data)
              this.data=data;
              this.totalLength=data.length;
              
       })

      
  }
  getDishes(emailid:any){
    window.localStorage.setItem('restid',emailid)
    this.router.navigate(['/profile',{
      outlets:{
        restdata:['dishes']
      }
    }])
}
}
