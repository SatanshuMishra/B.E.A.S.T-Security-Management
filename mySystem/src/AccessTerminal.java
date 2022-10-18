import java.util.UUID;
public class AccessTerminal implements ManageFramework{
    UUID id;
    int securityLevel;
    boolean isFunctional = true;
    boolean isUnlocked = false;
    GUITerminal graphicalInterface;
    Room room;

    AccessTerminal(int securityLevel, Room room){
        this.id = UUID.randomUUID();
        this.securityLevel = securityLevel;
        graphicalInterface = new GUITerminal();
        this.room = room;
    }

    @Override
    public boolean authenticateUser(int clearanceLevel, UUID keyId) {
        // -TO-DO-
        // FIND KEY IN DATABASE
        // CHECK KEY STATUS; IF TRUE CONTINUE; ELSE PROMPT ERROR 🪵
        // CHECK CLEARANCE LEVEL; IF TRUE CONTINUE; ELSE PROMPT ERROR 🪵
        // FIND USER IN DATABASE
        // DISPLAY USER INFORMATION; PROMPT SUCCESS PROMPT 🪵
        return false;
    }

    @Override
    public User findUser(UUID userId) {
        // -TO-DO-
        return null;
    }

    @Override
    public Key findKey(Key key) {
        // -TO-DO-
        // RETURN KEY IF FOUND; ELSE RAISE WARNING; PROMPT ERROR 🪵
        return null;
    }




    
}
