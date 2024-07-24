package MServer;

import java.net.Socket;

public class User {

    private int _id;
    private String username;
    private String password;
    private Socket socket;
    private boolean isOnline;

    public User(int _id, String username, String password, Socket socket, boolean isOnline) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.socket = socket;
        this.isOnline = isOnline;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}
