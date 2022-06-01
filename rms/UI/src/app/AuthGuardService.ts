import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { TokenStorage } from './TokenStorage';


@Injectable()
export class AuthGuardService implements CanActivate {

    constructor( public router: Router, public token: TokenStorage) { }

    canActivate(): boolean {

        if (this.token.getToken() === null) {
            this.router.navigate(['/login']);
            return false;
        } 
        return true;
    }
}