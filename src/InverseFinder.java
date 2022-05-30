
public class InverseFinder {
	
	public static void inverse(int a, int m) {
		boolean found = false;
		for(int i=1;i<m;i++) {
			
			if((a*i)%m == 1) {
				found = true;
				System.out.println("Multiplicative Inverse of "+ a + " (mod " + m + ") " + "is " + i);
				
			}
			
		}
		if(!found)
			System.out.println("Multiplicative inverse not found");
		
	}
	
	
}
