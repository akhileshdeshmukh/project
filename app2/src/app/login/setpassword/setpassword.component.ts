import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-setpassword',
  templateUrl: './setpassword.component.html',
  styleUrls: ['./setpassword.component.css']
})
export class SetpasswordComponent implements OnInit {
  msg:string;
  flag:boolean;
    constructor(public loginservice:LoginService,public router:Router) { }
  
    ngOnInit() {
    }
    gobacktologin()
    {
      this.router.navigate(['login']);
    }

    updatepass(data)
    {
      this.loginservice.setpass(data).subscribe((result)=>{
        console.log(result);
        if(result){
          this.msg="suucessfully changed password";
          this.flag=true;
          // this.router.navigate(['login']);
        }
        else{
          this.flag=false
          this.msg="Enter valid OTP";
        }
      })
      console.log(data);
    }
  
    navigate()
    {
      this.router.navigate(['login']);
    }
  
  
}
