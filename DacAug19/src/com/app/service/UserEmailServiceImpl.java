package com.app.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Service
@Transactional
public class UserEmailServiceImpl implements IUserEmailService
{
	@Autowired
	IUserDao dao;
	
	public User FindByEmails(String uEmail)
	{
		return dao.getDataByOnlyEmail(uEmail);
	}
	
	
	
	public int generatorOTP()
	{
		Random random=new Random();
		int num=random.nextInt(99999)+99999;
		if(num<100000 || num>999999)
		{
			num=random.nextInt(99999)+99999;
			if(num<100000 || num>999999)
			{
				System.out.println("not generated otp");
			}
		}
		return num;
	}






	@Override
	public void setPassword(String getuPassword, String getuEmail)
	{
		System.out.println(getuPassword+""+getuEmail);
	  	dao.setPassword(getuEmail, getuPassword);
	}



	@Override
	public void updatePassword(User user) {
		// TODO Auto-generated method stub
		
	}
}
