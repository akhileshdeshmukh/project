import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(public http:HttpClient) { }
  login(loginData:any)
  {
    return this.http.post("http://13.233.83.15:8080/DacAug19/login/check",loginData);
  }
  GetOtp(data)
  {
    return this.http.get("http://13.233.83.15:8080/DacAug19/login/forget/"+data);
  }

  setpass(data)
      {
      console.log(data)
      return this.http.post("http://13.233.83.15:8080/DacAug19/login/confirmOtp",data);
         
      }
      getlistofcatagory()
      {
        return this.http.get("http://13.233.83.15:8080/DacAug19/login/listofcatagory");
      }
}
