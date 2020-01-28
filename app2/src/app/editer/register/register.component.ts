import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/login/login.service';
import { EditerService } from '../editer.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
msg;
  constructor(public service:EditerService) { }

  ngOnInit() {
  }

  addempl(dataFromUI:any)
  {
  let reg=dataFromUI.form.value;
  console.log(reg);
  let stateofresult=this.service.adddata(reg)
  stateofresult.subscribe((result)=>{
    console.log(result);
    this.service.registermsg(reg).subscribe((result)=>{
      this.msg="registered";
    },err=>{

    });

    this.msg="registere";
  },err=>{ 
    this.msg="Failed";
  });
  }
}
