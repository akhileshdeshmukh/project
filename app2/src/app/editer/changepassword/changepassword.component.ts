import { Component, OnInit } from '@angular/core';
import { EditerService } from '../editer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-changepassword',
  templateUrl: './changepassword.component.html',
  styleUrls: ['./changepassword.component.css']
})
export class ChangepasswordComponent implements OnInit {
cpassword;
msg;
email;
password;
  constructor(public service:EditerService,public router:Router) { }

  ngOnInit() {
  }

  changepassword()
  {
    console.log(this.password);
    if(this.cpassword==this.password)
    {
      this.service.changepassword(this.email,this.password).subscribe((result:any)=>{
        this.msg="you enter wrong email!";
        this.router.navigate(['changepassword']);
      },err=>{ 
          this.router.navigate(['login']);      
        }
      );
    }else
    {
      this.msg="check conform password";
      this.router.navigate(['changepassword']);
    }
  }
}
