package beastSystem;
import java.util.UUID;

public class Key {
	UUID id;
	int clearanceLevel;
	boolean isWorking = true;
	
	Key(int clearanceLevel){
		this.id = UUID.randomUUID();
		this.clearanceLevel = clearanceLevel;
	}
	
}
