import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Enrolment en1;
	private Enrolment en2;
	private Enrolment en3;
	private Course C01;
	private Course C02;
<<<<<<< HEAD
	private User user1;
	private User user2;
	private User user3;
	
	
	private ArrayList<Enrolment> EnrolmentList;

	private ArrayList<Fee> feeList;

	private ArrayList<Course> courseList;
	
	private ArrayList<User> userList;
=======

	private ArrayList<Enrolment> EnrolmentList;

	private ArrayList<Fee> feeList;

	private ArrayList<Course> courseList;
>>>>>>> branch 'master' of https://github.com/22011466-Mikhail/C206_CaseStudy.git

	public C206_CaseStudyTest() {
		super();
	}
	@Before
	public void setUp() throws Exception {

		feeList = new ArrayList<Fee>();
<<<<<<< HEAD
		userList = new ArrayList<User>();
		
		user1 = new User("user1", "password1", "student");
		user2 = new User("user2", "password2", "teacher");
		user3 = new User("user3", "password3", "admin");
=======
>>>>>>> branch 'master' of https://github.com/22011466-Mikhail/C206_CaseStudy.git

		C01 = new Course("C01", "Mathematics", "Adam Salah", "Every Saturday at 5.00pm to 7.00pm");
		C02 = new Course("C02", "English", "Alice Lum", "Every Sunday at 7.00pm to 9.00pm");
		courseList = new ArrayList<Course>();
	}
<<<<<<< HEAD
	

	
	@Test
	public void testAddUser() {
		// Test if userList is not null and empty
		assertNotNull("Test if there is a valid courseList to add to", userList);
		assertEquals("Test that the userList is empty.", 0, userList.size());

		// Add a user and verify
		C206_CaseStudy.addUser(userList, user1);
		assertEquals("Test that the userList size is 1.", 1, userList.size());
		assertSame("Test that the added user is the same as the first user in the list", user1, userList.get(0));
	}
	@Test
	public void testViewUser() {
		// Test if ArrayList is not null and empty - boundary
		assertNotNull("Test if there is valid userList to retrieve user from", userList);

		// Given an empty list, after adding 2 courses, test if the size of the list is
		// 2 - normal
		C206_CaseStudy.addUser(userList, user1);
		C206_CaseStudy.addUser(userList, user2);
		assertEquals("Test that user list size is 2", 2, userList.size());

		// Call the method to view courses
		C206_CaseStudy.viewUser(userList);
	}
	@Test
	public void testDeleteUser() {
		// Add user to courseList
		userList.add(user1);
		userList.add(user2);

		// Delete a course
		C206_CaseStudy.removeUser(userList);
		assertEquals("Test that the ArrayList size is reduced after deletion.", 1, userList.size());

		// Verify the remaining course
		assertSame("Test that the remaining user is the second user in the list", user2, userList.get(0));

	}
	
	@Test
	public void testLogin() {
		
		//Error - test login with non-existent user
		
		userList.add(user1);
		
		assertNull(C206_CaseStudy.loginToUser(userList, "user2", "password2"));
		
		//Normal - test login with user1
		
		assertNotNull(C206_CaseStudy.loginToUser(userList, "user1", "password1"));
		
	}
	
	/*
	@Test
	public void testAddCourse() {
		// Test if courseList is not null and empty
		assertNotNull("Test if there is a valid courseList to add to", courseList);
		assertEquals("Test that the courseList is empty.", 0, courseList.size());

		// Add a course and verify
		C206_CaseStudy.addCourse(courseList, C01);
		assertEquals("Test that the courseList size is 1.", 1, courseList.size());
		assertSame("Test that the added course is the same as the first course in the list", C01, courseList.get(0));
	}
	@Test
	public void testViewCourse() {
		// Test if courseList is not null and empty - boundary
		assertNotNull("Test if there is valid courseList to retrieve course from", courseList);

		// Given an empty list, after adding 2 courses, test if the size of the list is
		// 2 - normal
		C206_CaseStudy.addCourse(courseList, C01);
		C206_CaseStudy.addCourse(courseList, C02);
		assertEquals("Test that course list size is 2", 2, courseList.size());

		// Call the method to view courses
		C206_CaseStudy.viewAllCourse(courseList);
=======
	@Test
	public void testAddCourse() {
		

		// Add a course and verify
		C206_CaseStudy.addCourse(courseList, C01);
		assertEquals("Test that the courseList size is 1.", 1, courseList.size());
		assertSame("Test that the added course is the same as the first course in the list", C01, courseList.get(0));
	}
	@Test
	public void testViewCourse() {
		
		// Test if courseList is not null and empty
				assertNotNull("Test if there is a valid courseList to add to", courseList);
				assertEquals("Test that the courseList is empty.", 0, courseList.size());

		// Given an empty list, after adding 2 courses, test if the size of the list is
		// 2 - normal
		C206_CaseStudy.addCourse(courseList, C01);
		C206_CaseStudy.addCourse(courseList, C02);
		assertEquals("Test that course list size is 2 and displayed correctly", 2, courseList.size());

		//test if the expected output string same as the list of courses retrieved 
				String allCourse= C206_CaseStudy.retrieveAllCourse(courseList);
				String testOutput = "";
				testOutput = String.format("Course List\n");
				testOutput += String.format("%-5s %-15s %-20s %-30s\n","ID", "Title", "Instructor", "Schedule");
				testOutput += String.format("%-5s %-15s %-20s %-30s\n","C01", "Mathematics", "Adam Salah", "Every Saturday at 5.00pm to 7.00pm");
				testOutput += String.format("%-5s %-15s %-20s %-30s\n","C02", "English", "Alice Lum", "Every Sunday at 7.00pm to 9.00pm");
			
				assertEquals("Test that ViewAllCourselist", testOutput, allCourse);
>>>>>>> branch 'master' of https://github.com/22011466-Mikhail/C206_CaseStudy.git
	}
	@Test
	public void testDeleteCourse() {
		// Add courses to courseList
		courseList.add(C01);
		courseList.add(C02);

		// Delete a course
		C206_CaseStudy.deleteCourse(courseList);
		assertEquals("Test that the courseList size is reduced after deletion.", 1, courseList.size());

		// Verify the remaining course
		assertSame("Test that the remaining course is the second course in the list", C02, courseList.get(0));

	}
	
	public void testAddEnrolment() {
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid Enrolment arraylist to add to", EnrolmentList);
		assertEquals("Test that the Enrolment arraylist is empty.", 0, EnrolmentList.size());
		// Given an empty list, after adding 1 item, the size of the list is 1
<<<<<<< HEAD
		C206_CaseStudy.addEnrolment(EnrolmentList, en1);
=======
		C206_CaseStudy.addEnrolment(EnrolmentList);
>>>>>>> branch 'master' of https://github.com/22011466-Mikhail/C206_CaseStudy.git
		assertEquals("Test that the Enrolment arraylist size is 1.", 1, EnrolmentList.size());

		// Add an item
		C206_CaseStudy.addEnrolment(EnrolmentList);
		assertEquals("Test that the Enrolment arraylist size is now 2.", 2, EnrolmentList.size());
		// The item just added is as same as the last item in the list
		assertSame("Test that Enrolment is added to the end of the list.", en2, EnrolmentList.get(1));

		// Add an item that already exists in the list
		C206_CaseStudy.addEnrolment(EnrolmentList);
		assertEquals("Test that the Enrolment arraylist size is unchange.", 2, EnrolmentList.size());

	}
<<<<<<< HEAD
	@Test
    public void testAddFee() {
        // Test that feeList is initially empty
        assertEquals("Test that feeList is empty", 0, feeList.size());
=======
	public void testRetrieveAllEnrolment() {
		//fail("Not yet implemented");
		// write your code here
		assertNotNull("Test if there is valid Enrolment arraylist to add to", EnrolmentList);
		assertEquals("Test that the Enrolment arraylist is empty.", 0, EnrolmentList.size());
		// Attempt to retrieve the Enrolment
		String allChromebook= C206_CaseStudy.retrieveAllEnrolment(EnrolmentList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allChromebook);
>>>>>>> branch 'master' of https://github.com/22011466-Mikhail/C206_CaseStudy.git

        // Add a fee
        C206_CaseStudy.addFee(feeList, "Tuition Fee", 1000.0, "2023-09-01");
        assertEquals("Test that feeList size is 1", 1, feeList.size());

        // Add another fee
        C206_CaseStudy.addFee(feeList, "Exam Fee", 500.0, "2023-10-01");
        assertEquals("Test that feeList size is 2", 2, feeList.size());
        
    }
	@Test
	public void testViewAllFees() {
	    // Add fees to feeList
	    feeList.add(new Fee("Tuition Fee", 1000.0, "2023-09-01"));
	    feeList.add(new Fee("Exam Fee", 500.0, "2023-10-01"));

	    // Test viewing all fees
	    String expectedOutput = "FEE TYPE             AMOUNT     DUE DATE       \n" +
                "Tuition Fee          1000.00    2023-09-01    \n" +
                "Exam Fee             500.00     2023-10-01    \n";

		String actualOutput = C206_CaseStudy.viewAllFees(feeList);
		
		System.out.println("Expected Output:\n" + expectedOutput);
		System.out.println("Actual Output:\n" + actualOutput);
		
		assertEquals(expectedOutput, actualOutput.trim());
		}
		
		//Test Case 2
<<<<<<< HEAD
		// Attempt to retrieve the Camcoders 
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
=======
		C206_CaseStudy.addEnrolment(EnrolmentList);
		C206_CaseStudy.addEnrolment(EnrolmentList);
		// Test that the list is not empty
		assertEquals("Test that Chromebook arraylist size is 2.", 2, EnrolmentList.size());
		// Attempt to retrieve the Enrolment
		allChromebook= C206_CaseStudy.retrieveAllEnrolment(EnrolmentList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
>>>>>>> branch 'master' of https://github.com/22011466-Mikhail/C206_CaseStudy.git
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allChromebook);

		//Test Case 3
		cc3.setIsAvailable(false);
		ResourceCentre.addCamcorder(camcorderList, cc3);
		assertEquals("Test that Camcorder arraylist size is 2.", 3, camcorderList.size());
		assertFalse("Test that the last item in the arraylist is not available", camcorderList.get(2).getIsAvailable());
		// Attempt to retrieve the Camcoders 
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allCamcorder);
		

    @Test
    public void testDeleteFee() {
        // Add fees to feeList
        feeList.add(new Fee("Tuition Fee", 1000.0, "2023-09-01"));
        feeList.add(new Fee("Exam Fee", 500.0, "2023-10-01"));

        // Delete a fee
        C206_CaseStudy.deleteFee(feeList, 0);
        assertEquals("Test that feeList size is 1 after deleting", 1, feeList.size());

        // Delete another fee
        C206_CaseStudy.deleteFee(feeList, 0);
        assertEquals("Test that feeList size is 0 after deleting", 0, feeList.size());
    }
    @Test
    public void testdeleteStudent() {
    	//Add student to StudentList 
        StudentList.add(new Student("Bryan","2001-06-30","N4567","English",82567898));
        StudentList.add(new Student("Cedric","2001-07-31","N8712","English",82567893));
        //Delete a Student
        C206_CaseStudy.deleteStudent(StudentList,0);
        assertEquals("Test that StudentList size is 1 after deleting",1,StudentList.size());
        
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
		C206_CaseStudy.addEnrolment(EnrolmentList);
		assertEquals("Test that Chromebook arraylist size is 2.", 3,  EnrolmentList.size());
		assertFalse("Test that the last item in the arraylist is not available",  EnrolmentList.get(2).getIsAvailable());
		// Attempt to retrieve the Enrolment
<<<<<<< HEAD
		allEnrolment = C206_CaseStudy.retrieveAllEnrolment(EnrolmentList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n", "CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
=======
		allChromebook= C206_CaseStudy.retrieveAllEnrolment( EnrolmentList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0011", "My Google Chromebook 1st", "Yes", "", "Mac OS");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","CB0012", "SAMSUNG Chromebook 4+", "Yes", "", "Win 10");
>>>>>>> branch 'master' of https://github.com/22011466-Mikhail/C206_CaseStudy.git
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allChromebook);
	}
	
<<<<<<< HEAD
	*/
=======
	public void testDeleteEnrolment() {
        // Add enrolment to EnrolmentList
       EnrolmentList.add(new Enrolment("CC01"));
       EnrolmentList.add(new Enrolment("CC02"));

        // Delete an Enrolment
        C206_CaseStudy.deleteEnrolment(EnrolmentList);
        assertEquals("Test that EnrolmentList size is 1 after deleting", 1, EnrolmentList.size());

        // Delete another Enrolment
        C206_CaseStudy.deleteEnrolment(EnrolmentList);
        assertEquals("Test that EnrolmentList size is 0 after deleting", 0, EnrolmentList.size());
    }
	@Test
    public void testAddFee() {
        // Test that feeList is initially empty
        assertEquals("Test that feeList is empty", 0, feeList.size());

        // Add a fee
        C206_CaseStudy.addFee(feeList, "Tuition Fee", 1000.0, "2023-09-01");
        assertEquals("Test that feeList size is 1", 1, feeList.size());

        // Add another fee
        C206_CaseStudy.addFee(feeList, "Exam Fee", 500.0, "2023-10-01");
        assertEquals("Test that feeList size is 2", 2, feeList.size());
        
    }
	@Test
	public void testViewAllFees() {
	    // After adding 1 fee, test that size of list is 1 - normal
	    feeList.add(new Fee("Tuition Fee", 1000.0, "2023-09-01"));
	    assertEquals("Test that the size of list is 1", 1, feeList.size());

	    C206_CaseStudy.viewAllFees(feeList);
		}
		

    @Test
    public void testDeleteFee() {
        // Add fees to feeList
        feeList.add(new Fee("Tuition Fee", 1000.0, "2023-09-01"));
        feeList.add(new Fee("Exam Fee", 500.0, "2023-10-01"));

        // Delete a fee
        C206_CaseStudy.deleteFee(feeList, 0);
        assertEquals("Test that feeList size is 1 after deleting", 1, feeList.size());

        // Delete another fee
        C206_CaseStudy.deleteFee(feeList, 0);
        assertEquals("Test that feeList size is 0 after deleting", 0, feeList.size());
    }
    
    
    @Test
    public void testdeleteStudent() {
    	//Add student to StudentList 
        StudentList.add(new Student("Bryan","2001-06-30","N4567","English",82567898));
        StudentList.add(new Student("Cedric","2001-07-31","N8712","English",82567893));
        //Delete a Student
        C206_CaseStudy.deleteStudent(StudentList,0);
        assertEquals("Test that StudentList size is 1 after deleting",1,StudentList.size());
        
    }
	
	
>>>>>>> branch 'master' of https://github.com/22011466-Mikhail/C206_CaseStudy.git
	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

}
