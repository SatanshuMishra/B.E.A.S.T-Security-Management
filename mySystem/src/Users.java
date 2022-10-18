import java.util.ArrayList;

public class Users {
    ArrayList<User> usersArr = new ArrayList<User>();

    Users(){}

    void addUser(User user){
        usersArr.add(user);
    }

    ArrayList<User> getUsers(){
        return usersArr;
    }
}
