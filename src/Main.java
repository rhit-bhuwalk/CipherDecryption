import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
			
			System.out.println("Welcome to the classical cipher decryption API.");
			System.out.println("Enter I if you want to find the modular multiplicative inverse of two numbers");
			System.out.println("Enter S if you want to decode a message using a shift cipher");
			System.out.println("Enter A if you want to encrypt a message using an AES cipher");
			String input = s.nextLine();
			
			
			if(input.equals("I")) {
				System.out.println("Enter 1st number");
				int num = s.nextInt();
				System.out.println("Enter mod");
				int mod = s.nextInt();
				InverseFinder i = new InverseFinder();
				i.inverse(num, mod);
				System.out.println("Thank you!");
			}
		
		else if(input.equals("S")) {
				System.out.println("Enter message");
				String message = s.next();
				ShiftCipher c = new ShiftCipher(message);
				System.out.println("Thank you");
		}
			
		else 
				System.out.println("Wrong input, please try again");
		
		}
	}

