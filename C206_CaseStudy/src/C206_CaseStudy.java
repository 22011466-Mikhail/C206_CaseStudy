import java.util.ArrayList;
import java.util.Arrays;

public class C206_CaseStudy {


//branch 'master' of https://github.com/22011466-Mikhail/C206_CaseStudy.git
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creation of arraylists for main
		ArrayList<Fee> feeList = new ArrayList<>();
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Enrolment> enrolmentList = new ArrayList<Enrolment>();
		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<Course> courseList = new ArrayList<Course>();
		
		//addition of sample objects to arraylists
		userList.add(new User("user1", "password1", "student"));
		userList.add(new User("user2", "password2", "teacher"));
		userList.add(new User("user3", "password3", "admin"));
		
		courseList.add(new Course(1, "Networking Course", "6 months", 2.0));
		courseList.add(new Course(2, "Cooking Course", "2 months", 1.0));
		courseList.add(new Course(3, "Math Course", "4 months", 3.0));
		
		Fee df = new Fee("Default Fee", 1000.0, "01/01/2024");
		Fee tf = new Fee("Tuition Fee", 2000.0, "01/02/2024");
		Fee bf = new Fee("Book Fee", 30.0, "01/03/2024");
		
		Enrolment = new Enrolment("1" , "Enrolment", String date)
		
		feeList.add(df);
		feeList.add(bf);
		feeList.add(tf);
		
		studentList.add(new Student("1", "John", 14, new ArrayList<Fee>(Arrays.asList(df,bf))));
		studentList.add(new Student("2", "Joe", 16, new ArrayList<Fee>(Arrays.asList(df,bf,tf))));
		studentList.add(new Student("3", "James", 18, new ArrayList<Fee>(Arrays.asList(tf))));
		
		int option = 0;
		int functionOption = 0;
		User loginUser = null;
		
		
		while(option != 2) {
			loginMenu();
			option = Helper.readInt("Insert menu option > ");
			if(option == 1) {
				String username = Helper.readString("Username > ");
				String password = Helper.readString("Password > "); 
				loginUser = loginToUser(userList, username, password);
				if(loginUser != null) {
					System.out.println("Login successful");
					System.out.println("User: " + loginUser.getUsername());
					break;
				} else {
					System.out.println("Username / password is wrong");
				}
 			}
		}
		
		if(loginUser != null) {
			while(option != 6) {
				menu();
				option = Helper.readInt("Insert menu option > ");
				if(option == 1) { // ----- COURSE FUNCTION ------
					while(functionOption != 4) {
						courseMenu();
						functionOption = Helper.readInt("Insert option > ");
						
						if(functionOption == 1) {
							addUser(userList, inputUser());
						} else if(functionOption == 2) {
							removeUser(userList);
						} else if(functionOption == 3) {
							viewUser(userList);
						}
						
					}

				} else if(option == 2) { // ----STUDENT FUNCTION-----
					while(functionOption != 4) {
						studentMenu();
						functionOption = Helper.readInt("Insert option > ");
						
						if(functionOption == 1) {
							addUser(userList, inputUser());
						} else if(functionOption == 2) {
							removeUser(userList);
						} else if(functionOption == 3) {
							viewUser(userList);
						}
					}

				} else if(option == 3) { // ---- FEE FUNCTION-----
					while(functionOption != 4) {
						feeMenu();
						functionOption = Helper.readInt("Insert option > ");
						
						if(functionOption == 1) {
							addUser(userList, inputUser());
						} else if(functionOption == 2) {
							removeUser(userList);
						} else if(functionOption == 3) {
							viewUser(userList);
						}
					}
				} else if(option == 4) { // ----ENROLMENT FUNCTION-----
					while(functionOption != 4) {
						enrolmentMenu();
						functionOption = Helper.readInt("Insert option > ");
						
						if(functionOption == 1) {
							addEnrolment(enrolmentList, inputUser());
						} else if(functionOption == 2) {
							removeUser(userList);
						} else if(functionOption == 3) {
							viewUser(userList);
						}
					}
				}  else if(option == 5) { // ----USER FUNCTION-----
					while(functionOption != 4) {
						studentMenu();
						functionOption = Helper.readInt("Insert option > ");
						
						if(functionOption == 1) {
							addUser(userList, inputUser());
						} else if(functionOption == 2) {
							removeUser(userList);
						} else if(functionOption == 3) {
							viewUser(userList);
						}
					}
				}
			}
		}
		
		
		System.out.println("Exiting the program...");
		
	    //addFee(feeList, "Tuition Fee", 1000.0, "2023-09-01");
	    
	
	}
	
	//Utility methods

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
	
	
	//---------MAIN MENUS----------
	
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
		setHeader("COURSE MENU");
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
		setHeader("COURSE MENU");
		System.out.println("1. Add Student");
		System.out.println("2. Remove Student");
		System.out.println("3. View Students");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
	
	public static void feeMenu() {
		setHeader("COURSE MENU");
		System.out.println("1. Add Fee");
		System.out.println("2. Remove Fee");
		System.out.println("3. View Fee");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
	
	public static void enrolmentMenu() {
		setHeader("COURSE MENU");
		System.out.println("1. Add Enrolment");
		System.out.println("2. Remove Enrolment");
		System.out.println("3. View Enrolment");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
	
	public static User loginToUser(ArrayList<User> userList, String username, String password) {
		
		boolean userFound = false;
		User userLogin = null;
		
		for(User user1: userList) {
			if(user1.getUsername().equals(username) && user1.getPassword().equals(password)) {
				userLogin = user1;
				userFound = true;
			}
		}
		
		if(userFound == true) {
			return(userLogin);
		} else {
			return(userLogin);
		}
		
	}
	
	
	//----------------User------------ - Mikhail
	public static String retrieveAllUsers(ArrayList<User> userList) {
		String output = "";
		for (int i = 0; i < userList.size(); i++) {

			output += String.format("%-20s %-20s %-20s\n", 
					userList.get(i).getUsername(),
					userList.get(i).getPassword(),
					userList.get(i).getRole());
		}
		return output;
	}
	
	public static void viewUser(ArrayList<User> userList) {
		setHeader("USER LIST");
		String output = String.format("%-20s %-20s %-20s\n", "USERNAME", "PASSWORD", "ROLE");
		output += retrieveAllUsers(userList);
		System.out.println(output);
	}
	
	public static User inputUser() {
		String username = Helper.readString("Enter username > ");
		String password = Helper.readString("Enter password > ");
		String role = Helper.readString("Enter role > ");
		
		User user = new User(username, password, role);
		return user;
	}
	
	public static void addUser(ArrayList<User> userList, User user1) {
		User userTest;
		for(int i = 0; i < userList.size(); i++) {
			userTest = userList.get(i);
			if (userTest.getUsername().equalsIgnoreCase(user1.getUsername()) )
				return;
		}
		if ((user1.getUsername().isEmpty()) || (user1.getPassword().isEmpty()) || (user1.getRole().isEmpty()) ) {
			return;
		}
		userList.add(user1);
	}
	
	public static void removeUser(ArrayList<User> userList) {
		String username = Helper.readString("Enter username of account to delete > ");
		User deleteUser = null;
		boolean userFound = false;
		String option = "";
		
		for(User user1 : userList) {
			if(user1.getUsername().equals(username)) {
				option = Helper.readString("Are you sure you want to delete " + user1.getUsername() + "? > ");
				userFound = true;
				deleteUser = user1;
				break;
			}
		}
		
		if(userFound == false) {
			System.out.println("Account not found");
		} else if (option.equalsIgnoreCase("no")) {
			return;
		} else if (option.equalsIgnoreCase("yes") && userFound == true){
			userList.remove(deleteUser);
			System.out.println("Account has been deleted.");
		} else {
			System.out.println("Error with input");
		}
	}
	
	
	// -------------Courses--------------
	
	
	public static String retrieveAllCourse(ArrayList<Course> courseList) {
		String output = "";
		for (int i = 0; i < courseList.size(); i++) {

			output += String.format("%-20d %-20s %-20s %-20.1f\n", 
					courseList.get(i).getId(),
					courseList.get(i).getDescription(),
					courseList.get(i).getDuration(),
					courseList.get(i).getMinimumGPA() );
		}
		return output;
	}
	
	public static void viewCourse(ArrayList<Course> courseList) {
		setHeader("USER LIST");
		String output = String.format("%-20s %-20s %-20s %-20s\n", "ID", "DESCRIPTION", "DURATION", "MINIMUM GPA");
		output += retrieveAllCourse(courseList);
		System.out.println(output);
	}
	
	public static User inputCourse() {
		int id = Helper.readInt("Enter id > ");
		String description = Helper.readString("Enter description > ");
		String duration = Helper.readString("Enter duration > ");
		double minimumGPA = Helper.readDouble("Enter minimum GPA > ");
		
		Course course = new Course(id, description, duration, minimumGPA);
		return course;
	}
	
	public static void addCourse(ArrayList<Course> courseList, Course course1) {
		Course courseTest;
		for(int i = 0; i < courseList.size(); i++) {
			courseTest = courseList.get(i);
			if (courseTest.getId() == course1.getId() )
				return;
		}
		if ((course1.getDescription().isEmpty()) || (course1.getDuration().isEmpty()) ) {
			return;
		}
		courseList.add(course1);
	}
	
	public static void removeCourse(ArrayList<Course> courseList) {
		int id = Helper.readInt("Enter id of course to delete > ");
		Course deleteCourse = null;
		boolean courseFound = false;
		String option = "";
		
		for(Course course1 : courseList) {
			if(course1.getId() == id) {
				option = Helper.readString("Are you sure you want to delete " + course1.getId() + "? > ");
				courseFound = true;
				deleteCourse = course1;
				break;
			}
		}
		
		if(courseFound == false) {
			System.out.println("Course not found");
		} else if (option.equalsIgnoreCase("no")) {
			return;
		} else if (option.equalsIgnoreCase("yes") && courseFound == true){
			courseList.remove(deleteCourse);
			System.out.println("Course has been deleted.");
		} else {
			System.out.println("Error with input");
		}
	}
	
	
	
	// ---------------Enrolment--------------
	public static String retrieveAllEnrolment(ArrayList<Enrolment> EnrolmentList) {
		String output = "";

		for (int i = 0; i < EnrolmentList.size(); i++) {
			if (EnrolmentList.get(i).getIsAvailable()) {
				output += String.format("%-10s %-30s %-10s %-10s\n", EnrolmentList.get(i).getid(),
						EnrolmentList.get(i).getDescription(),
						C206_CaseStudy.showAvailability(EnrolmentList.get(i).getIsAvailable()),
						EnrolmentList.get(i).getDate());
			}
		}
		return output;
	}

	public static void viewAllEnrolment(ArrayList<Enrolment> EnrolmentList) {
		C206_CaseStudy.setHeader("ENROLMENT LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ID", "DESCRIPTION", "AVAILABLE",
				"DATE");
		output += retrieveAllEnrolment(EnrolmentList);
		System.out.println(output);
	}
	
	public static Enrolment inputEnrolment() {
		String id = Helper.readString("Enter enrolment id > ");
		String description = Helper.readString("Enter description > ");
		String date = Helper.readString("Enter role > ");
		
		Enrolment en = new Enrolment(id, description, date);
		return en;
	}

	public static void addEnrolment(ArrayList<Enrolment> enrolmentList, Enrolment en) {
		Enrolment enrol;
		for (int i = 0; i < enrolmentList.size(); i++) {
			enrol = enrolmentList.get(i);
			if (enrol.getid().equalsIgnoreCase(en.getid()))
				return;
		}
		if ((en.getid().isEmpty()) || (en.getDescription().isEmpty())) {
			return;
		}

		enrolmentList.add(en);
	}
	
	public static void removeEnrolment(ArrayList<Enrolment> enrolmentList) {
		String deleteID = Helper.readString("Enter id of enrolment to delete > ");
		Enrolment deleteEnrolment = null;
		boolean enrolmentFound = false;
		String option = "";
		
		for(Enrolment enrol : enrolmentList) {
			if(enrol.getid().equals(deleteID)) {
				option = Helper.readString("Are you sure you want to delete " + enrol.getDescription() + "? > ");
				enrolmentFound = true;
				deleteEnrolment = enrol;
				break;
			}
		}
		
		if(enrolmentFound == false) {
			System.out.println("Enrolment not found");
		} else if (option.equalsIgnoreCase("no")) {
			return;
		} else if (option.equalsIgnoreCase("yes") && enrolmentFound == true){
			enrolmentList.remove(deleteEnrolment);
			System.out.println("Enrolment has been deleted.");
		} else {
			System.out.println("Error with input");
		}
	}
	
	
	// -------------Fee--------------
	public static void addFee(ArrayList<Fee> feeList, String feeType, double amount, String dueDate) {
		Fee newFee = new Fee(feeType, amount, dueDate);
		feeList.add(newFee);
		System.out.println("Fee added successfully.");
	}

	public static void viewAllFees(ArrayList<Fee> feeList) {
		System.out.println("Fee List");
		String format = "%-20s %-10s %-15s\n";
		System.out.printf(format, "FEE TYPE", "AMOUNT", "DUE DATE");

		for (Fee fee : feeList) {
			System.out.printf(format, fee.getFeeType(), fee.getAmount(), fee.getDueDate());
		}
	}

	public static void deleteFee(ArrayList<Fee> feeList, int index) {
		if (index >= 0 && index < feeList.size()) {
			feeList.remove(index);
			System.out.println("Fee deleted successfully.");
		} else {
			System.out.println("Invalid fee index.");
		}

	}

}
