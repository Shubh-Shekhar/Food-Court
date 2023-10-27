import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RestaurantdishesComponent } from '../restaurantdishes/restaurantdishes.component';

@Component({
  selector: 'app-search-by',
  templateUrl: './search-by.component.html',
  styleUrls: ['./search-by.component.css']
})
export class SearchByComponent implements OnInit {

  constructor( private router:Router) { }
searchData:any;
 
  ngOnInit(): void {
    this.searchData=JSON.parse(localStorage.getItem('searchData'))
   
  }
  checkDishes(emailid:any)
  {
    window.localStorage.setItem('restid',emailid)
    this.router.navigate(['/profile',{
      outlets:{
        restdata:['dishes']
      }
    }])
}
  
  
  

}
