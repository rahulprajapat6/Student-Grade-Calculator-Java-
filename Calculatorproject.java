import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculatorproject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Student Grade Calculator");

        try {
            System.out.print("Enter student name: ");
            String name = sc.nextLine().trim();

            int subjects = 0;
            while (subjects <= 0) {
                System.out.print("How many subjects? ");
                subjects = sc.nextInt();
                if (subjects <= 0) {
                    System.out.println("Please enter a positive integer for number of subjects.");
                }
            }

            double total = 0.0;
            boolean anyFailSubject = false;
            double[] marks = new double[subjects];

            for (int i = 0; i < subjects; i++) {
                double m = -1;
                while (m < 0 || m > 100) {
                    System.out.print("Enter marks for subject " + (i + 1) + " (0-100): ");
                    m = sc.nextDouble();
                    if (m < 0 || m > 100) {
                        System.out.println("Please enter a value between 0 and 100.");
                    }
                }
                marks[i] = m;
                total += m;
                if (m < 33) anyFailSubject = true;
            }

            double percentage = total / subjects;

            System.out.println();
            System.out.println("Result for: " + (name.isEmpty() ? "<Unnamed Student>" : name));
            System.out.printf("Total: %.2f / %.0f\n", total, subjects * 100.0);
            System.out.printf("Percentage: %.2f%%\n", percentage);

            if (anyFailSubject) {
                System.out.println("Grade: F (Failed at least one subject)");
            } else {
                String grade = calculateGrade(percentage);
                System.out.println("Grade: " + grade);
            }

        } catch (InputMismatchException ime) {
            System.out.println("Invalid input. Please enter numeric values for marks and number of subjects.");
        } finally {
            sc.close();
        }
    }

    private static String calculateGrade(double percentage) {
        if (percentage >= 90) return "A+";
        if (percentage >= 80) return "A";
        if (percentage >= 70) return "B";
        if (percentage >= 60) return "C";
        if (percentage >= 50) return "D";
        return "F";
    }
}
