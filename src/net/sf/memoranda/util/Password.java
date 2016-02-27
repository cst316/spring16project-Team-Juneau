package net.sf.memoranda.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Password {
	
	static String passwordPath = getPasswordPath();
	static String password; 
	
	static {
	    try {
	     Encryption ecrypter = new Encryption("CST315TeamJuneau");
	     password = ecrypter.decrypt(new FileInputStream(passwordPath));
	     System.out.println("Loaded from " + passwordPath);
	    }
	    catch (Exception e) {      
	      File f = new File(passwordPath);
	      new File(f.getParent()).mkdirs();      
	      /*DEBUG*/System.out.println("New password file created: "+passwordPath);
	      password="";
	      }
	    if(password==null)
	    {
	    	password="";
	    }
	    }
	
	static String getPasswordPath() {
	    String p = Util.getEnvDir()+"memoranda.password";
	    if (new File(p).exists()) 
	        return p;
	    String p1 = Util.getEnvDir()+"jnotes2.password";
	    if (new File(p1).exists()) {
	        /*DEBUG*/System.out.println(p + " not found.\n"+p1+" used instead.");
	        return p1;
	    }    
	    return p;
	  }
	
	public static void save()
	{
		try{
		Encryption ecrypter = new Encryption("CST315TeamJuneau");
		InputStream in = new ByteArrayInputStream(password.getBytes(StandardCharsets.UTF_8));
		ecrypter.encrypt(in,new FileOutputStream(passwordPath));
		}
		catch (Exception e)
		{
			System.out.println(e);
		/*DEBUG*/System.out.println("Unable to save password file");
		}
	}	
	
	public static void setPassword(String password1)
	{
		password = password1;
	}
	
	public static String getPassword()
	{
		return password;
	}

}
