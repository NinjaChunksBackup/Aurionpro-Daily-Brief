public class ManualArrayBoundsCheck {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        int indexToAccess = 5;

        if (indexToAccess >= 0 && indexToAccess < numbers.length) {
            System.out.println(numbers[indexToAccess]);
        } else {
            System.out.println("Error: Array index is out of bounds.");
        }
    }
}