import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.UUID;

public class App {
    private Connection con;
    public static void main(String[] args) throws Exception {
        // AccessTerminal a = new AccessTerminal(new Room(200, 3, 4));
        // a.authenticateUser(UUID.fromString("eba78f05-a0fe-43c1-be91-13adc826d495"));
        // a.authenticateUser(UUID.fromString("38f5b748-0ca9-4873-ad07-014749cf8389"));

        App app = new App();
                
        app.connect();
        app.init();
        app.close();

        SystemTerminalGui a = new SystemTerminalGui();
        a.main(args);
        

    }
	public Connection connect() throws SQLException
	{
        String url = "jdbc:mysql://localhost/files";
        String uid = "root";
        String pw = "310rootypw";

		System.out.println("Connecting to database.");
		// Note: Must assign connection to instance variable as well as returning it back to the caller
		con = DriverManager.getConnection(url, uid, pw);
		return con;		                       
	}
	
	/**
	 * Closes connection to database.
	 */
	public void close()
	{
		System.out.println("Closing database connection.");
		try
		{
			if (con != null)
	            con.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}




    public void init()
	{
	    String fileName = "ddl/MySQL_Files_DDL.sql";
	    Scanner scanner = null;
	    
	    try
	    {
	        // Create statement
	        Statement stmt = con.createStatement();
	        scanner = new Scanner(new File(fileName));
	        // Read commands separated by ;
	        scanner.useDelimiter(";");
	        while (scanner.hasNext())
	        {
	            String command = scanner.next();
	            if (command.trim().equals(""))
	                continue;
	            // System.out.println(command);        // Uncomment if want to see commands executed
	            stmt.execute(command);
	        }	        
	    }
	    catch (Exception e)
	    {
	        System.out.println(e);
	    }      
	    if (scanner != null)
	    	scanner.close();
	    
	    System.out.println("Data successfully loaded.");
	}
}