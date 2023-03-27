// Source Code written by Neil Elkadi in conjunction with Jordan Sanchez AND Ahmed Rami
// Source Code written between March 8th and March 12th

package examTwoComposite;

import java.util.*;

public class Name {
	private String firstName;
	private String middleName;
	private String lastName;
	
	public Name(String firstName, String middleName, String lastName)
	{
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
	}
	
	public Name(String firstName, String lastName)
	{
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	public Name() {
		setFirstName();
		setMiddleName();
		setLastName();
	}
	
	@Override
	public String toString() {
		if (middleName != null && middleName != "")
			return getFirstName() + " " + getMiddleName().toUpperCase().charAt(0) + ". " + getLastName();
		else
			return getFirstName() + " " + getLastName();
	}

	private static Scanner input = new Scanner(System.in);
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName() {
		System.out.print("First name: ");
		setFirstName(input.nextLine());
	}
	
	public void setFirstName(String firstName) {
		firstName = toSentenceCase(firstName);
		
		while (firstName == null) {
			System.out.print("Please use alphabetic characters!: ");
			firstName = input.nextLine();
		}
		
		this.firstName = firstName;
	}
	
//	private static boolean isSentenceCase(String name) {		
//		for (int i = 0; i < name.length(); i++) {
//			if (i == 0 && !Character.isUpperCase(name.charAt(i)))
//				return false;
//			else if (i != 0 && Character.isUpperCase(name.charAt(i)))
//				return false;
//		}
//		
//		return true;
//	}
	
	private static String toSentenceCase(String name) {		
		String result = "";
		
		for (int i = 0; i < name.length(); i++) {
			if (!Character.isAlphabetic(name.charAt(i)))
				return null;
			
			if (i == 0)
				result += Character.toUpperCase(name.charAt(i));
			else
				result += Character.toLowerCase(name.charAt(i));
		}
		
		return result;
	}

	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName() {
		System.out.print("Middle name: ");
		setMiddleName(input.nextLine());
	}
	
	public void setMiddleName(String middleName) {
		middleName = toSentenceCase(middleName);
		
		while (middleName == null) {
			System.out.print("Please enter alphabetic characters only!: ");
			middleName = input.nextLine();
		}
		
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName() {
		System.out.print("Last name: ");
		setLastName(input.nextLine());
	}
	
	public void setLastName(String lastName) {
		lastName = toSentenceCase(lastName);
		
		while (lastName == null) {
			System.out.print("Please enter alphabetic characters only!: ");
			lastName = input.nextLine();
		}

		this.lastName = lastName;
	}
}
