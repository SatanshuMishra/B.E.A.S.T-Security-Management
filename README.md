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

AccessTerminal class: 
