package lk.ijse.dep11;

import java.io.Serializable;

public class Member implements Serializable {
    private String username;
    private boolean isLogin;
    private String message;

    public Member() {
    }

    public Member(String username, boolean isLogin, String message) {
        this.username = username;
        this.isLogin = isLogin;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
