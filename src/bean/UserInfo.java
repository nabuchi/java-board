package bean;

import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;

public class UserInfo implements Serializable {
    private int id;
    private String name;
    private String password;
    private Calendar birthday;

    public UserInfo() {} 

    public UserInfo (
            String name,
            String password,
            String birthday) throws ParseException{
        this.name = name;
        this.password = password;
        this.birthday = this.birthday.getInstance();
        this.birthday.setTime(DateFormat.getDateInstance().parse(birthday));
        this.id = -1;
    }
    public UserInfo (
            String name,
            String password,
            Date birthday) {
        this.name = name;
        this.password = password;
        this.birthday = this.birthday.getInstance();
        this.birthday.setTime(birthday);
        this.id = -1;
    }


    public UserInfo (
            int id,
            String name,
            String password,
            Date birthday) {
        this(name, password, birthday);
        this.id = id;
    }

    public UserInfo (
            int id,
            String name,
            String password,
            String birthday) throws ParseException{
        this(name, password, birthday);
        this.id = id;
    }


	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public Calendar getBirthday() { return birthday; }
	public void setBirthday(Calendar birthday) { this.birthday = birthday; }

    public boolean checkPassword(String password) {
        return password != null && password.equals(this.password);
    }
}
