package User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    static List<User> users = new ArrayList<>();

    public User addUser(User user) {
        users.add(user);
        return user;
    }
    public User getUser(int id) {
        for (User user : users) {
            if (user.getUserID() == id) {
                return user;
            }
        }
        return null;
    }
}
