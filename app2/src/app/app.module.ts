import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { WriterComponent } from './writer/writer.component';
import { EditerComponent } from './editer/editer.component';
import { ReaderComponent } from './reader/reader.component';
import { from } from 'rxjs';
import { PollComponent } from './reader/poll/poll.component';
import { PollResultComponent } from './reader/poll-result/poll-result.component';
import { ReaderHomeComponent } from './reader/reader-home/reader-home.component';
import { RegisterComponent } from './editer/register/register.component';
import { LoginService } from './login/login.service';
import { AuthService } from './auth.service';
import { EditerHomeComponent } from './editer/editer-home/editer-home.component';
import { ListofwriterComponent } from './editer/listofwriter/listofwriter.component';
import { EditwriterComponent } from './editer/editwriter/editwriter.component';
import { ForgotpasswordComponent } from './login/forgotpassword/forgotpassword.component';
import { SetpasswordComponent } from './login/setpassword/setpassword.component';
import { ChangepasswordComponent } from './editer/changepassword/changepassword.component';
import { AddpollComponent } from './editer/addpoll/addpoll.component';
import { DeletepollComponent } from './editer/deletepoll/deletepoll.component';
import { AddnewsComponent } from './editer/addnews/addnews.component';
import { UploadnewsComponent } from './editer/uploadnews/uploadnews.component';
import { DeletenewsComponent } from './editer/deletenews/deletenews.component';
import { CategoryComponent } from './reader/category/category.component';
import { EditnewsComponent } from './editer/editnews/editnews.component';
import { EditprofileComponent } from './writer/editprofile/editprofile.component';
import { AddnewsbywriterComponent } from './writer/addnewsbywriter/addnewsbywriter.component';
import { ChangepasswordforwriterComponent } from './writer/changepasswordforwriter/changepasswordforwriter.component';
import { ProfileComponent } from './writer/profile/profile.component';
import { WriterHomeComponent } from './writer/writer-home/writer-home.component';
import { EditnewsbywriterComponent } from './writer/editnewsbywriter/editnewsbywriter.component';
import { SearchbydateComponent } from './reader/searchbydate/searchbydate.component';
import { AddcategoryComponent } from './editer/addcategory/addcategory.component';
import { ContactusComponent } from './reader/contactus/contactus.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    WriterComponent,
    EditerComponent,
    ReaderComponent,
    PollComponent,
    PollResultComponent,
    ReaderHomeComponent,
    RegisterComponent,
    EditerHomeComponent,
    ListofwriterComponent,
    EditwriterComponent,
    ForgotpasswordComponent,
    SetpasswordComponent,
    ChangepasswordComponent,
    AddpollComponent,
    DeletepollComponent,
    AddnewsComponent,
    UploadnewsComponent,
    DeletenewsComponent,
    CategoryComponent,
    EditnewsComponent,
    EditprofileComponent,
    AddnewsbywriterComponent,
    ChangepasswordforwriterComponent,
    ProfileComponent,
    WriterHomeComponent,
    EditnewsbywriterComponent,
    SearchbydateComponent,
    AddcategoryComponent,
    ContactusComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path:'',component:ReaderHomeComponent,},
      {path:'editer',component:EditerHomeComponent,canActivate:[AuthService]},
     // {path:'reader',component:ReaderComponent},
      {path:'writer',component:WriterComponent,canActivate:[AuthService]},
      {path:'login',component:LoginComponent},
      {path:'Reader',component:ReaderHomeComponent},
      {path:'poll',component:PollComponent},
      {path:'PollResult',component:PollResultComponent},
      {path:'Register',component:RegisterComponent,canActivate:[AuthService]},
      {path:'editwriter',component:EditwriterComponent,canActivate:[AuthService]},
      {path:'listofwriter',component:ListofwriterComponent,canActivate:[AuthService]},
      {path:'setpassword',component:SetpasswordComponent},
      {path:'Forgotpassword',component:ForgotpasswordComponent},
      {path:'changepassword',component:ChangepasswordComponent,canActivate:[AuthService]},
      {path:'addpoll',component:AddpollComponent,canActivate:[AuthService]},
      {path:'deletepoll',component:DeletepollComponent,canActivate:[AuthService]},
      {path:'addnews',component:AddnewsComponent,canActivate:[AuthService]},
      {path:'uploadnews',component:UploadnewsComponent,canActivate:[AuthService]},
      {path:'deletenews',component:DeletenewsComponent,canActivate:[AuthService]},
      {path:'category',component:CategoryComponent},
      {path:'searchbydate',component:SearchbydateComponent},
      {path:'contactus',component:ContactusComponent},
      {path:'editnews',component:EditnewsComponent,canActivate:[AuthService]},
      {path:'addnewsbywriter',component:AddnewsbywriterComponent,canActivate:[AuthService]},
      {path:'editprofile',component:EditprofileComponent,canActivate:[AuthService]},
      {path:'changepasswordofwriter',component:ChangepasswordforwriterComponent,canActivate:[AuthService]},
      {path:'profile',component:ProfileComponent,canActivate:[AuthService]},
      {path:'writerhome',component:WriterHomeComponent,canActivate:[AuthService]},
      {path:'editnewsbywriter',component:EditnewsbywriterComponent,canActivate:[AuthService]},
      {path:'addcategory',component:AddcategoryComponent,canActivate:[AuthService]}

    ])
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }