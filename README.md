# Best Easy Access System with Tracking (B.E.A.S.T)
## System Objectives
1. To provide a security and management framework for critical infrastructure (i.e., Buildings)
2. To provide administrative tools to restrict access or guard and tackle security breaches.

## Important Terminology
In order to properly understand our system, it is important to understand what certain terminologies may mean in the context of our server:
1. **Clearance Level**: This is the value assigned to a specific user via a key. This value dictates the access any particular user may have within the building and/or system. Our system has 7 distinct clearance levels.
2. **Privileged User**: This is a user with a clearance level >= 5.
3. **Security Level**: This is value assigned to a specific Access Terminal. In order for an Access Terminal to grant access, the clearance level of the user requesting access must be >= the Security level of the Access Terminal.
4. **Access Terminal**: This is the terminal present at every **entry point** within the hypothetical critical infrastructure our system has been implemented in. The only functionality of this type of terminal is to grant/deny access for a user. (Reference Point 2 for Further Details)
5. **System Terminal**: This is a terminal may only be accesses by a Privileged Users. This terminal allows users to view system analytics, search for and manage existing user properties and privileges (i.e., name, clearance level, password, etc.) or add new users to the system.
6. User: Represents an individual within our system. Each user must have unique ID and Key assigned to them. A user cannot exist without a key.
7. Key: Hold the information such as the clearance level for boolean value isSuspended. A key may only represent one user. A key cannot exist without a user.

## System Classes and Functionality

1. User
 Represents an individual within our system. This class contains several initialisation methods that allow for a user to be generated from various sets of data (i.e., Adding a new user to the system may need a new randomly generated id while fetching a user from the database will already have a id assigned to them)
 
The User class contains the following attributes:
 ``` Java
  private UUID id;

  private String firstName;
  private String lastName;
  private Key key;
  private String loginKey;
```

In addition to the the initialisation methods, this class holds getter and setter methods for the attributes listed above. 


2. Room
Represents a section within the hypothetical critical infrastructure our system has been implemented in. This class contains a single initialisation method.

The Room class contains the following attributes:
 ``` Java
  private int roomNumber;
  private int floor;
  private int clearanceLevel;
```

In addition to the the initialisation method, this class holds getter and setter methods for the attributes listed above. 

3. Key: 
Represents a key assigned to a specific user within our system. This class contains several initialisation methods that allow for a user to be generated from various sets of data (i.e., Adding a new user to the system will require a new key with a randomly generated id while fetching a user from the database will already have a key assigned to them)

The Key class contains the following attributes:
 ``` Java
  private UUID id;
  private int clearanceLevel;
  private boolean isActive;
```

In addition to the the initialisation method, this class holds getter and setter methods for the attributes listed above. 

A key may only be assigned to one user and a key may not exist without a user. A key determines the access a specific user may have within the system. 


4. AccessTerminal: 
Represents the Access Terminal present at every entry-point within the hypothetical critical infrastructure our system has been implemented in. This class contains a single initialisation method.

The AccessTerminal class contains the following attributes:
 ``` Java
    private UUID id;
    private int securityLevel;
    private boolean isActive;
    private boolean isLocked;
    private Room room;
```

In addition to the the initialisation method, this class holds getter and setter methods for the attributes listed above. 

This class contains an authentication method which compares a user's clearance level to the terminals security level. If clearance level >= security level, access is granted to the user.  


5. SystemTerminal
Represents the System Terminal. This class contains a single initialisation method.

The SystemTerminal class contains the following attributes:
 ``` Java
    private UUID id;
    private Room room;
```

In addition to the the initialisation method, this class holds getter and setter methods for the attributes listed above.

This class holds several methods used on the back end of the SystemTerminalGui class, which contains the code to generate the GUI for this class. These methods include:
* addUser
This method is used to add a new user to the system. This method has two instances: One for privileged users and one for non-privileged users.

* removeUser (Not yet Implemented)

* modifyUser
This method is used to modify an existing user within the system. This method has two instances: One for privileged users and one for non-privileged users.

* authenticateUser
Used to ensure that the user attempting to gain access to the System Terminal exists and has the proper clearance level.

* findKey
Used within the authenticateUser method to find and retrieve the key object based upon the key id provided by the user at Login.

* findUser
Used within the authenticateUser method to find and retrieve the user object based upon the key returned by the findKey method.

* ArrayList<Object[]> findUser (Used to populate element within the GUI)
Used to return a ArraryList which is used to populate the usersTable element withn the SystemTerminalGui class. This method has two instances: One returns all the users within the system while the other returns users who match a given parameter. (Note this is taken from user input within the SystemTerminalGui class)

* checkPassword
Checks the password entered against the loginKey stored within the system for a specific user. Returns a boolean result. 

* countUsers
Returns a count of the total number of users within the system.

* countSuspendedUsers
Returns a count of the total number of suspended users within the system. (i.e., Users with a key where isActive = flase)

* countPrivilegedUsers
Returns a count of the total number of privileged users within the system. (i.e., Users with a clearance level >= 5)

6. SystemTerminalGui
Holds the code to generate the GUI for an instance of a System Terminal. This class utilises the Java Swing library. 

In order to build the GUI, an external IDE (NetBeans) with a GUI editor was used. The source code was then transfered to VSCode where the back-end functionality for the various elements was added.


App: 
The main class for our System. This is where instances of the Access Terminal and System Terminal are created. 

Additionally, for collaberative purposes, this class holds methods that automatically initialise the database based upon a pre-written .ddl file. This allows for identical databases to be initialised across all devices the system is being constructed on.


Running our System:
In order to run our system, please follow the following steps:
1. Start Docker.
2. Open a terminal window at the mySystem directory and run the following commands in order:
	1. `docker-compose up -d`
	2. `docker exec -it cosc310-mysql bash`
3. Open VSCode at the same directory.
4. Run App.java
5. The program be successfully running at this point in time!

Privileged User Credential to try out the system:
John Doe
Key ID: 38f5b748-0ca9-4873-ad07-014749cf8389
Password: Johnpass
