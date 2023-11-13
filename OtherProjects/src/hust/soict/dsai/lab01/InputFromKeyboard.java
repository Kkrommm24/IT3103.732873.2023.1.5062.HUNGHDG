package hust.soict.dsai.lab01;
import java.util.Scanner;
public class InputFromKeyboard {
     public static void main(String args[]) {
    	 Scanner keyboard = new Scanner(System.in);
    	 
    	 System.out.println("HungHDG - 5062 What's your name?");
    	 String strName = keyboard.nextLine();
    	 System.out.println("HungHDG - 5062 How old are you?");
    	 int iAge = keyboard.nextInt();
    	 System.out.println("HungHDG - 5062 How tall are you (m)?");
    	 double dHeight = keyboard.nextDouble();
    	 
    	 System.out.println("HungHDG - 5062 Mrs/Ms. "+ strName + ", " + iAge + " years old. "
    			 + "Your height is " + dHeight +".");
		
     }
}
