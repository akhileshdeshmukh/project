package com.app.controller;

import static org.springframework.http.HttpStatus.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IEditerDao;
import com.app.pojos.News;
import com.app.pojos.Poll;
import com.app.pojos.PollResult;
import com.app.pojos.User;

@RestController // @Controller + @ResponseBody
@RequestMapping("/Editer") // resource oriented
@CrossOrigin(allowedHeaders = "*")
public class EditerController {
@Autowired
private IEditerDao editerDao;

public EditerController() {
System.out.println("inside editer contoller");
}

@PostMapping("/register")
public ResponseEntity<?> register(@RequestBody User u)
{int status;

	try {
		return new ResponseEntity<Integer>(editerDao.register(u), CREATED);
	} catch (Exception e) {
		e.printStackTrace();
		String msg=new String("failed");
		return new ResponseEntity<String>(msg, NOT_ACCEPTABLE);
	}
}
@GetMapping("/getwriter/{id}")
public ResponseEntity<?> getdatabyid(@PathVariable int id)
{try {
	System.out.println("after check");
	return new ResponseEntity<User>(editerDao.getWriterById(id), OK);
} catch (Exception e) {
	e.printStackTrace();
	return new ResponseEntity<Exception>(e, NOT_FOUND);
}
}

@GetMapping("/deletewriter/{id}")
public ResponseEntity<?> deletewriter(@PathVariable int id)
{try {
	int status = editerDao.writerDelete(id);
	System.out.println("after check");
	return new ResponseEntity<Integer>(status, OK);
} catch (Exception e) {
	e.printStackTrace();
	return new ResponseEntity<Exception>(e, NOT_FOUND);
}
}
@GetMapping("/listofwriter")
public ResponseEntity<?> getWriterList()
{
	try {
		//List<User> user=new ArrayList<>();
		return new ResponseEntity<List<User>>(editerDao.listOfWriter(), OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Exception>(e, NOT_FOUND);
	}	
}

@PostMapping("/editwriter")
public ResponseEntity<?> editwriter(@RequestBody User u)
{
	try {
		return new ResponseEntity<Integer>(editerDao.edit(u), CREATED);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Exception>(e, NOT_FOUND);
	}
}

@PostMapping("/addpoll")
public ResponseEntity<?> addpoll(@RequestBody Poll p)
{System.out.println("inside addpoll");
	try {
		return new ResponseEntity<String>(editerDao.addPoll(p), CREATED);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Exception>(e, NOT_FOUND);
	}
}

@GetMapping("/getpoll")
public ResponseEntity<?> getpoll()
{
	try {
		//List<User> user=new ArrayList<>();
		return new ResponseEntity<Poll>(editerDao.getPoll(), OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Exception>(e, NOT_FOUND);
	}	
}

@PutMapping("/setanswer/{id}")
public ResponseEntity<?> setPollAnswer(@RequestBody String answer,@PathVariable int id)
{
	try {
		return new ResponseEntity<String>(editerDao.savePollAnswer(id, answer), OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Exception>(e, NOT_FOUND);
	}	
}

@GetMapping("/deletepoll/{id}")
public ResponseEntity<?> deletepoll(@PathVariable int id)
{try {
	String status = editerDao.deletePoll(id);
	System.out.println("after check");
	return new ResponseEntity<String>(status, OK);
} catch (Exception e) {
	e.printStackTrace();
	return new ResponseEntity<Exception>(e, NOT_FOUND);
}
}

@PutMapping("/addnews/{cid}")
public ResponseEntity<?> addNews(@RequestBody News news,@PathVariable int cid)
{
	try {
		return new ResponseEntity<String>(editerDao.addNews(cid, news), OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Exception>(e, NOT_FOUND);
	}	
}

@GetMapping("/getuploadednews/{lang}/{cnt}")
public ResponseEntity<?> getUploadedNews(@PathVariable String lang,@PathVariable int cnt)
{
	System.out.println(lang);
	try {
		return new ResponseEntity<List<News>>(editerDao.getUploadedNews(lang,cnt), OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Exception>(e, NOT_FOUND);
	}	
}

@GetMapping("/getnewsbycategory/{cate}/{lang}")
public ResponseEntity<?> getNewsByCategory(@PathVariable String cate,@PathVariable String lang)
{
	System.out.println(cate);
	System.out.println(lang);
	try {
		return new ResponseEntity<List<News>>(editerDao.getNewsByCategory(cate,lang), OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Exception>(e, NOT_FOUND);
	}	
}

@GetMapping("/getallnews")
public ResponseEntity<?> getAllNews()
{
	try {
		return new ResponseEntity<List<News>>(editerDao.getAllNews(), OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Exception>(e, NOT_FOUND);
	}	
}

@GetMapping("/unuploadnews/{id}")
public ResponseEntity<?> unUploadNews(@PathVariable int id)
{
	try {
		return new ResponseEntity<Boolean>(editerDao.unUploadNews(id), OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Exception>(e, NOT_FOUND);
	}
}

@GetMapping("/deletenews/{id}")
public ResponseEntity<?> deleteNews(@PathVariable int id)
{
	try {
		return new ResponseEntity<String>(editerDao.deleteNews(id), OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Exception>(e, NOT_FOUND);
	}
}

@GetMapping("/getunuploadednews")
public ResponseEntity<?> getUnuploadedNews()
{
	try {
		return new ResponseEntity<List<News>>(editerDao.getUnuploadedNews(), OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Exception>(e, NOT_FOUND);
	}	
}

@GetMapping("/uploadnews/{id}")
public ResponseEntity<?> uploadNews(@PathVariable int id)
{
	try {
		return new ResponseEntity<String>(editerDao.uploadNews(id), OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Exception>(e, NOT_FOUND);
	}
}

@GetMapping("/getsinglenews/{id}")
public ResponseEntity<?> getSingleNews(@PathVariable int id)
{
	try {
		return new ResponseEntity<News>(editerDao.getSingleNews(id), OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Exception>(e, NOT_FOUND);
	}
}


@PutMapping("/editnews/{cid}/{nid}")
public ResponseEntity<?> editNews(@RequestBody News news,@PathVariable int cid,@PathVariable int nid)
{
	try {
		return new ResponseEntity<String>(editerDao.editNews(cid,nid,news), OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Exception>(e, NOT_FOUND);
	}	
}

@GetMapping("/getpollanswer/{pid}")
public ResponseEntity<?> getpollanswer(@PathVariable int pid)
{
	try {
		//List<User> user=new ArrayList<>();
		return new ResponseEntity<List<Integer>>(editerDao.getPollanswer(pid), OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Exception>(e, NOT_FOUND);
	}	
}

@GetMapping("/addcategory/{cat}")
public ResponseEntity<?> addcategory(@PathVariable String cat)
{
	System.out.println(cat);
	try {
		return new ResponseEntity<String>(editerDao.addCategory(cat), OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Exception>(e, NOT_FOUND);
	}	
}

@GetMapping("/getnewsbydate/{lang}/{sdate}")
public ResponseEntity<?> getNewsByDate(@PathVariable String lang,@PathVariable String sdate)
{
	System.out.println(lang);
	System.out.println(sdate);
	try {
		return new ResponseEntity<List<News>>(editerDao.searchByDate(lang, sdate), OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Exception>(e, NOT_FOUND);
	}	
}

}
