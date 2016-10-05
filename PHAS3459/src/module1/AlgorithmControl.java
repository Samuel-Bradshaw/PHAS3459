package module1;

public class AlgorithmControl {
	
	void loop (int i, int j) {
		for (System.out.println(i) ; i <= j; i = i + 1);
	}

	public static void main(String[] args) {
		
		//Using a for loop to print integers from 1 to 20
		int i;
		for (i = 1; i < 21; i = i + 1)
		{System.out.println(i);}
		
		//Using a while loop to print integers between 8 to -10
		int j = 8;
		while (j > -11) {
			System.out.println(j);
			j = j-1;
		}

	}

}
