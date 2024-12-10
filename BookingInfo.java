import java.util.Date;

public class BookingInfo implements Comparable<BookingInfo> {
    private String guestName;
    private String email;
    private Date checkIn;
    private Date checkOut;
    private int roomNumber;
    private String roomType;
    private String status;
    

    public BookingInfo(String guestName, String email, Date checkIn, Date checkOut, int roomNumber,String roomType) {
        this.guestName = guestName;
        this.email = email;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomNumber = roomNumber;
        this.status = "Occupied";
        this.roomType = roomType;
        
    }

    // Getters
    public String getGuestName() { 
    	return guestName; 
    	}
    public String getEmail() {
    	return email; 
    	}
    public Date getCheckIn() { 
    	return checkIn; 
    	}
    public Date getCheckOut() { 
    	return checkOut; 
    	}
    public int getRoomNumber() {
    	return roomNumber; 
    	}
    public String getStatus() {
    	return status; 
    	}
    
    public long getDuration() {
    	return checkOut.getTime() - checkIn.getTime();
    }
    public String getRoomType() {
    	return roomType;
    }
    
    @Override
    public int compareTo(BookingInfo other) {
        return Long.compare(this.getDuration(), other.getDuration());
    }
}