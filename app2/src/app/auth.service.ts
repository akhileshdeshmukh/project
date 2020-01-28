import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(public router:Router,public service:AuthService) { }


  islogin()
  {
   // return (sessionStorage.key.length>0)
  return(sessionStorage.length>0)
  }
  
  canActivate(route:ActivatedRouteSnapshot,state:RouterStateSnapshot)
{
  if(this.islogin())
  {
    return true;
  }
  else
  {
    this.router.navigate(['login']);
    return false;    
  }
}

Logout()
{
  sessionStorage.clear();
  this.router.navigate(['login']);
}

}
