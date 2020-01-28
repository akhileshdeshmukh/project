import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/login/login.service';
import { Router } from '@angular/router';
import { EditerService } from '../editer.service';

@Component({
  selector: 'app-addcategory',
  templateUrl: './addcategory.component.html',
  styleUrls: ['./addcategory.component.css']
})
export class AddcategoryComponent implements OnInit {
  list;
  msg="";
  category;
    constructor(public service:LoginService,public router:Router,public editservice:EditerService) {
  this.getdata()
  }
  
    ngOnInit() { 
    
    }
  
    getdata()
    {
      let stateofresult=this.service.getlistofcatagory();
  stateofresult.subscribe((result)=>{
  this.list=result;  
  });
    }
  
    addcategory()
    {
      alert(this.category);
      this.editservice.addcategory(this.category).subscribe((result)=>{

      },err=>{

      })
      this.msg="Category is added";
    }

}
