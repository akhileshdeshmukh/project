import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/login/login.service';
import { Router } from '@angular/router';
import { EditerService } from 'src/app/editer/editer.service';

@Component({
  selector: 'app-editnewsbywriter',
  templateUrl: './editnewsbywriter.component.html',
  styleUrls: ['./editnewsbywriter.component.css']
})
export class EditnewsbywriterComponent implements OnInit {

  list:any;
  flag=false;
  catagory;
  languages;
   newsid;
   news;
   msg;
    constructor(public service:LoginService,public router:Router,public editorservice:EditerService) { 
  this.newsid=sessionStorage.getItem('edit');
  sessionStorage.removeItem('edir');
this.editorservice.getsinglenews(this.newsid).subscribe((result)=>{
this.news=result;
this.catagory=this.news.categories.categoryId;
},err=>{

})
}
  
    ngOnInit() {
    }



  
    getdata()
    {
  let stateofresult=this.service.getlistofcatagory();
  stateofresult.subscribe((result)=>{
  this.list=result;  
  //this.router.navigate(['Reader']);
  });
    }
  
    setcatagory(c:any)
    {
      this.catagory=c.categoryId;
    }
  
    setlanguage(language)
    {
     if(language=="English")
     {
  this.flag=true;
  this.languages=language;
     }else
     {
      this.flag=false;     
      this.languages=language;
     }
      
    }
  
    editnews(newnews)
    {
      this.editorservice.editnews(this.catagory,this.news.newsId,newnews).subscribe((result)=>{
        this.msg=" news is edited";
        this.router.navigate(['writerhome']);
      },err=>{
        this.router.navigate(['writerhome']);
      })
    }

}
