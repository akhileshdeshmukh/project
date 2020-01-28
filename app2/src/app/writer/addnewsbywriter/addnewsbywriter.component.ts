import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/login/login.service';
import { Router } from '@angular/router';
import { EditerService } from 'src/app/editer/editer.service';

@Component({
  selector: 'app-addnewsbywriter',
  templateUrl: './addnewsbywriter.component.html',
  styleUrls: ['./addnewsbywriter.component.css']
})
export class AddnewsbywriterComponent implements OnInit {

  list:any;
  flag=false;
  catagory;
  languages;
    constructor(public service:LoginService,public router:Router,public editorservice:EditerService) { }
  
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
    
    uplodenews(news)
    {
      //alert(news.image);
      this.editorservice.addnews(news,this.catagory).subscribe((result)=>{
       
      },err=>{
        alert("news is added");
        window.location.reload();
      })
    }
  
   
}
