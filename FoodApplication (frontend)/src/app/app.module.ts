import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import {MaterialModule} from './material-module';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AdminComponent } from './admin/admin.component';
import { NavigationComponent } from './navigation/navigation.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { RestaurantDetailsComponent } from './restaurant-details/restaurant-details.component';
import { RestproductComponent } from './restproduct/restproduct.component';
import { RestDashboardComponent } from './rest-dashboard/rest-dashboard.component';
import { RestaurantdishesComponent } from './restaurantdishes/restaurantdishes.component';
import { AdminSideDishesComponent } from './admin-side-dishes/admin-side-dishes.component';
import { AddToFavouriteComponent } from './add-to-favourite/add-to-favourite.component';
import { AddToCartComponent } from './add-to-cart/add-to-cart.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { NavigationUserComponent } from './navigation-user/navigation-user.component';
import { SearchByComponent } from './search-by/search-by.component';
import { SearchBydishNameComponent } from './search-bydish-name/search-bydish-name.component';
import { DatePipe } from '@angular/common';
import { OrderhistoryComponent } from './orderhistory/orderhistory.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminComponent,
    NavigationComponent,
    RestaurantDetailsComponent,
    RestproductComponent,
    RestDashboardComponent,
    RestaurantdishesComponent,
    AdminSideDishesComponent,
    AddToFavouriteComponent,
    AddToCartComponent,
    NavigationUserComponent,
    SearchByComponent,
    SearchBydishNameComponent,OrderhistoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,ReactiveFormsModule, BrowserAnimationsModule,HttpClientModule,MaterialModule, LayoutModule, MatToolbarModule, MatButtonModule, MatSidenavModule,MatIconModule, MatListModule,NgxPaginationModule
  ],
  providers: [SearchByComponent,DatePipe,RestaurantdishesComponent,NavigationUserComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
