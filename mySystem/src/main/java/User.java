
import java.util.UUID;

public class User{
	private UUID id;
	private String firstName;
	private String lastName;
	private Key key;
	private String loginKey = null;

	private  String email;
	
	User(String firstName, String lastName){
		this.id = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	User(UUID id, String firstName, String lastName){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	User(String firstName, String lastName, Key key, String email){
		this.id = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName = lastName;
		this.key = key;
		this.email = email;
	}

	User(UUID id, String firstName, String lastName, Key key, String email){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.key = key;
		this.email = email;
	}

	User(String firstName, String lastName, String loginKey){
		this.id = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginKey = loginKey;
	}

	User(UUID id, String firstName, String lastName, String loginKey){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginKey = loginKey;
	}

	User(UUID id, String firstName, String lastName, Key key, String loginKey, String email){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.key = key;
		this.loginKey = loginKey;
		this.email = email;
	}

		User(String firstName, String lastName, Key key, String loginKey, String email){
		this.id = UUID.randomUUID();
		this.firstName = firstName;
		this.lastName = lastName;
		this.key = key;
		this.loginKey = loginKey;
		this.email = email;
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

	public String getFirstName() {
			return firstName;
	}

	public String getLastName() {
			return lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
}
