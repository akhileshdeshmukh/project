import { Component, OnInit } from '@angular/core';
import { EditerService } from 'src/app/editer/editer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-changepasswordforwriter',
  templateUrl: './changepasswordforwriter.component.html',
  styleUrls: ['./changepasswordforwriter.component.css']
})
export class ChangepasswordforwriterComponent implements OnInit {

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
          this.router.navigate(['changepasswordofwriter']);
        },err=>{ 
            this.router.navigate(['login']);      
          }
        );
      }else
      {
        this.msg="check conform password";
        this.router.navigate(['changepasswordofwriter']);
      }
    }
}
