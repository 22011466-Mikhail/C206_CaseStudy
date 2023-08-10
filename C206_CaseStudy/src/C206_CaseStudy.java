import java.util.ArrayList;

public class C206_CaseStudy {
//yc
//jay

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 ArrayList<Fee> feeList = new ArrayList<>();
		 ArrayList<Enrolment> EnrolmentList = new ArrayList<Enrolment>();
	    addFee(feeList, "Tuition Fee", 1000.0, "2023-09-01");
	    
	    int option = 0;

		while (option != 5) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items

			} else if (option == 2) {
				// Add a new item


			} else if (option == 3) {
				// Loan item

			}else if(option ==4) {
				

			} else if (option == 5) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}
	}
	public static void menu() {
		C206_CaseStudy.setHeader("TUITION CENTRE APP");
		System.out.println("1. ");
		System.out.println("2. ");
		System.out.println("3. ");
		System.out.println("4. ");
		System.out.println("5. Quit");
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

	public static void addEnrolment(ArrayList<Enrolment> EnrolmentList, Enrolment en) {
		Camcorder Enrolment;
		for (int i = 0; i < EnrolmentList.size(); i++) {
			Enrolment = EnrolmentList.get(i);
			if (Enrolment.getid().equalsIgnoreCase(en.getid()))
				return;
		}
		if ((en.getid().isEmpty()) || (en.getDescription().isEmpty())) {
			return;
		}

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
