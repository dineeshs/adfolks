import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TokenStorage } from './TokenStorage';
import { TokenResponse } from './TokenResponse';
import { SignIn } from './SignIn';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  signIn: string = "http://localhost:8080/login";
  loggedIn:boolean = false;

  constructor(private http: HttpClient, private token: TokenStorage, private tokenDetails: TokenResponse, public router: Router) { }
  public authenticate (signInRequest: SignIn) {
    this.http.post<TokenResponse>(this.signIn, signInRequest).subscribe(

      data => {

        //this.signInRequest = signInRequest;

        console.log(data)
        this.tokenDetails = data;
        console.log("test +"+this.tokenDetails.accessToken)
        this.token.saveToken(this.tokenDetails.accessToken)
        this.loggedIn = true;
        this.router.navigate(['/rms']);
        

      },
      error =>  console.log(error)
    );
  }
}


