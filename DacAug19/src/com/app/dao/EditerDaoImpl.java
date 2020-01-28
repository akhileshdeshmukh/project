package com.app.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Categories;
import com.app.pojos.News;
import com.app.pojos.Poll;
import com.app.pojos.PollResult;
import com.app.pojos.User;

@Service
@Repository
@Transactional
public class EditerDaoImpl implements IEditerDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Integer register(User u) throws Exception {

		StringBuffer hexString=null;
		   MessageDigest md;
			try {
				md = MessageDigest.getInstance("SHA-256");
				 md.update(u.getPassword().getBytes());
			      
			      //Compute the message digest
			      byte[] digest = md.digest();      
			      System.out.println(digest);  
			       hexString = new StringBuffer();
			      
			      for (int i = 0;i<digest.length;i++) {
			         hexString.append(Integer.toHexString(0xFF & digest[i]));
			      }
			      System.out.println("Hex format : " + hexString.toString()); 
			      u.setPassword(hexString.toString());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		
		return (Integer) sf.getCurrentSession().save(u);
	}

	@Override
	public User getWriterById(int id) throws Exception {
		return sf.getCurrentSession().get(User.class,id);
	}

	@Override
	public Integer writerDelete(int id) throws Exception {
		User user= sf.getCurrentSession().get(User.class,id);
		sf.getCurrentSession().delete(user);
	return 1;
	}

	@Override
	public List<User> listOfWriter() throws Exception {
		String jpql="select u from User u where u.role=com.app.pojos.Role.WRITER";
		return sf.getCurrentSession().createQuery(jpql, User.class).getResultList();
	
	}

	@Override
	public Integer edit(User u) throws Exception {
		//User user= sf.getCurrentSession().get(User.class,u.getuserId());
		 sf.getCurrentSession().update(u);
		 return 1;
	}

	@Override
	public String addPoll(Poll p) throws Exception {
	
		LocalDate ldt = LocalDate.now();
		int day = ldt.getDayOfMonth()+1;
		int month = ldt.getMonthValue();
		int year = ldt.getYear();
		//System.out.println(year+"-"+month+"-"+day);
		String cdate=null;
		if(day<10&&month<10)
		{
		cdate=year+"/0"+month+"/0"+day;	
		}
		if(month<10)
		{
		cdate=year+"-0"+month+"-"+day;
		}else if(day<10)
		{
		cdate=year+"/"+month+"/0"+day;
		}else {
			cdate=year+"/"+month+"/"+day;
		}
		
		Date d=new SimpleDateFormat("yyyy-MM-dd").parse(cdate);
		p.setValidUpto(d);
		p.setStatus("true");
		 sf.getCurrentSession().save(p);
		return "added";
	}

	@Override
	public Poll getPoll() throws Exception {

		LocalDate ldt = LocalDate.now();
		int day = ldt.getDayOfMonth();
		int month = ldt.getMonthValue();
		int year = ldt.getYear();
		//System.out.println(year+"-"+month+"-"+day);
		String cdate=null;
		if(day<10&&month<10)
		{
		cdate=year+"/0"+month+"/0"+day;	
		}
		if(month<10)
		{
		cdate=year+"-0"+month+"-"+day;
		}else if(day<10)
		{
		cdate=year+"/"+month+"/0"+day;
		}else {
			cdate=year+"/"+month+"/"+day;
		}
		
		Date d=new SimpleDateFormat("yyyy-MM-dd").parse(cdate);
		
		String jpql="select p from Poll p where p.status='true' and p.validUpto>:date";
		return sf.getCurrentSession().createQuery(jpql, Poll.class).setParameter("date", d).getSingleResult();
	
	}

	@Override
	public String savePollAnswer(int id, String answer) throws Exception {
		Poll p=sf.getCurrentSession().get(Poll.class,id);
		PollResult pr=new PollResult(answer);
		p.addPollResult(pr);
		sf.getCurrentSession().update(p);
		return "result added";
	}

	@Override
	public String deletePoll(int id) throws Exception {
		Poll p=sf.getCurrentSession().get(Poll.class,id);
		p.setStatus("false");
		return "delete poll completed";
	}

	@Override
	public String addNews(int id, News news) throws Exception {
		
		
		  LocalDateTime lt = LocalDateTime.now();
		  int hor= lt.getHour(); 
		  int min=lt.getMinute();
		  int sec= lt.getSecond();
		  
		  String time=hor+"-"+min+"-"+sec;
		    
		  Date t=new SimpleDateFormat("HH-mm-ss").parse(time);
		  System.out.println(t);
		  news.setUploadTime(t);
		  news.setFlag("false");

		  LocalDate ldt = LocalDate.now();
			int day = ldt.getDayOfMonth();
			int month = ldt.getMonthValue();
			int year = ldt.getYear();
			//System.out.println(year+"-"+month+"-"+day);
			String cdate=null;
			if(day<10&&month<10)
			{
			cdate=year+"/0"+month+"/0"+day;	
			}
			if(month<10)
			{
			cdate=year+"-0"+month+"-"+day;
			}else if(day<10)
			{
			cdate=year+"/"+month+"/0"+day;
			}else {
				cdate=year+"/"+month+"/"+day;
			}
			
			Date d=new SimpleDateFormat("yyyy-MM-dd").parse(cdate);
			news.setUploadDate(d);
			
			System.out.println(news);
			
			Categories c=sf.getCurrentSession().get(Categories.class,id);
			c.addNews(news);
			sf.getCurrentSession().update(c);
			
		 
		/*
		 * System.out.println(java.time.LocalTime.now()); java.time.LocalTime
		 * t=java.time.LocalTime.now(); new SimpleDateFormat("HH-mm-dd").parse(t);
		 */
		return "news is added";
	}

	@Override
	public String uploadNews(int id) throws Exception {
		News n=sf.getCurrentSession().get(News.class, id);
		n.setFlag("true");
		sf.getCurrentSession().update(n);
		return "uploaded";
	}

	@Override
	public String deleteNews(int id) throws Exception {
		News n=sf.getCurrentSession().get(News.class, id);
		sf.getCurrentSession().delete(n);
		return "news deleted";
	}

	@Override
	public List<News> getUploadedNews(String languages,int cnt) throws Exception {
		
		System.out.println(cnt);
	
			String jpql="select n from News n where n.flag='true' and n.language=:language order by n.uploadDate desc, n.uploadTime desc";	
			return sf.getCurrentSession().createQuery(jpql, News.class).setParameter("language", languages).setFirstResult(cnt).setMaxResults(10).getResultList();
		
		 
	}

	@Override
	public List<News> getNewsByCategory(String cat,String lang) throws Exception {

		   String jpql="select n from News n left outer join fetch n.categories c where n.flag='true' and n.language=:language and c.categoryName=:category order by n.uploadDate desc,n.uploadTime desc";
		//String jpql="select n from Categories c left outer join fetch c.news n where n.flag='true' and n.language=:language and c.categoryName=:category order by n.uploadDate,n.uploadTime desc";   
		return sf.getCurrentSession().createQuery(jpql,News.class).setParameter("language", lang).setParameter("category",cat).getResultList();
	}

	@Override
	public List<News> getAllNews() throws Exception {
		String jpql="select n from News n order by n.uploadDate desc,n.uploadTime desc";	
		return sf.getCurrentSession().createQuery(jpql, News.class).getResultList();		
	}

	@Override
	public boolean unUploadNews(int id) throws Exception {
		System.out.println(id);
		News n=sf.getCurrentSession().get(News.class, id);
		n.setFlag("false");
		sf.getCurrentSession().update(n);
		return true;
	}

	@Override
	public List<News> getUnuploadedNews() throws Exception {
		String jpql="select n from News n where n.flag='false' order by n.uploadDate desc,n.uploadTime desc";	
		return sf.getCurrentSession().createQuery(jpql, News.class).getResultList();
	}

	@Override
	public News getSingleNews(int id) throws Exception {
		return sf.getCurrentSession().get(News.class, id);
	}

	@Override
	public String editNews(int cid,int nid,News n) throws Exception {
		this.deleteNews(nid);
		this.addNews(cid, n);
		return "edited";
	}

	@Override
	public List<Integer> getPollanswer(int pid) throws Exception {
		//String jpql="select count(pr.answer) from PollResult pr left outer join fetch pr.poll p where p.pollId=:id group by pr.answer";
		//String jpql="select count(pr.answer) from Poll p left outer join fetch p.pollResult pr where p.pollId=:id group by pr.answer";
		//String jpql="select p from Poll p left outer join fetch p.pollResult pr where p.pollId=:id";
		String jpql="select pr from PollResult pr left join fetch pr.poll p where p.pollId=:id";
		List<PollResult> pr= sf.getCurrentSession().createQuery(jpql,PollResult.class).setParameter("id", pid).getResultList();		
		int  countA=0,countB=0,countC=0,countD=0;
		for (PollResult p : pr)
		{
			//System.out.println(p.getAnswer());
		if(p.getAnswer().equals("A"))
		{
			countA++;
		}
		if(p.getAnswer().equals("B"))
		{
			countB++;
		}
		if(p.getAnswer().equals("C"))
		{
			countC++;
		}
		if(p.getAnswer().equals("D"))
		{
			countD++;
		}
		}
		System.out.println(countA+"    "+countB+"    "+countC+"    "+countD);
		double all=countA+countB+countC+countD;
		System.out.println(all);
		List<Integer> ans=new ArrayList<>();
		//List<Integer> answ=new ArrayList<>();
		ans.add((int)((countA/all)*100));
		ans.add((int)((countB/all)*100));
		ans.add((int)((countC/all)*100));
		ans.add((int)((countD/all)*100));
		
		
		double ans1=(countA/all)*100;
		System.out.println(ans1);
		double ans2=(countB/all)*100;
		System.out.println(ans2);
		double ans3=(countC/all)*100;
		System.out.println(ans3);
		double ans4=(countD/all)*100;
		System.out.println(ans4);
		 int a =(int)ans1;
		return ans;
	}

	@Override
	public String addCategory(String cat) throws Exception {
		Categories c=new Categories();
		c.setCategoryName(cat);
		sf.getCurrentSession().save(c);
		return "added";
	}

	@Override
	public List<News> searchByDate(String lang, String sdate) throws Exception {
		
		Date d=new SimpleDateFormat("yyyy-MM-dd").parse(sdate);
		
		String jpql="select n from News n where n.flag='true' and n.language=:language and n.uploadDate=:dd order by n.uploadDate desc, n.uploadTime desc";	
		return sf.getCurrentSession().createQuery(jpql, News.class).setParameter("language", lang).setParameter("dd", d).getResultList();
		
	}

	
}
