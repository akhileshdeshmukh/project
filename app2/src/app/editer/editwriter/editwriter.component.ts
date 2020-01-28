import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { EditerService } from '../editer.service';
import { Route } from '@angular/compiler/src/core';

@Component({
  selector: 'app-editwriter',
  templateUrl: './editwriter.component.html',
  styleUrls: ['./editwriter.component.css']
})
export class EditwriterComponent implements OnInit {
  writers;
  message;
  id;
  constructor(public route:ActivatedRoute,public router:Router,public service:EditerService,public routers:ActivatedRoute,) { 
    this.id=this.route.snapshot.paramMap.get('id');
  this.service.getdatabyid(this.id).subscribe((result:any)=>{
    this.writers=result;
  },err=>{
    console.log(err);
  });
  }
  ngOnInit() {
  }

update()
{
  console.log(this.writers);
let updatedatais= this.service.editwriter(this.writers);
updatedatais.subscribe((result:any)=>{
  console.log(result)
  if(result>0)
  {
          this.router.navigate(['listofwriter']);
          }else
          {
            this.message="you enter wrong data!";
		        this.router.navigate(['editwriter']);
          }
});
}

}
