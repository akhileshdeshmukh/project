package com.app.dao;

import java.util.List;

import com.app.pojos.News;
import com.app.pojos.Poll;
import com.app.pojos.PollResult;
import com.app.pojos.User;

public interface IEditerDao {
public Integer register(User u)throws Exception;
public User getWriterById(int id)throws Exception;
public Integer writerDelete(int id)throws Exception;
public List<User> listOfWriter()throws Exception;
public Integer edit(User u)throws Exception;
public String addPoll(Poll p)throws Exception;
public Poll getPoll()throws Exception;
public String savePollAnswer(int id,String answer)throws Exception;
public String deletePoll(int id)throws Exception;
public String addNews(int id,News news)throws Exception;
public String uploadNews(int id)throws Exception;
public String deleteNews(int id)throws Exception;
public List<News> getUploadedNews(String language,int cnt)throws Exception;
public List<News> getNewsByCategory(String cat,String lang)throws Exception;
public List<News> getAllNews()throws Exception;
public boolean unUploadNews(int nid)throws Exception;
public List<News> getUnuploadedNews()throws Exception;  
public News getSingleNews(int id)throws Exception;
public String editNews(int cid,int nid,News n)throws Exception;
public List<Integer> getPollanswer(int pid)throws Exception;
public String addCategory(String cat)throws Exception;
public List<News> searchByDate(String lang,String sdate)throws Exception;
}

