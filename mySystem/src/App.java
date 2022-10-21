import java.io.*;
public class App {
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) throws Exception {

        User a = new User("John", "Doe", "password");
        User b = new User("Jen", "Doe");
        Key k_a = new Key(7);
        Key k_b = new Key(1);

        a.setKey(k_a);
        b.setKey(k_b);
        String debugMarker = ANSI_WHITE_BACKGROUND + ANSI_BLACK + "[DEBUG]" + ANSI_RESET + " ";
        System.out.println(debugMarker + a.getName() + " " + k_a.getId());
        System.out.println(debugMarker + b.getName() + " " + k_b.getId());
        
        User[] userList = {a, b};
        Key[] keyList = {k_a, k_b};


        // Serialization USERS
        try
        {   
            FileOutputStream file = new FileOutputStream("userData.ser"); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            for(User user: userList)
                out.writeObject(user);
              
            out.close(); 
            file.close();
              
            System.out.println(debugMarker + "User Objects successfully stored in File."); 
  
        } catch(IOException ex) 
        { 
            System.out.println("IOException is caught (USER|IN)"); 
        } 

        // Serialization KEY
        try
        {   
            FileOutputStream file = new FileOutputStream("keyData.ser"); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            for(Key key: keyList)
                out.writeObject(key);
              
            out.close(); 
            file.close();
              
            System.out.println(debugMarker + "Key Objects successfully stored in File."); 
  
        } catch(IOException ex) 
        { 
            System.out.println("IOException is caught (KEY|IN)"); 
        }

        // try
        // {   
        //     FileInputStream file = new FileInputStream("keyData.ser"); 
        //     ObjectInputStream out = new ObjectInputStream(file); 
              
        //     Key key = (Key) out.readObject();
        //     while(key!= null){
        //         System.out.println(key.getId());
        //         key = (Key) out.readObject();
        //     }
              
        //     out.close(); 
        //     file.close();
              
        //     System.out.println("Object has been serialized"); 
  
        // } catch(IOException ex) 
        // { 
        //     System.out.println("IOException is caught (KEY|READ)"); 
        // } 
        

        AccessTerminal t_a = new AccessTerminal(new Room(53, 2, 5));
        t_a.accessTerminalLogin();

        // SystemConsole s_a = new SystemConsole(new Room(53, 2, 7));
        // s_a.systemLogin();




    }
}