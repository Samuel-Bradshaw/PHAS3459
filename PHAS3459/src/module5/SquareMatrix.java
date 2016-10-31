package module5;

import java.lang.reflect.Array;

public class SquareMatrix {

	//Member variables 
	private double[][] matrixElements; 

	public SquareMatrix(double[][] elements) throws Exception {
		for(int i = 0; i < elements.length; i++){ 
			if ((elements[i].length == elements.length) == false){//Tests that a square matrix has been entered
				throw new Exception("Error in SquareMatrix object: Must enter a valid square Matrix");
			}
		}
		matrixElements = elements;
	}

public String toString(){
		
		for(int i; i < this.length; i++){
			
		}
		
			
		//}
//	}
}
