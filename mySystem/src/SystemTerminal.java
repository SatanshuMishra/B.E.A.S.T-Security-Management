import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class SystemTerminal extends App{
    private UUID id;
    private Room room;

    SystemTerminal(Room room){
        this.id = UUID.randomUUID();
        this.room = room;
    }

    public User addUser(){
        String url = "jdbc:mysql://localhost/files";
        String uid = "root";
        String pw = "310rootypw";

        String insertStatement = """
            INSERT INTO users *
            VALUES(
                ?,
                ?,
                ?,
                ?,
                ?
            )
        """;

        try ( Connection con = DriverManager.getConnection(url, uid, pw);
        PreparedStatement pstmt = con.prepareStatement(insertStatement);) 
        {
            pstmt.setString(1, ""); // UUID
            pstmt.setString(2, ""); // FIRSTNAME
            pstmt.setString(3, ""); // LASTNAME
            pstmt.setString(4, ""); // KEY UUID
            pstmt.setString(5, ""); // LOGIN KEY

            pstmt.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex);
            return null;
        }
        return null;
    }

    public void removeUser(){
        // -TO-DO-
    }

    public void modifyUser(){
        // -TO-DO-
    }

    public User authenticateUser(UUID keyId) {
        Key key = findKey(keyId);
        
        // CHECK KEY
        if(key != null){
            if(key.isActive){
                if(key.clearanceLevel >= 5){
                    User user = findUser(key);
                    if(user != null){
                        // -TO-DO-
                        // ALLOW ACCESS
                        // LOG ACCESS

                        // DEBUG
                        System.out.println("ACCESS GRANTED TO " + user.getName().toUpperCase());
                        return user;
                    } else{
                        // -TO-DO-
                        // DENY ACCESS
                        // LOG ATTEMPT
                        // RAISE FLAG 🚩

                        // DEBUG
                        System.out.println("USER IS NULL");
                        return null;
                    }
                } else{
                    // -TO-DO-
                    // DENY ACCESS
                    // LOG ATTEMPT

                    // DEBUG
                    System.out.println("KEY DOESN'T HAVE CLEARANCE");
                    return null;
                }
            } else{
                // -TO-DO-
                // DENY ACCESS
                // LOG ATTEMPT

                // DEBUG
                System.out.println("KEY IS INACTIVE");
                return null;
            }
        } else{
            // -TO-DO-
            // DENY ACCESS
            // LOG ATTEMPT
            // RAISE FLAG 🚩

            // DEBUG
            System.out.println("KEY IS NULL");
            return null;
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

    public ArrayList<Object[]> populateTable() {
        String url = "jdbc:mysql://localhost/files";
        String uid = "root";
        String pw = "310rootypw";

        String selectStatement = """
            SELECT *
            FROM users
            ORDER BY firstName LIMIT 5
        """;

        try ( Connection con = DriverManager.getConnection(url, uid, pw);
        PreparedStatement pstmt = con.prepareStatement(selectStatement, ResultSet.TYPE_SCROLL_SENSITIVE, 
        ResultSet.CONCUR_UPDATABLE);) 
        {
            ResultSet resultSet = pstmt.executeQuery();
            ArrayList<Object[]> rows = new ArrayList<Object[]>();

            while(resultSet.next()){
                Key key = findKey(UUID.fromString(resultSet.getString("kuuid")));
                Object[] row  = {resultSet.getString("uuid"), resultSet.getString("firstName"), resultSet.getString("lastName"), String.valueOf(key.getClearanceLevel())};
                rows.add(row);
            }

            return rows;
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex);
            return null;
        }
    }
}



