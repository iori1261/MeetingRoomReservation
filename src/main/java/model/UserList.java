package model;

import java.util.HashMap;
import java.util.Map;

public class UserList {
    private static UserList instance = new UserList();
    private Map<String, User> users = new HashMap<>();

    private UserList() {}

    public static UserList getInstance() {
        return instance;
    }

    public boolean addUser(User user) {
        if (users.containsKey(user.getUsername())) {
            return false;
        }
        users.put(user.getUsername(), user);
        return true;
    }

    public User getUser(String username) {
        return users.get(username);
    }
}
