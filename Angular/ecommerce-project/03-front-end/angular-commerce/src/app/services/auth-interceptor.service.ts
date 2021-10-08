import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OktaAuthService } from '@okta/okta-angular';
import { request } from 'http';
import { from, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor {

  constructor(private oktaAuth: OktaAuthService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return from(this.handleAccess(request, next));
  }

  private async handleAccess(request: HttpRequest<any>, next: HttpHandler): Promise<HttpEvent<any>>{
    // - only add access token for secured endpoints...
    const securedEndpoints = ['http://localhost:8080/api/orders'];

    if(securedEndpoints.some(url => request.urlWithParams.includes(url))){
      
      // - get access token
      const accessToken = await this.oktaAuth.getAccessToken();

      request = request.clone({
        setHeaders: {
          Authorization: 'Bearer' + accessToken
        }
      });
    }
    // - handle other requests if any, then continue 
    return next.handle(request).toPromise();
  }
}
