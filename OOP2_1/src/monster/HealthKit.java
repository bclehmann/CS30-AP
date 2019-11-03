package monster;

public class HealthKit extends Tools{
	public HealthKit(int d) {
		super(d+" HP Kit", d, true, true);
		// TODO Auto-generated constructor stub
	}
	
	public String getDescription() {
		return String.format("A %s (1 use) (Self Acting)", name);
	}

}
