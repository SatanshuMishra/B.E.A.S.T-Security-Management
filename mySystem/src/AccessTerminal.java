import java.sql.*;
import java.util.UUID;

public class AccessTerminal extends App{
    private UUID id;
    private int securityLevel;
    private boolean isActive = true;
    private boolean isLocked = true;
    private Room room;

    AccessTerminal(Room room){
        this.id = UUID.randomUUID();
        this.room = room;
        this.securityLevel = room.getClearanceLevel();
    }

    /**
    Takes the given UUID and authenticates it. If successful, it grants access to the user.
    @param UUID an keyId
    @return Returns void
    @throws what kind of exception does this method throw
    */

    public void authenticateUser(UUID keyId) {
        Key key = findKey(keyId);
        
        // CHECK KEY
        if(key != null){
            if(key.getIsActive()){
                if(key.getClearanceLevel() >= securityLevel){
                    User user = findUser(key);
                    if(user != null){
                        // -TO-DO-
                        // ALLOW ACCESS
                        // LOG ACCESS

                        // DEBUG
                        System.out.println("ACCESS GRANTED TO " + user.getName().toUpperCase());
                    } else{
                        // -TO-DO-
                        // DENY ACCESS
                        // LOG ATTEMPT
                        // RAISE FLAG 🚩

                        // DEBUG
                        System.out.println("USER IS NULL");
                    }
                } else{
                    // -TO-DO-
                    // DENY ACCESS
                    // LOG ATTEMPT

                    // DEBUG
                    System.out.println("KEY DOESN'T HAVE CLEARANCE");
                }
            } else{
                // -TO-DO-
                // DENY ACCESS
                // LOG ATTEMPT

                // DEBUG
                System.out.println("KEY IS INACTIVE");
            }
        } else{
            // -TO-DO-
            // DENY ACCESS
            // LOG ATTEMPT
            // RAISE FLAG 🚩

            // DEBUG
            System.out.println("KEY IS NULL");
        }
    }   

    public User findUser(Key key) {
        String url = "jdbc:mysql://localhost/files";
        String uid = "root";
        String pw = "310rootypw";

        String selectStatement = """
            SELECT *
            FROM users
            WHERE kuuid = ?
        """;

        try ( Connection con = DriverManager.getConnection(url, uid, pw);
        PreparedStatement pstmt = con.prepareStatement(selectStatement, ResultSet.TYPE_SCROLL_SENSITIVE, 
        ResultSet.CONCUR_UPDATABLE);) 
        {


            pstmt.setString(1, key.getId().toString());
            ResultSet resultSet = pstmt.executeQuery();
            
            // CHECK ONLY ONE ROW IS RETURNED
            resultSet.last();
            int size = resultSet.getRow();

            if(size == 1){
                resultSet.beforeFirst();
                while(resultSet.next()){
                    UUID idK = UUID.fromString(resultSet.getString("uuid"));
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");

                    if(key.getClearanceLevel() >= 5){
                        String loginKey = resultSet.getString("loginKey");
                        return new User(idK, firstName, lastName, key, loginKey);
                    }
                    
                    return new User(idK, firstName, lastName, key);
                }
            } else{
                // -TO-DO-
                // RAISE EXCEPTION
                // RAISE FLAG 🚩
                
                // DEBUG
                System.out.println("QUERY RETURNED MORE THAN 1 VALUE [USER]");
            }
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex);
            return null;
        }
        return null;
    }

    public Key findKey(UUID keyId) {
        String url = "jdbc:mysql://localhost/files";
        String uid = "root";
        String pw = "310rootypw";

        String selectStatement ="""
            SELECT *
            FROM keyCards
            WHERE kuuid = ?
        """;

        try ( Connection con = DriverManager.getConnection(url, uid, pw);
        PreparedStatement pstmt = con.prepareStatement(selectStatement, ResultSet.TYPE_SCROLL_SENSITIVE, 
        ResultSet.CONCUR_UPDATABLE);) 
        {
            pstmt.setString(1, keyId.toString());
            ResultSet resultSet = pstmt.executeQuery();
            
            // CHECK ONLY ONE ROW IS RETURNED
            resultSet.last();
            int size = resultSet.getRow();

            if(size == 1){
                resultSet.beforeFirst();
                while(resultSet.next()){
                    UUID idK = UUID.fromString(resultSet.getString("kuuid"));
                    int clearanceLevelK = resultSet.getInt("clearanceLevel");
                    boolean isActiveK = (resultSet.getBoolean("isActive"));
                    return new Key(idK, clearanceLevelK, isActiveK);
                }
            } else{
                // -TO-DO-
                // RAISE EXCEPTION
                // RAISE FLAG 🚩

                // DEBUG
                System.out.println("QUERY RETURNED MORE THAN 1 VALUE [KEY]");
            }
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex + " "+ ex.getStackTrace()[0].getLineNumber());
            return null;
        }
        return null;
    }

}
