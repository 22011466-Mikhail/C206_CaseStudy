import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Enrolment en1;
	private Enrolment en2;
	private Enrolment en3;

	private ArrayList<Enrolment> EnrolmentList;

	@Before
	public void setUp() throws Exception {
	}

	public void testAddEnrolment() {
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid Enrolment arraylist to add to", EnrolmentList);
		assertEquals("Test that the Enrolment arraylist is empty.", 0, EnrolmentList.size());
		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addEnrolment(EnrolmentList, en1);
		assertEquals("Test that the Enrolment arraylist size is 1.", 1, EnrolmentList.size());

		// Add an item
		C206_CaseStudy.addEnrolment(EnrolmentList, en2);
		assertEquals("Test that the Enrolment arraylist size is now 2.", 2, EnrolmentList.size());
		// The item just added is as same as the last item in the list
		assertSame("Test that Enrolment is added to the end of the list.", en2, EnrolmentList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addEnrolment(EnrolmentList, en2);
		assertEquals("Test that the Enrolment arraylist size is unchange.", 2, EnrolmentList.size());

		// Add an item that has missing detail
		Camcorder cc_missing = new Camcorder("CC0014", "", 60);
		C206_CaseStudy.addCamcorder(EnrolmentList, cc_missing);
		assertEquals("Test that the Enrolment arraylist size is unchange.", 2, EnrolmentList.size());
	}

	public void testRetrieveAllCamcorder() {
		// Test Case 1
		// Test if Item list is not null and empty
		assertNotNull("Test if there is valid Enrolment arraylist to add to", EnrolmentList);
		assertEquals("Test that the Enrolment arraylist is empty.", 0, EnrolmentList.size());
		// Attempt to retrieve the Enrolment
		String allEnrolment = C206_CaseStudy.retrieveAllEnrolment(EnrolmentList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allEnrolment);

		// Test Case 2
		C206_CaseStudy.addEnrolment(EnrolmentList, en1);
		C206_CaseStudy.addEnrolment(EnrolmentList, en2);
		// Test that the list is not empty
		assertEquals("Test that Camcorder arraylist size is 2.", 2, EnrolmentList.size());
		// Attempt to retrieve the Enrolment
		allEnrolment = C206_CaseStudy.retrieveAllCamcorder(EnrolmentList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allCamcorder);

		// Test Case 3
		en3.setIsAvailable(false);
		C206_CaseStudy.addEnrolment(EnrolmentList, en3);
		assertEquals("Test that Enrolment arraylist size is 2.", 3, EnrolmentList.size());
		assertFalse("Test that the last item in the arraylist is not available", EnrolmentList.get(2).getIsAvailable());
		// Attempt to retrieve the Enrolment
		allEnrolment = C206_CaseStudy.retrieveAllEnrolment(EnrolmentList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allEnrolment);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

}
