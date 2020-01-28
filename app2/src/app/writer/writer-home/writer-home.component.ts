import { Component, OnInit } from '@angular/core';
import { EditerService } from 'src/app/editer/editer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-writer-home',
  templateUrl: './writer-home.component.html',
  styleUrls: ['./writer-home.component.css']
})
export class WriterHomeComponent implements OnInit {

  news;
  constructor(public service:EditerService,public router:Router) { 
    this.getdata();
  }
  ngOnInit() {
  }

  getdata()
  {
    let stateofresult=this.service.getunuploadednews();
stateofresult.subscribe((result)=>{
this.news=result;  
});

  }

  uploadnews(nid)
  {
    alert(nid);
    let stateofresult=this.service.uploadnews(nid);
    stateofresult.subscribe((result)=>{
      window.location.reload();  
    },err=>{
      window.location.reload();
    });    
  }

editnews(news)
{
  sessionStorage['edit']=[news.newsId];
  this.router.navigate(['editnewsbywriter']);
}

}
