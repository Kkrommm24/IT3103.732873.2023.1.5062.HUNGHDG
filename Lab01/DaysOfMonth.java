package Lab01;
import javax.swing.JOptionPane;

public class DaysOfMonth {
    public static void main(String[] args) {
        while (true) {
            String yearInput = JOptionPane.showInputDialog("HungHDG - 5062 Enter a year (non-negative number with all digits):");

            if (yearInput == null) {
                JOptionPane.showMessageDialog(null, "HungHDG - 5062 Input canceled.");
                System.exit(0);
            }

            int year;
            try {
                year = Integer.parseInt(yearInput);
                if (year < 0) {
                    JOptionPane.showMessageDialog(null, "HungHDG - 5062 Please enter a non-negative year.");
                    continue;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "HungHDG - 5062 Invalid year input. Please enter a valid year.");
                continue;
            }

            boolean validMonthEntered = false;
            int month = 0;

            while (!validMonthEntered) {
                String monthInput = JOptionPane.showInputDialog("HungHDG - 5062 Enter a month (example: january, jan., jan, 1):")
                        .toLowerCase();

                switch (monthInput) {
                    case "january":
                    case "jan.":
                    case "jan":
                    case "1":
                        month = 1;
                        break;
                    case "february":
                    case "feb.":
                    case "feb":
                    case "2":
                        month = 2;
                        break;
                    case "march":
                    case "mar.":
                    case "mar":
                    case "3":
                        month = 3;
                        break;
                    case "april":
                    case "apr.":
                    case "apr":
                    case "4":
                        month = 4;
                        break;
                    case "may":
                    case "5":
                        month = 5;
                        break;
                    case "june":
                    case "jun":
                    case "6":
                        month = 6;
                        break;
                    case "july":
                    case "jul":
                    case "7":
                        month = 7;
                        break;
                    case "august":
                    case "aug.":
                    case "aug":
                    case "8":
                        month = 8;
                        break;
                    case "september":
                    case "sept.":
                    case "sep":
                    case "9":
                        month = 9;
                        break;
                    case "october":
                    case "oct.":
                    case "oct":
                    case "10":
                        month = 10;
                        break;
                    case "november":
                    case "nov.":
                    case "nov":
                    case "11":
                        month = 11;
                        break;
                    case "december":
                    case "dec.":
                    case "dec":
                    case "12":
                        month = 12;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid month. Enter again.");
                        continue;
                }

                validMonthEntered = true;
            }

            int days = getDaysInMonth(month, year);
            JOptionPane.showMessageDialog(null, "Number of days: " + days);
            break;
        }
    }

    private static int getDaysInMonth(int month, int year) {
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
