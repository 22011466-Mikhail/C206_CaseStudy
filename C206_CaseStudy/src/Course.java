
public class Course {

	private int id;
	private String description;
	private String duration;
	private double minimumGPA;
	
	public Course(int id, String description, String duration, double minimumGPA) {
		this.id = id;
		this.description = description;
		this.duration = duration;
		this.minimumGPA = minimumGPA;
	}

	public double getMinimumGPA() {
		return minimumGPA;
	}

	public void setMinimumGPA(double minimumGPA) {
		this.minimumGPA = minimumGPA;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
	
}
