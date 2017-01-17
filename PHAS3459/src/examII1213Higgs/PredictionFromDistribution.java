package examII1213Higgs;

import java.util.ArrayList;

public interface PredictionFromDistribution {

	double CalculatePredictionforSingleBin(double Elow);
	
	ArrayList<Double> ListOfSignalCountPredictions();
	

}
