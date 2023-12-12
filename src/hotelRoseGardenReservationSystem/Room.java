package hotelRoseGardenReservationSystem;

public class Room implements RoseGardenHotel
{
	String roomID;
	String roomAvail; 

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(String roomID, String roomAvail) {
		super();
		this.roomID = roomID;
		this.roomAvail=roomAvail; 
	}

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	
	public String getRoomAvail()
	{
		return roomID; 
	}
	
	public void setRoomAvail(String roomAvail)
	{
		this.roomAvail=roomAvail; 
	}

	@Override
	public String toString() {
		return "Room [roomID=" + roomID + ", roomAvail=" + roomAvail + "]";
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
