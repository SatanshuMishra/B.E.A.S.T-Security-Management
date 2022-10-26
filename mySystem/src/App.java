import java.util.UUID;
public class App {
    public static void main(String[] args) throws Exception {
        // AccessTerminal a = new AccessTerminal(new Room(200, 3, 4));
        // a.authenticateUser(UUID.fromString("eba78f05-a0fe-43c1-be91-13adc826d495"));
        // a.authenticateUser(UUID.fromString("38f5b748-0ca9-4873-ad07-014749cf8389"));

        SystemTerminalGui a = new SystemTerminalGui();
        a.main(args);

    }
}