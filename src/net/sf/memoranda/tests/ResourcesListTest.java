package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.memoranda.Project;
import net.sf.memoranda.Resource;
import net.sf.memoranda.ResourcesList;
import net.sf.memoranda.ResourcesListImpl;
import nu.xom.Document;



public class ResourcesListTest {

	private Document d1;
	private Project p1;
	private Project p2;
	private ResourcesList rList1;
	private ResourcesList rList2;
	private ResourcesList rList3;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {	
		rList1 = new ResourcesListImpl(p1);
		rList2 = new ResourcesListImpl(p1);
		rList3 = new ResourcesListImpl(p2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addResourceTest() {
		rList1.addResource("google", "search", true, false);
		rList1.addResource("image.png", "image1", false, true);
		rList2.addResource("google");
		rList2.addResource("image.png");

		assertNotNull(rList1);
		assertNotNull(rList2);
	}
	
	@Test
	public void removeResourceTest() {
		rList1.addResource("google", "search", true, false);
		rList3.addResource("google", "search", true, false);
		assertNotNull(rList1);
		assertNotNull(rList3);
		assertEquals(rList1.getResource("google").getPath(), rList3.getResource("google").getPath());
		rList1.removeResource("google");
		assertNull(rList1.getResource("google"));
		
		rList2.addResource("image.png", "image1", false, true);
		assertNotNull(rList2);
		rList2.removeResource("image.png");
		assertNull(rList2.getResource("image.png"));
	}
	
	@Test
	public void getResourceTest() {
		rList1.addResource("google", "search", true, false);
		rList1.addResource("image.png", "image1", false, true);
		assertNotNull(rList1.getResource("google"));
		assertNull(rList1.getResource("yahoo"));
	}
	
	@Test
	public void getAllResourcesTest() {
		rList1.addResource("google", "search", true, false);
		rList1.addResource("image.png", "image1", false, true);
		
		rList2.addResource("google", "search", true, false);
		rList2.addResource("image.png", "image1", false, true);
		
		assertEquals(rList1.getAllResources().size(), rList2.getAllResources().size());
	}
	
	@Test
	public void getAllResourcesCountTest() {
		rList1.addResource("google", "search", true, false);
		rList1.addResource("gmail", "email", true, false);
		rList1.addResource("image.png", "image1", false, true);
		assertNotNull(rList1);
		assertEquals(3, rList1.getAllResourcesCount());
		assertNotEquals(5, rList1.getAllResourcesCount());

		
	}

}
