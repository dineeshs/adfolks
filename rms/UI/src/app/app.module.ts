import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component';
import { Routes, RouterModule } from '@angular/router';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCardModule} from '@angular/material/card';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatButtonModule } from "@angular/material/button";
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { RmsComponent } from './rms/rms.component';
import {AppService} from './app.service';
import {AuthGuardService} from './AuthGuardService';
import { TokenStorage } from './TokenStorage';
import { TokenResponse } from './TokenResponse';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatTabsModule} from '@angular/material/tabs';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';


const appRoutes: Routes = [
  { path: 'login', component: LoginComponent },
 // { path: 'rms', component: RmsComponent ,canActivate:[AuthGuardService] },
  { path: 'rms', component: RmsComponent },
  { path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  }
];
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RmsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
     RouterModule.forRoot(
      appRoutes
    ),
    MatGridListModule,
    MatCardModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    FormsModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatTabsModule,
    MatDatepickerModule,
    MatNativeDateModule
    
  ],
  providers: [MatDatepickerModule,
    MatNativeDateModule,AppService, AuthGuardService, TokenStorage, TokenResponse],
  bootstrap: [AppComponent]
})
export class AppModule { }
