import { DatePipe } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import iziToast from 'izitoast';
import { Favourite } from '../favourite';
import { Mail } from '../mail';
import { NavigationUserComponent } from '../navigation-user/navigation-user.component';
import { OrderHistory } from '../order-history';

@Component({
  selector: 'app-add-to-cart',
  templateUrl: './add-to-cart.component.html',
  styleUrls: ['./add-to-cart.component.css']
})
export class AddToCartComponent implements OnInit {
  [x: string]: any;
  data: any;
  msg: any;
  cart:Favourite;
  QInput:any=1;
  option=[1,2,3,4,5]
  constructor(private http:HttpClient,public datepipe: DatePipe,private comp:NavigationUserComponent) { }
  ngOnInit(): void {
    let reqHeader = new HttpHeaders().set('Authorization', 'Bearer ' + window.localStorage.getItem('token'));
    this.http.get<any>("http://localhost:8050/addToCart/get/"+localStorage.getItem('loginemail') ,{ 'headers': reqHeader })
    .subscribe(
      data => {
        console.log(data)
         this.data=data;
         window.localStorage.setItem('cartlength',data.length)


  })
   }
   placeOrder(email:any,resturantName:any,dishName:any,price:any,discription:any,dishImage:any)
   {

   
    const date=new Date();
    let today =this.datepipe.transform(date, 'MM/dd/YY HH:MM:SS');
    console.log(today)
    let order:OrderHistory={
      "emailid":email,
      "restaurantName":resturantName,
      "dishName":dishName,
      "quantity":this.QInput,
      "price":price*this.QInput,
      "description":discription,
      "dishImage":dishImage,
      "uemailid":window.localStorage.getItem("loginemail"),
      "orderDate":today
    }
    
    this.deleteCart(email,resturantName,dishName,price,discription,dishImage)
    this.http.post<any>("http://localhost:8050/orderHistory/post",order).subscribe(
        success=>{
          iziToast.success({
            title: 'Success',
            message: "Order Successfully Placed"
        })
        }
    )
    console.log(this.QInput)
    this.msg="ThankYou for Ordering from our "+resturantName+" Your Order summary :\n"+"resturantName "+resturantName+"\n"+"Dish Name"+dishName+"\n"+"Total Amount "+price+"\n"+"Order Date "+today+"\n"+"Your Order will be delievered in 30 mins. Have a Nice Day ";
    let object:Mail={
      "recipient":window.localStorage.getItem("loginemail"),
      "msgBody":this.msg,
      "subject":"Your order"
    }
    console.log(order)
    console.log(object)
    this.http.post<any>("http://localhost:8050/sendMail",object)
    .subscribe(
      success=>{
        console.log(success);
        alert(success);
      }
    );
   }
   
   deleteCart(data:any,resturantName:any,dishName:any,price:any,discription:any,dishImage:any)
   {
    return this.http.delete("http://localhost:8050/addToCart/delete/cart/"+window.localStorage.getItem('loginemail')+"/"+data+"/"+dishName).subscribe(
      success=>{
        
        iziToast.success({
          message: "Deleted",
          position:"bottomRight"
      })// alert("Iteams deleted");
        this.ngOnInit();
        this.comp.ngOnInit()

      }
    )
   }
}