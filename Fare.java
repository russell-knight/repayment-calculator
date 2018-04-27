import java.util.Date;

/** The Fare object contains information such as the type, date and cost of each fare.

*/

public class Fare {
	
	private static int faresTaken;
	private Date fareDate;
	private String fareType; // fullfare or concession, not sure what datatype? maybe boolean (isConcession)

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