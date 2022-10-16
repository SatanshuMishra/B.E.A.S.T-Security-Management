package beastSystem;
import java.util.UUID;

public class User {
	UUID id;
	String firstName;
	String lastName;
	Key key;
	
	User(String firstName, String lastName){
		this.id = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
