// Source Code written by Neil Elkadi in conjunction with Jordan Sanchez AND Ahmed Rami
// Source Code written between March 8th and March 12th

package examTwoComposite;

import java.util.*;

public class Student {
	private Name name;
	private Date dob;
	private float gpa;
	private int credits;

	public Student(Name name) {
		setName(name);
	}

	public Student() {
		setName(new Name());
		setDob();
		setGpa();
		setCredits();
	}

	@Override
	public String toString() {
		return getName().toString() + "\n---\n" + "Date of Birth: " + getDob() + "\n" + "GPA: " + getGpa()
				+ "\n" + "Credits: " + getCredits();
	}

	private static Scanner input = new Scanner(System.in);

	public static void displayStudents(ArrayList<Student> list) {
		if (list.size() == 0)
			System.out.println("There are currently no people being stored...");
		else
			for (Student person : list)
				System.out.println(person.toString() + "\n");
	}

	public static ArrayList<Student> deleteStudent(ArrayList<Student> list) {
		System.out.print("Enter index of student to delete: ");
		try {
			int index = input.nextInt();
			if (index < 0 || index >= list.size()) {
				System.out.println("Invalid index.");
			} else {
				list.remove(index);
				System.out.println("Student deleted.");
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid index.");
			input.nextLine();
		}

		return list;
	}

	public static ArrayList<Student> studentEditor(ArrayList<Student> list) {
		int count = 0;

		for (Student person : list)
			System.out.println(count++ + " - " + person.getName().toString());

		System.out.print("Please select which person you'd like to edit by index: ");

		int index = -1;
		boolean flag = true;

		do {
			try {
				index = input.nextInt();
			} catch (InputMismatchException error) {
				System.out.println("Please input an integer!");
			}

			flag = index < 0 || index > count;

			if (flag)
				System.out.println("Your value is invalid. Please try again: ");
		} while (flag);

		input.nextLine();

		list.set(index, editOptions(list.get(index)));

		return list;
	}

	private static Student editOptions(Student person) {
		System.out.println("\n--------------------\n");
		System.out.println("[F]irst name\n[M]iddle name\n[L]ast name\n[D]ate of birth\n[G]pa\n[C]redits");
		System.out.print("Please select what you would like to edit: ");

		char option = input.nextLine().toLowerCase().charAt(0);

		switch (option) {
			case 'f':
				person.getName().setFirstName();
				break;
			case 'm':
				person.getName().setMiddleName();
				break;
			case 'l':
				person.getName().setLastName();
				break;
			case 'd':
				person.setDob();
				break;
			case 'g':
				person.setGpa();
				break;
			case 'c':
				person.setCredits();
				break;
		}

		return person;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob() {
		this.dob = new Date();
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa() {
		System.out.print("Please input an gpa: ");
		boolean invalid = true;
		while (invalid) {
			try {
				setGpa(input.nextFloat());
				invalid = false;
			} catch (InputMismatchException error) {
				System.out.print("Please enter a float!: ");
			}
		}
	}

	public void setGpa(float gpa) {
		while (gpa < 0 || gpa > 5) {
			System.out.println(
					"That is an invalid value for the GPA. Please input a number greater than 0 and less than 5: ");
			try {
				gpa = input.nextFloat();
			} catch (InputMismatchException error) {
				System.out.println("Please enter an integer!");
			}
		}

		this.gpa = gpa;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits() {
		System.out.print("Please input the number of credits: ");
		boolean invalid = true;
		while (invalid) {
			try {
				setCredits(input.nextInt());
				invalid = false;
			} catch (InputMismatchException error) {
				System.out.print("Please input a double!: ");
			}
		}

	}

	public void setCredits(int credits) {
		while (credits < 0 || credits > 200) {
			System.out.print("The credits value must be between 0 and 200: ");

			try {
				credits = input.nextInt();
			} catch (InputMismatchException error) {
				System.out.println("Pleaase input a double!");
			}
		}

		this.credits = credits;
	}
}