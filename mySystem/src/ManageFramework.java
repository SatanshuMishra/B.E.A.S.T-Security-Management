import java.util.UUID;

interface ManageFramework {
    User authenticateUser(UUID keyId);
    User findUser(Key key);
    Key findKey(UUID keyId);
}
