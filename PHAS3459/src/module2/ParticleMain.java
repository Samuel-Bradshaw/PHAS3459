package module2;

public class ParticleMain {

	public static void main(String[] args) {
		FallingParticle fp1 = new FallingParticle(6.3, 4.1);
		
		double zinit = 8; //setting the starting height
		double vinit = 0; //setting the starting velocity of particle
		
		System.out.println("Falling particle with mass m = "+fp1.m+"kg, drag coefficient d = "+fp1.d+"kg/m,\n"
				+ "from initial height h = "+zinit+"m, with starting velocity u = "+vinit+"m/s. \n");
		
		fp1.setZ(zinit);
		fp1.setV(vinit);
		double t05 = fp1.drop(0.5);
		System.out.println("Time taken to reach ground with time steps of 0.5s: "+t05+"s");
		
		fp1.setZ(zinit);
		fp1.setV(vinit);
		double t01 = fp1.drop(0.1);
		System.out.println("Time taken to reach ground with time steps of 0.1s: "+t01+"s");
		
		fp1.setZ(zinit);
		fp1.setV(vinit);
		double t001 = fp1.drop(0.01);
		System.out.println("Time taken to reach ground with time steps of 0.01s: "+t001+"s");
		
		fp1.setZ(zinit);
		fp1.setV(vinit);
		double t0001 = fp1.drop(0.001);
		System.out.println("Time taken to reach ground with time steps of 0.001s: "+t0001+"s");
		
		fp1.setZ(zinit);
		fp1.setV(vinit);
		double t00001 = fp1.drop(0.0001);
		System.out.println("Time taken to reach ground with time steps of 0.0001s: "+t00001+"s");
		
		System.out.println("\nAs the time steps fed into the algorithm become smaller, the output for time taken \nfor the particle "
				+ "to hit the ground becomes more accurate. \nThis is because the algorithm checks-in with the particle more often and "
				+ "hence \ngives a more accurate reading of when the particle has hit the ground.");
		
		
		
		
		

	}

}
