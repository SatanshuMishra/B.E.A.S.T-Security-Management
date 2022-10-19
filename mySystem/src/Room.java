public class Room{
	int roomNumber;
	int floor;
	int clearanceLevel;
	
	Room(int roomNumber, int floor, int clearanceLevel){
		this.roomNumber = roomNumber;
		this.floor = floor;
		this.clearanceLevel = clearanceLevel;
	}

	public int getClearanceLevel() {
		return clearanceLevel;
	}

}
