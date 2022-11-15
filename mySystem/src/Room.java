public class Room{
	private int roomNumber;
	private int floor;
	private int clearanceLevel;
	
	Room(int roomNumber, int floor, int clearanceLevel){
		this.roomNumber = roomNumber;
		this.floor = floor;
		this.clearanceLevel = clearanceLevel;
	}

	public int getClearanceLevel() {
		return clearanceLevel;
	}

	public void setClearanceLevel(int clearanceLevel) {
			this.clearanceLevel = clearanceLevel;
	}

	public int getFloor() {
			return floor;
	}

	public void setFloor(int floor) {
			this.floor = floor;
	}

	public int getRoomNumber() {
			return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
			this.roomNumber = roomNumber;
	}

}
