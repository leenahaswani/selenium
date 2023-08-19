package JavaBasics;

import java.util.Scanner;

public class myFirstjavacode {

	public static void main(String[] args) {
		
		Scanner S= new Scanner(System.in);
		System.out.println("Enter the number of seconds to be processed");
		long val=S.nextLong();
		int secs=(int)val%60;
		int val2=(int)val/60;
		int mins=(int)val2%60;
		int hrs=(int)val2/60;
		System.out.println("Its " +hrs +" hrs " +mins +" mins  " +secs +" secs");
		

	}

}
