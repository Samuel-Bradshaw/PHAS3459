package module5;

/** 
 * Defining Square Matrix objects from arrays 
 * and some matrix manipulation methods such as
 * adding, subtracting, and multiplying matrices.
 * **/

import java.lang.reflect.Array;
import java.util.Arrays;

public class SquareMatrix {

	//Member variables: 
	double[][] matrixElements; 

	//Constructor - throws exception if argument passed isn't in square Matrix form. 
	public SquareMatrix(double[][] elements) throws Exception {
		for(int i = 0; i < elements.length; i++){ 
			if (elements[i].length != elements.length){
				throw new Exception("Error in SquareMatrix object: Must enter a valid square Matrix");
			}
		}
		matrixElements = elements;
	}

	//Presents SquareMatrix objects in a readable form
	public String toString(){
		String matstring = "(";//Indicate start of each matrix with a "("
		for(int row = 0; row < matrixElements.length; row++){
			for(int column = 0; column < matrixElements[row].length; column++){
				if(column < (matrixElements.length - 1)){ 			 // Adding each matrix element
					matstring +=  matrixElements[row][column] +"\t"; // to the string and adding a 
				}													 // space between each element.
				else{ //If the element is the last one in the row, don't add a space at the end. 
					matstring +=  matrixElements[row][column];
				}
			}
			if(row < (matrixElements.length - 1)){ // Each time we reach the end of a row,
				matstring +=  "\n ";			   // write next row of matrix on  a new line,
			}                                      // unless it is the final row.
			else{ // Close off matrix with ")"
				matstring += ")\n";}
		}
		return matstring;
	}

	//Creates an Identity Matrix of dimensions passed in the argument.
	public static SquareMatrix unitMatrix(int n) throws Exception{
		double[][] unitmat = new double[n][n];//Create a 2D array of n*n dimensions. 
		for(int i = 0; i < n ; i++){
			for(int j = 0; j < n; j++){
				if(i == j){					//For elements across the diagonal,
					unitmat[i][j] = 1.0;	//set these to 1.
				}
				else{						//For elements not on the diagonal,
					unitmat[i][j] = 0.0;	//set these to 0
				}
			}
		}
		return new SquareMatrix(unitmat);
	}

	//Generated from Source -> Generate hasCode() and equals()...
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(matrixElements);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SquareMatrix other = (SquareMatrix) obj;
		if (!Arrays.deepEquals(matrixElements, other.matrixElements))
			return false;
		return true;
	}

	//Adds two Matrices together 
	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		if(sm1.matrixElements.length != sm2.matrixElements.length){ 
			throw new Exception("SquareMatrix.add() failure: Cannot add matrices of different dimensions.");
		}
		double[][] sm3 = new double[sm1.matrixElements.length][sm2.matrixElements.length]; 
		for(int i = 0; i < sm1.matrixElements.length ; i++){
			for(int j = 0; j < sm2.matrixElements.length; j++){
				sm3[i][j] = sm1.matrixElements[i][j] + sm2.matrixElements[i][j];
			}
		}
		return new SquareMatrix(sm3);
	}

	//Subtracts matrix passed in second argument from matrix passed in first argument. 
	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		if(sm1.matrixElements.length != sm2.matrixElements.length){
			throw new Exception("SquareMatrix.subtract() failure: Cannot subtract matrices of different dimensions.");
		}
		double[][] sm3 = new double[sm1.matrixElements.length][sm2.matrixElements.length]; 

		for(int i = 0; i < sm1.matrixElements.length ; i++){
			for(int j = 0; j < sm2.matrixElements.length; j++){ 
				sm3[i][j] = sm1.matrixElements[i][j] - sm2.matrixElements[i][j];
			}
		}
		return new SquareMatrix(sm3);
	}

	//Multiplies two square matrices together:
	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		if(sm1.matrixElements.length != sm2.matrixElements.length){
			throw new Exception("SquareMatrix.multiply() failure: Cannot multiply square matrices of different dimensions.");
		} 
		int n = sm1.matrixElements.length;
		//Initialising the product of the two matrices as sm3:
		double[][] sm3 = new double[n][n]; 
		for(int i = 0; i < n; i++){			
			for(int j = 0; j < n; j++){		// Initialising all the values
				sm3[i][j] = 0;				// of sm3 as 0.
			}
		}
		//The product of matrices sm1 and sm2 is given by sm3[i][j] = sm1[i][k]*sm2[k][j] where we sum over all k indices. 
		for(int i = 0; i < n ; i++){
			for(int j = 0; j < n; j++){
				for(int k = 0; k < n; k++){ //Summing over k indices
					sm3[i][j] = sm3[i][j] + sm1.matrixElements[i][k]*sm2.matrixElements[k][j];  
				}
			}
		}
		return new SquareMatrix(sm3);
	}
	
	/** Non-Static methods:*/
	
	SquareMatrix add(SquareMatrix sm1) throws Exception{
		return add(this, sm1);
	}
	
	SquareMatrix subtract(SquareMatrix sm1) throws Exception{
		return subtract(this, sm1);
	}
	
	SquareMatrix multiply(SquareMatrix sm1) throws Exception{
		return multiply(this, sm1);
	}
	
}
