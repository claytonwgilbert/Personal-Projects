import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { BehaviorSubject, Subject } from "rxjs";
import { tap } from "rxjs/operators";
import { User } from "./user.model";

//Defining how we get our response data back from rest calls below, we pass this to the post method below
interface AuthResponseData{
idToken: string;
email: string;
refreshToken: string;
expiresIn: string;
localId: string;
}


@Injectable({providedIn:'root'})
export class AuthService{
    user = new BehaviorSubject<User>(null);

    constructor(private http: HttpClient, private router: Router){}

    signup(email: string, password: string){
     return this.http.post<AuthResponseData>(
            'https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=AIzaSyAeIEUFZvrf8lHLtcaYWopTsJCe6CbffZc', 
            {
                email: email,
                password: password,
                returnSecureToken: true
            }
        )
        .pipe(tap(resData => {
           this.handleAuthentication(
               resData.email, 
               resData.localId, 
               resData.idToken, 
               +resData.expiresIn
            );
        }));
    }

    login(email: string, password: string){
        return this.http.post<AuthResponseData>(
            'https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyAeIEUFZvrf8lHLtcaYWopTsJCe6CbffZc',
            {
                email: email,
                password: password,
                returnSecureToken: true 
            }
        )
        .pipe(tap(resData => {
            this.handleAuthentication(
                resData.email, 
                resData.localId, 
                resData.idToken, 
                +resData.expiresIn
             );
         }));
    }

    logout(){
        this.user.next(null);
        this.router.navigate(['/auth']);
    }

    handleAuthentication(email: string, userId: string, token: string, expiresIn: number){
        const expirationDate = new Date(new Date().getTime() + expiresIn * 1000);
            
        const user = new User(
                email, 
                userId, 
                token, 
                expirationDate
            );
            
            this.user.next(user);
    }
}