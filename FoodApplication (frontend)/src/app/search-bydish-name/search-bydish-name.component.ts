import { Component, OnInit } from '@angular/core';
import { AddToCartComponent } from '../add-to-cart/add-to-cart.component';
import { RestaurantdishesComponent } from '../restaurantdishes/restaurantdishes.component';

@Component({
  selector: 'app-search-bydish-name',
  templateUrl: './search-bydish-name.component.html',
  styleUrls: ['./search-bydish-name.component.css']
})
export class SearchBydishNameComponent implements OnInit {

  constructor(private cart:RestaurantdishesComponent) { }
  searchData:any;
  ngOnInit(): void {
    this.searchData=JSON.parse(localStorage.getItem('searchData'))
  }


addtoCart(data:any,resturantName:any,dishName:any,quantity:any,price:any,discription:any,dishImage:any){
this.cart.addtoCart(data,resturantName,dishName,quantity,price,discription,dishImage)
}

addtoFav(data:any,resturantName:any,dishName:any,quantity:any,price:any,discription:any,dishImage:any){
  this.cart.addtoFav(data,resturantName,dishName,quantity,price,discription,dishImage)
}
}