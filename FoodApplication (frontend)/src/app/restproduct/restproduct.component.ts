import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import iziToast from 'izitoast';
import { RestaurantService } from '../Services/restaurant.service';
import { Restproduct } from '../Models/restproduct';

@Component({
  selector: 'app-restproduct',
  templateUrl: './restproduct.component.html',
  styleUrls: ['./restproduct.component.css'],
})
export class RestproductComponent implements OnInit {
  restProduct: Restproduct;
  selectedFile: any;

  constructor(
    private restProductService: RestaurantService,
    private http: HttpClient
  ) {}

  restaurantform = new FormGroup({
    emailid: new FormControl(window.localStorage.getItem('user')),
    restaurantName: new FormControl(window.localStorage.getItem('restname')),
    dishName: new FormControl('', [Validators.required]),
    price: new FormControl('', [Validators.required]),
    description: new FormControl('', [Validators.required]),
  });

  ngOnInit(): void {}
  public onFileChanged(event: any) {
    //Select File
    this.selectedFile = event.target.files[0];
  }

  submit() {
    console.log(this.restaurantform.value);
    const formData = new FormData();
    this.restProduct = this.restaurantform.value;
    // console.log("data"+this.signupdata);
    formData.append(
      'profile',
      new Blob([JSON.stringify(this.restProduct)], {
        type: 'application/json',
      })
    );
    formData.append('imageFile', this.selectedFile);
    console.log('log is' + formData);

    let reqHeader = new HttpHeaders().set(
      'Authorization',
      'Bearer ' + window.localStorage.getItem('token')
    );
    this.http
      .post('http://localhost:9000/admin/menu/addDetails', formData, {
        headers: reqHeader,
      })
      .subscribe((res) => {
        console.log(res);
        this.restaurantform.reset();
        iziToast.success({
          title: 'Success',
          message: 'Added',
        });
      });
  }
}
