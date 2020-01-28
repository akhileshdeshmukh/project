import { Component, OnInit } from '@angular/core';
import { EditerService } from '../editer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-deletepoll',
  templateUrl: './deletepoll.component.html',
  styleUrls: ['./deletepoll.component.css']
})
export class DeletepollComponent implements OnInit {
list;
flag=true;
msg="";
  constructor(public service :EditerService,public router:Router) { 
    this.getdata();
  }

  ngOnInit() {
  }

  getdata()
    {
      let stateofresult=this.service.getpoll();
  stateofresult.subscribe((result)=>{
  this.list=result;
  this.flag=true;  
  },err=>{
    this.flag=false;
    this.msg="No active poll is avalible";
  });
    }
  
  delete(n)
  {
    let isdelete=this.service.deletepoll(n);
    isdelete.subscribe((result:any)=>{
      if(result>0)
      {
        this.getdata();
        this.router.navigate(['deletepoll']); 
      }else
      {

      }
    });
  }

}
