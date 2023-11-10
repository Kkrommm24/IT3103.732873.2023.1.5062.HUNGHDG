package Lab01;

import javax.swing.JOptionPane;

public class EquationSolving {
    public static void main(String[] args) {
        String choice = JOptionPane.showInputDialog("HungHDG - 5062 Choose an equation type to solve:\n1. "
        		+ "First-degree equation with one variable\n2. "
        		+ "First-degree equations with two variables\n3. "
        		+ "Second-degree equation with one variable");

        if (choice == null || choice.isEmpty()) {
            JOptionPane.showMessageDialog(null, "HungHDG - 5062 Invalid choice. Please enter 1 or 2.");
            return;
        }

        int option = Integer.parseInt(choice);

        if (option == 1) {
            solveLinearEquation();
        } else if (option == 2) {
            solveLinearSystem();
        }else if (option == 3) {
            solveTwoDegree();
        } else {
            JOptionPane.showMessageDialog(null, "HungHDG - 5062 Invalid choice. Please enter 1 or 2.");
        }
    }

    public static void solveLinearEquation() {
        String aStr = JOptionPane.showInputDialog("HungHDG - 5062 Enter the coefficient 'a' (a ≠ 0):");
        String bStr = JOptionPane.showInputDialog("HungHDG - 5062 Enter the constant 'b':");

        double a = Double.parseDouble(aStr);
        double b = Double.parseDouble(bStr);

        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "HungHDG - 5062 Infinite solutions");
            } else {
                JOptionPane.showMessageDialog(null, "HungHDG - 5062 No solutions");
            }
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "HungHDG - 5062 The solution is x = " + x);
        }
    }

    public static void solveLinearSystem() {
        String a11Str = JOptionPane.showInputDialog("HungHDG - 5062 Enter 'a11':");
        String a12Str = JOptionPane.showInputDialog("HungHDG - 5062 Enter 'a12':");
        String b1Str = JOptionPane.showInputDialog("HungHDG - 5062 Enter 'b1':");
        String a21Str = JOptionPane.showInputDialog("HungHDG - 5062 Enter 'a21':");
        String a22Str = JOptionPane.showInputDialog("HungHDG - 5062 Enter 'a22':");
        String b2Str = JOptionPane.showInputDialog("HungHDG - 5062 Enter 'b2':");

        double a11 = Double.parseDouble(a11Str);
        double a12 = Double.parseDouble(a12Str);
        double b1 = Double.parseDouble(b1Str);
        double a21 = Double.parseDouble(a21Str);
        double a22 = Double.parseDouble(a22Str);
        double b2 = Double.parseDouble(b2Str);

        double determinant = a11 * a22 - a12 * a21;
        if (determinant == 0) {
            if (a11 / a21 == a12 / a22 && a11 / a21 == b1 / b2) {
                JOptionPane.showMessageDialog(null, "HungHDG - 5062 Infinite solutions");
            } else {
                JOptionPane.showMessageDialog(null, "HungHDG - 5062 No solution");
            }
        } else {
            double x1 = (b1 * a22 - b2 * a12) / determinant;
            double x2 = (a11 * b2 - a21 * b1) / determinant;
            JOptionPane.showMessageDialog(null, "HungHDG - 5062 The solution is x1 = " + x1 + " and x2 = " + x2);
        }
    }
    public static void solveTwoDegree() {
        String aStr = JOptionPane.showInputDialog("HungHDG - 5062 Enter the coefficient 'a' (a ≠ 0):");
        String bStr = JOptionPane.showInputDialog("HungHDG - 5062 Enter the coefficient 'b':");
        String cStr = JOptionPane.showInputDialog("HungHDG - 5062 Enter the constant 'c':");

        double a = Double.parseDouble(aStr);
        double b = Double.parseDouble(bStr);
        double c = Double.parseDouble(cStr);

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            JOptionPane.showMessageDialog(null, "HungHDG - 5062 The solutions are x1 = " + root1 + " and x2 = " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            JOptionPane.showMessageDialog(null, "HungHDG - 5062 The solution is a repeated root x = " + root);
        } else {
            JOptionPane.showMessageDialog(null, "HungHDG - 5062 No real solutions (discriminant < 0).");
        }
    }
}

