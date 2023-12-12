package hotelRoseGardenReservationSystem;

public class Booking implements RoseGardenHotel
{
	String bookingID;
	String bookingDate;
	Room room;
	Customer customer;
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(String bookingID, String bookingDate, Room room, Customer customer) {
		super();
		this.bookingID = bookingID;
		this.bookingDate = bookingDate;
		this.room = room;
		this.customer = customer;
	}
	public String getBookingID() {
		return bookingID;
	}
	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Booking [bookingID=" + bookingID + ", bookingDate=" + bookingDate + ", room=" + room + ", customer="
				+ customer + "]";
	}
	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void quit() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	} 

	
	
}
