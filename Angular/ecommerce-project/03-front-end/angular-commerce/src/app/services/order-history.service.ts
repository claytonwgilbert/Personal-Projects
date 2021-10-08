import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderHistory } from '../common/order-history';

@Injectable({
  providedIn: 'root'
})
export class OrderHistoryService {

  private orderUrl = 'http://localhost:8080/api/orders';

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
