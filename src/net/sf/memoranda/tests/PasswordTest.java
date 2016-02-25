package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import net.sf.memoranda.util.Password;

public class PasswordTest {
	
	String systemPassword;
	
	@Before
	public void setUp() throws Exception {
		systemPassword = Password.getPassword();
	
	}
	
	@After
	public void tearDown() throws Exception {
		Password.setPassword(systemPassword);
	}
	
	@Test
	public void passwordTest() {
		Password.setPassword("Test1");
		assertEquals(Password.getPassword(),"Test1");
		
		Password.setPassword("Test2?");
		assertEquals(Password.getPassword(),"Test2?");
		
		Password.setPassword("Test333");
		assertEquals(Password.getPassword(),"Test333");
		
	}
}
