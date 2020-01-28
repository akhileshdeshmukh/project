import { Component, OnInit } from '@angular/core';
import { setDefaultService } from 'selenium-webdriver/chrome';
import { Router } from '@angular/router';
import { EditerService } from 'src/app/editer/editer.service';

@Component({
  selector: 'app-searchbydate',
  templateUrl: './searchbydate.component.html',
  styleUrls: ['./searchbydate.component.css']
})
export class SearchbydateComponent implements OnInit {
  news:any;
  language;
  sdate;
  //category;
  constructor(public router:Router,public service:EditerService) { 
    //window.location.reload();
    this.sdate=sessionStorage.getItem('sdate');
    this.language=sessionStorage.getItem('language');
    //sessionStorage.clear();
this.getnewsbydate();
  }

  ngOnInit() {
  }
 
  getnewsbydate()
  {
   // alert(this.language+this.sdate);
    this.service.getnewsbydate(this.language,this.sdate).subscribe((result)=>{
      this.news=result;
    },err=>{
  
  })
  }


}
