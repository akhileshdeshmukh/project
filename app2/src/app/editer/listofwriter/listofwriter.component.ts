import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EditerService } from '../editer.service';

@Component({
  selector: 'app-listofwriter',
  templateUrl: './listofwriter.component.html',
  styleUrls: ['./listofwriter.component.css']
})
export class ListofwriterComponent implements OnInit {
  list;
  msg;
  l;

    constructor(public router:Router, public service:EditerService) 
    {
  this.getdata();
    }
    ngOnInit() { }
    
    getdata()
    {
      let stateofresult=this.service.getlistofwriter();
  stateofresult.subscribe((result)=>{
  this.list=result;  
  });
    }
  
  delete(n)
  {
    let isdelete=this.service.deletewriter(n);
    isdelete.subscribe((result:any)=>{
      if(result>0)
      {
        this.getdata();
        this.router.navigate(['listofwriter']); 
      }else
      {
        this.msg="something went wrong !";
      }
    });
  }
  
  editdata(n)
  {
    this.router.navigate(['editwriter',{id:n}]);
  }
}
