import java.util.ArrayList;

public class C206_CaseStudy {


//branch 'master' of https://github.com/22011466-Mikhail/C206_CaseStudy.git
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creation of arraylists for main
		ArrayList<Fee> feeList = new ArrayList<>();
		ArrayList<User> userList = new ArrayList<User>();
		
		//addition of sample objects to arraylists
		userList.add(new User("user1", "password1", "student"));
		userList.add(new User("user2", "password2", "teacher"));
		userList.add(new User("user3", "password3", "admin"));
		
		int option = 0;
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
			menu();
			option = Helper.readInt("Insert menu option > ");
			
			while(option != 5) {
				if(option == 1) {
					
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
	
	
	//Main login page
	
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
		System.out.println("5. Quit");
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
	
	
	//User - Mikhail
	public static String retrieveAllUsers(ArrayList<User> userList) {
		String output = "";
		for (int i = 0; i < userList.size(); i++) {

			output += String.format("%-84s\n", userList.get(i).toString());
		}
		return output;
	}
	
	public static void viewUsers(ArrayList<User> userList) {
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
	
	public static void addUsers(ArrayList<User> userList, User user1) {
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
	
	public static void removeUsers(ArrayList<User> userList) {
		String username = Helper.readString("Enter username of account to delete > ");
		User deleteUser = null;
		boolean userFound = false;
		String option = "";
		
		for(User user1 : userList) {
			if(user1.getUsername().equals(username)) {
				option = Helper.readString("Are you sure you want to delete " + user1.getUsername() + "?");
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
	
	//Enrollment
	public static String retrieveAllEnrolment(ArrayList<Enrolment> EnrolmentList) {
		String output = "";

		for (int i = 0; i < EnrolmentList.size(); i++) {
			if (EnrolmentList.get(i).getIsAvailable()) {
				output += String.format("%-10s %-30s %-10s %-10s %-20d\n", EnrolmentList.get(i).getid(),
						EnrolmentList.get(i).getDescription(),
						C206_CaseStudy.showAvailability(EnrolmentList.get(i).getIsAvailable()),
						EnrolmentList.get(i).getDate(), EnrolmentList.get(i).getOpticalZoom());
			}
		}
		return output;
	}

	public static void viewAllEnrolment(ArrayList<Enrolment> EnrolmentList) {
		C206_CaseStudy.setHeader("ENROLMENT LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION", "AVAILABLE",
				"DUE DATE", "OPTICAL ZOOM");
		output += retrieveAllEnrolment(EnrolmentList);
		System.out.println(output);
	}

	public static void addEnrolment(ArrayList<Enrolment> camcorderList, Enrolment en) {
		Camcorder Enrolment;
		for (int i = 0; i < camcorderList.size(); i++) {
			Enrolment = camcorderList.get(i);
			if (Enrolment.getid().equalsIgnoreCase(en.getid()))
				return;
		}
		if ((en.getid().isEmpty()) || (en.getDescription().isEmpty())) {
			return;
		}

		camcorderList.add(en);
	}

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
