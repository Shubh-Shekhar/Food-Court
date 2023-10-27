import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, ElementRef, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { login } from '../login';
import { LoginService } from '../login.service';
import { RestaurantdishesComponent } from '../restaurantdishes/restaurantdishes.component';
import { signup } from '../signup';
import { ViewChild } from '@angular/core';
import iziToast from 'izitoast';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  selectedFile:File;
  logindata: login
  signupdata:signup
  emailcheck:any;
  status: any;
  message: any;
  path: any;
  target: any;
  constructor(private loginservice:LoginService,private route:Router,private http:HttpClient) { }

  ngOnInit(): void {
    this.http.get<any>("http://localhost:8050/user/getAll").subscribe(
      success=>{
        //  this.emailcheck=success
         this.emailcheck=success.map((s: { uemailid: any; })=>s.uemailid)
         console.log(this.emailcheck)
         
      })
  }
  loginFormGroup = new FormGroup({
    "uemailid": new FormControl('',[Validators.required]),
    "upassword": new FormControl('',[Validators.required])
  });
  registerFormGroup = new FormGroup({
    "name": new FormControl('',[Validators.required]),
    "emailid": new FormControl('',[Validators.required,Validators.pattern("^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z]+(?:\.[a-zA-Z]+)*$")]),
    "password": new FormControl('',[Validators.required]),
    "address": new FormControl('',[Validators.required])
  });


  public onFileChanged(event:any) {
    //Select File
    this.selectedFile = event.target.files[0];
  }
  onEmailChanged(event:any){
      
   if(this.emailcheck.includes(event.target.value))
    {
      iziToast.warning({
      
        message: 'User Already Exists',
        position: 'topCenter'
    })
    }
  }


  loginCheck() {
    localStorage.clear();
    console.log(this.loginFormGroup)
    this.logindata = this.loginFormGroup.value;
    window.localStorage.setItem("loginemail",this.loginFormGroup.get('uemailid').value);
    this.loginservice.logincheck(this.logindata).subscribe(
      success => {
        console.log(success);
       
        window.localStorage.setItem('token',success.token);
        window.localStorage.setItem('tokenAdmin',success.tokenAdmin)
        // window.localStorage.setItem("loginemail")
        
       
        if(success.role=="role_admin"){
          iziToast.success({
            title: 'Success',
            message: 'Welcome',
            position: 'bottomRight'
        })
          this.route.navigate(['/nav',{
            outlets:{
              restaurant:['admin']
            }
          }])
          
          
        }
        else{
          iziToast.success({
            title: 'Success',
            message: 'Welcome',
            position: 'bottomRight'
        })
          this.route.navigate(['/profile',{
            outlets:{
              restdata:['dashboard']
            }
          }])
          
        }

       
      },
      error => {
        // alert("Something Went Wrong")
        iziToast.error({
          title: 'Failed',
          message: 'EmailID or Password Wrong'
          ,position: 'topCenter'
      });
      });
  }
   
  register(){


    console.log(this.registerFormGroup.value)
    const formData = new FormData();
    this.signupdata=this.registerFormGroup.value;
    console.log("data"+this.signupdata);
    formData.append("profile",new Blob([JSON.stringify(this.signupdata)], {
      type: "application/json"
  }));
    formData.append("imageFile", this.selectedFile);
    console.log("log is"+formData);


    this.http.post('http://localhost:8050/userprofile/signup',formData)
      .subscribe(res => {
        console.log(res);
        this.registerFormGroup.reset();
        this.reset()
        iziToast.success({
          title: 'Success',
          message: 'User Registered',
          position: 'bottomRight'
      })
      },error=>{
        iziToast.error({
          title: 'Failed',
          message: 'User Registration Failed'
          ,position: 'topCenter'
      })
      }
      )
  }

  @ViewChild('myInput')
  myInputVariable: ElementRef;
  reset() {
    console.log(this.myInputVariable.nativeElement.files);
    this.myInputVariable.nativeElement.value = "";
    console.log(this.myInputVariable.nativeElement.files);
}


   get upassword(){
    return this.loginFormGroup.get('upassword')
   }
   get uemailid(){
    return this.loginFormGroup.get('uemailid')
   }

}
