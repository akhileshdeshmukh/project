import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-writer',
  templateUrl: './writer.component.html',
  styleUrls: ['./writer.component.css']
})
export class WriterComponent implements OnInit {

  constructor(public router:Router,public service:AuthService) { }

  ngOnInit() {
  }

  editprofile()
  {
    let user=sessionStorage.getItem('user');
    alert(user[0]);
    let n=user[0];
    this.router.navigate(['editprofile',{id:n}]);
  }
}
