package examII201314plants;

public class Species {
	
	//Member variables
	String IDcode;
	String ScientificName;
	int SpeciesCount;
	double heightCount;
	
	//Constructors
	Species(){};
	
	Species(String ID, String name){
		IDcode = ID;
		ScientificName = name;
	}
	
	void AddToSpeciesCount(){
		SpeciesCount = SpeciesCount + 1;
	}
	
	void AddToHeightCount(double h){
		heightCount = heightCount + h;
	}
	
	//Methods for returning member variables
	int getCount(){
		return SpeciesCount;
	}
	
	double getMean(){
		return heightCount/(double)SpeciesCount;
	}
	
	String getID(){
		return IDcode;
	}
	String getName(){
		return ScientificName;
	}
	
	public String toString(){
		return ScientificName;
	}
	

}
