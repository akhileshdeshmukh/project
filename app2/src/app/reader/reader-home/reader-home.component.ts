import { Component, OnInit } from '@angular/core';
import { EditerService } from 'src/app/editer/editer.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-reader-home',
  templateUrl: './reader-home.component.html',
  styleUrls: ['./reader-home.component.css']
})
export class ReaderHomeComponent implements OnInit {
news:any;
language="English";
categoryId;
morenews;
  constructor(public route:ActivatedRoute,public router:Router,public service:EditerService) {
    //this.language=this.route.snapshot.paramMap.get('language');
    //this.language="English"
     if(sessionStorage.length>0)
     {
       this.language=sessionStorage.getItem('language');
     }else
     {
       sessionStorage['language']=[this.language];
     }

//sessionStorage.clear();
    //this.categoryId=this.route.snapshot.paramMap.get('cid');
this.getallnews();

   }

  ngOnInit() {
  }

getallnews()
{
  
  let tmp=sessionStorage.getItem('count');
  if(tmp!=null)
  {
  this.morenews=tmp;
//  alert(this.morenews);
  }else
  {
    this.morenews=0;
  //  alert(this.morenews);
  }
  
this.language=sessionStorage.getItem('language');
  //alert(this.language);
  this.service.getuploadednews(this.language,this.morenews).subscribe((result)=>{
    this.news=result;
  },err=>{

})
}

nextnews()
{
this.morenews=this.morenews+10;
sessionStorage['count']=[this.morenews];
window.location.reload();
}

}
