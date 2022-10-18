import java.util.UUID;

public class Key {
	UUID id;
	int clearanceLevel;
	boolean isSuspended = false;
	
	Key(int clearanceLevel){
		this.id = UUID.randomUUID();
		this.clearanceLevel = clearanceLevel;
	}
	
}
