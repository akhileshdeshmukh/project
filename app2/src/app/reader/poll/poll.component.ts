import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { $ } from 'protractor';
import { EditerService } from 'src/app/editer/editer.service';

@Component({
  selector: 'app-poll',
  templateUrl: './poll.component.html',
  styleUrls: ['./poll.component.css']
})
export class PollComponent implements OnInit {
poll:any;
msg:any="";
flag=true;
  constructor(public router:Router,public service:EditerService) { 
this.getpoll();    
  }

  ngOnInit() {
  }


getpoll()
{
  this.service.getpoll().subscribe((result)=>{
    this.poll=result;
    sessionStorage['poll']=[this.poll.pollId];
    this.flag=true;
  },err=>{
    this.flag=false;
    this.msg="No poll is uploaded";
})

}


  submitpoll(answer:any)
  {
    //alert(answer.answer1);
    let pollId= sessionStorage.getItem("poll");
    this.service.setanswer(pollId,answer.answer1).subscribe((result)=>{
      alert("thanks for submiting poll");
    },err=>{

    })

    this.router.navigate(['Reader']);
  }


}
