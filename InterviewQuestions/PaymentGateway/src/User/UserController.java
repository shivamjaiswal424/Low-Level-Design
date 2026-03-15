package User;

public class UserController {
    UserService userService;
    public UserController() {
        this.userService = new UserService();
    }
    public User addUser(User user) {
        userService.addUser(user);
        return user;
    }
    public User getUser(int userID) {
        return userService.getUser(userID);
    }

}
