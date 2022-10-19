import java.util.UUID;
import java.io.Serializable;

public class User implements Serializable{
	private UUID id;
	private String firstName;
	private String lastName;
	private Key key;
	private String loginKey;
	
	User(String firstName, String lastName){
		this.id = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	User(String firstName, String lastName, String loginKey){
		this.id = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginKey = loginKey;
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

	public void setKey(Key key){
		this.key = key;
	}

	public String getName(){
		return String.format("%s %s", firstName, lastName);
	}

	public void setLoginKey(String loginKey) {
		this.loginKey = loginKey;
	}
	
	public String getLoginKey() {
		return loginKey;
	}


}
