import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.css']
})
export class ForgotpasswordComponent implements OnInit {
msg;
  constructor(public router:Router,public loginservice:LoginService) { }

  ngOnInit() {
  }
  getotp(data)
  {
    console.log(data);
    this.loginservice.GetOtp(data).subscribe((result:string)=>{
      this.msg="change pass";
      console.log(this.msg);
    },
    error=>{ 
      if(error.status===200){
      this.router.navigate(['setpassword']);
    }
    else{
      this.msg="enter valid email"
      }
    })
  }

  

}
