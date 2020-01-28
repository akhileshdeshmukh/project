package com.app.service;

import com.app.pojos.User;

public interface IUserEmailService
{
	public User FindByEmails(String uEmail);
	public void updatePassword(User user);
	public int generatorOTP();
	public void setPassword(String getuPassword, String getuEmail);
}
