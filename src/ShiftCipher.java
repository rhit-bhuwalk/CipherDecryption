import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShiftCipher {

	public Map<Character, Double> ci;
	ArrayList<Double> dots;
	String message;
	public ShiftCipher(String message) {
		dots = new ArrayList<Double>();
		ci = new HashMap<Character, Double>();
		this.message = message;
		ci.put('a', 0.0);
		ci.put('b', 0.0);
		ci.put('c', 0.0);
		ci.put('d', 0.0);
		ci.put('e', 0.0);
		ci.put('f', 0.0);
		ci.put('g', 0.0);
		ci.put('h', 0.0);
		ci.put('i', 0.0);
		ci.put('j', 0.0);
		ci.put('k', 0.0);
		ci.put('l', 0.0);
		ci.put('m', 0.0);
		ci.put('n', 0.0);
		ci.put('o', 0.0);
		ci.put('p', 0.0);
		ci.put('q', 0.0);
		ci.put('r', 0.0);
		ci.put('s', 0.0);
		ci.put('t', 0.0);
		ci.put('u', 0.0);
		ci.put('v', 0.0);
		ci.put('w', 0.0);
		ci.put('x', 0.0);
		ci.put('y', 0.0);
		ci.put('z', 0.0);	
		
		message = message.toLowerCase();
		
		for(int i=0;i<message.length();i++) {
			char c = message.charAt(i);
			double freq = ci.get(c);
			ci.replace(c, freq+1);
		}
		
		for(char c: ci.keySet()) {
			double freq = ci.get(c);
			ci.replace(c, freq/message.length());
		}	
		
		decipher();
	}
	
	
	public void decipher() {
		FrequencyData f = new FrequencyData();
		Map<Character, Double> frq = FrequencyData.frq;
		
		for(int i=0;i<26;i++)
		{
			dotProduct(frq, i);
		}
		
		int max = 0;
		double maxVal=0;
		for(int i=0;i<26;i++) {
			System.out.println("Product = " + dots.get(i) + "    :    " + "Shift = " + i);
			if(dots.get(i) > maxVal) {
				maxVal = dots.get(i);
				max = i;
			}
		}
		String dec="";
		for(int i=0;i<message.length();i++) {
			int newASCII = ((int)message.charAt(i) - max);
			if(newASCII < 97) {
				newASCII+=26;
			}
			
			dec = dec + "" + (char)newASCII;
		}
		
		System.out.println(dec);
		System.out.println(max);
		
	}


	private void dotProduct(Map<Character, Double> frq, int shift) {
		double val = 0;
		for(char c: ci.keySet()) {
			// example: c = 100, shift = 3 (making it 103 which is e)
			//example 2: x = 120, shift = 5(making it 125 which should go back to 99)
			
			int newASCII = (int)(c+shift);
			if(newASCII>122) 
				newASCII = newASCII-26;
			char s = (char)newASCII;
			
			double v1 = ci.get(s);
			double v2 = frq.get(c);
			val = val + v1*v2;
		}
		dots.add(val);
	}
	
	
	
	
	
}
