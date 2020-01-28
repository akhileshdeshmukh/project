import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EditerService } from 'src/app/editer/editer.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  category="MISCELLANEOUS";
  news:any;
  language;
  constructor(public router:Router,public service:EditerService) { 
    //window.location.reload();
    this.category=sessionStorage.getItem('category');
    this.language=sessionStorage.getItem('language');
    //sessionStorage.clear();
this.getnewsbycategory();
  }

  ngOnInit() {
  }
 
  getnewsbycategory()
  {
   // alert(this.category+this.language);
    this.service.getnewsbycategory(this.category,this.language).subscribe((result)=>{
      this.news=result;
    },err=>{
  
  })
  }


}
