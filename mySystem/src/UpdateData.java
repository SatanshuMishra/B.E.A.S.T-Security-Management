public class UpdateData {
String userId, keyId, firstName, lastName, loginKey; 
boolean isActive;
int clearanceLevel;

UpdateData(String userId, String keyId, String firstName, String lastName, String loginKey, boolean isActive, int clearanceLevel){
  this.userId = userId;
  this.keyId = keyId;
  this.firstName = firstName;
  this.lastName = lastName;
  this.loginKey = loginKey;
  this.isActive = isActive;
  this.clearanceLevel = clearanceLevel;
}
}
