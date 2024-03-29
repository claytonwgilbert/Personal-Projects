import { templateJitUrl } from "@angular/compiler";
import { Component } from "@angular/core";
import { Form, NgForm } from "@angular/forms";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { AuthService } from "./auth.service";

@Component({
    selector: 'app-auth',
    templateUrl: './auth.component.html'
})
export class AuthComponent{
    isLoginMode = true;
    isLoading = false;
    error: string = null;

    constructor(private authService: AuthService, private router: Router){}

    onSwitchMode(){
        this.isLoginMode = !this.isLoginMode; //Change to opposite of what it already is
    }

    onSubmit(form: NgForm){
        if(!form.valid){
            return;
        }
        const email = form.value.email;
        const password = form.value.password;

        this.isLoading = true;

        if(this.isLoginMode){
            this.authService.login(email, password).subscribe(
                responseData =>  {
                    console.log(responseData);
                    this.isLoading = false;
                    this.router.navigate(['/recipes']);
                }, 
                error => {
                    this.error = 'An error occured';
                    this.isLoading = false;
                });
        }else{
            this.authService.signup(email, password).subscribe(
                responseData =>  {
                    console.log(responseData);
                    this.isLoading = false;
                }, 
                error => {
                    this.error = 'An error occured';
                    this.isLoading = false;
                });
        }
        form.reset();
    }

}