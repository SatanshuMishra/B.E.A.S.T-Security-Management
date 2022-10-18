public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Users employeeList = new Users();
        // employeeList.addUser(new User("Satanshu", "Mishra"));
        // employeeList.addUser(new User("John", "Doe"));
        // employeeList.addUser(new User("Jen", "Doe"));

        Room officeABC = new Room(1, 1, 1);
        AccessTerminal a = new AccessTerminal(5, officeABC);
        AccessTerminal b = new AccessTerminal(5, officeABC);
        AccessTerminal c = new AccessTerminal(5, officeABC);
        AccessTerminal d = new AccessTerminal(5, officeABC);
    }
}
