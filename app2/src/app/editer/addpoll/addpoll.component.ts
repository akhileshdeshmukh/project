import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EditerService } from '../editer.service';

@Component({
  selector: 'app-addpoll',
  templateUrl: './addpoll.component.html',
  styleUrls: ['./addpoll.component.css']
})
export class AddpollComponent implements OnInit {

  constructor(public router:Router,public service:EditerService) { }

  ngOnInit() {
  }
  uplodepoll(polldata:any)
  {
//alert(polldata.addPoll+polldata.optA);
this.service.addpoll(polldata).subscribe((result)=>{
    this.router.navigate(['editer']);
  },err=>{
    this.router.navigate(['editer']);
  })
}


  gobacktologin()
  {
  this.router.navigate(['addpoll']);
  }

}
