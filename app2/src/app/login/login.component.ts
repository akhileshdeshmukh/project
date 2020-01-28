import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from './login.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
msg;
user;
  constructor(public router:Router,public service:LoginService,public routers:ActivatedRoute,public authservice:AuthService) { 
    sessionStorage.clear();
  }

  ngOnInit() {
  }
  Login(cd:any) {
    let c=cd.form.value;
    c.e
      if (c.email.length == 0) 
      {
        this.msg='enter valid email';
      } else if(c.password.length == 0) 
      {
        this.msg='enter valid password';
      } else 
      {
   

        
        //let checku =this.service.login(c);  
        //console.log(checku);
        //checku.subscribe((result:any)=>{
          this.service.login(c).subscribe(result=>{  
          this.user=result;
          alert("Wellcome "+this.user.name+" to News Blogger");
          
          if(this.user.role=='EDITOR')
          {
            sessionStorage['user']=[this.user.email,this.user.role,this.user.name,this.user.userId];
            this.router.navigate(['editer']);
                  }else
                  {
                    sessionStorage['user']=[this.user.userId];
                  this.router.navigate(['writerhome']);
                  }
        },err=>{
          this.msg='enter valid password/email';
          //this.router.navigate(['login']);
        });  
      }
    }
    forgotpassword()
    {
      this.router.navigate(['Forgotpassword']);
    }

    gobacktohome()
    {
      this.router.navigate(['Reader']);
    }
}
