package examII201415tides;

/**
 * Class defining tides Objects used for storing data.
 * @author samue
 */

public class tides {
	
	//Member variables
	String siteID;
	int year;
	int month;
	int day;
	int hour;
	int minute;
	double seaLevel;
	double predictedLevel;
	
	//Constructors
	
	tides(){}
	
	tides(String Id, int yr, int mon, int d, int ho, int min, double level, double pLevel){
		siteID = Id;
		year = yr;
		month = mon;
		day = d;
		hour = ho;
		minute = min;
		seaLevel = level;
		predictedLevel = pLevel;
	}
	
	
	public String toString(){
		return "Sea Level Measured: "+seaLevel+" m, Predicted Sea Level: "+predictedLevel+" m"+
				"\nDate: "+day+"/"+month+"/"+year+", Time: "+hour+":"+minute+
				"\nIdentifier for the site: "+siteID;
	}
	

	double getLevel(){
		return seaLevel;
	}
	
	double getPredictedLevel(){
		return predictedLevel;
	}
	
	String getID(){
		return siteID;
	}
}

