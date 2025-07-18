public class ManualArithmeticCheck {
    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;

        if (denominator == 0) {
            System.out.println("Error: Cannot divide by zero.");
        } else {
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        }
    }
}