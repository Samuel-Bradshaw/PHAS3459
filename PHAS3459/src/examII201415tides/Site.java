package examII201415tides;

/**
 * Class defining Site Objects used for storing data. 
 * @author Samuel Bradshaw
 */

public class Site {

	//Member variables
	String name;
	String siteID;

	//Constructors
	Site(){}
	
	Site(String n, String ID){
		name = n;
		siteID = ID;
	}
	
	public String toString(){
		return "Site name: "+name+", Site ID: "+siteID;
	}
	
	String getName(){
		return name;
	}
	
	String getID(){
		return siteID;
	}
}
