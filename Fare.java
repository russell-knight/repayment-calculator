import java.util.Date;

/** The Fare object contains information such as the type, date and cost of each fare.

*/

public class Fare {
	// public transport fare prices Melbourne
	final static double CONCES_2019 = 2.15;
	final static double FULL_2019 = 4.30;
	final static double CONCES_2020 = 2.25;
	final static double FULL_2020 = 4.50;

	private static int faresTaken;
	private Date fareDate;
	private boolean isConcession;

	public Fare(Date date, String type) {
		fareDate = date;
		fareType = type;
	}
	
	//Accessor & Mutator Methods
	
	public Date getFareDate() {
		return fareDate;
	}
	
	#TO-DO the rest of these methods...
	
	
}