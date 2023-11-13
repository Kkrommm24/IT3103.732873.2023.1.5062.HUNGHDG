package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;
//Example 3: HelloNameDialog.java
public class HelloNameDialog {

	public static void main(String[] args) {
		String result;
		result = JOptionPane.showInputDialog("HungHdg 5062 - Please enter your name");
		JOptionPane.showMessageDialog(null, "Toi la Hoang Duc Gia Hung 5062. Hi " + result + "!");
		System.exit(0);


	}

}
