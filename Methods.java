package examTwoComposite;

import java.util.*;

public class Methods {
    private static Scanner scanner = new Scanner(System.in);
	private static boolean firstRun = true;
	
	public static void menu(ArrayList<Student> students) {
        int choice = 0;
        do {
        	if (!firstRun)
        		pause();
        	else
        		firstRun = false;
        	
            System.out.println("\n\tMenu:");
            System.out.println("1. Add a student");
            System.out.println("2. Delete a student");
            System.out.println("3. Edit a student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");
            try {
                choice = scanner.nextInt();
                System.out.println();
                switch (choice) {
                    case 1:
                        students.add(new Student());
                        break;
                    case 2:
                    	students = Student.deleteStudent(students);
                        break;
                    case 3:
                    	students = Student.studentEditor(students);
                    case 4:
                        Student.displayStudents(students);
                        break;
                    case 5:
                        System.out.println("Goodbye.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice.");
                scanner.nextLine();
            }
        } while (choice != 5);
        scanner.close();
	}

	public static void pause() {
		scanner.nextLine();
		System.out.println("\nPress enter to continue...");
		scanner.nextLine();
		System.out.println("----------------------------------");
	}
}
