import java.util.ArrayList;

public class C206_CaseStudy {
//yc
//jay
//hakim

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Fee> feeList = new ArrayList<Fee>();
		ArrayList<Course> courseList = new ArrayList<Course>();
		ArrayList<Enrolment> EnrolmentList = new ArrayList<Enrolment>();
		ArrayList<Student> StudentList = new ArrayList<Student>();
		StudentList.add(new Student("Adam Salah","2003-08-25","M7654","Mathematics",83435469));

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
					String feeType = Helper.readString("Enter Fee Type (Tuition Fee/Exam Fee): ");
					double amount = Helper.readDouble("Enter Amount: ");
					String dueDate = Helper.readString("Enter Due Date(YYYY-mm-dd): ");

					C206_CaseStudy.addFee(feeList, feeType, amount, dueDate);

				} else if (option2 == 5) {
					C206_CaseStudy.viewAllFees(feeList);

				} else if (option2 == 6) {
					C206_CaseStudy.viewAllFees(feeList);

					int feeIndexToDelete = Helper.readInt("Enter the index of the fee to delete: ");
					C206_CaseStudy.deleteFee(feeList, feeIndexToDelete);
				}

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

	// ================================= View items
	// =================================
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
		System.out.println(String.format("%-20s %-10s %-15s\n", "FEE TYPE", "AMOUNT", "DUE DATE"));
		

		for (Fee fee : feeList) {
			System.out.println(String.format("%-20s %-10.2f %-15s", fee.getFeeType(), fee.getAmount(), fee.getDueDate()));
		}
		
	}

	public static String retrieveAllCourse(ArrayList<Course> courseList) {
		String result = "Course List\n";
		String format = "%-5s %-15s %-20s %-30s\n";
		result += String.format(format, "ID", "Title", "Instructor", "Schedule");

		for (Course course : courseList) {
			result += String.format(format, course.getCourseCode(), course.getTitle(), course.getInstructor(),
					course.getSchedule());
		}

		return result;
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
		public static void viewStudentList(ArrayList<Student>StudentList) {
			System.out.println("Student List");
			String format= "%-15s %-15s %-10s %-30s %-15s\n";
			System.out.printf(format,"Name","DOB","NRIC","Course","Contact Number");
			for(Student student:StudentList) {
				System.out.printf(format,student.getName(),student.getDob(),student.getNric(),student.getCourse(),student.getContactNumber());;
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
	public static void addStudent(ArrayList<Student> StudentList) {
		String name=Helper.readString("enter your name: ");
		String dob=Helper.readString("Enter your date of birth: ");
		String nric=Helper.readString("Enter your nric number: ");
		String course=Helper.readString("Enter your desired course: ");
		int contact=Helper.readInt("Enter your contact number: ");
		StudentList.add(new Student(name,dob,nric,course,contact));
		System.out.println("Student has been added");
	}

	// ================================= Deleting =================================
	public static void deleteFee(ArrayList<Fee> feeList, int feeIndex) {
		if (feeIndex >= 0 && feeIndex < feeList.size()) {
			feeList.remove(feeIndex);
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
	public static void deleteStudent(ArrayList<Student>StudentList) {
		viewStudentList(StudentList);
		String nrictodelete=Helper.readString("Enter the nric number to be deleted: ");
		for(Student student:StudentList) {
			if(student.getNric().equalsIgnoreCase(nrictodelete)) {
				StudentList.remove(student);
				System.out.println("Student has been successfully deleted");
				
			}
		}
		
	}

}
