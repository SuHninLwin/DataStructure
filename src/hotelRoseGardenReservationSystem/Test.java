package hotelRoseGardenReservationSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Test 
{	
	Room rooms;
	private static List<Room> room = new ArrayList<Room>(); 
	private static List<Booking> booking = new ArrayList<Booking>(); 
	private ArrayList<Customer>customer= new ArrayList<Customer>();
	
	static Scanner sc= new Scanner(System.in);
	
	static void showBooking()
	{
		//System.out.println("Booking in Rose Garden Hotel: "+ booking);
		
		for (Iterator iterator = booking.iterator(); iterator.hasNext();)
		{
			Booking booking = (Booking) iterator.next();
			System.out.println(booking);	
		}
	}
	
	static void showRoom()
	{
		for (Iterator iterator = room.iterator(); iterator.hasNext();)
		{
			Room room = (Room) iterator.next();
			System.out.println(room);	
		}
	}
	
	void addBooking()
	{
		Scanner sc= new Scanner (System.in);
		boolean bid = false;
		boolean cid = false;
		boolean rid = false;
		
		showRoom();
		System.out.println();
		
		showBooking();
		System.out.println();
		
		System.out.println("Adding Booking!");
		
		System.out.println("Enter booking ID");
		System.out.println("Enter here >> ");
		String bookingID = sc.nextLine();
		while (!bid)
		{
			try 
			{
				if(checkBookingID(bookingID))
				{
					bid=true; 
				}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				break;
			}
		}
		
		System.out.println("Enter booking date");
		System.out.println("Enter here >> ");
		String bookingdate = sc.nextLine();
		
		System.out.println("Enter customer ID >> "); 
		String customerid =sc.nextLine();
		while(!cid)
		{
			try 
			{
				if(checkCustomerID(customerid))
				{
					cid=true;
				}
			}
			catch(Exception exception)
			{
				System.out.println(exception.getMessage());
				break;
			}
		}
		
		System.out.println("Enter customer name >> "); 
		String customername =sc.nextLine();
		System.out.println("Enter customer NRC >> ");
		String customernrc = sc.nextLine();
		Customer cus = new Customer(customerid, customername, customernrc);
		
		System.out.println("Enter room ID");
		System.out.println("Enter here >> ");
		String roomid = sc.nextLine();
		while(!rid)
		{
			try 
			{
				if(checkRoomID(roomid))
					
				{
					rid = true; 
					
					for(Room room: room)
					{
						if(room.roomID.equals(roomid) && room.roomAvail.equals("Available"))
						{
							Room ro = new Room(roomid, "Unavailable");
							booking.add(new Booking(bookingID, bookingdate, ro, cus));
							
							//System.out.println("You've added: "+ booking);
							
							for (Iterator iterator = booking.iterator(); iterator.hasNext();)
							{
								Booking booking = (Booking) iterator.next();
								System.out.println(booking);
							}
							break;
						}
					} 
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
				break; 
			}
		}
	}

	void removeBooking()
	{
		int count = 0; 
		Scanner sc= new Scanner (System.in);
		
		showBooking();
		
		System.out.println("Cancelling Booking!");
		
		System.out.println("Enter booking ID");
		System.out.println("Enter here >> ");
		String bookingID = sc.nextLine();
		
		for(Booking book: booking)
		{
			if(book.bookingID.equals(bookingID))
			{
				System.out.println("You are going to remove booking ID - "+bookingID);
				booking.remove(count);
				System.out.println("Booking record delete");
				
				//System.out.println("Left booking: "+booking);
				
				for (Iterator iterator = booking.iterator(); iterator.hasNext();)
				{
					Booking booking = (Booking) iterator.next();
					System.out.println("Booking left"+booking);	
				}
				break; 
			}
			else
			{
				count++;  
			}
		}
	}
	
	void updateBooking()
	{
		int count = 0; 
		Scanner sc= new Scanner (System.in);
		
		showBooking();
		
		System.out.println("Update Booking!");
		
		System.out.println("Enter booking ID");
		System.out.println("Enter here >> ");
		String bookingID = sc.nextLine();
		
		for(Booking book: booking)
		{
			if(book.bookingID.equals(bookingID))
			{
				System.out.println("You are going to update booking ID - "+bookingID);
				
				System.out.println("Enter booking date");
				System.out.println("Enter here >> ");
				String bookingdate = sc.nextLine();
				
				System.out.println("Enter customer ID >> "); 
				String customerid =sc.nextLine();
				System.out.println("Enter customer name >> "); 
				String customername =sc.nextLine();
				System.out.println("Enter customer NRC >> ");
				String customernrc = sc.nextLine();
				Customer cus = new Customer(customerid, customername, customernrc);
				
				System.out.println("Enter room ID");
				System.out.println("Enter here >> ");
				String roomid = sc.nextLine();
				System.out.println("Enter room availability");
				System.out.println("Enter here >> ");
				String roomavail = sc.nextLine();
				Room ro = new Room(roomid, roomavail);
				
				booking.set(count, new Booking(bookingID, bookingdate, ro, cus));
				System.out.println("Booking records updated");
				
				//System.out.println("Booking: "+booking);
				
				for (Iterator iterator = booking.iterator(); iterator.hasNext();)
				{
					Booking booking = (Booking) iterator.next();
					System.out.println("Booking left"+booking);	
				}
				break; 
			}
			else
			{
				count++; 
			}
		}
	}
	
	void searchBooking()
	{
		int count = 0; 
		Scanner sc= new Scanner (System.in);
		
		showBooking();
		
		System.out.println("Searching Booking!");
		
		System.out.println("Enter booking ID");
		System.out.println("Enter here >> ");
		String bookingID = sc.nextLine();
		
		for(Booking book: booking)
		{
			if(book.bookingID.equals(bookingID))
			{
				System.out.println("The "+bookingID+" exists.");
				break; 
			}
			else
			{
				count++; 
			}
		}
	}
	
	public static void binarySearch()
	{
		int first = 0;
		int last = booking.size()-1;
		int mid = 0; 
		
		System.out.println("Enter Booking ID");
		String bid = sc.next(); 
		
		do
		{
			mid = (first + last)/2;
			
			if(bid .compareTo(booking.get(mid).bookingID)<0)
			{
				last = mid - 1;
				mid= (first + last)/2;
			}
			
			else if(bid .compareTo(booking.get(mid).bookingID)>0)
			{
				first = mid + 1;
				mid= (first + last)/2;
			}
			
			else if(booking.get(mid).bookingID.equals(bid))
			{
				System.out.println(bid+" is found.");
				break;
			}
			
			if(first>last)
			{
				System.out.println(bid+" is not found.");
			}
			
		}while(first<=last); 
	}
	
	void quit()
	{
		System.out.println();
		System.out.println("Thank you for trying Rose Garden Hotel Reservation System.");
		System.out.println();
		System.out.println();
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("www.RoseGardenHotelMM.com <-- Contact Me --> rosegardenhotel.myanmar@gmail.com");
		System.out.println("------------------------------------------------------------------------------");
		System.exit(0);
	}
	
	public static boolean checkBookingID(String bookingID) throws Exception 
	{
		if(Pattern.matches("bookingID-[0-9]{1}", bookingID))
		{
			return true; 
		}
		else
		{
			throw new Exception("Your room ID format should be bookingID-[0-9].");
		}
	}
	
	public static boolean checkCustomerID(String customerID) throws Exception 
	{
		if(Pattern.matches("customerID-[0-9]{1}", customerID))
		{
			return true; 
		}
		else
		{
			throw new Exception("Your customer ID format should be customerID-[0-9].");
		}
	}
	
	public static boolean checkRoomID(String roomID) throws Exception
	{
		if(Pattern.matches("SingleR-\\d{3}", roomID)||Pattern.matches("KingR-[1-9]{3}", roomID)||Pattern.matches("QueenR-[1-9]{3}", roomID))
		{
			return true;
		}
		else
		{
			throw new Exception("Please enter room ID that only belongs to Rose Garden Hotel.");
		}
	}
	
	public static long bytes(long bytes)
	{
		return bytes; 
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		long total = 0;
		
		Customer cus1 = new Customer("customerID-1", "Susan", "12/TMN(N)454681");
		Room ro1 = new Room("SingleR-100", "Unavailable");
		
		Customer cus2 = new Customer("customerID-2", "Cindy", "12/TMN(N)546867");
		Room ro2 = new Room("SingleR-101", "Unavailable");
		
		Customer cus3 = new Customer("customerID-3", "Micky", "12/TMN(N)546867");
		Room ro3 = new Room("SingleR-102", "Unavailable");
		
		Customer cus4 = new Customer("customerID-4", "Sympathy", "12/TMN(N)876867");
		Room ro4 = new Room("SingleR-103", "Unavailable");
		
		Customer cus5 = new Customer("customerID-5", "Lion", "12/TMN(N)542367");
		Room ro5 = new Room("SingleR-104", "Unavailable");
		
		booking.add(new Booking("bookingID-1", "2/2/2020", ro1, cus1));
		booking.add(new Booking("bookingID-2", "10/6/2020", ro2, cus2));
		booking.add(new Booking("bookingID-3", "12/8/2020", ro3, cus3));
		booking.add(new Booking("bookingID-4", "18/5/2020", ro4, cus4));
		booking.add(new Booking("bookingID-5", "15/12/2020", ro5, cus5));
		
		room.add(new Room("SingleR-100","Unavailable")); 
		room.add(new Room("SingleR-101","Unavailable"));
		room.add(new Room("SingleR-102","Unavailable"));
		room.add(new Room("SingleR-103","Unavailable"));
		room.add(new Room("SingleR-104","Unavailable"));
		room.add(new Room("SingleR-105","Available"));
		
		room.add(new Room("KingR-106","Available"));
		room.add(new Room("KingR-107","Available"));
		
		room.add(new Room("QueenR-108","Available"));
		room.add(new Room("QueenR-109","Available"));
		
		
		
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("|                        WELCOME TO ROSE GARDEN HOTEL                        |");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();
		
		Test test = new Test(); 
		
		String confirm;
		
		do 
		{	
			System.out.println("Sign in and get more functions! \nAdmin access --> secret key");
			Scanner enter= new Scanner(System.in);
			System.out.print("Enter here >> ");
			String entry=enter.nextLine(); 
			
			System.out.println("Your name is "+entry+".");
			
			if(entry.equalsIgnoreCase("admin123"))
			{
				System.out.println();
				System.out.println("Assess available. Welcome our dear customers!");
				System.out.println();
				System.out.println("Choose a function: ");
				System.out.println();
				
				System.out.println("1 --> Show booking list");
				System.out.println("2 --> Adding booking");
				System.out.println("3 --> Cancelling booking");
				System.out.println("4 --> Updating booking");
				System.out.println("5 --> Search booking");
				System.out.println("6 --> Searching bookingID by Binary Search");
				System.out.println("7 --> Exit");
				System.out.println();
				System.out.print("Enter here >> ");
				
				int option= sc.nextInt();
				System.out.println("You choose "+option);
				
				if(option == 1)
				{ 
					test.showBooking();
				}
				if(option == 2)
				{
					test.addBooking();
				}
				if(option == 3)
				{
					test.removeBooking();
				}
				if(option == 4)
				{
					test.updateBooking();
				}
				if(option == 5)
				{
					test.searchBooking();
				}
				if(option == 6)
				{
					test.binarySearch();
				}
				if(option == 7)
				{
					test.quit(); 
				}
			}
			else
			{
				System.out.println("Thank you for using Rose Garden Hotel Reservation system.");
			}
			System.out.println();
			System.out.println("Again to function? Enter 'yes' for next time.");
			confirm = sc.next();
			
		} while (confirm.equalsIgnoreCase("yes"));
		long stopTime = System.currentTimeMillis();
		long proceedTime = stopTime - startTime;
		
		System.out.println();
		System.out.println("TIME COMPLEXITY IN MILLISECOND");
		System.out.println("-----------------------------");
		System.out.println();
		System.out.println("Start Time = "+ startTime + "ms");
		System.out.println("Proceed Time = "+ proceedTime + "ms");
		System.out.println("Stop Time = "+ stopTime + "ms");
		
		System.out.println();
		
		Runtime runtime=Runtime.getRuntime();
		runtime.gc();  
		
		long totalmemory=runtime.totalMemory();
		long freememory=runtime.freeMemory();
		
		System.out.println();
		System.out.println("MEMORY SPACE IN BYTES");
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Total memory: "+totalmemory);
		System.out.println("Used memory: "+bytes(totalmemory-freememory));
		System.out.print("Free memory: "+freememory);
		System.out.println("\n");
	}
}
