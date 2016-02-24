package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.ui.Die;

public class DieTest {
	
	private Die d6;
	private Die d12;
	private Die d18;
	private Die df1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void rollRange() throws Exception {
		d6 = new Die();
		d12 = new Die(12);
		d18 = new Die(18);
		for(int i=0; i < 50; i++){
			assertTrue((d18.roll()<=18) && (d18.getResult()>=1));
		}
		for(int i=0; i < 50; i++){
			assertTrue((d12.roll()<=12) && (d12.getResult()>=1));
		}
		for(int i=0; i < 50; i++){
			assertTrue((d6.roll()<=6) && (d6.getResult()>=1));
		}		
	}
	@Test
	public void creationValues() throws Exception{
		Die dFault = new Die();
		Die d7 = new Die(7,4);
		Die d3 = new Die(3);
		Die d1 = new Die(1,1);
		Die dClone = new Die(7,4);
		
		assertTrue(6==dFault.getNumSides());
		assertTrue(7==d7.getNumSides());
		assertTrue(4==d7.getResult());
		assertTrue(3==d3.getNumSides());
		assertTrue(1==d1.getNumSides());
		assertTrue(1==d1.getResult());
		assertTrue(dClone.equals(d7));
		assertFalse(d3.equals(d1));
				
	}


}
