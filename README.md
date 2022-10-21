# COSC310-Project

User class: 
the user class contains the basic information about a user, such as their first name, last name, a randomised ID and a unique key. 
this class also has getter and setter methods for the user. 

Room class: 
the room class contains basic information about the room. it contains getter and setter methods for the room class. 

Key class: 
the key class contains a unique ID, a clearance level and a boolean noting if the key has been suspended. each user will be paired to a key, and their key is what 
determines their access levels as the key's access level will be compared to the security level. it also contains setters and getters

App class: 
this is the main class where the code is run. it has multiple instances of users, keys, and matching the keys to users and an instace of an access
terminal. it also contains the serialization of users and keys, which is our way of approaching the database structure we wanted. this will eventually
be converted into an actual database

ManageFramework class: 
this is an interface which is used by the AccessTerminal class

LoggerClass class:
class that creates a .txt file and logs that a door was unlocked and locked

GUITerminal class:
this class contains the first attempt at making a GUI for our system. it is not complete therefore not used within the demo. 

AccessTerminal class: 
this is the class where most of our system functionality occurs. a user's key is checked to see if it exists, if it does then it checks if the owner of this key
exists by reading it from a text file. if the owner exists, then it checks if the owner's key has a security level that is larger than or equal to that of the 
access terminal. if so, then the person is allowed to enter and a welcome message is provided, along with the hypothetical door opening and then closing after 
a 5 second delay. in any of the cases that the owner doesnt exist or the key doesnt exist or the key's access level is less than that of the terminal, 
an error is generated asking the user of the system to try and enter a different key to try again. if there are multiple failed attempts,
the system generates an access denied message and the user of the system can no longer try again

to run the code, App.java is the main file. by running, an output will be produced, for our current demo, each person's key is visible to us and we have to 
enter it manually. for our system right now, Jon Doe's key is correct and true. if copied and then pasted under the "enter key id" prompt, a message proving that 
the door has been unlocked will be shown. Jen Doe's key is not detected and therefore will generate an error if the system is asked to let her in. 
