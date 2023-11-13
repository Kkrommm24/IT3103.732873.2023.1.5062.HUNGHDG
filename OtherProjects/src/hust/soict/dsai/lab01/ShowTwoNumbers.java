package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;
public class ShowTwoNumbers {

	public static void main(String[] args) {
		String strNum1, strNum2;
		String strNotification = "HungHdg - 5062 You've just entered: ";
		
		strNum1 = JOptionPane.showInputDialog(null,
				"HungHdg - 5062 Please input the first number: ", "HungHdg - 5062 Input the first number", 
				JOptionPane.INFORMATION_MESSAGE);
		strNotification += strNum1 + " and ";
		strNum2 = JOptionPane.showInputDialog(null,
				"HungHdg - 5062 Please input the second number: ", "HungHdg - 5062 Input the second number", 
				JOptionPane.INFORMATION_MESSAGE);
		strNotification += strNum2;
		JOptionPane.showMessageDialog(null, strNotification, "HungHdg - 5062 Show two numbers", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);


	}

}
