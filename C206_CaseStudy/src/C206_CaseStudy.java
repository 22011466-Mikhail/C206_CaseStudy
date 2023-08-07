import java.util.ArrayList;

public class C206_CaseStudy {
//yc
//jay

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
					EnrolmentList.get(i).getDate(),EnrolmentList.get(i).getOpticalZoom());
			}
		}
		return output;
	}
	
	public static void viewAllEnrolment(ArrayList<Enrolment> EnrolmentList) {
		C206_CaseStudy.setHeader("ENROLMENT LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION",
				"AVAILABLE", "DUE DATE","OPTICAL ZOOM");
		 output += retrieveAllEnrolment(EnrolmentList);	
		System.out.println(output);
	}
	
	public static void addEnrolment(ArrayList<Enrolment> camcorderList, Enrolment en) {
		Camcorder Enrolment;
		for(int i = 0; i < camcorderList.size(); i++) {
			Enrolment = camcorderList.get(i);
			if (Enrolment.getid().equalsIgnoreCase(en.getid()) )
				return;
		}
		if ((en.getid().isEmpty()) || (en.getDescription().isEmpty()) ) {
			return;
		}
		
		camcorderList.add(en);
	}
	
	
}
