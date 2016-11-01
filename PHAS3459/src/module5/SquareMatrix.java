package module5;

import java.lang.reflect.Array;

public class SquareMatrix {

	//Member variables 
	private double[][] matrixElements; 

	//Constructor - throws exception if argument doesn't form a square Matrix
	public SquareMatrix(double[][] elements) throws Exception {
		for(int i = 0; i < elements.length; i++){ 
			if ((elements[i].length == elements.length) == false){//Tests that a square matrix has been entered
				throw new Exception("Error in SquareMatrix object: Must enter a valid square Matrix");
			}
		}
		matrixElements = elements;
	}
	
	//Presents Square Matrix objects in a readable form
	public String toString(){
		String matstring = "(";//start presentation of matrix with a "("
		for(int row = 0; row < matrixElements.length; row++){
			for(int column = 0; column < matrixElements[row].length; column++){
				if(column < (matrixElements.length - 1)){
					matstring +=  matrixElements[row][column] +"\t"; //Adding a space between 
				}													 //each matrix element. 
				else{ //If the element is the last one in the row, don't add a space at the end. 
					matstring +=  matrixElements[row][column];
				}
			}
			if(row < (matrixElements.length - 1)){
				matstring +=  "\n ";// New line for each row, apart from the final row of matrix. 
			}
			else{ //If the element is the last one in the matrix, close it off with a ")"
				matstring += ")";}
		}
		return matstring;
	}

}
