import java.util.ArrayList;

public class C206_CaseStudy {
private static final int COURSE_EXIT = 4;
private static final int COURSE_VIEW = 3;
private static final int COURSE_DELETE = 2;
private static final int COURSE_ADD = 1;
private static final int COURSE = 1;
private static final int STUDENT_ADD =1;
private static final int STUDENT_DELETE=2;
private static final int STUDENT_VIEW=3;

//yc
//jayanth
//Norhilman

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Fee> feeList = new ArrayList<Fee>();
		ArrayList<Course> courseList = new ArrayList<Course>();
		ArrayList<Enrolment> EnrolmentList = new ArrayList<Enrolment>();
		ArrayList<Student> StudentList = new ArrayList<Student>();
		
		
		feeList.add(new Fee("Tuition Fee", 1000.0, "2023-09-01"));

		// addition of sample objects to arraylists
		userList.add(new User("user1", "password1"));
		userList.add(new User("user2", "password2"));
		userList.add(new User("user3", "password3"));

		StudentList.add(new Student("Adil", "2003-08-25", "M7654", "Mathematics", 83435469));
		StudentList.add(new Student("Abraham", "2003-09-27", "M7684", "Mathematics", 83435423));

		courseList.add(new Course("C01", "Mathematics", "Adam Salah", "Every Saturday at 5.00pm to 7.00pm"));
		courseList.add(new Course("C02", "English", "Alice Lum", "Every Sunday at 7.00pm to 9.00pm"));
		EnrolmentList.add(new Enrolment( "C01"));
		Enrolment en1 = new Enrolment ("C01");
		
		int option = 0;
		int functionOption = 0;
		User loginUser = null;

		while (option	 != 2) {
			loginMenu();
			option = Helper.readInt("Insert menu option > ");
			if (option == 1) {
				String username = Helper.readString("Username > ");
				String password = Helper.readString("Password > ");
				loginUser = loginToUser(userList, username, password);
				if (loginUser != null) {
					System.out.println("Login successful");
					System.out.println("User: " + loginUser.getUsername());
					break;
				} else {
					System.out.println("Username / password is wrong");
				}
			}
		}

		if (loginUser != null) {
			while (option != 6) {
				menu();
				
				
				option = Helper.readInt("Insert menu option > ");// 22024343 Norhilman
				if (option == COURSE) { // ----- COURSE FUNCTION ------
					while (functionOption != COURSE_EXIT) {
						courseMenu();
						functionOption = Helper.readInt("Insert option > ");

						if (functionOption == COURSE_ADD) {
							addCourse(courseList, inputCourse());
						} else if (functionOption == COURSE_DELETE) {
							deleteCourse(courseList);
						} else if (functionOption == COURSE_VIEW) {
							viewAllCourse(courseList);
						}

					}

				} else if (option == 2) { // ----STUDENT FUNCTION-----
					while (functionOption != 4) {
						studentMenu();
						functionOption = Helper.readInt("Insert option > ");

						if (functionOption == STUDENT_ADD) {
							addStudent(StudentList);
						} else if (functionOption == STUDENT_DELETE) {
							String nrictodelete=Helper.readString("enter nric number to be deleted");
							deleteStudent(StudentList,nrictodelete);
						} else if (functionOption == STUDENT_VIEW) {
							viewStudentList(StudentList);
						}
					}

				} else if (option == 3) { // ---- FEE FUNCTION-----// 22030683 Hakim
					while (functionOption != 4) {
						feeMenu();
						functionOption = Helper.readInt("Insert option > ");

						if (functionOption == 1) {
							String feeType = Helper.readString("Enter Fee Type (Tuition Fee/Exam Fee): ");
							double amount = Helper.readDouble("Enter Amount: ");
							String dueDate = Helper.readString("Enter Due Date(YYYY-mm-dd): ");

							C206_CaseStudy.addFee(feeList, feeType, amount, dueDate);
						} else if (functionOption == 2) {
							int feeIndexToDelete = Helper.readInt("Enter the index of the fee to delete: ");
							C206_CaseStudy.deleteFee(feeList, feeIndexToDelete);
						} else if (functionOption == 3) {
							viewAllFees(feeList);
						}
					}
				} else if (option == 4) { // ----ENROLMENT FUNCTION-----
					while (functionOption != 4) {
						enrolmentMenu();
						functionOption = Helper.readInt("Insert option > ");

						if (functionOption == 1) {
							addEnrolment(EnrolmentList,en1);
						} else if (functionOption == 2) {
							deleteEnrolment(EnrolmentList);
						} else if (functionOption == 3) {
							viewAllEnrolment(EnrolmentList);
						}
					}
				} else if (option == 5) { // ----USER FUNCTION-----
					while (functionOption != 4) {
						userMenu();
						functionOption = Helper.readInt("Insert option > ");

						if (functionOption == 1) {
							addUser(userList, inputUser());
						} else if (functionOption == 2) {
							deleteUser(userList,findDeleteUser(userList));
						} else if (functionOption == 3) {
							viewUser(userList);
						}
					}
				}
			}
		}
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}

	// ---------MAIN MENUS----------

	public static void loginMenu() {
		setHeader("LOGIN MENU");
		System.out.println("1. Login as user");
		System.out.println("2. Quit");
		Helper.line(80, "-");
	}

	public static void menu() {
		setHeader("MAIN MENU");
		System.out.println("1. Courses");
		System.out.println("2. Students");
		System.out.println("3. Fees");
		System.out.println("4. Enrolment");
		System.out.println("5. Users");
		System.out.println("6. Quit");
		Helper.line(80, "-");
	}

	public static void userMenu() {
		setHeader("USER MENU");
		System.out.println("1. Add User");
		System.out.println("2. Remove User");
		System.out.println("3. View User");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	public static void courseMenu() {
		setHeader("COURSE MENU");
		System.out.println("1. Add Course");
		System.out.println("2. Remove Course");
		System.out.println("3. View Courses");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	public static void studentMenu() {
		setHeader("STUDENT MENU");
		System.out.println("1. Add Student");
		System.out.println("2. Remove Student");
		System.out.println("3. View Students");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
	// 22030683 Hakim
	public static void feeMenu() {
		setHeader("FEE MENU");
		System.out.println("1. Add Fee");
		System.out.println("2. Remove Fee");
		System.out.println("3. View Fee");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	public static void enrolmentMenu() {
		setHeader("ENROLMENT MENU");
		System.out.println("1. Add Enrolment");
		System.out.println("2. Remove Enrolment");
		System.out.println("3. View Enrolment");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	public static User loginToUser(ArrayList<User> userList, String username, String password) {

		boolean userFound = false;
		User userLogin = null;

		for (User user1 : userList) {
			if (user1.getUsername().equals(username) && user1.getPassword().equals(password)) {
				userLogin = user1;
				userFound = true;
			}
		}

		if (userFound == true) {
			return (userLogin);
		} else {
			return (userLogin);
		}

	}

	// ----------------User------------ - Mikhail
	public static String retrieveAllUsers(ArrayList<User> userList) {
		String output = "";
		for (int i = 0; i < userList.size(); i++) {

			output += String.format("%-20s %-20s\n", userList.get(i).getUsername(), userList.get(i).getPassword());
		}
		return output;
	}

	// ----------------User------------ - Mikhail
	public static String viewUser(ArrayList<User> userList) {
		setHeader("USER LIST");
		String output = String.format("%-20s %-20s\n", "USERNAME", "PASSWORD");
		output += retrieveAllUsers(userList);
		System.out.println(output);
		
		return output;
	}
	// ----------------User------------ - Mikhail
	public static User inputUser() {
		String username = Helper.readString("Enter username > ");
		String password = Helper.readString("Enter password > ");

		User user = new User(username, password);
		return user;
	}
	// ----------------User------------ - Mikhail
	public static void addUser(ArrayList<User> userList, User user1) {
		User userTest;
		for (int i = 0; i < userList.size(); i++) {
			userTest = userList.get(i);
			if (userTest.getUsername().equalsIgnoreCase(user1.getUsername()))
				return;
		}
		if ((user1.getUsername().isEmpty()) || (user1.getPassword().isEmpty()) ) {
			return;
		}
		userList.add(user1);
	}
	// ----------------User------------ - Mikhail
	public static User findDeleteUser(ArrayList<User> userList) {
		String username = Helper.readString("Enter username of account to delete > ");
		User deleteUser = null;
		boolean userFound = false;
		String option = "";
		
				for (User user1 : userList) {
			if (user1.getUsername().equals(username)) {
				while(!option.equalsIgnoreCase("yes")) {
					option = Helper.readString("Are you sure you want to delete " + user1.getUsername() + "? (Yes/No) > ");					
					if(option.equalsIgnoreCase("no")) {
						return deleteUser;
					} else if (option.equalsIgnoreCase("yes")) {
						userFound = true;
						deleteUser = user1;
					}
					System.out.println("Invalid input (Yes/No)?");

				}

			}
		}
		if(userFound == false) {
			System.out.println("Account not found");
		} else if (option.equalsIgnoreCase("no")) {
			return deleteUser;
		} else if (option.equalsIgnoreCase("yes") && userFound == true) {
			System.out.println("Account has been deleted.");
		} else {
			System.out.println("Error with input");
		}
		return deleteUser;
	}
	// ----------------User------------ - Mikhail
	public static void deleteUser(ArrayList<User> userList, User user) {
		
		userList.remove(user);

	}

	// ================================= View items =================================
	public static String retrieveAllEnrolment(ArrayList<Enrolment> EnrolmentList) { // Yong Chuan
		String output = "";
		for (int i = 0; i < EnrolmentList.size(); i++) {
				boolean isAvailable = EnrolmentList.get(i).getIsAvailable();
				output += String.format("%-16s %-10s %-10s\n", ("EN"+(i+1)),EnrolmentList.get(i).getCourse(),
						C206_CaseStudy.showAvailability(isAvailable)
						);		
		}
		return output;
	}

	public static void viewAllEnrolment(ArrayList<Enrolment> EnrolmentList) { // Yong Chuan
		C206_CaseStudy.setHeader("ENROLMENT LIST");
		String output = String.format("%-15s %10s %-10s\n", "ENROLMENT ID", "COURSE ID", "AVAIBILITY");
		output += retrieveAllEnrolment(EnrolmentList);
		System.out.println(output);
	}
	
	public static void viewAllFees(ArrayList<Fee> feeList) { //22030683 Hakim
		System.out.println(String.format("%-20s %-10s %-15s", "FEE TYPE", "AMOUNT", "DUE DATE"));

		for (Fee fee : feeList) {
			System.out
					.println(String.format("%-20s %-10.2f %-15s", fee.getFeeType(), fee.getAmount(), fee.getDueDate()));
		}

	}

	public static String retrieveAllCourse(ArrayList<Course> courseList) {//22024343 Norhilman
		String result = "Course List\n";
		String format = "%-5s %-15s %-20s %-30s\n";
		result += String.format(format, "ID", "Title", "Instructor", "Schedule");

		for (Course course : courseList) {
			result += String.format(format, course.getCourseCode(), course.getTitle(), course.getInstructor(),
					course.getSchedule());
		}

		return result;
	}

	public static void viewAllCourse(ArrayList<Course> courseList) { //22024343 Norhilman
		System.out.println("Course List");
		String format = "%-5s %-15s %-20s %-30s\n";
		System.out.printf(format, "ID", "Title", "Instructor", "Schedule");

		for (Course course : courseList) {
			System.out.printf(format, course.getCourseCode(), course.getTitle(), course.getInstructor(),
					course.getSchedule());
		}
	}

	// ================================= Adding =================================


	
	public static void viewStudentList(ArrayList<Student> StudentList) { //Jayanth
		System.out.println("Student List");
		String format = "%-15s %-15s %-10s %-30s %-15s\n";
		System.out.printf(format, "Name", "DOB", "NRIC", "Course", "Contact Number");
		for (Student student : StudentList) {
			System.out.printf(format, student.getName(), student.getDob(), student.getNric(), student.getCourse(),
					student.getContactNumber());
			;
		}
	}

	// ================================= Adding =================================

	public static void addEnrolment(ArrayList<Enrolment> EnrolmentList ,Enrolment en) { //Yong Chuan
		String id = Helper.readString("Enter Course ID: ");
		boolean found = false;
		
			for (Enrolment enrol : EnrolmentList) {
				if (enrol.getCourse().equalsIgnoreCase(id)) {
					
					System.out.println("Error: Duplicate course code. Enrolment cannot be added.");
					found = true;
					break;
				}
			}
			if (!found) {
				EnrolmentList.add(new Enrolment(id));
				System.out.println("Enrolment added successfully.");
			
		}
	}

	
	public static void addFee(ArrayList<Fee> feeList, String feeType, double amount, String dueDate) { //22030683 Hakim
		Fee newFee = new Fee(feeType, amount, dueDate);
		feeList.add(newFee);
		System.out.println("Fee added successfully.");
	}

	public static Course inputCourse() { //22024343 Norhilman
		String id = Helper.readString("Enter Course ID: ");
		String title = Helper.readString("Enter Course Title: ");
		String instructor = Helper.readString("Enter Instructor Name: ");
		String schedule = Helper.readString("Enter Schedule: ");

		Course newCourse = new Course(id, title, instructor, schedule);
		return newCourse;
	}

	public static void addCourse(ArrayList<Course> courseList, Course course) { //22024343 Norhilman
		String courseCode = course.getCourseCode();
		String title = course.getTitle();

		// Check for duplicate course code
		for (Course existingCourse : courseList) {//22024343 Norhilman
			String courseCode2 = existingCourse.getCourseCode();
			if (courseCode2.equalsIgnoreCase(courseCode)) {
				System.out.println("Error: Duplicate course code. Course cannot be added.");
				return;
			}
		}

		// Check for duplicate title
		for (Course existingCourse : courseList) {//22024343 Norhilman
			String title2 = existingCourse.getTitle();
			if (title2.equalsIgnoreCase(title)) {
				System.out.println("Error: Duplicate course title. Course cannot be added.");
				return;
			}
		}
		if (course.getCourseCode().isEmpty() || course.getTitle().isEmpty() || course.getInstructor().isEmpty()
				|| course.getSchedule().isEmpty()) {
			System.out.println("Error: Missing details. Course cannot be added.");
		} else {

			courseList.add(course);
			System.out.println("Course added successfully.");
		}
	}

	
		public static void addStudent(ArrayList<Student> StudentList) { //22003801 Jayanth
			String name = Helper.readString("enter your name: ");
			String dob = Helper.readString("Enter your date of birth: ");
			String nric = Helper.readString("Enter your nric number: ");
			String course = Helper.readString("Enter your desired course: ");
			int contact = Helper.readInt("Enter your contact number: ");
			boolean studentExists = false;
		    for (Student student : StudentList) {
		        if (student.getNric().equalsIgnoreCase(nric)) {
		            studentExists = true;
		            break; // Exit the loop once a matching NRIC is found
		        }
		    }

	 

		    if (studentExists) {
		        System.out.println("Student already exists.");
		    } else {
		        StudentList.add(new Student(name, dob, nric, course, contact));
		        System.out.println("Student has been added.");
		    }
		}

	// ================================= Deleting =================================
	//22030683 Hakim
	public static void deleteFee(ArrayList<Fee> feeList, int feeIndex) {
		if (feeIndex >= 0 && feeIndex < feeList.size()) {
			feeList.remove(feeIndex);
			System.out.println("Fee deleted successfully.");
		} else {
			System.out.println("Invalid fee index.");
		}
	}

	public static void deleteCourse(ArrayList<Course> courseList) { //22024343 Norhilman
		viewAllCourse(courseList);

		String courseCodeToDelete = Helper.readString("Enter the code of the course to delete: ");

		boolean found = false;
		for (Course course : courseList) {
			String courseCode = course.getCourseCode();
			if (courseCode.equalsIgnoreCase(courseCodeToDelete)) {
				courseList.remove(course);
				System.out.println("Course deleted successfully.");
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Course not found.");
		}
	}

	
		public static void deleteStudent(ArrayList<Student> StudentList,String nrictodelete) {//22003801 Jayanth
			viewStudentList(StudentList);
			boolean found = false;
			for (Student student : StudentList) {
				if (student.getNric().equalsIgnoreCase(nrictodelete)) {
					StudentList.remove(student);

					System.out.println("Student has been successfully deleted");
					found =  true;
					break;
				} 
			}viewStudentList(StudentList);
				if (!found) {
					System.out.println("Student not found");

				}

			}
	

	public static void deleteEnrolment(ArrayList<Enrolment> EnrolmentList) { //Yong Chuan
		String ask_id = Helper.readString("Enter Course ID >");
		boolean found = false;
		for (Enrolment en : EnrolmentList) {
			boolean equalsIgnoreCase = en.getCourse().equalsIgnoreCase(ask_id);
			if (equalsIgnoreCase) {
				EnrolmentList.remove(en);
				System.out.println("Enrolment remove succesfully");
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Enrolment not found.");
		}
	}

}
