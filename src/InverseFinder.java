
public class InverseFinder {
	
	public static void inverse(int a, int m) {
		
		for(int i=1;i<m;i++) {
			
			if((a*i)%m == 1)
				System.out.println(i);
		}
		System.out.println("not found");
		
	}
	
	
}
