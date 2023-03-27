// Source Code written by Jordan Sanchez in conjunction with Neil Eldaki AND Ahmed Rami
// Source Code written between March 8th and March 12th
// Class that validates all fields needed for an effective Date class, will be integrated inside of Student composite class

package examTwoComposite;

import java.util.*;

public class Date {
	Calendar calendar = Calendar.getInstance();
	private Scanner input = new Scanner(System.in);
	private int month;
	private int day;
	private int year;
	
	public Date(int month, int day, int year) {
		super();
		setMonth(month);
		setYear(year);
		setDay(day);
	} // end Date constructor

	
	public Date() {
		super();
		populateDate();
		
		while(true) {
			// try and catch statement so that program doesn't throw an exception and instead tells the user to set the date correctly
			try{
				setMonth(month);
				setDay(day);
				setYear(year);
				
				break;
			}catch(IllegalArgumentException e) {
				System.out.println("Thats an invalid date! It must not exist or it is too old of a date for you to be alive, "
						+ "please input your DOB correclty \n");
				populateDate();
				continue;
			} // end try-catch statement
			
		}// end while loop
		
		convertMonth(month);
	} // end no field constructor

	// setters and getters
	public int getDay(int month, int year) {	
		
		// if the month is February and its a leap year then return 29 days
		if(month == 2 && isLeapYear(year) == true) 
			return 29;
		else if(month == 2)
			return 28;
		else if(month == 4 || month == 6 || month == 9 || month == 11 ) 
			return 30;
		else
			return 31;
		// end if statement
		
	}
	
	public void setDay(int day) {
		// if day is greater than 1 and less than the designated month amount then set day
		if(day > 1 && day <= getDay(month, year)) {
			this.day = day;
		}else throw new IllegalArgumentException("Please enter a valid day based on your month");
			
	}// end setDay


	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		if(month > 12 || month < 1)
			throw new IllegalArgumentException("Please enter a valid month, between 1 and 12");
		
		else this.month = month;
		
	}// end setMonth

	public static boolean isLeapYear(int year) {
		// returns true if the year is a leap year and false if not
		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
	}// end isLeapYear
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		// setting a variable equals to the current year on the users device
		int currentYear = calendar.get(Calendar.YEAR);
		
		if(currentYear - year >= 110 || currentYear - year < 0)
			throw new IllegalArgumentException("Please enter a valid DOB. Age must be 0 or greater and less than 110");
		else this.year = year;
		
	}// end setYear
	
	// this method will grab an user inputed DOB and validate it
	public void populateDate() {
		boolean going = true;
		String inputDate = "00/00/0000";
		System.out.println("Please input your DOB in the following format: MM/DD/YYYY ");
		
		while(going) {
			
			try {
				inputDate = input.nextLine();
				// separating the string when a forward slash is seen
				String[] dateParts = inputDate.split("/");
				
				
				// parsing all separated parts of the string and setting it to a respective variable
				month = Integer.parseInt(dateParts[0]);
				day = Integer.parseInt(dateParts[1]);
				year = Integer.parseInt(dateParts[2]);
				
				going = false;
			} catch(NumberFormatException e) {
				System.out.println("Please format the date correctly. It must be in the following format: MM/DD/YYYY");
				continue;
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Please format the date correctly. It must be in the following format: MM/DD/YYYY");
				continue;
			}// end try-catch statement
			
		} // end while loop
		
	}// end populateDate
	

	public String convertMonth(int numMonth) {
		String month = "";
		// switch and case statements that set the name of the month based on its respective number
		switch (numMonth) {
		case 1:
			month = "January";
			break;
		case 2:
			month = "February";
			break;
		case 3:
			month = "March";
			break;
		case 4:
			month = "April";
			break;
		case 5:
			month = "May";
			break;
		case 6:
			month = "June";
			break;
		case 7:
			month = "July";
			break;
		case 8:
			month = "August";
			break;
		case 9:
			month = "September";
			break;
		case 10:
			month = "October";
			break;
		case 11:
			month = "November";
			break;
		case 12:
			month = "December";
			break;
		}
		
		return month;
	} // end convertMonth
	
	
	@Override
	public String toString() {
		String modifier = "";
		
		switch (day % 10) {
		case 1:
			modifier = "st";
			break;
		case 2:
			modifier = "nd";
			break;
		case 3:
			modifier = "rd";
			break;
		default:
			modifier = "th";
			break;
		}
		
		return convertMonth(month) + " " + day + modifier + ", " + year;
	}
	
}// End Date class
