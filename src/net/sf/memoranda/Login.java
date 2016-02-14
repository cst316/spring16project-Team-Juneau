package net.sf.memoranda;

import net.sf.memoranda.ui.LoginDialog;
import net.sf.memoranda.ui.NewLoginDialog;
import net.sf.memoranda.util.Configuration;

public class Login {
	
	static boolean cancelled = false;
	static boolean valid = true; 
	static boolean loginOpen = false;

	public static void getDetails(){
		if(Configuration.get("USER_PASSWORD").toString().equalsIgnoreCase("default")||
				Configuration.get("USER_PASSWORD")=="")
		{
			loginOpen=true;
			new NewLoginDialog();
		}
		else if(Configuration.get("USER_PASSWORD").toString().equalsIgnoreCase("none"))
		{
			cancelled = true;
		}
		else
		{
			loginOpen=true;
			System.out.println(Configuration.get("USER_PASSWORD"));
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
