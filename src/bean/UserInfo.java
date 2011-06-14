package bean;

import java.io.*;
import java.util.*;
import java.text.DateFormat;

public class UserInfo implements Serializable {
    private int id;
    private String name;
    private String password;
    private String birthday;

    public UserInfo() {}

    public UserInfo(
            String name,
            String password,
            String birthday) {
        this.name = name;
        this.password = password;
        this.birthday = birthday;
        this.id = -1;
    }

    public UserInfo(
            int id,
            String name,
            String password,
            String birthday) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.birthday = birthday;
    }


	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public String getBirthday() { return birthday; }
	public void setBirthday(String birthday) { this.birthday = birthday; }

    public boolean checkPassword(String password) {
        return password != null && password.equals(this.password);
    }
}
