import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Favourite } from '../favourite';
import { NavigationUserComponent } from '../navigation-user/navigation-user.component';
import { Restproduct } from '../restproduct';
import iziToast from 'izitoast';
@Component({
  selector: 'app-add-to-favourite',
  templateUrl: './add-to-favourite.component.html',
  styleUrls: ['./add-to-favourite.component.css']
})
export class AddToFavouriteComponent implements OnInit {
  data: any;
  constructor(private http:HttpClient,private comp:NavigationUserComponent) { }
  ngOnInit(): void {
    let reqHeader = new HttpHeaders().set('Authorization', 'Bearer ' + window.localStorage.getItem('token'));
    this.http.get<any>("http://localhost:8050/addToFavourite/get/"+localStorage.getItem('loginemail'),{ 'headers': reqHeader })
    .subscribe(
      data => {
        console.log(data)
         this.data=data;
  })
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
          message: "Added to Cart"
          
      })
      this.comp.ngOnInit()
      },
      error=>{
        iziToast.warning({
          message: "Already In Cart"
      })
      }
      
      
    );

   }
 
   deletefromFavourite(data:any,resturantName:any,dishName:any,quantity:any,price:any,discription:any,dishImage:any)
   {
    return this.http.delete("http://localhost:8050/addToFavourite/delete/favourite/"+window.localStorage.getItem('loginemail')+"/"+data+"/"+dishName).subscribe(
      success=>{
        iziToast.success({
          title: 'Success',
          message: "Deleted"
      })
        this.ngOnInit();
        this.comp.ngOnInit()
      }
    )
   }
}