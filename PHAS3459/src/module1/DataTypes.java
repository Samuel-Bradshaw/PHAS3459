package module1;

public class DataTypes {

	public static void main(String[] args) {
		
		double doubVar = 20.0; 
		System.out.println("doubVar = "+doubVar);
		System.out.println("doubVar*doubVar = "+(doubVar*doubVar)); 
		
		float floatVar = 20;
		System.out.println("floatVar = "+floatVar);
		System.out.println("floatVar*floatVar = "+(floatVar*floatVar));
		
		int intVar = 20;
		System.out.println("intVar = "+intVar);
		System.out.println("intVar*intVar = "+(intVar*intVar));
		
		long longVar = 20;
		System.out.println("longVar = "+longVar);
		System.out.println("longVar*longVar = "+longVar*longVar);
		
		byte byteVar = 20;
		System.out.println("byteVar = "+byteVar);
		System.out.println("byteVar*byteVar = "+ byteVar*byteVar);
		
		//mixing a character and an integer
		char charVar = 'a' + 10;
		System.out.println("charVar = "+charVar );
		System.out.println("charVar, defined as char charVar = 'a' + 10,  is another character distict from the character 'a'");
		
		//mixing an integer and a floating point
		System.out.println("floatVar + intVar = "+ (floatVar + intVar));
		System.out.println("Combining a float and an int gives a float");
		
		//mixing a floating point and a byte
		float floatVar2 = 500; 
		System.out.println("floatVar2 = "+ floatVar2);
		System.out.println("floatVar2 + byteVar = "+ (floatVar2 + byteVar));
		System.out.println("Combining a float and a byte gives a float");
		//this is essentially the same result as combining a float and an int. 
		
		//mixing a byte and an integer
		byte byteVar2 = 50; int intVar2 = 500; 
		System.out.println("byteVar2 ="+byteVar2+"; intVar2 ="+intVar2);
		System.out.println("byteVar2 + intVar2 = "+ (byteVar2 + intVar2));
		System.out.println("Combining a byte and an int gives an int as int has a larger possible range of values it can take");
		
		System.out.println("Combining two different data types generally results in the data type that has the greater precision e.g. a combination of a float and int will give a float");
		
		//int j=1; int i; j=i+1;
		//^the above line produces an error message. 
		System.out.println("If a variable has not been initialised (e.g. int j=1; int i; j=i+1), this produces an error message.");
		
		//Narrowing conversion - cast operation
		double x = 12.99; int y;
		y = (int) x; //double to int cast
		System.out.println(y);
		System.out.println("Converting a double to an int rounds it the double down to the next nearest integer.\nThis is an example of a narrowing conversion");
		
		



		
	}

}
