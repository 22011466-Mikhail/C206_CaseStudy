import java.util.ArrayList;

public class C206_CaseStudy {
//yc
//jay

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		



		ArrayList<Fee> feeList = new ArrayList<Fee>();
		ArrayList<Course> courseList = new ArrayList<Course>();
		ArrayList<Enrolment> EnrolmentList = new ArrayList<Enrolment>();

		feeList.add(new Fee("Tuition Fee", 1000.0, "2023-09-01"));

		courseList.add(new Course("C01", "Mathematics", "Adam Salah", "Every Saturday at 5.00pm to 7.00pm"));
		courseList.add(new Course("C02", "English", "Alice Lum", "Every Sunday at 7.00pm to 9.00pm"));

		int option = 0;

		while (option != 4) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Sign in to > ");

			if (option == 1) {
				Helper.line(80, "-");
				System.out.println("1. Add Course");
				System.out.println("2. View Courses");
				System.out.println("3. Delete Course");
				System.out.println("4. Add Fees");
				System.out.println("5. View Fees");
				System.out.println("6. Delete Fees");
				System.out.println("7. Add Users");
				System.out.println("8. View Users");
				System.out.println("9. Delete Users");
				System.out.println("10. Add Students");
				System.out.println("11. View Students");
				System.out.println("12. Delete Students");
				Helper.line(80, "-");

				int option2 = Helper.readInt("Enter an option > ");

				if (option2 == 1) {
					Course c = inputCourse();
					C206_CaseStudy.addCourse(courseList, c);
					System.out.println("Course added");

				} else if (option2 == 2) {
					C206_CaseStudy.viewAllCourse(courseList);

				} else if (option2 == 3) {
					C206_CaseStudy.deleteCourse(courseList);

				} else if (option2 == 4) {
					C206_CaseStudy.addFee(feeList, null, option2, null);
					System.out.println("Fee added");

				} else if (option2 == 5) {
					C206_CaseStudy.viewAllFees(feeList);

				} else if (option2 == 6) {
					C206_CaseStudy.deleteFee(feeList, option2);

				} else if (option == 2) {

				} else if (option == 3) {
					Helper.line(80, "-");
					System.out.println("1. Add enrolment");
					System.out.println("2. View enrolment");
					System.out.println("3. Delete enrolment");
					Helper.line(80, "-");

					int option3 = Helper.readInt("Enter an option > ");

					if (option3 == 1) {

					} else if (option3 == 2) {
						C206_CaseStudy.viewAllEnrolment(EnrolmentList);

					} else if (option3 == 3) {
					}

				} else if (option == 4) {
					System.out.println("Bye!");
				} else {
					System.out.println("Invalid option");
				}
			}
		}
	}

	public static void menu() {
		System.out.println("TUITION CENTRE APP");
		Helper.line(80, "-");
		System.out.println("1. Administrator");
		System.out.println("2. Teacher");
		System.out.println("3. Student");
		System.out.println("4. Exit");
		Helper.line(80, "-");

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

	// ================================= View items =================================
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




	public static void viewAllFees(ArrayList<Fee> feeList) {
		System.out.println("Fee List");
		String format = "%-20s %-10s %-15s\n";
		System.out.printf(format, "FEE TYPE", "AMOUNT", "DUE DATE");

		for (Fee fee : feeList) {
			System.out.printf(format, fee.getFeeType(), fee.getAmount(), fee.getDueDate());
		}
	}

	public static void viewAllCourse(ArrayList<Course> courseList) {
		System.out.println("Course List");
		String format = "%-5s %-15s %-20s %-30s\n";
		System.out.printf(format, "ID", "Title", "Instructor", "Schedule");

		for (Course course : courseList) {
			System.out.printf(format, course.getCourseCode(), course.getTitle(), course.getInstructor(),
					course.getSchedule());
		}
	}

	// ================================= Adding =================================
	public static void addEnrolment(ArrayList<Enrolment> EnrolmentList, Enrolment en) {
		
		EnrolmentList.add(en);
	}
	
	public static void deleteEnrolment(ArrayList<Enrolment> EnrolmentList, int index) {
		if (index >= 0 && index < EnrolmentList.size()) {
			EnrolmentList.remove(index);
			System.out.println("Enrolment deleted successfully.");
		} else {
			System.out.println("Invalid Enrolment ID.");
		}
	}

	public static void addFee(ArrayList<Fee> feeList, String feeType, double amount, String dueDate) {
		Fee newFee = new Fee(feeType, amount, dueDate);
		feeList.add(newFee);
		System.out.println("Fee added successfully.");
	}
	
	public static Course inputCourse() {
		String id = Helper.readString("Enter Course ID: ");
		String title = Helper.readString("Enter Course Title: ");
		String instructor = Helper.readString("Enter Instructor Name: ");
		String schedule = Helper.readString("Enter Schedule: ");

		Course newCourse = new Course(id, title, instructor, schedule);
		return newCourse;
	}

	public static void addCourse(ArrayList<Course> courseList, Course course) {
		courseList.add(course);
	}

	// ================================= Deleting =================================
	public static void deleteFee(ArrayList<Fee> feeList, int index) {
		if (index >= 0 && index < feeList.size()) {
			feeList.remove(index);
			System.out.println("Fee deleted successfully.");
		} else {
			System.out.println("Invalid fee index.");
		}
	}
	public static void deleteCourse(ArrayList<Course> courseList) {
	    viewAllCourse(courseList);
	    
	    String courseCodeToDelete = Helper.readString("Enter the code of the course to delete: ");
	    
	    boolean found = false;
	    for (Course course : courseList) {
	        if (course.getCourseCode().equalsIgnoreCase(courseCodeToDelete)) {
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
	






	

}
