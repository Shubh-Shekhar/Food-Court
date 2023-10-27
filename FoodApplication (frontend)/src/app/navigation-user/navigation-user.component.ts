import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormControl, FormGroup } from '@angular/forms';
import { SearchByComponent } from '../search-by/search-by.component';
import iziToast from 'izitoast';
@Component({
  selector: 'app-navigation-user',
  templateUrl: './navigation-user.component.html',
  styleUrls: ['./navigation-user.component.css']
})
export class NavigationUserComponent {

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );
  path: string;
  tempemail: any;
  tempname: any;
  searchInput: string;
  cartlength=window.localStorage.getItem('cartlength')
  option=["RestaurantName","DishName","City"]
  favlength: any;

  constructor(private breakpointObserver: BreakpointObserver,private http:HttpClient,private router:Router,private searchComp:SearchByComponent) {}
  

 
  ngOnInit(): void {
   
    this.http.get<any>('http://localhost:8050/userprofile/get/'+localStorage.getItem('loginemail'))
    .subscribe(
      res => {
        
        console.log(res)
        this.path = 'data:image/jpeg;base64,' + res[0];
        this.tempemail=res[1].toUpperCase();
        this.tempname=res[2].toUpperCase();
      
      }
      
    );
    // this.router.navigate(['/profile',{
    //   outlets:{
    //     restdata:['dashboard']
    //   }
    // }])
    let reqHeader = new HttpHeaders().set('Authorization', 'Bearer ' + window.localStorage.getItem('token'));
    this.http.get<any>("http://localhost:8050/addToCart/get/"+localStorage.getItem('loginemail') ,{ 'headers': reqHeader })
    .subscribe(
      data => {
        console.log(data)
         
        this.cartlength=data.length

  })
  let reqHeader1 = new HttpHeaders().set('Authorization', 'Bearer ' + window.localStorage.getItem('token'));
  this.http.get<any>("http://localhost:8050/addToFavourite/get/"+localStorage.getItem('loginemail'),{ 'headers': reqHeader })
  .subscribe(
    data => {
      console.log(data)
       this.favlength=data.length
})

}
  
  // reload(){
  //   window.location.reload()
  // }
  signout(){
    window.localStorage.clear();
    iziToast.success({
      title: 'Success',
      message: 'Bye '+this.tempname
  })
    this.router.navigate([''])

  }

  favourite(){
    this.router.navigate(['/profile',{
      outlets:{
        restdata:['fav']
      }
    }])
  }
  cart(){
    this.router.navigate(['/profile',{
      outlets:{
        restdata:['cart']
      }
    }])
  }
   orderhistory(){
    this.router.navigate(['/profile',{
      outlets:{
        restdata:['history']
      }
    }])
   }


  searchForm=new FormGroup({
    search: new FormControl('')
    })
  
    
 search(){
  this.router.navigate(['/profile',{
    outlets:{
      restdata:['dashboard']
    }
  }])
  
  if(this.searchForm.get('search').value=="DishName")
  
  this.http.get<any>("http://localhost:8050/admin/menu/searchbydishname/"+this.searchInput).subscribe(
    success=>{
      console.log(success)
      if(success.length==0){
        iziToast.error({
          message: "Not Found",
          position: 'bottomCenter'
      })
      }
      else{
        iziToast.success({
          message: "Found "+success.length,
          position: 'topCenter'
      })
      window.localStorage.setItem('searchData',JSON.stringify(success))
      this.router.navigate(['/profile',{
        outlets:{
          restdata:['searchbyDish']
        }
      }])
    }
  }
  )
  else if(this.searchForm.get('search').value=="RestaurantName")
  this.http.get<any>("http://localhost:8050/admin/search/"+this.searchInput).subscribe(
    success=>{
      console.log(success)
      if(success.length==0){
        iziToast.error({
          message: "Not Found",
          position: 'bottomCenter'
      })
      }
      else{
        iziToast.success({
          message: "Found "+success.length,
          position: 'topCenter'
      })
        window.localStorage.setItem('searchData',JSON.stringify(success))
        this.router.navigate(['/profile',{
          outlets:{
            restdata:['search']
          }
        }])
      }
      
    }
  )
  else if(this.searchForm.get('search').value=="City")
  this.http.get<any>("http://localhost:8050/admin/searchbycity/"+this.searchInput).subscribe(
    success=>{
      console.log(success)
      if(success.length==0){
        iziToast.error({
          message: "Not Found",
          position: 'bottomCenter'
      })
      }
      else{
        iziToast.success({
          message: "Found "+success.length,
          position: 'topCenter'
      })
        window.localStorage.setItem('searchData',JSON.stringify(success))
        
        this.router.navigate(['/profile',{
          outlets:{
            restdata:['search']
          }
        }])
      }
      
     
    }
  )
 }
}
