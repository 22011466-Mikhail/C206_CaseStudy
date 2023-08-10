
public class Enrolment  {
	private String enrol_id ;
	private String description;
	private String date;
	public boolean isAvailable;
	
	public Enrolment(String enrol_id , String description, String date) {
		this.enrol_id = enrol_id;
		this.description = description;
		this.date = date;
		this.isAvailable=true;
	}
	
	public String getid() {
		return enrol_id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getDate() {
		return date;
	}
	public boolean getIsAvailable(){
		return isAvailable;
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
