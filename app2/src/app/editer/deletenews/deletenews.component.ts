import { Component, OnInit } from '@angular/core';
import { EditerService } from '../editer.service';

@Component({
  selector: 'app-deletenews',
  templateUrl: './deletenews.component.html',
  styleUrls: ['./deletenews.component.css']
})
export class DeletenewsComponent implements OnInit {
news;
  constructor(public service:EditerService) { 
    this.getdata();
  }
  ngOnInit() {
  }

  getdata()
  {
    let stateofresult=this.service.getallnews();
stateofresult.subscribe((result)=>{
this.news=result;  
});
  }


deletenews(nid)
{
  let stateofresult=this.service.deletenews(nid);
  stateofresult.subscribe((result)=>{
  window.location.reload();  
  },err=>{
    window.location.reload();
  });  
}

  unuploadnews(nid)
  {
    alert(nid);
    let stateofresult=this.service.unuploadnews(nid);
    stateofresult.subscribe((result)=>{
      window.location.reload();  
    },err=>{
      window.location.reload();
    });    
  }

}
