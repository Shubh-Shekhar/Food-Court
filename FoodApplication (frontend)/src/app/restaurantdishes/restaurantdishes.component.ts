import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Favourite } from '../favourite';
import { NavigationUserComponent } from '../navigation-user/navigation-user.component';
import iziToast from 'izitoast';
@Component({
  selector: 'app-restaurantdishes',
  templateUrl: './restaurantdishes.component.html',
  styleUrls: ['./restaurantdishes.component.css']
})
export class RestaurantdishesComponent implements OnInit {

  data: any;
  favourite:Favourite;
 

  constructor(private http:HttpClient,private comp:NavigationUserComponent) { }

  ngOnInit(): void { 
    let reqHeader = new HttpHeaders().set('Authorization', 'Bearer ' + window.localStorage.getItem('token'));
    this.http.get<any>("http://localhost:8050/admin/menu/getProducts/"+window.localStorage.getItem('restid'),{ 'headers': reqHeader })
    .subscribe(
      data => {
        console.log(data)
        if(data.length==0){
          iziToast.error({
            message: "No Dishes Found",
            position:"topCenter"
        })
        }else{
         this.data=data; 
        }
        
  })
   }
   addtoFav(data:any,resturantName:any,dishName:any,quantity:any,price:any,discription:any,dishImage:any){
    // this.favourite=new Favourite(data,resturantName,dishName,quantity,price,discription,window.localStorage.getItem("loginemail"));
    let fav:Favourite={
      "emailid":data,
      "restaurantName":resturantName,
      "dishName":dishName,
      "quantity":quantity,
      "price":price,
      "description":discription,
      "dishImage":dishImage,
      "uemailid":window.localStorage.getItem("loginemail")
    }
    this.http.post<any>("http://localhost:8050/addToFavourite/post",fav)
    .subscribe(
      success=>{
        console.log(success);
        iziToast.success({
          title: 'Success',
          message: "Added To Favorite",
          position:"bottomRight"
      })
        this.comp.ngOnInit()
      },
      error=>{
        iziToast.warning({
          
          message: "Already In Favorite",
          position:"topCenter"
      })
          }
    );

   }

   addtoCart(data:any,resturantName:any,dishName:any,quantity:any,price:any,discription:any,dishImage:any){
    // this.favourite=new Favourite(data,resturantName,dishName,quantity,price,discription,window.localStorage.getItem("loginemail"));
    let fav:Favourite={
      "emailid":data,
      "restaurantName":resturantName,
      "dishName":dishName,
      "quantity":quantity,
      "price":price,
      "description":discription,
      "dishImage":dishImage,
      "uemailid":window.localStorage.getItem("loginemail")
    }
    this.http.post<any>("http://localhost:8050/addToCart/post",fav)
    .subscribe(
      success=>{
        console.log(success);
        iziToast.success({
          title: 'Success',
          message: "Added To Cart",
          position:"bottomRight"
      })
        // this.comp.reload()
        this.comp.ngOnInit()
      },
      error=>{
        iziToast.warning({
          
          message: "Already In Cart",
          position:"topCenter"
      })
          }
    );

   }
 


}
