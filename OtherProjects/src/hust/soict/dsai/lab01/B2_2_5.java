package hust.soict.dsai.lab01;
import javax.swing.*;

public class B2_2_5 {
    public static void main(String[] args){
        String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog(null,
                "HungHDG - 5062 Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null,
                "HungHDG - 5062 Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        
        JOptionPane.showMessageDialog(null, num1 + num2 , "HungHDG - 5062 Sum of two number:",
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, num1 - num2 , "HungHDG - 5062 Difference of two number:",
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, num1 * num2 , "HungHDG - 5062 Product of two number:",
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, num1 / num2 , "HungHDG - 5062 Quotient of two number:",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}