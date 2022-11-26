package CourseDatabaseManager;

import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CourseDBManager_STUDENT_Test {
	private static CourseDBManagerInterface dataMgr = new CourseDBManager();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dataMgr = new CourseDBManager();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
			dataMgr = null;
	}

	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	@Test
	public void testAdd() {
		try {
			dataMgr.add("CMSC9999",12345,4,"SC999","Who K. Nows");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception!!!");
		}
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadFile() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC9999 101 4 SC999 Who K.Nows");
			inFile.print("CMSC1111 999 4 SC111 Random Pearson");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			
			assertEquals("CMSC9999",dataMgr.get(101).getCRN());
			assertEquals("CMSC9999",dataMgr.get(101).getCRN());
			assertEquals("SC111",dataMgr.get(999));
			
			
			
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
	

	@Test
	public void testShowAll() {
		dataMgr.add("CMSC203",30504,4,"SC450","Joey Bag-O-Donuts");
		dataMgr.add("CMSC203",30503,4,"SC450","Jill B. Who-Dunit");
		dataMgr.add("CMSC204",30559,4,"SC450","BillyBob Jones");
		System.out.println(dataMgr.showAll());
	}

}
