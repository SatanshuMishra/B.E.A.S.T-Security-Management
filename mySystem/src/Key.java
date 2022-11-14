import java.util.UUID;

public class Key{
	private UUID id;
	private int clearanceLevel;
	private boolean isActive = true;
	
	Key(int clearanceLevel){
		this.id = UUID.randomUUID();
		this.clearanceLevel = clearanceLevel;
	}

	Key(UUID id, int clearanceLevel, boolean isActive){
		this.id = id;
		this.clearanceLevel = clearanceLevel;
		this.isActive = isActive;
	}

		Key(int clearanceLevel, boolean isActive){
		this.id = UUID.randomUUID();
		this.clearanceLevel = clearanceLevel;
		this.isActive = isActive;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getClearanceLevel() {
		return clearanceLevel;
	}

	public void setClearanceLevel(int clearanceLevel) {
		this.clearanceLevel = clearanceLevel;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
