import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import iziToast from 'izitoast';

@Component({
  selector: 'app-admin-side-dishes',
  templateUrl: './admin-side-dishes.component.html',
  styleUrls: ['./admin-side-dishes.component.css']
})
export class AdminSideDishesComponent implements OnInit {
  message: any;

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    let reqHeader = new HttpHeaders().set('Authorization', 'Bearer ' + window.localStorage.getItem('token'));

    this.http.get<any>("http://localhost:8050/admin/menu/getProducts/"+window.localStorage.getItem('dishemail'),{ 'headers': reqHeader })
    .subscribe(
      data => {
        console.log(data)
        this.message=data; 
        // if(data.length==0){
        //   alert("Something Went Wrong")
        // }
        
         
        
  })
  }
  delete(email:any,dish:any){
    let reqHeader = new HttpHeaders().set('Authorization', 'Bearer ' + window.localStorage.getItem('token'));
  this.http.delete<any>("http://localhost:8050/admin/menu/deletedish/"+email+"/"+dish,{ 'headers': reqHeader }).subscribe(
    success=>{
      console.log(success)
      iziToast.success({
        message: "Deleted",
        position:"topCenter"
    })
      this.ngOnInit();
    }
  );
  
  }

}
