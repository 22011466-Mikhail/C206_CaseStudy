import java.util.ArrayList;

public class Student {
	
	private String studentID;
	private String name;
	private int age;
	private ArrayList<Fee> feeList;
	
	
	public Student(String studentID, String name, int age, ArrayList<Fee> feeList) {
		this.studentID = studentID;
		this.name = name;
		this.age = age;
		this.feeList = feeList;
	}


	public String getStudentID() {
		return studentID;
	}


	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public ArrayList<Fee> getFeeList() {
		return feeList;
	}
	

}
