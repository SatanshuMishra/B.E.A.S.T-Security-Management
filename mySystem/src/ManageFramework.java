import java.util.UUID;

interface ManageFramework {
    void authenticateUser(UUID keyId);
    User findUser(Key key);
    Key findKey(UUID keyId);
}
