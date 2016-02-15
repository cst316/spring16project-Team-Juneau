package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.memoranda.Resource;

public class ResourceTest {
	
	private Resource r1;
	private Resource r2;
	private Resource r3;
	private Resource r4;
	private Resource r5;
	private Resource r6;
	private Resource r7;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		r1 = new Resource("google", "search", true, false);
		r2 = new Resource("google", "search", true, false);
		r3 = new Resource("youtube", "videos", true, false);
		r4 = new Resource("image.png", "image1", false, true);
		r5 = new Resource("image2.png", "image2", false, true);
		r6 = new Resource("image2.png", "image2", false, true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void resourceTest() {
		assertEquals(r1.getPath(), r2.getPath());
		assertEquals(r1.getPath(), r2.getPath());
		assertEquals(r1.getResDesc(), r2.getResDesc());
		assertEquals(r1.isInetShortcut(), r2.isInetShortcut());
		assertEquals(r1.isProjectFile(), r2.isProjectFile());
		
		assertEquals(r5.getPath(), r6.getPath());
		assertEquals(r5.getResDesc(), r6.getResDesc());
		assertEquals(r5.isInetShortcut(), r6.isInetShortcut());
		assertEquals(r5.isProjectFile(), r6.isProjectFile());
		
		assertNotSame(r3.getPath(), r4.getPath());
		assertNotSame(r3.getResDesc(), r4.getResDesc());
		assertNotSame(r3.isInetShortcut(), r4.isInetShortcut());
		assertNotSame(r3.isProjectFile(), r4.isProjectFile());

		assertNull(r7);
		assertNotNull(r1);
	}

}
