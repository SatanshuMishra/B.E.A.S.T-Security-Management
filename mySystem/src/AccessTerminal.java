import java.util.UUID;
import java.util.Scanner;
import java.io.*;
import java.util.concurrent.TimeUnit;
import  java.util.logging.Logger;
import java.util.logging.Level;

public class AccessTerminal extends LoggerClass implements ManageFramework {
    UUID id;
    int securityLevel;
    boolean isFunctional = true;
    boolean isUnlocked = false;
    GUITerminal graphicalInterface;
    Room room;
    Logger logger = Logger.getLogger("SPES");

    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    
    String informationMarker = ANSI_PURPLE_BACKGROUND + ANSI_WHITE + "[INFORMATION]" + ANSI_RESET + " ";

    AccessTerminal(Room room){
        this.id = UUID.randomUUID();
        this.room = room;
        this.securityLevel = room.getClearanceLevel();

        // -TO-DO-
        // IMPLEMENT GUI
        
        // graphicalInterface = new GUITerminal();
        this.room = room;
    }

    public void accessTerminalLogin(){
        Scanner scanner = new Scanner(System.in);

        // GET KEYCARD ID

        while(true){
            System.out.print("Enter Key ID: ");
            UUID enteredKeyId = UUID.fromString(scanner.nextLine());
            User user = authenticateUser(enteredKeyId);
            if(user != null){
                // scanner.close();
                isUnlocked = true;
                System.out.println(informationMarker + "DOOR UNLOCKED\n");
                logToFile("DOOR UNLOCKED");
                System.out.println(String.format("ACCESS GRANTED!\nWELCOME %s!\n", user.getName().toUpperCase()));
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isUnlocked = false;
                System.out.println(informationMarker + "DOOR LOCKED\n");
                logToFile("DOOR LOCKED");

                // break;
            } else{
                System.out.println("ACCESS DENIED!");
            }
        }
    }

    @Override
    public User authenticateUser(UUID keyId) {

        // DEBUG
        // System.out.println("ENTERED AUTHENTICATE USER");
        // logger.log(Level.INFO, "Entered Authenticate User");

        Key key = findKey(keyId);
        User user;

        if(key != null){
            if(key.getClearanceLevel() >= securityLevel){
                user = findUser(key);
                if(user != null)
                    return user;

                // -TO-DO-
                // RAISE SECURITY WARNING
                return null;
            } else{
                return null;
            }
        } else{
            // -TO-DO-
            // RAISE SECURITY WARNING
            return null;
        }
    }

    @Override
    public User findUser(Key key) {
        // DEBUG
        // System.out.println("ENTERED FIND USER");

        User user;
        try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream("userData.ser"); 
            ObjectInputStream in = new ObjectInputStream(file); 
            
            user = (User) in.readObject();
            System.out.println(user.getKey().getId() + "CHECKED");

            while(user.getKey().equals(key)){
                System.out.println(user.getKey().getId() + "CHECKED");
                user = (User) in.readObject();
            }
              
            in.close(); 
            file.close();

            return user;
        } 
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught (FIND USER)"); 
        }
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught (FIND USER)"); 
        }

        return null;
    }

    @Override
    public Key findKey(UUID keyId) {
        // System.out.println("ENTERED FIND KEY");
        Key key;
        try
        {    
            FileInputStream file = new FileInputStream("keyData.ser"); 
            ObjectInputStream in = new ObjectInputStream(file);
            
            key = (Key) in.readObject();
            while(keyId.compareTo(key.getId()) != 0){
                
                // DEBUG
                // System.out.println(key.getId() + " COMPARED...");

                key = (Key) in.readObject();
            }
              
            in.close(); 
            file.close();

            return key;
        } 
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught (FIND KEY)"); 
        }
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught (FIND KEY)"); 
        }
        return null;
    }




    
}
