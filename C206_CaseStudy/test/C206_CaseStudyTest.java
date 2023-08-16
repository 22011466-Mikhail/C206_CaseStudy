import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class C206_CaseStudyTest {
	private Enrolment en1;
	private Enrolment en2;
	private Course C01;
	private Course C02;
	private User user1;
	private User user2;

	private ArrayList<Enrolment> EnrolmentList;
	//22030683 Hakim
	private ArrayList<Fee> feeList;

	private ArrayList<Course> courseList;
	
	private ArrayList<Student> StudentList;
	
	private ArrayList<User> userList;
	
	String nrictodelete=null;

	public C206_CaseStudyTest() {
		super();
	}
	@Before
	public void setUp() throws Exception {

		feeList = new ArrayList<Fee>();
		StudentList=new ArrayList<Student>();
		

		C01 = new Course("C01", "Mathematics", "Adam Salah", "Every Saturday at 5.00pm to 7.00pm");
		C02 = new Course("C02", "English", "Alice Lum", "Every Sunday at 7.00pm to 9.00pm");
		en1 = new Enrolment ("C01");
		en2 = new Enrolment("C02");
		user1 = new User("user1","password1");
		user2 = new User("user2","password2");
		
		userList = new ArrayList<User>();
		EnrolmentList = new ArrayList<Enrolment>();
		courseList = new ArrayList<Course>();
	}
	
	// --------------Mikhail------------
	@Test
	public void testAddUser() {

		// Test if courseList is not null and empty
		assertNotNull("Test if there is a valid userList to add to", userList);
		

		// Add a course and verify
		C206_CaseStudy.addUser(userList, user1);
		assertEquals("Test that the userList size is 1.", 1, userList.size());
		assertSame("Test that the added user is the same as the first user in the list", user1, userList.get(0));
		
		// Add a course that already exists in the list
		C206_CaseStudy.addUser(userList, user1);
		assertEquals("Test that the User arraylist size is unchanged.", 1, userList.size());

		// Add a course that has missing detail
		User user3_missing = new User("user3","");
		C206_CaseStudy.addUser(userList, user3_missing);
		assertEquals("Test that the Course arraylist size is unchanged.", 1, userList.size());


	}

	// --------------Mikhail------------
	@Test
	public void testViewUser() {
		
		// Test if courseList is not null and empty
				assertNotNull("Test if there is a valid userList to add to", userList);
				assertEquals("Test that the userList is empty.", 0, userList.size());

		// Given an empty list, after adding 2 courses, test if the size of the list is
		// 2 - normal
		C206_CaseStudy.addUser(userList, user1);
		C206_CaseStudy.addUser(userList, user2);
		assertEquals("Test that user list size is 2", 2, userList.size());

		//test if the expected output string same as the list of courses retrieved 
				
				String allUsers = C206_CaseStudy.viewUser(userList);
				String testOutput = "";
				testOutput = String.format("%-20s %-20s\n", "USERNAME", "PASSWORD");
				testOutput += String.format("%-20s %-20s\n","user1", "password1");
				testOutput += String.format("%-20s %-20s\n","user2", "password2");
				
				assertEquals("Test that ViewAllUsers list displays correctly", testOutput, allUsers);
				
	}
	
	// --------------Mikhail------------
	@Test
	public void testDeleteUser() {
		// Add courses to courseList
		C206_CaseStudy.addUser(userList, user1);
		C206_CaseStudy.addUser(userList, user2);
		// Test if courseList is not null and empty - boundary
	    assertNotNull("Test if there is valid userList for deletion", userList);


		// Delete a course
		C206_CaseStudy.deleteUser(userList, user1);
		assertEquals("Test that the userList size is reduced after deletion.", 1, userList.size());

		// Verify the remaining course
		assertSame("Test that the remaining course is the second course in the list", user2, userList.get(0));
	}
	
	@Test
	public void testAddCourse() {//22024343 Norhilman

		// Test if courseList is not null and empty
		assertNotNull("Test if there is a valid courseList to add to", courseList);
		

		// Add a course and verify
		C206_CaseStudy.addCourse(courseList, C01);
		assertEquals("Test that the courseList size is 1.", 1, courseList.size());
		assertSame("Test that the added course is the same as the first course in the list", C01, courseList.get(0));
		
		// Add a course that already exists in the list
		C206_CaseStudy.addCourse(courseList, C01);
		assertEquals("Test that the Course arraylist size is unchange.", 1, courseList.size());

		// Add a course that has missing detail
		Course C03_missing = new Course("C03", "", "John Doe", "Every Monday at 2.00pm to 4.00pm");
		C206_CaseStudy.addCourse(courseList, C03_missing);
		assertEquals("Test that the Course arraylist size is unchange.", 1, courseList.size());


	}

	@Test
	public void testViewCourse() {//22024343 Norhilman
		
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
				
	}
	@Test
	public void testDeleteCourse() {//22024343 Norhilman
		// Add courses to courseList
		courseList.add(C01);
		courseList.add(C02);
		// Test if courseList is not null and empty - boundary
	    assertNotNull("Test if there is valid courseList for deletion", courseList);


		// Delete a course
		C206_CaseStudy.deleteCourse(courseList);
		assertEquals("Test that the courseList size is reduced after deletion.", 1, courseList.size());

		// Verify the remaining course
		assertSame("Test that the remaining course is the second course in the list", C02, courseList.get(0));

	}
	@Test 
	public void testAddEnrolment() { //Yong Chuan
		//Test whether the list is empty or not
		assertNotNull("Test if there is valid Enrolment arraylist to add to", EnrolmentList);
		assertEquals("Test that the Enrolment arraylist is empty.", 0, EnrolmentList.size());
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addEnrolment(EnrolmentList, en1);		
		assertEquals("Test that the Enrolment arraylist size is 1.", 1, EnrolmentList.size());

		
		// Add an item
		C206_CaseStudy.addEnrolment(EnrolmentList, en2);
		assertEquals("Test that the Enrolment arraylist size is now 2.", 2, EnrolmentList.size());

        
    }

	@Test
	public void testRetrieveAllEnrolment() { //Yong Chuan
		//fail("Not yet implemented");
		// write your code here
		assertNotNull("Test if there is valid Enrolment arraylist to add to", EnrolmentList);
		assertEquals("Test that the Enrolment arraylist is empty.", 0, EnrolmentList.size());
		// Attempt to retrieve the Enrolment
		EnrolmentList.add(new Enrolment("C01"));
	    assertEquals("Test that the size of list is 1", 1, EnrolmentList.size());

	    C206_CaseStudy.viewAllEnrolment(EnrolmentList);
		
	}
	@Test
	public void testDeleteEnrolment() { //Yong Chuan
        // Add enrolment to EnrolmentList
	   EnrolmentList.add(new Enrolment("C01"));
       
       EnrolmentList.add(new Enrolment("C02"));

        // Delete an Enrolment
        C206_CaseStudy.deleteEnrolment(EnrolmentList);
        assertEquals("Test that EnrolmentList size is 1 after deleting", 1,EnrolmentList.size());

        // Delete another Enrolment
        C206_CaseStudy.deleteEnrolment(EnrolmentList);
        assertEquals("Test that EnrolmentList size is 0 after deleting",0, EnrolmentList.size());
    }
	@Test
    public void testAddFee() { //22030683 Hakim
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
	public void testViewAllFees() { //22030683 Hakim
	    // After adding 1 fee, test that size of list is 1 - normal
	    feeList.add(new Fee("Tuition Fee", 1000.0, "2023-09-01"));
	    assertEquals("Test that the size of list is 1", 1, feeList.size());

	    C206_CaseStudy.viewAllFees(feeList);
		}
		

    @Test
    public void testDeleteFee() {  //22030683 Hakim
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
    public void testdeleteStudent() {    //22003801 Jayanth
    	//Add student to StudentList 
    	StudentList.add(new Student("Bryan","2001-06-30","N4567","English",82567898));
        StudentList.add(new Student("Cedric","2001-07-31","N8712","English",82567893));

         String nrictodelete = "N8712";

         // Delete an existing student
         C206_CaseStudy.deleteStudent(StudentList,nrictodelete);
         assertEquals( "Test that StudentList size is 1 after deleting",1,StudentList.size());

         // Delete a non existing student
         String nonExistingNric = "N1234"; // Assuming "N1234" does not exist in the student list
         C206_CaseStudy.deleteStudent(StudentList, nonExistingNric);
         assertEquals("Test that StudentList size remains 1 after attempting to delete a non-existing student", 1, StudentList.size());
     }
    
    @Test
  public void testaddStudent() {//22003801-Jayanth
  	 Student newStudent = new Student("Ahamed", "2000-02-127", "M8611", "Math", 88765678);
       StudentList.add(newStudent);

       // Add a new student - Normal

       C206_CaseStudy.addStudent(StudentList);

       assertEquals("Test that StudentList size is 1 after adding a student", 2, StudentList.size());
       //Add an existing student-error
       C206_CaseStudy.addStudent(StudentList);

        assertEquals("Test that studentList size remains one after an existing student is added,",2,StudentList.size());
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
