 class StringMethodsDemo {
    public static void main(String[] args) {
    
        String example = "Hello, welcome to my world!";

        int index = 7;
        char charAtIndex = example.charAt(index);
        System.out.println("Character at index " + index + ": " + charAtIndex);

        String substring = "welcome";
        boolean containsSubstring = example.contains(substring);
        System.out.println("Does the string contain \"" + substring + "\"? " + containsSubstring);

        String name = "shwet";
        int age = 18 ;
        String formattedString = String.format("Name: %s, Age: %d", name, age);
        System.out.println("Formatted string: " + formattedString);

        int length = example.length();
        System.out.println("Length of the string: " + length);

        String[] words = example.split(" ");
        System.out.println("Words in the string:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
