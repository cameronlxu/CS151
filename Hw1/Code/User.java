package hw1;

public class User {

    private String username;
    private String password;

    User(String user, String pass){
        this.username = user;
        this.password = pass;
    }

    String getPassword() {
        return password;
    }

    String getUsername() {
        return username;
    }
}
