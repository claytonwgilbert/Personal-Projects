import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { OrderHistory } from '../common/order-history';

@Injectable({
  providedIn: 'root'
})
export class OrderHistoryService {

  private orderUrl = environment.luv2shopApiUrl + "/orders";

  constructor(private httpClient: HttpClient) { }

  getOrderHistory(theEmail: string): Observable<GetResponseOrderHistory>{

    // - Build full url
    const orderhistoryFullUrl = this.orderUrl + `/search/findByCustomerEmailOrderByDateCreatedDesc?email=${theEmail}`;

    console.log(orderhistoryFullUrl);

    return this.httpClient.get<GetResponseOrderHistory>(orderhistoryFullUrl);

  }
}

interface GetResponseOrderHistory {
  _embedded: {
    orders: OrderHistory[];
  }
}
