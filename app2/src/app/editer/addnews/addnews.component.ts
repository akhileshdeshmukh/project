import { Component, OnInit } from '@angular/core';
import { EditerService } from '../editer.service';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login/login.service';

@Component({
  selector: 'app-addnews',
  templateUrl: './addnews.component.html',
  styleUrls: ['./addnews.component.css']
})
export class AddnewsComponent implements OnInit {
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
    
    this.editorservice.addnews(news,this.catagory).subscribe((result)=>{
      alert("check details");
      //alert("news is uploaded (for add more news clear first)");
    },err=>{
      
      alert("news is added");
        window.location.reload();
    })
  }


}
