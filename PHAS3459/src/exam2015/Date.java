package exam2015;

/**
 * Create Date objects so that we are not passing too many 
 * arguments into the Earthquake object. 
 */

public class Date {

	//Member variables
	public int year;
	public int month;
	public int day;
	
	//Constructor
	Date(int YYYY, int MM, int DD){
		year = YYYY;
		month = MM;
		day = DD;
	}
	
	//Define methods that return the required member variables:
	int getYear(){
		return year;
	}
	int getMonth(){
		return month;
	}
	int getDay(){
		return day;
	}
	
	//Represent the printed data in a readable form:
	public String toString(){
		String date = "date (dd/mm/yyyy): "+day+"/"+month+"/"+year;
		return date;
	}
}
