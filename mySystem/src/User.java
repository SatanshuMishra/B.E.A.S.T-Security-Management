import java.util.UUID;

public class User{
	UUID id;
	private String firstName;
	private String lastName;
	private Key key;
	
	User(String firstName, String lastName){
		this.id = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public UUID getId(){
		return id;
	}

	public void setId(UUID id){
		this.id = id;
	}

	public Key getKey(){
		return key;
	}
}
