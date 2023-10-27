import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddToCartComponent } from './add-to-cart/add-to-cart.component';
import { AddToFavouriteComponent } from './add-to-favourite/add-to-favourite.component';
import { AdminSideDishesComponent } from './admin-side-dishes/admin-side-dishes.component';
import { AdminComponent } from './admin/admin.component';

import { AuthAdminGuard } from './authGuard/auth-admin.guard';

import { AuthGuard } from './authGuard/auth.guard';
import { LoginComponent } from './login/login.component';
import { NavigationUserComponent } from './navigation-user/navigation-user.component';
import { NavigationComponent } from './navigation/navigation.component';
import { OrderhistoryComponent } from './orderhistory/orderhistory.component';
import { RestDashboardComponent } from './rest-dashboard/rest-dashboard.component';

import { RestaurantDetailsComponent } from './restaurant-details/restaurant-details.component';
import { RestaurantdishesComponent } from './restaurantdishes/restaurantdishes.component';
import { Restproduct } from './restproduct';
import { RestproductComponent } from './restproduct/restproduct.component';
import { SearchByComponent } from './search-by/search-by.component';
import { SearchBydishNameComponent } from './search-bydish-name/search-bydish-name.component';

const routes: Routes = [
  {
    path:'',component:LoginComponent
  }
  ,{
    path:'nav',component:NavigationComponent,canActivate:[AuthAdminGuard],children:[
      {path:'admin',outlet:'restaurant',component:AdminComponent},
      {path:'resDetails',outlet:'restaurant',component:RestaurantDetailsComponent},
  {path:"rest",outlet:'restaurant',component:RestproductComponent},
  {
    path:'admindish',outlet:'restaurant',component:AdminSideDishesComponent
  }
  
    ]
  },
  
  {
    path:'profile',component:NavigationUserComponent,canActivate:[AuthGuard],children:[
      {
        path:'dashboard',outlet:'restdata',component:RestDashboardComponent
      }
      ,
      {
        path:'dishes',outlet:'restdata',component:RestaurantdishesComponent
      },
      {
        path:'fav',outlet:'restdata',component:AddToFavouriteComponent
      },
      {
        path:'cart',outlet:'restdata',component:AddToCartComponent
      },
      {
        path:'search',outlet:'restdata',component:SearchByComponent
      },
      {
        path:'searchbyDish',outlet:'restdata',component:SearchBydishNameComponent
      },
      {
        path:'history',outlet:'restdata',component:OrderhistoryComponent
      }    
    ]
  },
  
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
