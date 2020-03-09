package hw1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ticket {

    // List of seat sections and their full seat availability.
    static int[] mainFloor = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150};
    static int[] mainFloorL = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50};
    static int[] mainFloorR = {51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};
    static int[] mainFloorB = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150};

    static int[] southBal = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50};
    static int[] southBalB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
    static int[] southBalF = {26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50};

    static int[] west = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};
    static int[] east = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};


    /*
     * Method that deals with removing the seats already reserved in the reservations.txt file.
     * This disallows any user from reserving the same seat.
     */
    static void eliminateTakenSeats() throws IOException {
        File file = new File("/Users/cameronlau/eclipse-workspace/cs151/src/hw1/reservations.txt");
        Scanner sc = new Scanner(file);
        if(sc.hasNextLine() == false) {
            ;   // base case where user is the first person to reserve seats
        } else {
            while(sc.hasNextLine()) {
                String line = sc.next();
                String[] splitLine = line.split(",");

                String seatArea = splitLine[4];     // seat area

                // seat numbers, converted from String to Integer
                String[] seatNumbers = splitLine[5].split("-");
                int[] seats = new int[seatNumbers.length];
                for(int i = 0; i < seatNumbers.length; i++) {
                    seats[i] = Integer.parseInt(seatNumbers[i]);
                }

                seatSection(seatArea, seats);
            }
        }
    }

    /*
     * Iterate through seatSection and seatNumbers from reservations.txt
     * and convert the taken seats to 0 to recognize later.
     *
     * @param seatArea: the section of seats
     * @param seats:    an array of the seat numbers
     */
    static void seatSection(String seatArea, int[] seats) {
        int totalNumSeats;
        if(seatArea.equals("mf")) {
            totalNumSeats = 150;
            for(int i = 0; i < seats.length; i++) {
                int tempCheck = seats[i];

                for(int j = 0; j < totalNumSeats; j++) {
                    if(tempCheck == mainFloor[j]) {
                        mainFloor[j] = 0;
                        break;
                    }
                }
            }
        } else if(seatArea.equals("sb")) {
            totalNumSeats = 50;
            for(int i = 0; i < seats.length; i++) {
                int tempCheck = seats[i];

                for(int j = 0; j < totalNumSeats; j++) {
                    if(tempCheck == southBal[j]) {
                        southBal[j] = 0;
                        break;
                    }
                }
            }
        } else if(seatArea.equals("wb")) {
            totalNumSeats = 100;
            for(int i = 0; i < seats.length; i++) {
                int tempCheck = seats[i];

                for(int j = 0; j < totalNumSeats; j++) {
                    if(tempCheck == west[j]) {
                        west[j] = 0;
                        break;
                    }
                }
            }
        } else if(seatArea.equals("eb")) {
            totalNumSeats = 100;
            for(int i = 0; i < seats.length; i++) {
                int tempCheck = seats[i];

                for(int j = 0; j < totalNumSeats; j++) {
                    if(tempCheck == east[j]) {
                        east[j] = 0;
                        break;
                    }
                }
            }
        }
    }
}
