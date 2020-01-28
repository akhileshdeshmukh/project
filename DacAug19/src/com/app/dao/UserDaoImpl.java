package com.app.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Categories;
import com.app.pojos.Role;
import com.app.pojos.User;
@Service
@Repository
@Transactional
public class UserDaoImpl implements IUserDao {


	@Autowired
	private SessionFactory sf;
	
	@Override
	public User logincheck(User u)throws Exception {
			System.out.println("inside dao");
			
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
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
			String jpql = "select u from User u where u.email = :em and u.password=:pass";
			User user= sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", u.getEmail())
					.setParameter("pass", hexString.toString()).getSingleResult();
			
			System.out.println(user.getRole().name());
			return user;
	}
	public User getDataByEmail(String uEmail,String uPassword)
	{
		StringBuffer hexString=null;
		   MessageDigest md;
			try {
				md = MessageDigest.getInstance("SHA-256");
				 md.update(uPassword.getBytes());
			      
			      //Compute the message digest
			      byte[] digest = md.digest();      
			      System.out.println(digest);  
			       hexString = new StringBuffer();
			      
			      for (int i = 0;i<digest.length;i++) {
			         hexString.append(Integer.toHexString(0xFF & digest[i]));
			      }
			      System.out.println("Hex format : " + hexString.toString());     
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		String jpql="select u from User u where email=:em and password=:pass";
		return sf.getCurrentSession().createQuery(jpql,User.class).setParameter("em", uEmail).setParameter("pass",hexString.toString()).getSingleResult();
	}

	@Override
	public User getDataByOnlyEmail(String uEmail)
	{
		System.out.println(uEmail);
		String jpql="select u from User u where email=:em";
		return sf.getCurrentSession().createQuery(jpql,User.class).setParameter("em", uEmail).getSingleResult();
	}
	
	public void setPassword(User user)
	{
		StringBuffer hexString=null;
		   MessageDigest md;
			try {
				md = MessageDigest.getInstance("SHA-256");
				 md.update(user.getPassword().getBytes());
			      
			      //Compute the message digest
			      byte[] digest = md.digest();      
			      System.out.println(digest);  
			       hexString = new StringBuffer();
			      
			      for (int i = 0;i<digest.length;i++) {
			         hexString.append(Integer.toHexString(0xFF & digest[i]));
			      }
			      System.out.println("Hex format : " + hexString.toString()); 
			      user.setPassword(hexString.toString());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		sf.getCurrentSession().update(user);
	}

	@Override
	public void setPassword(String email, String password)
	{
		System.out.println(email+""+password);
		
		StringBuffer hexString=null;
		   MessageDigest md;
			try {
				md = MessageDigest.getInstance("SHA-256");
				 md.update(password.getBytes());
			      
			      //Compute the message digest
			      byte[] digest = md.digest();      
			      System.out.println(digest);  
			       hexString = new StringBuffer();
			      
			      for (int i = 0;i<digest.length;i++) {
			         hexString.append(Integer.toHexString(0xFF & digest[i]));
			      }
			      System.out.println("Hex format : " + hexString.toString());     
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		String str = "select u from User u where u.email=:email";
		User u= sf.getCurrentSession().createQuery(str,User.class).setParameter("email",email).
					getSingleResult();	
			u.setPassword(hexString.toString());
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Categories> listOfCatagory() {
		String jpql="select c from Categories c";
		return sf.getCurrentSession().createQuery(jpql,Categories.class).getResultList();
	}
}
