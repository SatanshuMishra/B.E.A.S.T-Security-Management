# COSC310-Project

### Class Descriptions

**User**: 
The user class contains basic information about a user. It holds attributes such as first name, last name, a unique user id and a unique key.

This class also contains getter and setter methods for the various attributes stored within it. 

**Room**: 
The room class contains basic information about a specific room. It holds attributes such as room number, floor, and the minimum clearance level required to access the room. The room class is used closely with the Access Terminal class to regulate access to the room.

This class also contains getter and setter methods for the for the various attributes stored within it. 

**Key**: 
The key class contains a unique id, a clearance level and a boolean representing the key's functionality (i.e., If the key has been suspended or not). 

Each user will be paired to a key. This key determines the user's access level as the key's clearance level will be compared to the security level of an access terminal before access can be granted/denied.

This class also contains getter and setter methods for the for the various attributes stored within it. 

**App**: 
This is our main class where the code is run. This is where multiple instances of the User and Key class are created, and then assigned to each other.

The objects are then serialized and stored into local files which can be accessed by other classes. This will **eventually** be switched out for a database.

It also contains an instance of the Access Terminal class.

**ManageFramework**: 
This is an interface which is used by the Access Terminal class.

**LoggerClass**:
This class creates a .txt file and logs inputs given to it.

**GUITerminal**:
This class contains the first attempt at making a GUI for our system. it is not complete therefore not used within the demo. 

**AccessTerminal**: 
This is the class where most of our system functionality occurs. A user's key is checked to see if it exists, if it does then it checks if the owner of this key exists by reading it from local file (mentioned in **App**). If the owner exists, then it checks if the owner's key has a security level that is larger than or equal to that of the access terminal. If so, then the person is allowed to enter and a welcome message is provided, along with the hypothetical door being unlocked and then locked following a 5 second delay. In any of the cases that the owner doesnt exist or the key doesnt exist or the key's access level is less than that of the terminal, an error is generated denying access before returning the the original "Enter Key ID: " prompt.

To run the code, App.java is the main file. by running, an output will be produced, for our current demo, each person's key is visible to us and we have to enter it manually. for our system right now, Jon Doe's key is correct and true. if copied and then pasted under the "enter key id" prompt, a message proving that the door has been unlocked will be shown. Jen Doe's key is not detected and therefore will generate an error if the system is asked to let her in. 
