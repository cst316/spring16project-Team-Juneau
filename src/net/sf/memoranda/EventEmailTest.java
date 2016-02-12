package net.sf.memoranda;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EventEmailTest {
	
	private EventEmail emailTest1 = null;
	private EventEmail emailTest2 = null;
	private EventEmail emailTest3 = null;
	
	@Before
	public void setUp() throws Exception {
		
		emailTest1 = new EventEmail("clhoover@asu.edu","test");
		emailTest2 = new EventEmail("clhoover","");
		emailTest3 = new EventEmail("test","blah");
		
	}
	
	@Test
	public void testEmail() {
		
		assertTrue(emailTest1.sendNewEmail());
		assertTrue(!emailTest2.sendNewEmail());
		assertTrue(!emailTest3.sendNewEmail());
		
	}

}
