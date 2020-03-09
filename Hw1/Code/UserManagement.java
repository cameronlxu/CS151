package hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UserManagement {
    static String takenUsernames[];

    // Checks to see if there are existing usernames in users.txt
    static void checkUsers() {
        File file = new File("/Users/cameronlau/eclipse-workspace/cs151/src/hw1/users.txt");
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        String userLine;
        int counter = 0;
        while(input.hasNextLine()) {
            userLine = input.next();
            String[] split = userLine.split(",");
            String usernameInFile = split[0];
            takenUsernames[counter] = usernameInFile;
            counter++;
        }
    }

    // Prints to reservations.txt
    static void printUsers() {
        File file = new File("/Users/cameronlau/eclipse-workspace/cs151/src/hw1/users.txt");
        PrintWriter out = null;
        try {
            out = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        for(int i = 0; i < Reservation.seats.size(); i++) {
            out.print(TheatreReservationSystem.globalUsername + ", " + Reservation.month + ", " + Reservation.day + ", " + Reservation.time + ", " + Reservation.seats.get(i));
        }
        out.close();
    }
}
