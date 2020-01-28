import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EditerService } from 'src/app/editer/editer.service';

@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.css']
})
export class EditprofileComponent implements OnInit {

  writers;
  message;
  id;
  constructor(public route:ActivatedRoute,public router:Router,public service:EditerService,public routers:ActivatedRoute,) { 
    //this.id=this.route.snapshot.paramMap.get('id');
    let user=sessionStorage.getItem('user');
    this.id= user[0];
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
          this.router.navigate(['addnewsbywriter']);
          }else
          {
            this.message="you enter wrong data!";
		        this.router.navigate(['editprofile']);
          }
});
}

}
