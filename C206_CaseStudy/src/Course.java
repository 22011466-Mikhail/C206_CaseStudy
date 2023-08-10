
public class Course {

	private String courseCode;
	private String title;
	private String instructor;
	private String schedule;

	public Course(String courseCode, String title, String instructor, String schedule) {
		this.courseCode = courseCode;
		this.title = title;
		this.instructor = instructor;
		this.schedule = schedule;

	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

}
