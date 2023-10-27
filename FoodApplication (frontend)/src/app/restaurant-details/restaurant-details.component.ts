import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestaurantService } from '../restaurant.service';

@Component({
  selector: 'app-restaurant-details',
  templateUrl: './restaurant-details.component.html',
  styleUrls: ['./restaurant-details.component.css']
})
export class RestaurantDetailsComponent implements OnInit {
  message: any;

  constructor(private resService:RestaurantService,private router:Router,private http:HttpClient) { }

  ngOnInit(): void {
    this.resService.getRestaurant().subscribe(
      data => {
              console.log(data)
              this.message=data;
              
              
       })
  }

  delete(emailid:any)
  {
    this.resService.deleteRestaurant(emailid).subscribe(success=>{
      alert("Restaurant remove of id: "+emailid);
      this.ngOnInit();
    });

  }
  addDishes(user:any,resturantName:any){

    window.localStorage.setItem("user",user);
    window.localStorage.setItem("restname",resturantName);
    this.router.navigate(['/nav',{
      outlets:{
        restaurant:['rest']
      }
    }])

  }
  getDishes(email:any){
    window.localStorage.setItem("dishemail",email)
    this.router.navigate(['/nav',{
      outlets:{
        restaurant:['admindish']
      }
    }])
}
  

}
