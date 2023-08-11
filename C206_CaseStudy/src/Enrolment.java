//yc
public class Enrolment  {
	private String enrol_id ;
	private String course_id;
	public boolean isAvailable;
	
	public Enrolment(String course_id) {
		this.course_id = course_id;
		this.isAvailable=true;
	}
	
	public String getCourse() {
		return course_id;
	}
	public String getid() {
		for(int i=1; i<999; i++)
		System.out.println("EN"+i);
		return enrol_id;
	}
	
	public boolean getIsAvailable(){
		return isAvailable;
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
