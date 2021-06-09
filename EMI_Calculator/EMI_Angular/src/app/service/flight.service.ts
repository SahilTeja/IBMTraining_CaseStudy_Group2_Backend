import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { retry } from 'rxjs/operators';
import { EMI_chart } from 'src/emichart.module';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  baseUrl : string = "http://localhost:8880";
  // we have assigned url for database runnning in baseUrl

  constructor(private http : HttpClient) { }

  async getFlightlist() {
    return await this.http.get<EMI_chart[]>(this.baseUrl + "/emi/5000000/20").pipe(retry(1)).toPromise();
  }

  
}
