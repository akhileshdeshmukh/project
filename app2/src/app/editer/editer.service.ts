import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EditerService {

  constructor(public http:HttpClient) { }

  adddata(reg)
  {
    return this.http.post("http://13.233.83.15:8080/DacAug19/Editer/register",reg);
  }
  getdatabyid(id:any)
  {
    return this.http.get("http://13.233.83.15:8080/DacAug19/Editer/getwriter/"+id);
  }
  deletewriter(id:any)
  {
    return this.http.get("http://13.233.83.15:8080/DacAug19/Editer/deletewriter/"+id);
  }
  editwriter(user:any)
  {
  return this.http.post("http://13.233.83.15:8080/DacAug19/Editer/editwriter",user);
  }
  getlistofwriter()
  {
    return this.http.get("http://13.233.83.15:8080/DacAug19/Editer/listofwriter");
  }
  registermsg(reg:any)
  {
    return this.http.post("http://13.233.83.15:8080/DacAug19/login/registermsg",reg);
  }

  changepassword(email:string,password:string)
  {
    return this.http.put("http://13.233.83.15:8080/DacAug19/login/changepassword/"+email,password);
  }

  addpoll(poll:any)
  {
    return this.http.post("http://13.233.83.15:8080/DacAug19/Editer/addpoll",poll);
  }

  getpoll()
  {
    return this.http.get("http://13.233.83.15:8080/DacAug19/Editer/getpoll");
  }

  setanswer(id,ans)
  {
    return this.http.put("http://13.233.83.15:8080/DacAug19/Editer/setanswer/"+id,ans);
  }

  deletepoll(id:any)
  {
    return this.http.get("http://13.233.83.15:8080/DacAug19/Editer/deletepoll/"+id);
  }

  addnews(news:any,cid)
  {
    return this.http.put("http://13.233.83.15:8080/DacAug19/Editer/addnews/"+cid,news);
  }

  getunuploadednews()
  {
    return this.http.get("http://13.233.83.15:8080/DacAug19/Editer/getunuploadednews");
  }

  getuploadednews(language,cnt)
  {
    return this.http.get("http://13.233.83.15:8080/DacAug19/Editer/getuploadednews/"+language+"/"+cnt);
  }

  uploadednews(id)
  {
    return this.http.get("http://13.233.83.15:8080/DacAug19/Editer/uploadednews/"+id);
  }


  deletenews(id)
  {
    return this.http.get("http://13.233.83.15:8080/DacAug19/Editer/deletenews/"+id);
  }

  getnewsbycategory(category,language)
  {
    return this.http.get("http://13.233.83.15:8080/DacAug19/Editer/getnewsbycategory/"+category+"/"+language);
  }

  getallnews()
  {
    return this.http.get("http://13.233.83.15:8080/DacAug19/Editer/getallnews");
  }

  unuploadnews(id)
  {
    return this.http.get("http://13.233.83.15:8080/DacAug19/Editer/unuploadnews/"+id);
  }

  editnews(cat,nid,news)
  {
    return this.http.put("http://13.233.83.15:8080/DacAug19/Editer/editnews/"+cat+"/"+nid,news);
  }

  uploadnews(nid)
  {
    return this.http.get("http://13.233.83.15:8080/DacAug19/Editer/uploadnews/"+nid);
  }

getsinglenews(nid)
{
  return this.http.get("http://13.233.83.15:8080/DacAug19/Editer/getsinglenews/"+nid);
}

getpollanswer(pollid)
{
  return this.http.get("http://13.233.83.15:8080/DacAug19/Editer/getpollanswer/"+pollid);
}

getnewsbydate(lang,sdate)
{
  return this.http.get("http://13.233.83.15:8080/DacAug19/Editer/getnewsbydate/"+lang+"/"+sdate);
}

addcategory(add)
{
  return this.http.get("http://13.233.83.15:8080/DacAug19/Editer/addcategory/"+add);
}

}
