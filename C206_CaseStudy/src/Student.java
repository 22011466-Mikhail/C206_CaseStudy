
public class Student {
	private String name;
	private String dob;
	private String nric;
	private String course;
	private int contactNumber;
	public Student(String name, String dob, String nric, String course, int contactNumber) {
		super();
		this.name = name;
		this.dob = dob;
		this.nric = nric;
		this.course = course;
		this.contactNumber = contactNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getNric() {
		return nric;
	}
	public void setNric(String nric) {
		this.nric = nric;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	public void display() {
		System.out.println("Name :" + name);
		System.out.println("Date of birth: "+dob);
		System.out.println("NRIC: "+nric);
		System.out.println("Course: "+course );
		System.out.println("Contact Number: "+contactNumber);
	}

}
