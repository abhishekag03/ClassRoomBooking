 // Authors:
 // 1) Abhishek Agarwal
 // 2) Lakshya Bansal


package Main;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
/**
 * A class which contains objects having information about a request
 * @author Lenovo
 */
public class Requests implements Serializable {

    private String roomNumber;
    private String date;
    private String status;
    private String startTime, endTime;
    private String reason;
    private String userType;
    private User user;
    private Date BookingDate;
    private int day;
    
    public Requests(String date, String startTime, String endTime, String reason, String userType, String roomNumber) {
        this.roomNumber = roomNumber;
        this.date = date;
        this.status = "Pending";
        this.startTime = startTime;
        this.endTime = endTime;
        this.userType = userType;
        this.reason = reason;
        Calendar cal = Calendar.getInstance();
        this.BookingDate = cal.getTime();
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }
    
    public Date getBookingDate(){
        return BookingDate;
    }
    public User getUser() {
        return user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setStatus(String s) {
        this.status = s;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean equals(Requests req) {
        if (date.equals(req.getDate()) && reason.equals(req.getReason()) && userType.equals(req.getUserType()) && startTime.equals(req.startTime) && endTime.equals(req.endTime)) {
//            System.out.println(" Request True");
            return true;

        }
//        System.out.println("Request False");
        return false;
    }

    @Override
    public String toString() {
        return "Requests{" + "roomNumber=" + roomNumber + ", date=" + date + ", status=" + status + ", startTime=" + startTime + ", endTime=" + endTime + ", reason=" + reason + ", userType=" + userType + '}';
//        return "Requests{" + "roomNumber=" + roomNumber + ",reason=" + reason + '}';

    }

//    public String toSring(){
//        return ();
//    }
    public String getRoomNumber() {
        return roomNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setRoomNumber(String RoomNo) {
        this.roomNumber = RoomNo;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static void main(String[] args) {
//        System.out.println("ABHISHEK");
    }
}
