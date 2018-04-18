import java.util.Date;

/** The Fare object contains information such as the type, date and cost of each fare as well as a collective count of all fares taken.

*/

public class Fare {
	
	private static int fareCount;
	private Date fareDate;
	private boolean isConcession;

	public Fare(Date date, String type) {
		fareDate = date;
		fareType = type;
		isConcession = false;
	}
	
	//Accessor & Mutator Methods
	
	public Date getFareDate() {
		return fareDate;
	}
	
	public setFareDate(Date d) {
		fareDate = d;
	}
	
	public int getFareCount() {
		return fareCount;
	}
	
	public setFareCount(int c) {
		fareCount = c;
	}
	
	
}
