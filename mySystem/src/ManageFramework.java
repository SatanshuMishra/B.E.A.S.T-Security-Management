import java.util.UUID;

interface ManageFramework {
    boolean authenticateUser(int clearanceLevel, UUID keyId);
    User findUser(UUID userId);
    Key findKey(Key key);
}
