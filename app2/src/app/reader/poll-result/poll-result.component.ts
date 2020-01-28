import { Component, OnInit } from '@angular/core';
import { EditerService } from 'src/app/editer/editer.service';
//import * as CanvasJS from '../../../assets/canvasjs.min';
//import { EditerService } from 'src/app/editer/editer.service';
//import { Script } from 'vm';

@Component({
  selector: 'app-poll-result',
  templateUrl: './poll-result.component.html',
  styleUrls: ['./poll-result.component.css']
})
export class PollResultComponent {
    poll;
    flag;
    msg;
    pollresult;
  constructor(public service:EditerService)
  {
    this.getpoll();
  }

  getpoll()
{
  this.service.getpoll().subscribe((result)=>{
    this.poll=result;
    this.service.getpollanswer(this.poll.pollId).subscribe((result)=>{
     this.pollresult=result;
    // alert(this.pollresult);
    },err=>{

    });
    sessionStorage['poll']=[this.poll.pollId];
    this.flag=true;
  },err=>{
    this.flag=false;
    this.msg="No poll is uploaded";
})

}

}
