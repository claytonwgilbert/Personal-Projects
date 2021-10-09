import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Country } from '../common/country';
import { State } from '../common/state';

@Injectable({
  providedIn: 'root'
})
export class Luv2ShopFormService {

  private countriesUrl = environment.luv2shopApiUrl + "/countries";
  private statesUrl = environment.luv2shopApiUrl + "/states";

  constructor(private httpClient: HttpClient) { }

  getCountries(): Observable<Country[]>{
      return this.httpClient.get<GetResponseCountries>(this.countriesUrl).pipe(
        map(response => response._embedded.countries)
      );
  }

  getStates(countryCode: string): Observable<State[]>{
    const stateSearchUrl = `${this.statesUrl}/search/findByCountryCode?code=${countryCode}`; 

    return this.httpClient.get<GetResponseStates>(stateSearchUrl).pipe(
      map(response => response._embedded.states)
    );
}

  getCreditCardMonths(startMonth: number): Observable<number[]> {

    let data: number[] = [];

    for(let theMonth = startMonth; theMonth <= 12; theMonth++){
      data.push(theMonth);
    }

    return of(data); //Returns data as Observable so that our angular components can subscribe to it
  }

  getCreditCardYears(): Observable<number[]> {

    let data: number[] = [];

    const startYear: number = new Date().getFullYear();
    const endYear: number = startYear + 10;

    for(let theYear = startYear; theYear <= endYear; theYear++){
      data.push(theYear);
    }

    return of(data); //of(data) returns an Observable so that our angular components can subscribe to it
  }

}

interface GetResponseCountries{
  _embedded:{
    countries: Country[]
  }
}

interface GetResponseStates{
  _embedded:{
    states: State[]
  }
}
