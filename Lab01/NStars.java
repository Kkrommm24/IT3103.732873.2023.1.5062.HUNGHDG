package Lab01;
import javax.swing.JOptionPane;

public class NStars {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("HungHDG - 5062 Enter n: ");
        
        if (input == null) {
            JOptionPane.showMessageDialog(null, "HungHDG - 5062 Canceled.");
            System.exit(0);
        }
        
        int n = Integer.parseInt(input);
        
        int i, j, k;

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        System.exit(0);
    }
}
