package module6;


/**
 * An extension of the DataPoint class with an added member variable (i.e. its label)
 * and an altered toString() method
 */

public class LabelledDataPoint extends DataPoint {
	
	//This class has an added member variable representing a label
	String label;

	//Constructor
	public LabelledDataPoint(double x1, double y1, double errory, String Label) {
		super(x1, y1, errory);
		label = Label;
	}
	
	//returns string in the form: "data_point_label: x = ..., y = ...+-ey..."
	public String toString(){ 
		return label+": x = "+x+", y = "+y+" +- "+ey;
	}

	
}
