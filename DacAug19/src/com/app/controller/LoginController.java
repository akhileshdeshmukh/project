package com.app.controller;

import static org.springframework.http.HttpStatus.*;

import java.util.List;

import javax.persistence.NoResultException;

import org.apache.catalina.ha.backend.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IUserDao;
import com.app.pojos.Categories;
import com.app.pojos.User;
import com.app.service.IUserEmailService;

@RestController // @Controller + @ResponseBody
@RequestMapping("/login") // resource oriented
@CrossOrigin(allowedHeaders = "*")
public class LoginController {
	
	int otp;
	User user;
	@Autowired
	private IUserDao userDao;

	@Autowired
	private IUserEmailService emSer;
	
	@Autowired
	private JavaMailSender sender;
	
	public LoginController() {
		System.out.println("inside login controller");
	}

	@PostMapping("/check")
	public ResponseEntity<?> login(@RequestBody User u) {
		System.out.println("inside login function" + u.getEmail() + u.getPassword());
		try {
			User user = userDao.logincheck(u);
			System.out.println("after check");
			return new ResponseEntity<User>(user, OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Exception>(e, INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/registermsg")
	public ResponseEntity<?> registermsg(@RequestBody User u)
	{
		if(u !=null)
		{
			String msg="hiii "+u.getName()+" your Registerd is Sucessfull your ID :"+u.getEmail()+" password :"+u.getPassword();
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(u.getEmail());
			mailMessage.setSubject("wellcome to News Blogger");
			mailMessage.setText(msg);
			try
			{
				sender.send(mailMessage);
				return new ResponseEntity<String>("success",OK);
			}
			catch (MailException e) 
			{
				System.out.println("inside mail exception");
				e.printStackTrace();
			}
		}
		return new ResponseEntity<String>("error",INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/forget/{uEmail:.+}")
	public ResponseEntity<?> forgotPassword(@PathVariable String uEmail)
	{
		System.out.println(uEmail);

		try
		{
			user = userDao.getDataByOnlyEmail(uEmail);
			if(user !=null)
			{
				otp = emSer.generatorOTP();
				String msg="Your one time password for forgot password is = "+otp;
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setTo(user.getEmail());
				mailMessage.setSubject("One Time Password");
				mailMessage.setText(msg);
				try
				{
					sender.send(mailMessage);
					return new ResponseEntity<String>("success",OK);

				}
				catch (MailException e) 
				{
					System.out.println("inside mail exception");
					e.printStackTrace();
				}
			
			}
		} catch (NoResultException e) 
		{
			e.printStackTrace();
		}
		return new ResponseEntity<String>("error",INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/confirmOtp")
	public ResponseEntity<?> confirmOtp(@RequestBody User user1)
	{
		System.out.println(otp);
	System.out.println(user1.getOtp());	
	 System.out.println(user1);
	 if(otp==user1.getOtp()) 
	 {
			emSer.setPassword(user1.getPassword(),user.getEmail());
			return new ResponseEntity<Integer>(1,OK);

	 }
	 else {
			return new ResponseEntity<Integer>(0,OK);
		}
	 
	
	}
	
	@PutMapping("/changepassword/{email:.+}")
	public ResponseEntity<?> changepassword(@RequestBody String password,@PathVariable String email)
	{
		try {
			emSer.setPassword(password,email);
			return new ResponseEntity<Integer>(1,OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Exception>(e, NOT_FOUND);
			
		}
	}

	@GetMapping("/listofcatagory")
	public ResponseEntity<?> getCatagoryList()
	{
		try {
			return new ResponseEntity<List<Categories>>(userDao.listOfCatagory(), OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Exception>(e, NOT_FOUND);
		}	
	}
	
}
