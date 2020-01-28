import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EditerService } from 'src/app/editer/editer.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  l;
  message;
  id;
  constructor(public route:ActivatedRoute,public router:Router,public service:EditerService,public routers:ActivatedRoute,) { 
    
    let user=sessionStorage.getItem('user');
    this.id= user;
  this.service.getdatabyid(this.id).subscribe((result:any)=>{
    this.l=result;
  },err=>{
    console.log(err);
  });
  }

  ngOnInit() {
  }
  editdata()
  {
    this.router.navigate(['editprofile']);
  }

}
