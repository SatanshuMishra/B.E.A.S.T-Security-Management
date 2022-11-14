import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;


public class testbeast
{
	
	private static AccessTerminal q;
    private static SystemTerminal s;
	
	
	private static Connection con;
	
	
	
	
	@BeforeClass
	public static void init() throws Exception 
	{		
		q = new AccessTerminal(new Room(200, 3, 4));
		con = q.connect();		
		q.init();

        s = new SystemTerminal(new Room(200, 3, 5));
        con = s.connect();
        s.init();
	}
	

	@AfterClass
	public static void end() throws Exception 
	{
		q.close();        
        s.close();
	}
	
	
    @Test
    public void testfindkeyAT() throws SQLException
    {   
        q.init();
        
         Key result = q.findKey(UUID.fromString("38f5b748-0ca9-4873-ad07-014749cf8389"));
         UUID resid = result.getId();
         int resultint = result.getClearanceLevel();
         boolean resactive = result.getIsActive();
        // Verify result
        Key answerKey = new Key(UUID.fromString("38f5b748-0ca9-4873-ad07-014749cf8389"), 5, true);
        UUID answerid = answerKey.getId();
        int answerint = answerKey.getClearanceLevel();
        boolean answeractive = answerKey.getIsActive();
        assertEquals(resid, answerid);
        assertEquals(resultint, answerint);
        assertEquals(resactive, answeractive);

    }

    @Test
    public void testfindkeyST() throws SQLException
    {   
       
        s.init();
        
        
         Key result = q.findKey(UUID.fromString("38f5b748-0ca9-4873-ad07-014749cf8389"));
         UUID resid = result.getId();
         int resultint = result.getClearanceLevel();
         boolean resactive = result.getIsActive();
        // Verify result
        Key answerKey = new Key(UUID.fromString("38f5b748-0ca9-4873-ad07-014749cf8389"), 5, true);
        UUID answerid = answerKey.getId();
        int answerint = answerKey.getClearanceLevel();
        boolean answeractive = answerKey.getIsActive();
        assertEquals(resid, answerid);
        assertEquals(resultint, answerint);
        assertEquals(resactive, answeractive);

    }
    
    @Test
    public void testfinduserAT() throws SQLException
    {   
       
        q.init();
        
        Key key = new Key(UUID.fromString("38f5b748-0ca9-4873-ad07-014749cf8389"), 5, true);
         User result = q.findUser(key);

         UUID resid = result.getId();
         String resfirst = result.getFirstName();
         String reslast = result.getLastName();
         String resloginkey = result.getLoginKey();
         Key reskey = result.getKey();
        // Verify result
        User answerUser = new User(UUID.fromString("c88bb0d4-d6e6-48e8-a3ef-86e7550ea1b2"), "John", "Doe", key,"Johnpass");
        UUID answerid = answerUser.getId();
        String answerfirst = answerUser.getFirstName();
        String answerlast = answerUser.getLastName();
        String answerloginkey = answerUser.getLoginKey();
        Key answerkey = answerUser.getKey();
        assertEquals(resid, answerid);
        assertEquals(resfirst, answerfirst);
        assertEquals(reslast, answerlast);
        assertEquals(resloginkey, answerloginkey);
        assertEquals(reskey, answerkey);


    }

    @Test
    public void testfinduserST() throws SQLException
    {   
     
        s.init();
        
        Key key = new Key(UUID.fromString("38f5b748-0ca9-4873-ad07-014749cf8389"), 5, true);
         User result = s.findUser(key);

         UUID resid = result.getId();
         String resfirst = result.getFirstName();
         String reslast = result.getLastName();
         String resloginkey = result.getLoginKey();
         Key reskey = result.getKey();
        // Verify result
        User answerUser = new User(UUID.fromString("c88bb0d4-d6e6-48e8-a3ef-86e7550ea1b2"), "John", "Doe", key,"Johnpass");
        UUID answerid = answerUser.getId();
        String answerfirst = answerUser.getFirstName();
        String answerlast = answerUser.getLastName();
        String answerloginkey = answerUser.getLoginKey();
        Key answerkey = answerUser.getKey();
        assertEquals(resid, answerid);
        assertEquals(resfirst, answerfirst);
        assertEquals(reslast, answerlast);
        assertEquals(resloginkey, answerloginkey);
        assertEquals(reskey, answerkey);
    }

    @Test
    public void testauthenticateUserST() throws SQLException
    {   
      
        s.init();
    
        Key key = new Key(UUID.fromString("38f5b748-0ca9-4873-ad07-014749cf8389"), 5, true);
         User result = s.authenticateUser(key.getId().toString());

         UUID resid = result.getId();
         String resfirst = result.getFirstName();
         String reslast = result.getLastName();
         String resloginkey = result.getLoginKey();
        // Verify result
        User answerUser = new User(UUID.fromString("c88bb0d4-d6e6-48e8-a3ef-86e7550ea1b2"), "John", "Doe", key,"Johnpass");
        UUID answerid = answerUser.getId();
        String answerfirst = answerUser.getFirstName();
        String answerlast = answerUser.getLastName();
        String answerloginkey = answerUser.getLoginKey();
        assertEquals(resid, answerid);
        assertEquals(resfirst, answerfirst);
        assertEquals(reslast, answerlast);
        assertEquals(resloginkey, answerloginkey);


    }
    

}
