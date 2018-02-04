 // Authors:
 // 1) Abhishek Agarwal
 // 2) Lakshya Bansal

package Main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Admin class is a class which extends the user class and it has info of all
 * the Room Booking requests and the current room Bookings
 *
 * @author Lenovo
 */
public class Admin extends User {

    private static ArrayList<Requests> requests;
    private static HashMap<String, Room> roomBookings;

    Admin(String name, String emailId, String password, String type) {
        super(name, emailId, password, type);
        requests = new ArrayList<>();
        roomBookings = new HashMap<>();
    }

    public ArrayList<Requests> getReq() {

        if (requests == null) {
            requests = new ArrayList<>();
        }
        return requests;
    }

    public static void addRequest(Requests req) {
        if (requests == null) {
            requests = new ArrayList<>();
        }
        requests.add(req);
    }

    public static void setList(ArrayList<Requests> arr) {
        requests = arr;
    }
//    @Override
//    public String toString() {
//        return ;
//    }

    /**
     * addBookings method is used to add the default bookings for all the rooms
     * once we have read the CSV file
     *
     * @param timeAndVenue represents time and Venue for the class of a
     * particular course as read from CSV
     * @param i Represents the day of class
     */
    public static void addBookings(String[] timeAndVenue, int i) {                      // i REPRESENTS DAY

        Room room;
        String[] time = timeAndVenue[0].split("-");
        String startTime = time[0];
        String endTime = time[1];
        int startHour = Integer.parseInt((startTime.split(":"))[0]);
        int startMin = Integer.parseInt((startTime.split(":"))[1]);
        int endHour = Integer.parseInt((endTime.split(":"))[0]);
        int endMin = Integer.parseInt((endTime.split(":"))[1]);
        int startIndex;
        int endIndex;

        if (startHour < 8) {
            startIndex = (12 + startHour - 8) * 2;
        } else {
            startIndex = (startHour - 8) * 2;
        }
        if (startMin != 0) {
            startIndex++;
        }

        if (endHour <= 8) {
            endIndex = (12 + endHour - 8) * 2 - 1;
        } else {
            endIndex = (endHour - 8) * 2 - 1;
        }

        if (endMin != 0) {
            endIndex++;
        }

        if (roomBookings == null) {
            roomBookings = new HashMap<>();
        }
        if (roomBookings.get(timeAndVenue[1]) == null) {

            room = new Room(timeAndVenue[1], 50);

            for (int j = startIndex; j <= endIndex; j++) {
                (room.getAvailability())[j][i] = true;
            }
        } else {
            room = roomBookings.get(timeAndVenue[1]);
            for (int j = startIndex; j <= endIndex; j++) {
                (room.getAvailability())[j][i] = true;
            }
        }
        roomBookings.put(timeAndVenue[1], room);

    }

//    public ArrayList<Requests> ViewRequests(){
//
//    }

    @Override
    public void BookRoom(Room room, String startTime, String endTime, int date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CancelRoom(Room room) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
