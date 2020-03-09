package hw1;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TheatreReservationSystem {
    static Scanner input = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<User>();
    static String globalUsername;
    static String takenUsernames[];

    static void menu(){
        boolean exit = false;

        while (exit == false){
            System.out.println("------------------------------");
            System.out.println("Sign [U]p   Sign [I]n   E[X]it");
            System.out.println("------------------------------");
            String choice = input.next();

            if(choice.equals("U")) {
                signUP();
            } else if(choice.equals("I")) {
                signIN();
                transaction();
            } else if(choice.equals("X")) {
                System.out.println("Goodbye.");
                UserManagement.printUsers();
                exit = true;
                System.exit(0);
            } else {
                System.out.println("Not a valid input!");
                continue;
            }
        }

    }

    static void signUP() {
        System.out.print("Enter a username: ");
        String username = input.next();

        // Check to see if the Username is taken or not
        boolean duplicate = users.contains(username);
        while(duplicate == true) {
            System.out.println("That username is taken!");
            System.out.println("Enter a username: ");
            username = input.next();
            duplicate = users.contains(username);
        }

        System.out.print("Enter a Password: ");
        String password = input.next();
        users.add(new User(username,password));
        globalUsername = username;
    }

    static void signIN() {
        boolean validUsername = false;
        boolean correctPassword = false;
        String username, password;

        while(validUsername == false || correctPassword == false) {
            System.out.print("Username: ");
            username = input.next();

            // Check to see if the Username exists
            for(int i = 0; i < users.size(); i++) {
                if(users.get(i).getUsername().equals(username)) {
                    validUsername = true;
                }
            }

            if(validUsername == false) {
                System.out.println(" '" + username + "' username does not exist");
                continue;
            }

            System.out.print("Password: ");
            password = input.next();

            // Traverse through "users" ArrayList to find the user objects with previously input username
            // Once user is found, then check to see if the input Passowrd matches the password in that object
            for(int i = 0; i < users.size(); i++) {
                if(users.get(i).getUsername().equals(username)) {
                    if(users.get(i).getPassword().equals(password)) {
                       System.out.println("Welcome " + users.get(i).getUsername() + "!");
                       correctPassword = true;
                       break;
                    } else {
                        System.out.println("Incorrect Password!");
                        validUsername = false;
                        break;
                    }
                }
            }

        }
    }

    static void transaction() {
        boolean validInput = true;
        while(validInput == true) {
            System.out.println("----------------------------------------");
            System.out.println("[R]eserve    [V]iew    [C]ancel    [O]ut");
            System.out.println("----------------------------------------");
            String choiceT = input.next();

            if(choiceT.equals("R")) {
                Reservation.Reserve(globalUsername);
            } else if (choiceT.equals("V")) {
                view();
            } else if(choiceT.equals("C")) {
                cancel();
            } else if(choiceT.equals("O")) {
                return;
            } else {
                System.out.println("Not a valid input!");
            }
        }
    }

    static void view() {
        File file = new File("/Users/cameronlau/eclipse-workspace/cs151/src/hw1/reservations.txt");
        Scanner viewFile = null;
        try {
            viewFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        String checkForUsername = globalUsername;
        String[] viewUserSeats = null;
        int counter = 0;
        while(viewFile.hasNextLine()) {
            String temp = viewFile.next();
            String[] split = temp.split(",");
            String iterationUsername = split[0];
            if(iterationUsername.equals(checkForUsername)) {
                viewUserSeats[counter] = split[4] + split[5];   //add seat area and seat numbers to array
            }
            counter++;
        }
        viewFile.close();
        System.out.println("Your seats are: " + viewUserSeats);
    }

    static void cancel() {
        int[] decemberDates = Reservation.decemberDates;
        int[] januaryDates = Reservation.januaryDates;
        int month = 0;
        int day, time;


        String[] customerReservations = null;
        File file = new File("/Users/cameronlau/eclipse-workspace/cs151/src/hw1/reservations.txt");
        Scanner viewFile = null;
        try {
            viewFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        String checkForUsername = globalUsername;
        int counter = 0;
        while(viewFile.hasNextLine()) {
            String temp = viewFile.next();
            String[] split = temp.split(",");
            String iterationUsername = split[0];
            if(iterationUsername.equals(checkForUsername)) {
                customerReservations[counter] = split[4] + split[5];   //add seat area and seat numbers to array
            }
        }

        boolean validMonth = false;
        while(validMonth == false) {
            System.out.println("Which month would you like to cancel?");
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
    }


    public static void main(String[] args) {
        menu();
    }

}
