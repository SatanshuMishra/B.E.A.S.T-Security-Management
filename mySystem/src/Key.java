import java.util.UUID;
import java.io.Serializable;

public class Key implements Serializable{
	UUID id;
	int clearanceLevel;
	boolean isSuspended = false;
	
	Key(int clearanceLevel){
		this.id = UUID.randomUUID();
		this.clearanceLevel = clearanceLevel;
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

	public boolean getIsSuspended() {
		return isSuspended;
	}

	public void setSuspended(boolean isSuspended) {
		this.isSuspended = isSuspended;
	}
	
}
