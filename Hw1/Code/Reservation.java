package hw1;

import java.util.ArrayList;
import java.util.Scanner;

public class Reservation {
    static Scanner input = new Scanner(System.in);
    static String[] allSeats;
    static int decemberDates[] = {23,24,25,26,27,28,29,30,31};
    static int januaryDates[] = {1,2};
    static int time, day, month;
    public static ArrayList<Integer> seats = new ArrayList<Integer>();

    static void whichShow(String globalUsername) {
        // Get a valid month from user
        boolean validMonth = false;
        while(validMonth == false) {
            System.out.println("Which month would you like to see the show in?");
            month = input.nextInt();
            if(month == 1 || month == 12) {
                validMonth = true;
            } else {
                System.out.println(">>> We do not offer shows in this month.");
            }
        }

        String monthString;
        if(month == 1) {
            monthString = "January";
        } else {
            monthString = "December";
        }


        // Get a valid day from user
        boolean dayCheck = false;
        while(dayCheck == false) {
            System.out.println("Which day in " + monthString + "?");
            day = input.nextInt();
            if(month == 1) {
                for(int i = 0; i < januaryDates.length; i++) {
                    if(day == januaryDates[i]) {
                        dayCheck = true;
                    }
                }
            } else if(month == 12) {
                for(int i = 0; i < decemberDates.length; i++) {
                    if(day == decemberDates[i]) {
                        dayCheck = true;
                    }
                }
            }

            if(dayCheck == false) {
                System.out.println(">>> We do not offer the show at this day.");
                continue;
            }
        }


        // Get a valid time from user
        boolean validTime = false;
        while(validTime == false) {
            System.out.println("Which time? (630 or 830)");
            time = input.nextInt();
            if(time == 630 || time == 830) {
                validTime = true;
            } else {
                System.out.println(">>> We only offer 630 and 830 times.");
                continue;
            }
        }

        pickSeat();
    }


    static void pickSeat() {
        System.out.println("Enter tickets separated by spaces (mf1-mf150, sb1-sb50, wb1-wb100, eb1-eb100)");
        String selection = input.next();
        boolean multipleSeats = false;
        boolean differentSections = false;
        String seatSection = selection.substring(0, 2);

        // Check for multiple seats by checking for "-"
        // Check for different sections by checking for a space " "
        for(int i = 0; i < selection.length()+1; i++) {
            String temp = selection.substring(i, i+1);
            if(temp == "-") {
                multipleSeats = true;
            }

            if(temp == " ") {
                differentSections = true;
            }
        }

        String[] theSeats;
        // If there is one seat requested to add, collect that number,
        // else add the multple seats requested to an array.
        if(multipleSeats == false) {
            seats.add(Integer.parseInt(selection));
        }

    }


    static void Reserve(String globalUsername) {
        whichShow(globalUsername);
    }
}
