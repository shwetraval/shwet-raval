import java.util.Scanner;

class Student {
    String enrollmentNo;
    String name;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student student1 = new Student();
        System.out.print("Enter enrollment number for Student 1: ");
        student1.enrollmentNo = scanner.nextLine();
        System.out.print("Enter name for Student 1: ");
        student1.name = scanner.nextLine();

        Student student2 = new Student();
        System.out.print("Enter enrollment number for Student 2: ");
        student2.enrollmentNo = scanner.nextLine();
        System.out.print("Enter name for Student 2: ");
        student2.name = scanner.nextLine();

        Student student3 = new Student();
        System.out.print("Enter enrollment number for Student 3: ");
        student3.enrollmentNo = scanner.nextLine();
        System.out.print("Enter name for Student 3: ");
        student3.name = scanner.nextLine();

        System.out.println("\nStudent Details:");
        System.out.println(student1.enrollmentNo + " - " + student1.name);
        System.out.println(student2.enrollmentNo + " - " + student2.name);
        System.out.println(student3.enrollmentNo + " - " + student3.name);

        scanner.close();
    }
}