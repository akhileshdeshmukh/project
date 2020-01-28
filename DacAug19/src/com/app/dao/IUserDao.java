package com.app.dao;



import java.util.List;

import com.app.pojos.Categories;
import com.app.pojos.User;
public interface IUserDao 
{
public User logincheck(User u)throws Exception;

public User getDataByEmail(String uEmail,String uPassword);
public User getDataByOnlyEmail(String uEmail);
public void setPassword(String email,String password);
public List<Categories> listOfCatagory();
}
