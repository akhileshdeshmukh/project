import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reader',
  templateUrl: './reader.component.html',
  styleUrls: ['./reader.component.css']
})
export class ReaderComponent implements OnInit {
list;
language="English";
  constructor(public service:LoginService,public router:Router) {

    if(sessionStorage.length>0)
     {
       this.language=sessionStorage.getItem('language');
     }else
     {
      sessionStorage['language']=[this.language];
     }

//sessionStorage['language']=[this.language];

this.getdata()
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

  setlanguage(language)
  {
    sessionStorage.clear();   
    this.language=language;
    //alert(language);
    sessionStorage['language']=[this.language];
    window.location.reload();
    //this.router.navigate(['Reader']);
    
  }


  setcatagory(c:any)
  {
    //sessionStorage['language']=[this.language];
    sessionStorage['category']=[c.categoryName];  
    this.router.navigate(['category']);
  }

searchbydate(sedate)
{
  //alert(sedate.sdate);
  sessionStorage['sdate']=([sedate.sdate]);
  this.router.navigate(['searchbydate'])
}

}
