import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { map, take } from "rxjs/operators";
import { AuthService } from "./auth.service";

@Injectable({providedIn: 'root'})
export class AuthGuard implements CanActivate {
    constructor(private authService: AuthService, private router: Router){
    }
    
    //When this method is placed on a route such as in router.module file, this check is performed to see if user is
    //authenticated, if it fails then the route is unaccessible, if succeeds then we allow that route to be visited.
    canActivate(
        route: ActivatedRouteSnapshot, 
        router: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
            return this.authService.user.pipe(
            take(1),
            map(user => {
               const isAuth = !!user; 
               if(isAuth){
                   return true;
               }else{
                   return this.router.createUrlTree(['/auth']);
               }
            }));
        }

}