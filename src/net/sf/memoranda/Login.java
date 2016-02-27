package net.sf.memoranda;

import net.sf.memoranda.ui.LoginDialog;
import net.sf.memoranda.ui.NewLoginDialog;
import net.sf.memoranda.util.Configuration;
import net.sf.memoranda.util.Password;

public class Login {
	
	static boolean cancelled = false;
	static boolean valid = true; 
	static boolean loginOpen = false;

	public static void getDetails(){
		if(Password.getPassword()=="")
		{
			loginOpen=true;
			new NewLoginDialog();
		}
		else if(Password.getPassword().equalsIgnoreCase("none"))
		{
			cancelled = true;
		}
		else
		{
			loginOpen=true;
			new LoginDialog();
		}
	}
	
	public static boolean isOpen()
	{
		return loginOpen;
	}
	
	public static boolean isValid()
	{
		return valid;
	}
	
	public static boolean isCancelled()
	{
		return cancelled;
	}
	
	public static void cancelled()
	{
		cancelled = true;
	}
	public static void invalid()
	{
		valid = false; 
	}
}
