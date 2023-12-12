package hotelRoseGardenReservationSystem;

public class Customer 
{
	String customerID;
	String customerName;
	String customerNRC;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerID, String customerName, String customerNRC) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerNRC = customerNRC;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNRC() {
		return customerNRC;
	}

	public void setCustomerNRC(String customerNRC) {
		this.customerNRC = customerNRC;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerNRC=" + customerNRC
				+ "]";
	} 
	
	
}
