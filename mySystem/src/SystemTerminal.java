import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class SystemTerminal{
    private UUID id;
    private Room room;

    SystemTerminal(Room room){
        this.id = UUID.randomUUID();
        this.room = room;
    }

    public User addUser(String userId, String keyId, String firstName, String lastName, boolean isActive, int clearanceLevel){
        String url = "jdbc:mysql://localhost/files";
        String uid = "root";
        String pw = "310rootypw";

        String insertStatementUsers = """
            INSERT INTO users
            VALUES(
                ?,
                ?,
                ?,
                ?,
                NULL
            )
        """;

        String insertStatementKeyCards = """
            INSERT INTO keyCards
            VALUES(
                ?,
                ?,
                ?
            )
        """;

        try ( Connection con = DriverManager.getConnection(url, uid, pw);
        PreparedStatement upstmt = con.prepareStatement(insertStatementUsers);PreparedStatement ppstmt = con.prepareStatement(insertStatementKeyCards);) 
        {
            Key key = new Key(clearanceLevel, isActive);
            User newUser = new User(firstName, lastName, key);

            upstmt.setString(1, newUser.getId().toString()); // UUID
            upstmt.setString(2, newUser.getFirstName()); // FIRSTNAME
            upstmt.setString(3, newUser.getLastName()); // LASTNAME
            upstmt.setString(4, newUser.getKey().getId().toString()); // KEY UUID

            ppstmt.setString(1, key.getId().toString());
            ppstmt.setInt(2, key.getClearanceLevel());
            ppstmt.setBoolean(3, key.getIsActive());

            ppstmt.executeUpdate();
            upstmt.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex);
            return null;
        }
        return null;
    }

    public User addUser(String userId, String keyId, String firstName, String lastName, String loginKey, boolean isActive, int clearanceLevel){
        String url = "jdbc:mysql://localhost/files";
        String uid = "root";
        String pw = "310rootypw";

        String insertStatementUsers = """
            INSERT INTO users
            VALUES(
                ?,
                ?,
                ?,
                ?,
                ?
            )
        """;

        String insertStatementKeyCards = """
            INSERT INTO keyCards
            VALUES(
                ?,
                ?,
                ?
            )
        """;

        try ( Connection con = DriverManager.getConnection(url, uid, pw);
        PreparedStatement upstmt = con.prepareStatement(insertStatementUsers);PreparedStatement ppstmt = con.prepareStatement(insertStatementKeyCards);) 
        {
            Key key = new Key(clearanceLevel, isActive);
            User newUser = new User(firstName, lastName, key, loginKey);

            upstmt.setString(1, newUser.getId().toString()); // UUID
            upstmt.setString(2, newUser.getFirstName()); // FIRSTNAME
            upstmt.setString(3, newUser.getLastName()); // LASTNAME
            upstmt.setString(4, newUser.getKey().getId().toString()); // KEY UUID
            upstmt.setString(5, newUser.getLoginKey()); // KEY UUID

            ppstmt.setString(1, key.getId().toString());
            ppstmt.setInt(2, key.getClearanceLevel());
            ppstmt.setBoolean(3, key.getIsActive());

            ppstmt.executeUpdate();
            upstmt.executeUpdate();

            System.out.println("Added User\nName:" + newUser.getName() + "\nKeyID: " + newUser.getKey().getId() + "\nPassword: " + newUser.getLoginKey());

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

    public void modifyUser(String userId, String keyId, String firstName, String lastName, boolean isActive, int clearanceLevel) throws SQLException{
        String url = "jdbc:mysql://localhost/files";
        String uid = "root";
        String pw = "310rootypw";

        String updateStatementUser = """
            UPDATE users 
            SET firstName = ?, lastName = ?, loginKey = ?
            WHERE uuid = ?
        """;
        
        String updateStatementKey = """
            UPDATE keyCards 
            SET clearanceLevel = ?, isActive = ?
            WHERE kuuid = ?
        """;

        try (Connection con = DriverManager.getConnection(url, uid, pw);
        PreparedStatement upstmt = con.prepareStatement(updateStatementUser); PreparedStatement kpstmt = con.prepareStatement(updateStatementKey);) 
        {
            upstmt.setString(1, firstName); // FIRSTNAME 
            upstmt.setString(2, lastName); // LASTNAME 
            upstmt.setNull(3, java.sql.Types.VARCHAR); //LOGINKEY
            upstmt.setString(4, userId); // UUID

            kpstmt.setInt(1, clearanceLevel); // CLEARANCE
            kpstmt.setBoolean(2, isActive); // ACTIVE
            kpstmt.setString(3, keyId); // KUUID

            upstmt.executeUpdate();
            kpstmt.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex);
        }
    }

    public void modifyUser(String userId, String keyId, String firstName, String lastName, String loginKey, boolean isActive, int clearanceLevel){
                String url = "jdbc:mysql://localhost/files";
        String uid = "root";
        String pw = "310rootypw";

        String updateStatementUser = """
            UPDATE users 
            SET firstName = ?, lastName = ?, loginKey = ?
            WHERE uuid = ?
        """;
        
        String updateStatementKey = """
            UPDATE keyCards 
            SET clearanceLevel = ?, isActive = ?
            WHERE kuuid = ?
        """;

        try (Connection con = DriverManager.getConnection(url, uid, pw);
        PreparedStatement upstmt = con.prepareStatement(updateStatementUser); PreparedStatement kpstmt = con.prepareStatement(updateStatementKey);) 
        {
            upstmt.setString(1, firstName); // FIRSTNAME 
            upstmt.setString(2, lastName); // LASTNAME 
            upstmt.setString(3, loginKey); //LOGINKEY
            upstmt.setString(4, userId); // UUID

            kpstmt.setInt(1, clearanceLevel); // CLEARANCE
            kpstmt.setBoolean(2, isActive); // ACTIVE
            kpstmt.setString(3, keyId); // KUUID

            upstmt.executeUpdate();
            kpstmt.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex);
        }
    }

    public User authenticateUser(String keyId) {
        
        Key key;
        try {
            key = findKey(UUID.fromString(keyId));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            key = null;
        }
        
        // CHECK KEY
        if(key != null){
            if(key.getIsActive()){
                if(key.getClearanceLevel() >= 5){
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
            int size;
            if(resultSet.last())
                size = resultSet.getRow();
            else
                size = 0;

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
                System.out.println("QUERY RETURNED ZERO OR MORE THAN 1 VALUE [USER]");
            }
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex);
            return null;
        }
        return null;
    }

    public User findUser(String keyId) {
        String url = "jdbc:mysql://localhost/files";
        String uid = "root";
        String pw = "310rootypw";

        String selectStatement = """
            SELECT *
            FROM users
            WHERE uuid = ?
        """;

        try ( Connection con = DriverManager.getConnection(url, uid, pw);
        PreparedStatement pstmt = con.prepareStatement(selectStatement, ResultSet.TYPE_SCROLL_SENSITIVE, 
        ResultSet.CONCUR_UPDATABLE);) 
        {


            pstmt.setString(1, keyId);
            ResultSet resultSet = pstmt.executeQuery();
            
            // CHECK ONLY ONE ROW IS RETURNED
            int size;
            if(resultSet.last())
                size = resultSet.getRow();
            else
                size = 0;

            if(size == 1){
                resultSet.beforeFirst();
                while(resultSet.next()){
                    UUID id = UUID.fromString(resultSet.getString("uuid"));
                    UUID kid = UUID.fromString(resultSet.getString("kuuid"));
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    
                    Key key = findKey(kid);

                    if(key.getClearanceLevel() >= 5){
                        String loginKey = resultSet.getString("loginKey");
                        return new User(id, firstName, lastName, key, loginKey);
                    }
                    
                    return new User(id, firstName, lastName, key);
                }
            } else{
                // -TO-DO-
                // RAISE EXCEPTION
                // RAISE FLAG 🚩
                
                // DEBUG
                System.out.println("QUERY RETURNED ZERO OR MORE THAN 1 VALUE [USER]");
            }
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex);
            return null;
        }
        return null;
    }

    public ArrayList<Object[]> findUser(String parmA, String parmB) {
        // -DEBUG-
        System.out.println("Entered findUser");

        String url = "jdbc:mysql://localhost/files";
        String uid = "root";
        String pw = "310rootypw";

        String selectStatement = """
            SELECT *
            FROM users
            WHERE firstName LIKE ? OR lastName LIKE ? OR  firstName LIKE ? OR lastName LIKE ?
        """;

        try ( Connection con = DriverManager.getConnection(url, uid, pw);
        PreparedStatement pstmt = con.prepareStatement(selectStatement, ResultSet.TYPE_SCROLL_SENSITIVE, 
        ResultSet.CONCUR_UPDATABLE);) 
        {

            pstmt.setString(1, '%' + parmA + '%');
            pstmt.setString(2, '%' + parmB + '%');
            pstmt.setString(3, '%' + parmA + '%');
            pstmt.setString(4, '%' + parmB + '%');
            ResultSet resultSet = pstmt.executeQuery();
            ArrayList<Object[]> rows = new ArrayList<Object[]>();

            while(resultSet.next()){
                String ID = resultSet.getString("uuid");
                Key key = findKey(UUID.fromString(resultSet.getString("kuuid")));
                String name = resultSet.getString("firstName") + " " + resultSet.getString("lastName");
                String status = ((key.getIsActive()) ? "Active" : "Suspended");

                Object[] row  = {ID, name, key.getClearanceLevel(), status};
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
            int size;
            if(resultSet.last())
                size = resultSet.getRow();
            else
                size = 0;

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
                System.out.println("QUERY RETURNED ZERO OR MORE THAN 1 VALUE [KEY]");
            }
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex + " "+ ex.getStackTrace()[0].getLineNumber());
            return null;
        }
        return null;
    }

    public ArrayList<Object[]> fetchTable() {
        String url = "jdbc:mysql://localhost/files";
        String uid = "root";
        String pw = "310rootypw";

        String selectStatement = """
            SELECT *
            FROM users
            ORDER BY firstName
        """;

        try ( Connection con = DriverManager.getConnection(url, uid, pw);
        PreparedStatement pstmt = con.prepareStatement(selectStatement, ResultSet.TYPE_SCROLL_SENSITIVE, 
        ResultSet.CONCUR_UPDATABLE);) 
        {
            ResultSet resultSet = pstmt.executeQuery();
            ArrayList<Object[]> rows = new ArrayList<Object[]>();

            while(resultSet.next()){
                String ID = resultSet.getString("uuid");
                Key key = findKey(UUID.fromString(resultSet.getString("kuuid")));
                String name = resultSet.getString("firstName") + " " + resultSet.getString("lastName");
                String status = ((key.getIsActive()) ? "Active" : "Suspended");

                Object[] row  = {ID, name, key.getClearanceLevel(), status};
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

    public boolean checkPassword(User user, String password){
        if(user.getLoginKey() != null){
            if(user.getLoginKey().equals(password))
                return true;
            else
                return false;
        } else{
            // RAISE FLAG 🚩
            return false;
        }
    }

    public int countUsers(){
        String url = "jdbc:mysql://localhost/files";
        String uid = "root";
        String pw = "310rootypw";

        String selectStatement = """
            SELECT *
            FROM users
        """;

        try ( Connection con = DriverManager.getConnection(url, uid, pw);
        PreparedStatement pstmt = con.prepareStatement(selectStatement, ResultSet.TYPE_SCROLL_SENSITIVE, 
        ResultSet.CONCUR_UPDATABLE);) 
        {
            ResultSet resultSet = pstmt.executeQuery();
            if(resultSet.last())
                return resultSet.getRow();
            else
                return 0;
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex);
            return 0;
        }
    }

    public int countSuspendedUsers(){
        String url = "jdbc:mysql://localhost/files";
        String uid = "root";
        String pw = "310rootypw";

        String selectStatement = """
            SELECT isActive
            FROM keyCards
            WHERE isActive = 'TRUE'
        """;

        try ( Connection con = DriverManager.getConnection(url, uid, pw);
        PreparedStatement pstmt = con.prepareStatement(selectStatement, ResultSet.TYPE_SCROLL_SENSITIVE, 
        ResultSet.CONCUR_UPDATABLE);) 
        {
            ResultSet resultSet = pstmt.executeQuery();
            if(resultSet.last())
                return resultSet.getRow();
            else
                return 0;
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex);
            return 0;
        } 
    }

    public int countPrivilagedUsers(){
        String url = "jdbc:mysql://localhost/files";
        String uid = "root";
        String pw = "310rootypw";

        String selectStatement = """
            SELECT clearanceLevel
            FROM keyCards
            WHERE clearanceLevel >= 5
        """;

        try ( Connection con = DriverManager.getConnection(url, uid, pw);
        PreparedStatement pstmt = con.prepareStatement(selectStatement, ResultSet.TYPE_SCROLL_SENSITIVE, 
        ResultSet.CONCUR_UPDATABLE);) 
        {
            ResultSet resultSet = pstmt.executeQuery();
            if(resultSet.last())
                return resultSet.getRow();
            else
                return 0;
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex);
            return 0;
        }
    }



}



