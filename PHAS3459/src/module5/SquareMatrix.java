package module5;

/** 
 * Square Matrix 
 * **/

import java.lang.reflect.Array;

public class SquareMatrix {

	//Member variables: 
	double[][] matrixElements; 

	//Constructor - throws exception if argument passed isn't in square Matrix form. 
	public SquareMatrix(double[][] elements) throws Exception {
		for(int i = 0; i < elements.length; i++){ 
			if ((elements[i].length == elements.length) == false){
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

	//Creates a unit Matrix of dimensions passed in the argument.
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

	//Checks whether tow matrices have the same elements. 
	public boolean equals(Object obj){
		
	}
	
}
