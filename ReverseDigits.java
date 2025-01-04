public class ReverseDigits {
    public static void main(String[] args) {
        int number = 635620069; 
        int reversed = 0;

        while (number != 0) {
            reversed = reversed * 10 + number % 10; 
            number /= 10; 
        }

        System.out.println("Reversed Number: " + reversed);
    }
}